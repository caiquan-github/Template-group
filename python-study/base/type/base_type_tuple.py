# Python 的元组（tuple，简写为tup）与列表类似，不同之处在于元组的元素不能修改。

# 定义

tup1 = ('Google', 'W3CSchool', 1997, 2020)
tup2 = (1, 2, 3, 4, 5)
tup3 = "a", "b", "c", "d"  # 不需括号也可以
print(type(tup3))

# 访问

tup1 = ('Google', 'W3CSchool', 1997, 2020)
tup2 = (1, 2, 3, 4, 5, 6, 7)
print("tup1[0]: ", tup1[0])
print("tup2[1:5]: ", tup2[1:5])

# 修改
tup1 = (12, 34.56);
tup2 = ('abc', 'xyz')

# 以下修改元组元素操作是非法的。
# tup1[0] = 100

# 创建一个新的元组
tup3 = tup1 + tup2;
print(tup3)

# 删除
tup = ('Google', 'W3CSchool', 1997, 2020)

print(tup)
del tup;
print("删除后的元组 tup : ")
print(tup)
