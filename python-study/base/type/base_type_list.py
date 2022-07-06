# list
print('list start')
list1 = ['Google', 'W3Cschool', 1997, 2000]
list2 = [1, 2, 3, 4, 5, 6, 7]
print("list1: ", list1)
print("list2: ", list2)

print("list1的第一项: ", list1[0])
print("list1的最后一项: ", list1[-1])

print("list1的前3项: ", list1[0:3])
print("list1的2、3项: ", list1[1:3])

# 新增

print("list1的第三个元素为: ", list1[2])
list1[2] = "1998"  # 直接对想要修改的数据项赋上一个新值即可修改该数据项
print("list1的第三个元素为: ", list1[2])
list1.append(2021)  # append()可以在列表后追加一项列表项
print("追加列表项后的list1: ", list1)

# 删除
list1 = ['Google', 'W3CSchool', 'Taobao', 'Baidu']
del list1[0]  # del可以删掉一个元素
print("删除列表项后的list1: ", list1)
list1.remove('Taobao')  # remove可以按值查找列表中的元素并删除
print("列表现在为 : ", list1)
list1.remove('Baidu')
print("列表现在为 : ", list1)
