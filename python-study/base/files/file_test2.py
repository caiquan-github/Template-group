try:
    with open('its.txt', 'w') as data:
        print("It' s", file=data)
except IOError as err:
    print('file error', str(err))
