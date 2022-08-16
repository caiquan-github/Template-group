man = []
other = []
try:
    data = open('ske1tch.txt', 'r')
    for item in data:
        try:
            (role, line_spoken) = item.split(':', 1)
            line_spoken = line_spoken.strip()
            if role == 'Man':
                man.append(line_spoken)
            elif role == 'Other Man':
                other.append(line_spoken)
        except ValueError:
            pass
except IOError:
    print('not file ')
finally:
    print(locals())
    if 'data' in locals():
        data.close()

try:
    man_file = open('main_data.txt', 'w')
    other_file = open('other_data.txt', 'w')
    print(man, file=man_file)
    print(other, file=other_file)
except IOError:
    print('not file ')
finally:
    man_file.close()
    other_file.close()
