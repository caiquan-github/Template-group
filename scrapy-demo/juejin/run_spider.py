from scrapy import cmdline
cmd_str = 'scrapy crawl juejin -o item.json'
cmdline.execute(cmd_str.split(' '))