# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html

from .settings import mysql_movie
import pymysql


class BaseInfoPipeline:
    def __init__(self):
        self.host = mysql_movie["host"]
        self.port = mysql_movie["port"]
        self.user = mysql_movie["user"]
        self.password = mysql_movie["password"]
        self.db = mysql_movie["db"]
        self.conn = pymysql.connect(host=self.host, port=self.port, user=self.user, password=self.password, db=self.db,
                                    charset='utf8')
        self.cursor = self.conn.cursor()

    def process_item(self, item, spider):
        sql = '''insert into movie(name, rating, quote)values('%s','%s','%s')''' % (
            item["name"], item["rating_num"], item["quote"])
        try:
            self.cursor.execute(sql)
            self.conn.commit()
        except:
            self.conn.rollback()
        return item


class CommentPipeline:
    def __init__(self):
        self.host = mysql_movie["host"]
        self.port = mysql_movie["port"]
        self.user = mysql_movie["user"]
        self.password = mysql_movie["password"]
        self.db = mysql_movie["db"]
        self.conn = pymysql.connect(host=self.host, port=self.port, user=self.user, password=self.password, db=self.db,
                                    charset='utf8')
        self.cursor = self.conn.cursor()

    def process_item(self, item, spider):
        sql = '''insert into movie1(name, comment )values('%s','%s')''' % (
            item["name"], item["comment"])
        try:
            self.cursor.execute(sql)
            self.conn.commit()
        except:
            self.conn.rollback()
        return item
