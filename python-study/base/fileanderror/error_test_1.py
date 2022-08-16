import os

# 文件格式如果改变 那么代码也需要改变 我们无法准确的判断出文件的格式内容 无法保证后续是否出问题 所以换一种方式来解决 那就是异常捕获
data_file_adder = 'book.txt'
try:
    data = open(data_file_adder)

    # 异常捕获
    # 遍历每一句话
    for data_line in data:
        # 异常捕获来处理
        try:
            # 根据符号分隔 用两个参数接收，如果多更多的参数 这里会报错 所以还指定一个值
            role, line_spoken = data_line.split(':', 1)
            print(role, end='')
            print(' said: ', end='')
            print(line_spoken, end='')
        except ValueError:
            pass  # 跳过
    data.close()
except IOError:
    print('the data file  is missing !')
