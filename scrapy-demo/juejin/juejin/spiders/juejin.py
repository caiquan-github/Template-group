import scrapy
from scrapy import Request
import json
from ..items import JuejinItem


class JiejinSpider(scrapy.Spider):
    name = 'juejin'
    allowed_domains = ['juejin.cn']
    start_urls = 'https://api.juejin.cn/recommend_api/v1/article/recommend_all_feed?aid=2608&uuid=7049991233455818248&spider=0'

    default_headers = {
        'authority': 'api.juejin.cn',
        'accept': '*/*',
        'accept-language': 'zh-CN,zh;q=0.9,en;q=0.8',
        'content-type': 'application/json',
        'cookie': '_ga=GA1.2.1391903923.1641454004; __tea_cookie_tokens_2608=%257B%2522web_id%2522%253A%25227049991233455818248%2522%252C%2522ssid%2522%253A%25222c7f1657-6a5b-4258-a424-f629d6c73d06%2522%252C%2522user_unique_id%2522%253A%25227049991233455818248%2522%252C%2522timestamp%2522%253A1641454004355%257D; MONITOR_WEB_ID=e45af7d8-35d4-44fd-9893-b68ab454ff0e; passport_csrf_token=372411d423f262dccf7f25df905cf7de; passport_csrf_token_default=372411d423f262dccf7f25df905cf7de; n_mh=oGL3bgUD-Fl46j2fYmket3ofHjknH_ML7bBSdO3979g; _tea_utm_cache_2608={%22utm_source%22:%22web_banner%22%2C%22utm_medium%22:%22banner%22%2C%22utm_campaign%22:%22xiaoce_redis_20221012%22}; _gid=GA1.2.810439325.1668391949; sid_guard=178c825ae51364202672423816c5b88f%7C1668664892%7C21600%7CThu%2C+17-Nov-2022+12%3A01%3A32+GMT; uid_tt=6e89899a3e4d8b568300edd29676e518; uid_tt_ss=6e89899a3e4d8b568300edd29676e518; sid_tt=178c825ae51364202672423816c5b88f; sessionid=178c825ae51364202672423816c5b88f; sessionid_ss=178c825ae51364202672423816c5b88f; sid_ucp_v1=1.0.0-KDIzMGExNzVhYzAxMTliMWZlNWVmZjJiYzgzN2I3MGI3MzIzNDQxNTcKCBC8nNebBhgNGgJsZiIgMTc4YzgyNWFlNTEzNjQyMDI2NzI0MjM4MTZjNWI4OGY; ssid_ucp_v1=1.0.0-KDIzMGExNzVhYzAxMTliMWZlNWVmZjJiYzgzN2I3MGI3MzIzNDQxNTcKCBC8nNebBhgNGgJsZiIgMTc4YzgyNWFlNTEzNjQyMDI2NzI0MjM4MTZjNWI4OGY',
        'origin': 'https://juejin.cn',
        'referer': 'https://juejin.cn/',
        'sec-ch-ua': '"Google Chrome";v="107", "Chromium";v="107", "Not=A?Brand";v="24"',
        'sec-ch-ua-mobile': '?0',
        'sec-ch-ua-platform': '"Windows"',
        'sec-fetch-dest': 'empty',
        'sec-fetch-mode': 'cors',
        'sec-fetch-site': 'same-site',
        'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36'
    }

    payload = {
        "id_type": 2,
        "client_type": 2608,
        "sort_type": 200,
        "cursor": "0",
        "limit": 20
    }

    def start_requests(self):
        yield Request(method='POST', url=self.start_urls, headers=self.default_headers, callback=self.parse,
                      body=json.dumps(self.payload))

    def parse(self, response):
        res = json.loads(response.body)
        for i in res['data']:
            if 2 == i['item_type']:
                item = JuejinItem()
                item['title'] = i['item_info']['article_info']['title']
                item['content'] = i['item_info']['article_info']['brief_content']
                item['url'] = 'https://juejin.cn/post/' + i['item_info']['article_id']
                yield item

        next = res['has_more']
        if next:
            index = str(int(self.payload['cursor']) + 1)
            self.payload['cursor'] = index
            yield Request(method='POST', url=self.start_urls, headers=self.default_headers, callback=self.parse,
                          body=json.dumps(self.payload))
