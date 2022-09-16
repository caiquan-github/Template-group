import pickle

# 意思是从athletelist.py中导入AthleteList
from athletelist import AthleteList


def get_coach_data(filename):
    try:
        with open(filename) as f:
            data = f.readline()
        templ = data.strip().split(',')
        return (AthleteList(templ.pop(0), templ.pop(0), templ))
    except IOError as ioerr:
        print('File error (get_coach_data): ' + str(ioerr))
        return (None)


def put_to_store(files_list):
    all_athletes = {}
    # 定义字典，用于存储运动员对象
    for each_file in files_list:
        # get_coach_data(each_file)打开文件列表中的每一个文件，
        # 并将其转换成AthleteList对象。
        # 最后，将AthleteList对象存入all_athletes字典。
        ath = get_coach_data(each_file)
        all_athletes[ath.name] = ath
    try:
        # 打开athletes.pickle文件，将字典 all_athletes存入其中。
        with open('athletes.pickle', 'wb') as athf:
            pickle.dump(all_athletes, athf)
    except IOError as ioerr:
        print('File error (put_and_store): ' + str(ioerr))
    return (all_athletes)


def get_from_store():
    all_athletes = {}
    try:
        # 打开athletes.pickle文件，它是一个字典
        # 然后，将其赋值给字典all_athletes。
        with open('athletes.pickle', 'rb') as athf:
            all_athletes = pickle.load(athf)
    except IOError as ioerr:
        print('File error (get_from_store): ' + str(ioerr))
    return (all_athletes)
