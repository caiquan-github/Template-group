man = []
other = []
try:
    data = open('sketch.txt', 'r')
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
except IOError as err:
    print('not file ', str(err))
finally:
    print(locals())
    if 'data' in locals():
        data.close()

try:
    with open('main_data.txt', 'w') as man_file:
        print(man, file=man_file)
    with open('other_data.txt', 'w') as other_file:
        print(other, file=other_file)
except IOError:
    print('not file ')
finally:
    man_file.close()
    other_file.close()
