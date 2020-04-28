
import scrapy
from mySpider.items import ItcastItem


class ItcastSpider(scrapy.Spider):
    name="itcast"
    allowed_domains= ["itcast.cn"]
    start_urls=(
        'http://www.itcast.cn/channel/teacher.shtml',
    )

    def parse(self, response):
        # filename= "teacher.html"
        # open(filename,"wb+").write(response.body)
        # 存放信息的集合

        itmes =[]
        for each in response.xpath("//div[@class='li_txt']"):
            item =ItcastItem()
            name =each.xpath("h3/text()").extrach()
            title =each.xpath("h4/text()").extract()
            info =each.xpath("p/text()").extrach()

            item['name']=name[0]
            item['title'] = title[0]
            item['info'] = info[0]

            itmes.append(item)

            return itmes