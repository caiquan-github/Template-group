from scrapy.cmdline import execute
execute(["scrapy", "crawl", "douban", "-o", "item.json"])
