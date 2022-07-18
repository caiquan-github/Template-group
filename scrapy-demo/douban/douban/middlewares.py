import random
from scrapy import signals
from douban.settings import ipPool, count
import requests


class MyproxiesSpiderMiddleware(object):
    def __init__(self, ip=''):
        self.ip = ip

    def process_request(self, request, spider):
        ip = get_one_proxy()
        request.meta['proxy'] = ip
        return None



def get_one_proxy():
    if len(ipPool) == 0:
        append_proxy()
    # 随机选中一个ip
    ip = random.choice(ipPool)
    print('当前ip', ip, '-----', count['count'])

    # 如果循环大于某个值,就清理ip池,更换ip的内容
    if count['count'] > 50:
        append_proxy()
    # 每次访问,计数器+1
    count['count'] += 1

    return ip


def append_proxy():
    print('-------------切换ip------------------')
    count['count'] = 0
    ipPool.clear()
    ips = requests.get(
        'http://dps.kdlapi.com/api/getdps/?orderid=905812536317585&num=10&signature=i0tpdxpdivmrtzpqhse02nhx54u1h5r9&pt=1&sep=1')
    for ip in ips.text.split('\r\n'):
        ipPool.append('http://' + ip)

    print("更新后的ip池：")
    for ip in ipPool:
        print(ip)
    print("更新后的ip池  end ")

