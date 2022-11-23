def test1(*args):
    for i in args:
        print(i)


def test2(**kwargs):
    for key, value in kwargs.items():
        print(key, value)


def test3(*args, **kwargs):
    for i in args:
        print(i)
    for key, value in kwargs.items():
        print(key, value)


test1([1, 2, 3, 4, 5, 6])
test2(a=1, b=2)
print('-------------------------')
test3(1, 2, 3, 4, 5, 6, x=1, y=2)
