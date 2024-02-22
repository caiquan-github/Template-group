from __future__ import print_function
import torch
import numpy as np

# 桥接NumPy
# 将一个 Torch 张量转换为一个 NumPy 数组是轻而易举的事情，反之亦然。
# Torch 张量和 NumPy数组将共享它们的底层内存位置，因此当一个改变时，另外也会改变。

a = torch.ones(5)
print(a)

b = a.numpy()
print(b)

a.add_(1)
print(a)
print(b)

print('------------------------------')

# 将 NumPy 数组转化为Torch张量
# 看改变 NumPy 分配是如何自动改变 Torch 张量的：
a = np.ones(5)
b = torch.from_numpy(a)
print(a)
print(b)
np.add(a, 1, out=a)
print(a)
print(b)

print('------------------------------')

# CUDA上的张量

x = torch.randn(1)
print(x)
print(x.item())

# 当GPU可用时,我们可以运行以下代码
# 我们将使用`torch.device`来将tensor移入和移出GPU
print(torch.__version__)
print(torch.cuda.is_available())

if torch.cuda.is_available():
    device = torch.device("cuda")  # a CUDA device object
    y = torch.ones_like(x, device=device)  # 直接在GPU上创建tensor
    x = x.to(device)  # 或者使用`.to("cuda")`方法
    z = x + y
    print('cuda  ',z)
    print(z.to("cpu", torch.double))  # `.to`也能在移动时改变dtype




disTrue(b):
