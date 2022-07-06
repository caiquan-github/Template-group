# Python 数字类型用于数值的储存。数值类型是不允许改变的，如果改变数字数据类型的值，将重新分配内存空间。
var1 = 1
var2 = 10

number = 0xA0F  # 十六进制
print(number)

number = 0o37  # 八进制
print(number)

#类型转换
#int(x) 将x转换为一个整数。
#float(x) 将x转换到一个浮点数。
#complex(x) 将x转换到一个复数，实数部分为 x，虚数部分为 0。
#complex(x, y) 将 x 和 y 转换到一个复数，实数部分为 x，虚数部分为 y。x 和 y 是数字表达式。

a = 1.0
print(int(a))

