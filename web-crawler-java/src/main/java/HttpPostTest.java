import com.alibaba.fastjson.JSONObject;
import utils.HttpRequestUtils;

import java.util.*;

/**
 * @author Kwon
 * @Title: post
 * @Description:
 * @date 2020/4/21 00:46
 */
public class HttpPostTest {
    public static void main(String[] args) throws Exception {

        Map<String,String> map=new HashMap<String, String>();
        map.put("channel","twitter");

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("channel","twitter");
        String s = HttpRequestUtils.doPost("http://node1-calcsvr.realsvr.cs-xc-idc2-area1.singhand.com:8004/proxy/show", jsonObject);
        System.out.println(s);

        //解析响应
//        if(response.getStatusLine().getStatusCode()==200){
//            //解析编码
//            String context = EntityUtils.toString(response.getEntity(),"utf8");
//            System.out.println("响应长度"+context.length());
//
//        }
    }
}
