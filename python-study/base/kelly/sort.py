#!/usr/bin/python
# -*- coding:utf-8 -*-
with open('james.txt') as jaf:  # 打开文件
    data = jaf.readline()  # 读取第一行
    james = data.strip().split(',')  # 去空格以,为分割符转换成列表赋值给james
with open('julie.txt') as juf:
    data = juf.readline()
    julie = data.strip().split(',')
with open('mikey.txt') as mif:
    data = mif.readline()
    mikey = data.strip().split(',')
with open('sarah.txt') as saf:
    data = saf.readline()
    sarah = data.strip().split(',')
print(james)
print(julie)
print(mikey)
print(sarah)

# 原地排序 直接改变原来的值
data = [6, 3, 1, 2, 3, 5]
data.sort()
print(data)

# 复制排序 复制内容 然后进行排序
data = [6, 3, 1, 2, 3, 5]
data1 = sorted(data)
print(data)
print(data1)
