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


def get_coach_data(filename):
    try:
        with open(filename) as jaf:
            data = jaf.readline()  # 读取第一行
        return data.strip().split(',')
    except IOError as err:
        print('file error ', str(err))
        return None


james = get_coach_data('james.txt')
julie = get_coach_data('julie.txt')
mikey = get_coach_data('mikey.txt')
sarah = get_coach_data('sarah.txt')

clean_james = [sanitize(each_t) for each_t in james]
clean_julie = [sanitize(each_t) for each_t in julie]
clean_mikey = [sanitize(each_t) for each_t in mikey]
clean_sarah = [sanitize(each_t) for each_t in sarah]

# 用set删掉重复的数据 然后排序 展示最快的三个值
print(sorted(set(clean_james))[:3])
print(sorted(set(clean_julie))[:3])
print(sorted(set(clean_mikey))[:3])
print(sorted(set(clean_sarah))[:3])

print('----------------------')

# 降序
print(sorted(clean_james, reverse=True))
print(sorted(clean_julie, reverse=True))
print(sorted(clean_mikey, reverse=True))
print(sorted(clean_sarah, reverse=True))
