import org.beetl.core.*;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.io.ByteWriter_Byte;
import org.beetl.core.io.ByteWriter_Char;
import org.beetl.core.misc.BeetlUtil;
import org.beetl.core.statement.AjaxStatement;
import org.beetl.core.statement.ErrorGrammarProgram;
import org.beetl.core.statement.GrammarToken;
import org.beetl.core.statement.Program;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.Set;

/**
 * Created by chenjie on 16/8/2.
 */
public class Template {

    public Program program;
    public Configuration cf;
    public GroupTemplate gt;
    public boolean isRoot = true;
    public String ajaxId = null;
    Context ctx = new Context();

    protected Template(GroupTemplate gt, Program program, Configuration cf)
    {
        this.program = program;
        this.cf = cf;
        this.gt = gt;
    }

    /**
     * 获取模板输出的文本，结果是一个String
     *
     * @return
     * @throws BeetlException
     */
    public String render() throws BeetlException
    {
        StringWriter sw = new StringWriter();
        renderTo(sw);
        return sw.toString();
    }

    /**
     * 获取模板输出的文本,输出到Writer里
     *
     * @param writer
     * @throws BeetlException
     */
    public void renderTo(Writer writer) throws BeetlException
    {
        ByteWriter_Char byteWriter = new ByteWriter_Char(writer, cf.getCharset(), ctx);
        this.renderTo(byteWriter);

    }

    /**
     * 获取模板输出的文本,输出到OutputStream里,tempalte必须在二进制输出模式下才能使用
     *
     * @param os
     * @throws BeetlException
     */
    public void renderTo(OutputStream os) throws BeetlException
    {
        ByteWriter_Byte byteWriter = new ByteWriter_Byte(os, cf.getCharset(), ctx);
        this.renderTo(byteWriter);
    }

    public void renderTo(ByteWriter byteWriter)
    {

        try
        {
            ctx.byteWriter = byteWriter;
            ctx.gt = this.gt;
           // ctx.template = this;
            if (gt.getSharedVars() != null)
            {
                for (Map.Entry<String, Object> entry : gt.getSharedVars().entrySet())
                {
                    ctx.set(entry.getKey(), entry.getValue());
                }
            }
            program.metaData.initContext(ctx);
            if (ajaxId != null)
            {
                AjaxStatement ajax = program.metaData.getAjax(ajaxId);
                if (ajax == null)
                {
                    BeetlException be = new BeetlException(BeetlException.AJAX_NOT_FOUND);

                    be.pushToken(new GrammarToken(ajaxId, 0, 0));
                    throw be;
                }
                ajax.execute(ctx);
            }
            else
            {
                program.execute(ctx);
            }

            byteWriter.flush();
        }
        catch (BeetlException e)
        {
            if (!(program instanceof ErrorGrammarProgram))
            {
                e.pushResource(this.program.res.getId());
            }

            // 是否打印异常，只有根模板才能打印异常
            if (!isRoot)
                throw e;

            if (e.detailCode == BeetlException.CLIENT_IO_ERROR_ERROR && ctx.gt.getConf().isIgnoreClientIOError())
            {
                return;
            }

            Writer w = BeetlUtil.getWriterByByteWriter(ctx.byteWriter);

            e.gt = this.program.gt;
            e.cr = this.program.metaData.lineSeparator;
            ErrorHandler errorHandler = this.gt.getErrorHandler();

            if (errorHandler == null)
            {
                throw e;
            }
            errorHandler.processExcption(e, w);
            try {
                ctx.byteWriter.flush();
            } catch (IOException e1) {
                //输出到客户端
            }

        }
        catch (IOException e)
        {
            if (!ctx.gt.getConf().isIgnoreClientIOError())
            {

                BeetlException be = new BeetlException(BeetlException.CLIENT_IO_ERROR_ERROR, e.getMessage(), e);
                be.pushResource(this.program.res.getId());
                be.pushToken(new GrammarToken(this.program.res.getId(), 0, 0));
                ErrorHandler errorHandler = this.gt.getErrorHandler();

                if (errorHandler == null)
                {
                    throw be;
                }
                Writer w = BeetlUtil.getWriterByByteWriter(ctx.byteWriter);
                errorHandler.processExcption(be, w);
                try {
                    ctx.byteWriter.flush();
                } catch (IOException e1) {
                    //输出到客户端
                }

            }
            else
            {
                //do  nothing ,just ignore
            }

        }

    }

    /**
     * 为模板绑定变量，此变量在模板编译的时候,根据infer标记来决定是否要推测期类型，如果dynamic为true，
     * 则表示模板引擎优化不需要推测其类型，默认总是false，即变量总是对应同一个类型。如果为true，则认为: 因为变量可能能对应不同java类型，
     * 或者变量是容器，但容器里的元素是不同类型
     *
     * @param varName
     * @param o
     */
    public void binding(String varName, Object o, boolean dynamic)
    {
        ctx.set(varName, o, dynamic);
        // ctx.globalVar.put(varName, o);
        if (dynamic)
        {
            ctx.objectKeys.add(varName);
        }
    }

    /**
     * 为模板绑定一个变量，infer是true
     *
     * @param varName
     *            变量名称，必须符合jaavascript 命名规范
     * @param o
     *            模板变量
     */
    public void binding(String varName, Object o)
    {
        this.binding(varName, o, false);
    }

    public void dynamic(Set<String> objectKeys)
    {
        this.ctx.objectKeys = objectKeys;
    }

    public void dynamic(String key)
    {
        this.ctx.objectKeys.add(key);
    }

    /**
     * 为模板绑定多个变量，map的key，value对应了变量名称和变量值。key必须符合javascript命名规范
     *
     * @param map
     */
    public void binding(Map map)
    {
        Map<String, Object> values = map;
        if(values==null) return ;
        for (Map.Entry<String,Object> entry : values.entrySet())
        {
            this.binding(entry.getKey(), entry.getValue());
        }

    }

    public void fastBinding(Map map)
    {
        ctx.globalVar = map;
    }

    public Context getCtx()
    {
        return this.ctx;
    }

    //	public void fastRender(Map map, ByteWriter byteWriter)
    //	{
    //		if (ctx.isInit)
    //		{
    //			ctx.globalVar = map;
    //			// 重用
    //			for (int i = ctx.tempVarStartIndex; i < ctx.vars.length; i++)
    //			{
    //				ctx.vars[i] = null;
    //			}
    //			ctx.byteWriter = byteWriter;
    //			program.metaData.replaceGlobal(ctx);
    //			program.execute(ctx);
    //		}
    //		else
    //		{
    //			ctx.globalVar = map;
    //			renderTo(byteWriter);
    //		}
    //
    //	}
}
