import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.List;

/**
 * Created by chenjie on 17/5/5.
 */
public class JSonParse {

public static final String str = "[{\"columnName\":\"contents\",\"type\":\"string\",\"defaultValue\":null,\"isRegular\":true,\"state\":true},{\"columnName\":\"created_at\",\"type\":\"date\",\"defaultValue\":null,\"isRegular\":0,\"state\":true},{\"columnName\":\"id\",\"type\":\"long\",\"defaultValue\":null,\"isRegular\":0,\"state\":true}]";
    public static void main(String[] args) {
       /* List<EsColumnVo> esColumnVos = JSON.parseArray(str,EsColumnVo.class);
        System.out.println(esColumnVos.size());*/
        test("");

    }


    static void  test(String str){
        assert !"".equals(str) : "字符串为空,有问题";
    }
}
