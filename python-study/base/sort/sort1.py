#!/usr/bin/python
# -*- coding:utf-8 -*-

def sanitize(itme_string):
    if '-' in itme_string:
        splitter = '-'
    elif ':' in itme_string:
        splitter = ':'
    else:
        return itme_string
    (mins, secs) = itme_string.split(splitter)
    return mins + '.' + secs


def openFileReadLine(file_name):
    with open(file_name) as jaf: data = jaf.readline()  # 读取第一行
    return data.strip().split(',')


james = openFileReadLine('james.txt')
julie = openFileReadLine('julie.txt')
mikey = openFileReadLine('mikey.txt')
sarah = openFileReadLine('sarah.txt')


clean_james = [sanitize(each_t) for each_t in james]
clean_julie = [sanitize(each_t) for each_t in julie]
clean_mikey = [sanitize(each_t) for each_t in mikey]
clean_sarah = [sanitize(each_t) for each_t in sarah]

print(sorted(clean_james))
print(sorted(clean_julie))
print(sorted(clean_mikey))
print(sorted(clean_sarah))
print('----------------------')

# 降序
print(sorted(clean_james, reverse=True))
print(sorted(clean_julie, reverse=True))
print(sorted(clean_mikey, reverse=True))
print(sorted(clean_sarah, reverse=True))
