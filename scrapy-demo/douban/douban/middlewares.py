import random
from scrapy import signals
from douban.settings import IPPOOL
import requests


class MyproxiesSpiderMiddleware(object):
    def __init__(self, ip=''):
        self.ip = ip

    def process_request(self, request, spider):
        # thisip = random.choice(IPPOOL)

        r = requests.get(
            "http://dps.kdlapi.com/api/getdps/?orderid=905812536317585&num=1&signature=i0tpdxpdivmrtzpqhse02nhx54u1h5r9&pt=1&sep=1",
            params=None)
        print("this is ip:" + r.text)
        request.meta["proxy"] = "http://" + r.text
