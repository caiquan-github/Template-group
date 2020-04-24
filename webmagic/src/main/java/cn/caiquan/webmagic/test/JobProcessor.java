package cn.caiquan.webmagic.test;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author Kwon
 * @Title:
 * @Description:
 * @date 2020/4/25 02:18
 */
public class JobProcessor implements PageProcessor {

    //解析页面
    public void process(Page page) {
        //css
        page.putField("div",page.getHtml().css("ul#navitems-group1 li a").get());

        //Xpath
        page.putField("div2",page.getHtml().xpath("//div[@id=news_div]/ul/li/div/a"));

        //正则表达式
        page.putField("div3",page.getHtml().css("dev#news_div a").regex(".*江苏.*").all());

    }

    Site site=Site.me();
    public Site getSite() {
        return site;
    }


    public static void main(String[] args) {
        Spider.create(new JobProcessor())
                .addUrl("https://www.jd.com")   //设置爬取页面
                .run(); //执行
    }
}
