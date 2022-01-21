# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

import scrapy


class DoubanItem(scrapy.Item):
    name = scrapy.Field()
    rating_num = scrapy.Field()
    quote = scrapy.Field()
    comment = scrapy.Field()