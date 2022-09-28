# str

# 定义
var1 = 'Hello World!'
var2 = "W3Cschool"

# 取值
str = "W3cschool"
print(str[2:3])  # 使用截取方式，用正序进行截取
print(str[2:-6])  # 使用截取方式，正序和倒序混合使用
print(str[-7:-6])  # 使用截取方式，使用倒序进行截取
print(str[-7])  # 使用负索引获取单个字符C
print(str[2])  # 使用正索引获取单个字符C

str = "W3cschool"
# 取W3C
# 只有尾下标的情况，默认头下标为0（正序的0，也就是字符串开始的地方）
print(str[:3])
print(str[:-6])

# 取sch
print(str[3:6])
print(str[-6:-3])

# 只有头下标的情况，默认尾下标为0（逆序的0，也就是字符串结束的地方）
# 也就是从3的位置截取到字符串结尾（也就是school）
print(str[3:])

# 更多应用
str2 = "https://www.w3cschool.cn/"
# 截取协议名称
print(str2[:5])  # 也就是截取前五位
# 截取域名
print(str2[8:-1])  # 也就是截取第八位到倒数第一位

str = '你好'
print(str)
bs = str.encode('gbk')
print(str.encode('gbk'))
print(b'\xc4\xe3\xba\xc3'.decode('gbk'))

print(str.encode("unicode-escape"))