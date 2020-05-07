import pymysql
config={
    "host":"127.0.0.1",
    "user":"root",
    "password":"root",
    "database":"myscrapy"
}
db = pymysql.connect(**config)
cursor = db.cursor()
sql = "INSERT INTO article(title,name,reply) VALUES(%s,%s,%s)"
cursor.execute(sql,("bob","123","w"))
db.commit()  #提交数据
cursor.close()
db.close()
