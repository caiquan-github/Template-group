# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: http://doc.scrapy.org/en/latest/topics/item-pipeline.html
import base64
import hashlib
import time
import json
import os
from io import BytesIO

from hpack import struct
from scrapy.pipelines.images import ImagesPipeline
from scrapy.pipelines.files import FilesPipeline
from scrapy.exceptions import DropItem
from scrapy import Request
from urllib.parse import urlparse

from scrapy.utils.misc import md5sum
from scrapy.utils.python import to_bytes
from .settings import FILES_STORE

class DoubanImgDownloadPipeline(ImagesPipeline):
    default_headers = {
        'accept': 'image/webp,image/*,*/*;q=0.8',
        'accept-encoding': 'gzip, deflate, sdch, br',
        'accept-language': 'zh-CN,zh;q=0.8,en;q=0.6',
        'cookie': 'bid=yQdC/AzTaCw',
        'referer': 'https://www.douban.com/photos/photo/2370443040/',
        'user-agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36',
    }

    # 下载图片
    def get_media_requests(self, item, info):
        for image_url in item['image_urls']:
            self.default_headers['referer'] = image_url
            yield Request(image_url, headers=self.default_headers)

    # 处理完的后续，一般把item传给下一个pipeline
    def item_completed(self, results, item, info):
        image_paths = [x['path'] for ok, x in results if ok]

        if not image_paths:
            raise DropItem("Item contains no images")

        item['image_paths'] = image_paths
        item['download_time'] = time.time()

        return item

    # 设置储存路径
    # 默认情况下 file_path() 方法返回 full/<request URL hash>.<extension> .
    def file_path(self, request, response=None, info=None, *, item=None):
        return 'files/' + os.path.basename(urlparse(request.url).path)


# 获取字节码的自定义存储方式
class DoubanFilePipeline(FilesPipeline):
    default_headers = {
        'accept': 'image/webp,image/*,*/*;q=0.8',
        'accept-encoding': 'gzip, deflate, sdch, br',
        'accept-language': 'zh-CN,zh;q=0.8,en;q=0.6',
        'cookie': 'bid=yQdC/AzTaCw',
        'referer': 'https://www.douban.com/photos/photo/2370443040/',
        'user-agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36',
    }

    # 发起请求
    def get_media_requests(self, item, info):
        for image_url in item['image_urls']:
            self.default_headers['referer'] = image_url
            yield Request(image_url, headers=self.default_headers)

    # 获取字节码 以及 md5
    def file_downloaded(self, response, request, info, *, item=None):
        # 获取字节码 存储文件

        # 获取response响应体的字节码
        buf = BytesIO(response.body)
        # 要储存的地方
        filename = FILES_STORE+'\\' + hashlib.sha1(to_bytes(request.url)).hexdigest() + '.webp'
        # 创建这个文件
        file = open(filename, 'wb')
        # 读取 response响应体字节码到 byte_datya
        with buf as f:
            byte_data = f.read()
            # 写入文件
            file.write(byte_data)

        # 将字节转base64编码后的数据
        base64_str = base64.b64encode(byte_data).decode("ascii")
        print(base64_str)
        file.close()

        # Calculate the md5 checksum of a file-like object without reading its
        # checksum = md5sum(buf)
        # buf.seek(0)
        return

    def item_completed(self, results, item, info):
        # 获取 md5data
        # checksum = results[0][1].get('checksum')
        return item


class DoubanItemPipeline:

    def __init__(self, images_store):
        self.images_store = images_store
        self.file_name = os.path.join(images_store, str(int(time.time())) + '.txt')
        self.handler = open(self.file_name, 'w')

    def process_item(self, item, spider):
        # 往文件写入数据
        self.handler.write(json.dumps(dict(item)) + '\n')

        return item

    def close_spider(self, spider):
        self.handler.close()

    @classmethod
    def from_crawler(cls, crawler):
        images_store = crawler.settings.get('IMAGES_STORE')
        if not images_store:
            raise ValueError("not find the images_store, please check")

        return cls(
            images_store=images_store
        )
