# coding=utf-8
import os, shutil, glob
from threading import Thread

base_dir = 'E:\download\lingshi'
target_dir = 'E:\\seeyelo'
files = [os.path.join(base_dir, file) for file in os.listdir(base_dir)]

# 将base_dir目录下的包含子目录 所有的匹配文件 拷贝 target_dir
dir_path = base_dir

def move(v1, v2):
    shutil.move(v1, v2)

def copy(v1, v2):
    shutil.copy(v1, v2)

for dirpath, dirnames, filenames in os.walk(dir_path):
    for filename in filenames:
        file = os.path.join(dirpath, filename)
        # print(os.path.join(dirpath, filename))
        if file.endswith(('.mp4', '.mov', '.avi', '.flv')):
            t1 = Thread(target=move, args=(file, os.path.join(target_dir, filename)))
            t1.start()

