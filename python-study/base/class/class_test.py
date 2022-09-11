#!/usr/bin/python
# -*- coding:utf-8 -*-
class Athlete:
    def __init__(self, a_name, a_dob=None, a_time=[]):  # 定义类
        self.name = a_name  # 初始化这三个属性,使用所提供的参数数据为3个类属性赋值
        self.dob = a_dob
        self.times = a_time


sarah = Athlete('Sarah Sweeney', '2002-6-17', ['2.58', '2.58', '1.56'])  # 创建两个唯一选手james使用省却参数
james = Athlete('James Jones')
print(type(sarah))
print(sarah)
print(sarah.name)
print(sarah.dob)
print(sarah.times)
