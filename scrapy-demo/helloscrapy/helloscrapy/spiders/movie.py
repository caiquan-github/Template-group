import scrapy

from helloscrapy.items import DoubanItem

class MovieSpider(scrapy.Spider):
    name = 'movie'
    allowed_domains = ['movie.douban.com/top250']
    start_urls = ['http://movie.douban.com/top250/']
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36'}

    def start_requests(self):
        url = 'http://movie.douban.com/top250/'
        yield scrapy.Request(url, headers=self.headers)

    def parse(self, response):
        # 将得到的数据封装到一个DoubanItem对象，就是在items.py里的
        item = DoubanItem()
        for each in response.xpath('//*[@id="content"]/div/div[1]/ol/li'):
            name = each.xpath('./div/div[2]/div[1]/a/span[1]/text()').extract_first()
            rating_num = each.xpath('./div/div[2]/div[2]/div/span[2]/text()').extract_first()
            quote = each.xpath('./div/div[2]/div[2]/p[2]/span/text()').extract_first()
            comment = each.xpath('./div/div[2]/div[2]/div/span[4]/text()').extract_first()
            item['name'] = name
            item['rating_num'] = rating_num
            item['quote'] = quote
            item['comment'] = comment
            yield item
