import pickle
import nester

man = [1, 2, 3]
other = [4, 5, 6]
try:
    with open('main_data.txt', 'wb') as main_data, open('other_data.txt', 'wb') as other_data:
        pickle.dump(man, main_data)
        pickle.dump(other, other_data)

except IOError as err:
    print('file error ', err)
except pickle.PickleError as perr:
    print('pickle error', perr)

try:
    with open('main_data.txt', 'rb') as main_data, open('other_data.txt', 'rb') as other_data:
        list = pickle.load(main_data)
        nester.print_lol(list[1:])
        list1 = pickle.load(other_data)
        nester.print_lol(list1)

except IOError as err:
    print('file error ', err)
except pickle.PickleError as perr:
    print('pickle error', perr)
