package JavaBasis.daynamicproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by chenjie on 17/4/12.
 */
public class NewProxy {

    public static Object newProxyInstance(Class infce, InvocationHandler invocationHandler) throws Exception {
        Method[] methods = infce.getMethods();
        String rt = "\r\n";
        String methodStr = "";
        for (Method method : methods) {
            methodStr += " @Override" + rt +
                    "      public " + method.getReturnType() + " " + method.getName() + " () {" +
                    "      try{ " + rt +
                    "      Method md = " + infce.getName() + ".class.getMethod(\"" + method.getName() + "\");" + rt +
                    "      h.invoke(this,md);" + rt +
                    "          }catch(Exception e) { e.printStackTrace();}" + rt +
                    "       }" + rt;

        }

        //生成java原文件
        String srcCode = "package JavaBasis.daynamicproxy;" + rt +
                " import java.lang.reflect.Method;" + rt +
                "  public class $Proxy1 implements " + infce.getName() + " {" + rt +
                "  public $Proxy1(InvocationHandler h) {" + rt +
                "  this.h = h;" + rt +
                " }" + rt +
                " JavaBasis.daynamicproxy.InvocationHandler h;" + rt +
                methodStr + rt +
                " }";

        String fileName = "/Users/chenjie/code/saber/target/classes/JavaBasis/daynamicproxy/$Proxy1.java";
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        fw.write(srcCode);
        fw.flush();
        fw.close();

        //java类加载
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
        Iterable units = fileMgr.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
        t.call();
        fileMgr.close();

        //java类编译
        URL[] urls = new URL[]{new URL("file:/"+"/Users/chenjie/code/saber/target/classes/")};
        URLClassLoader ul = new URLClassLoader(urls);
        Class c = ul.loadClass("JavaBasis.daynamicproxy.$Proxy1");

        Constructor ctr = c.getConstructor(InvocationHandler.class);
        Object m = ctr.newInstance(invocationHandler);

        return m;

    }
}
