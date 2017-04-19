
import org.beetl.core.*;
import org.beetl.core.resource.StringTemplateResourceLoader;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenjie on 16/8/2.
 */
public class HelloBeetl {


    public   static   void   main(String[] args) throws IOException {

        String input = "hello,${name}!";
        StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate group = new GroupTemplate(resourceLoader, cfg);
        org.beetl.core.Template template = group.getTemplate(input);
        Map<String,String> map =new HashMap<>();
        map.put("name","chenjie");
        template.binding(map);
        String output = template.render();
        System.out.println(output);
    }
}
