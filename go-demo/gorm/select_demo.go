package main

import "gorm/connect"

// User7 默认值是直接设置在数据库中的 如果后续有改动并不会更新数据库中设置  但字符串为'' 或者数字为0都会触发默认值
type User7 struct {
	ID   int64
	Name string `gorm:"default:'小王子'"`
	Age  int64  `gorm:"default:'18'"`
}

func (User7) TableName() string {
	return "user6"
}

func main() {
	db, _ := connect.Connect()

	user := User7{}
	// 根据主键查询第一条记录
	db.First(&user)
	//// SELECT * FROM users ORDER BY id LIMIT 1;

	// 随机获取一条记录
	user = User7{}
	db.Take(&user)
	//// SELECT * FROM users LIMIT 1;

	// 根据主键查询最后一条记录
	user = User7{}
	db.Last(&user)
	//// SELECT * FROM users ORDER BY id DESC LIMIT 1;

	var users []User7
	// 查询所有的记录
	db.Find(&users)
	//// SELECT * FROM users;

	// 查询指定的某条记录(仅当主键为整型时可用)
	db.First(&user, 10)
	//// SELECT * FROM users WHERE id = 10;
}
