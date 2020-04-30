import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kwon
 * @Title: post
 * @Description:
 * @date 2020/4/21 00:46
 */
public class HttpPostTest {
    public static void main(String[] args) throws Exception {
        //创建httpclient对象
        CloseableHttpClient  httpclient = HttpClients.createDefault();

//        //设置请求地址，创建URIBulder
//        URIBuilder uriBuilder = new URIBuilder("https://www.baidu.com/s");


    //        //set 参数
    //        uriBuilder.setParameter("wd","java");

        //创建httpPost对象
        HttpPost httpPost=new HttpPost("https://www.baidu.com/s");

        //声明List集合，封装表单中的参数
        List<NameValuePair> parmes= new ArrayList<NameValuePair>();
        parmes.add(new BasicNameValuePair("wd","java"));

        //创建表单对象Entity
        UrlEncodedFormEntity formEntity =new UrlEncodedFormEntity(parmes,"utf8");

        //将表单Entity设置在请求中
        httpPost.setEntity(formEntity);

        //包装头文件
        httpPost.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");



        //请求 获取
        CloseableHttpResponse response = httpclient.execute(httpPost);

        //解析响应
        if(response.getStatusLine().getStatusCode()==200){
            //解析编码
            String context = EntityUtils.toString(response.getEntity(),"utf8");
            System.out.println("响应长度"+context.length());

        }
    }
}
