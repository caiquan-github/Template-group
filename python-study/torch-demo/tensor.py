from __future__ import print_function

import numpy
import torch

x = torch.empty(5, 3)
print(x)
print('--------------------------------------')

x = torch.rand(5, 3)
print(x)
print('--------------------------------------')

x = torch.zeros(5, 3, dtype=torch.long)
print(x)
print('--------------------------------------')

x = torch.tensor([5.5, 3])
print(x)
print('--------------------------------------')

# 或根据现有的 tensor 建立新的 tensor 。除非用户提供新的值，否则这些方法将重用输入张量的属性，例如 dtype 等：
x = x.new_ones(5, 3, dtype=torch.double)  # new_* methods take in sizes
print(x)
x = torch.randn_like(x, dtype=torch.float)  # 重载 dtype!
print(x)  # 结果size一致
print(x.size())  # 获取张量的状态

print('--------------------------------------')

# 加法
y = torch.rand(5, 3)
print(x + y)
# 指定输出
result = torch.empty(5, 3)
torch.add(x, y, out=result)
print(result)
print('--------------------------------------')

# adds x to y
print(y)
print(x)
y.add_(x)  # 注意：任何一个就地改变张量的操作后面都固定一个 _ 。例如 x.copy_（y）， x.t_（）将更改x
print(y)
print('--------------------------------------')

# 也可以使用像标准的 NumPy 一样的各种索引操作：
print(x[:, 1])
print('--------------------------------------')

# 改变形状：如果想改变形状，可以使用 torch.view
x = torch.randn(4, 4)
y = x.view(16)  # 这里是把上面的二维数组转换成了一维数组
z = x.view(-1, 8)  # 这个-1 代表根据实际长度会推断出来  比如这里16/8=2
print(x, y, z, sep='\n')
print(x.size(), y.size(), z.size())
print('--------------------------------------')

x = torch.randn(1)
print(x)
print(x.item())  # 如果是仅包含一个元素的 tensor，可以使用 .item（） 来得到对应的 python 数值
