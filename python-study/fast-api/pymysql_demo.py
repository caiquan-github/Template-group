import pymysql

from api import app

db = pymysql.connect(host='192.168.29.200',
                     user='root',
                     password='123456',
                     database='book-demo')


# http://127.0.0.1:8000/items/213?q=dwdw
@app.get("/pymysql/{id}")
def read_item(id: int):
    # 创建游标对象
    cursor = db.cursor()

    sql = "SELECT * FROM books WHERE id = %s" % id
    try:
        cursor.execute(sql)  # 执行sql语句，也可执行数据库命令，如：show tables
        result = cursor.fetchall()  # 所有结果
        print(result)
    except Exception as e:
        db.rollback()
        print("查询失败")
        print(e)
    finally:
        cursor.close()  # 关闭当前游标

    return result
