# 集合（set）是一个无序的不重复元素序列
basket = {'apple', 'orange', 'apple', 'pear', 'orange', 'banana'}
print(basket)  # 这里演示的是去重功能

print('orange' in basket)  # 快速判断元素是否在集合内
print('crabgrass' in basket)

# 运算
a = set('abracadabra')
b = set('alacazam')

print(a)
print(b)
print(a - b)
print(a | b)
print(a & b)
print(a ^ b)
a = {x for x in 'abracadabra' if x not in 'abc'}
print(a)

# 添加
thisset = set(("Google", "W3Cschool", "Taobao"))
thisset.add("Baidu")
print(thisset)

# 修改可以传参列表，元组，字典等
thisset = set(("Google", "w3Cschool", "Taobao"))
thisset.update({1, 3})
print(thisset)
thisset.update([1, 4], [5, 6])
print(thisset)

# 移除元素
thisset = set(("Google", "W3Cschool", "Taobao"))
thisset.remove("Taobao")
print(thisset)

thisset.discard("Facebook")  # 不存在不会报错
# thisset.remove("Facebook")   # 不存在会发生错误

print(thisset.pop())

# 计算集合元素个数
thisset = set(("Google", "W3Cschool", "Taobao"))
print(len(thisset))

# 清空
thisset = set(("Google", "W3cschool", "Taobao"))
thisset.clear()
print(thisset)

# 判断是否存在
thisset = set(("Google", "W3Cschool", "Taobao"))
print("W3Cschool" in thisset)
print("Facebook" in thisset)
