#!/usr/bin/python
# -*- coding:utf-8 -*-
class NameList(list):  # 提供一个类名新类派生list类
    def __init__(self, a_name):
        list.__init__([])  # 初始化所派生的类,然后把参数赋值至属性
        self.name = a_name


johnny = NameList("John Paul Jones")  # 创建一个新的NameList对象实例
print(type(johnny))  # johnny是一个NameList
print(dir(johnny))  # johnny继承了list的方法

johnny.append("Base Player")
johnny.extend(['Composer', 'Arranger', 'Musician'])  # 使用内置的方法为NameList追加数据
print(johnny)
print(johnny.name)