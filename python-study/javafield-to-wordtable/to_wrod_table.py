# coding=utf8
import re

file = open('java-field.txt', encoding='utf8')

strs = []

new = open('out.txt', encoding='utf8', mode='w')

index = 1
for i in file:
    i = i.strip()
    if not i.startswith('private'):
        continue

    # 根据空格分割  0舍弃，1类型，2参数，3注解 可能没有注释
    i = re.split('[; ]', i)
    i3 = "".join(i[3: len(i) + 1])
    i3 = i3.replace('//', '')
    put = str(index) + '\t' + i[2] + '\t' + '0' + ' \t' + i[1] + '\t' + i3 + '\t' + i3 + '\n'
    new.writelines(put)
    index = index + 1
