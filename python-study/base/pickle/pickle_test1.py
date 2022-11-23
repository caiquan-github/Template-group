import pickle
import nester

man = [1, 2, 3]
other = [4, 5, 6]
try:
    with open('main_data.txt', 'w') as main_data, open('other_data.txt', 'w') as other_data:
        nester.print_lol(man, fn=main_data)
        nester.print_lol(other, fn=other_data)
except IOError as err:
    print('file error ', err)

print(__name__)
