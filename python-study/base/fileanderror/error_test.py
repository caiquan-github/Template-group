data = open('book.txt')

# 遍历每一句话
for data_line in data:
    # 如果连一个:都没有 那么就不处理
    if not data_line.find(":") == -1:
        # 根据符号分隔 用两个参数接收，如果多更多的参数 这里会报错 所以还指定一个值
        role, line_spoken = data_line.split(':', 1)
        print(role, end='')
        print(' said: ', end='')
        print(line_spoken, end='')

data.close()

# 尽管 我通过了 第6行、第8行的处理 解决了错误 但是文件格式如果改变
# 那么代码也需要改变 我们无法准确的判断出文件的格式内容 无法保证后续是否出问题 所以换一种方式来解决 那就是异常捕获
