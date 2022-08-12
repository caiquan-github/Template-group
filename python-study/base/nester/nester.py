"""这里nester模块，提供了 print_lol函数"""


def print_lol(the_list):
    """递归打印所有list内容"""
    for each_item in the_list:
        if isinstance(each_item, list):
            print_lol(each_item)
        else:
            print(each_item)


def print_lol(the_list, level):
    """递归打印所有list内容"""
    for each_item in the_list:
        if isinstance(each_item, list):
            print_lol(each_item, level + 1)
        else:
            for tab_stop in range(level):
                print("\t", end='')
            print(each_item)


def test():
    movies = ["the", 1, "the 2", 2, ["2323", 2332, 5555, ["dwdw", "123123"]]]
    print_lol(movies, 0)
