# Define your item pipelines here
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://doc.scrapy.org/en/latest/topics/item-pipeline.html

#导入数据库的类
import pymysql
class QiubaiproPipelineByMysql(object):
    conn = None  #mysql的连接对象声明
    cursor = None#mysql游标对象声明


    def open_spider(self,spider):
        print('开始爬虫')
        #链接数据库
        self.conn = pymysql.Connect(host='127.0.0.1',port=3306,user='root',password='root',db='test')
    #编写向数据库中存储数据的相关代码


    def process_item(self, item, spider):
        #1.链接数据库
        #2.执行sql语句
        sql = 'insert into test values("%s","%s")'%(item['author'],item['content'])
        self.cursor = self.conn.cursor()
        #执行事务
        try:
            self.cursor.execute(sql)
            self.conn.commit()
        except Exception as e:
            print(e)
            self.conn.rollback()

        return item

    def close_spider(self,spider):
        print('爬虫结束')
        self.cursor.close()
        self.conn.close()
