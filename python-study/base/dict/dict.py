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


def get_coach_data(filename):  # 定义函数打开文件
    try:
        with open(filename) as f:
            data = f.readline()
        return (data.strip().split(','))  # 去掉空格回车生成列表作为返回值
    except IOError as ioerr:
        print('File error:' + str(ioerr))
        return (None)


sarah = get_coach_data('sarah2.txt')
sarah_data = {}
sarah_data['NAME'] = sarah.pop(0)
sarah_data['DOB'] = sarah.pop(0)
sarah_data['Times'] = sarah
print(sarah_data['NAME'] + "'s fastest times are:" + str(sorted(set([sanitize(t) for t in sarah_data['Times']]))[0:3]))