# Define your item pipelines here
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://doc.scrapy.org/en/latest/topics/item-pipeline.html

#导入数据库的类
import pymysql
import json
import codecs

class QiubaiproPipelineByMysql(object):
    conn = None  #mysql的连接对象声明
    cursor = None#mysql游标对象声明



    def open_spider(self,spider):
        config = {
            "host": "127.0.0.1",
            "user": "root",
            "password": "root",
            "database": "myscrapy"
        }
        #链接数据库
        self.conn  = pymysql.connect(**config)
        self.cursor = self.conn.cursor()


    #编写向数据库中存储数据的相关代码
    def process_item(self, item, spider):
        #1.链接数据库
        #2.执行sql语句
        sql = "INSERT INTO article(title,name,reply) VALUES(%s,%s,%s)"

        self.cursor.execute(sql,(item['title'], item['author'], item['reply']))
        self.conn.commit()  #提交数据

        return item

    def close_spider(self,spider):
        self.cursor.close()
        self.conn.close()


class JsonWithEncodingPipeline(object):
    def __init__(self):
        self.file = open('items.json', 'w')

    def process_item(self, item, spider):
        line = json.dumps(dict(item)) + "\n"
        self.file.write(line)
        return item