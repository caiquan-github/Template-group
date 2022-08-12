"""这里nester模块，提供了 print_lol函数"""


def print_lol(the_list):
    """递归打印所有list内容"""
    for each_item in the_list:
        if isinstance(each_item, list):
            print_lol(each_item)
        else:
            print(each_item)
