languages = ["C", "C++", "Perl", "Python"]
for x in languages:
    print(x)
print('-----------------------------------')

for x in range(5):
    print(x)
print('-----------------------------------')

# 5到8
for x in range(5, 9):
    print(x)
print('-----------------------------------')

# 0
# 3
# 6
# 9
for i in range(0, 11, 3):
    print(i)
print('-----------------------------------')

# -10
# -40
# -70
for i in range(-10, -100, -30):
    print(i)
print('-----------------------------------')

# 您可以结合 range() 和 len() 函数以遍历一个序列的索引,如下所示:
a = ['Mary', 'had', 'a', 'little', 'lamb']
for i in range(len(a)):
    print(i, a[i])
print('-----------------------------------')

for x in range(5):
    if x == 3:
        print('pass')
        pass
    print(x)
