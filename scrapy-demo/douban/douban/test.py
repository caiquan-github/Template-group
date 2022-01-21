import hashlib
import shutil
import os
import struct

hl = hashlib.md5()

hl.update('aef4b54aad3fb2f4a21a15fa930ae715'.encode())



# 第一部分，准备工作，拼接出要存放的文件夹的路径
file = 'C:\\test\\douban\\1.jpg'
with open(file, 'wb') as fp:
    for x in hl.hexdigest():
        fp.write(struct.pack('b', x))
fp.close()
print('done')