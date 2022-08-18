#!/usr/bin/python
# -*- coding:utf-8 -*-
def sanitize(time_string):  # 定义函数如果字符串含有-和:
    if '-' in time_string:  # 均转换成.
        splitter = '-'
    elif ':' in time_string:
        splitter = ':'
    else:
        return (time_string)
    (mins, secs) = time_string.split(splitter)
    return (mins + '.' + secs)


'''
class Athlete:
    def __init__(self,a_name,a_dob=None,a_times=[]):                    
        self.name = a_name
        self.dob = a_dob
        self.times = a_times
    def top3(self):
        return(sorted(set([sanitize(t) for t in self.times]))[0:3])
    def add_time(self,time_value):
        self.times.append(time_value)           #追加单个时间
    def add_times(self,list_of_times):
        self.times.extend(list_of_times)        #列表追加多个时间
'''


class AthleteList(list):
    def __init__(self, a_name, a_dob=None, a_times=[]):
        list.__init__([])
        self.name = a_name
        self.dob = a_dob
        self.extend(a_times)  # 数据本身是计时数据,所以不再需要times属性

    def top3(self):
        return (sorted(set([sanitize(t) for t in self]))[0:3])


vera = AthleteList('Vera Vi')
vera.append('1.31')
print(vera.top3())
vera.extend(['2.22', '1.21', '2.22'])
print(vera.top3())  # 测试