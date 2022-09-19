package main

import (
	"gorm/connect"
)

// User7 默认值是直接设置在数据库中的 如果后续有改动并不会更新数据库中设置  但字符串为'' 或者数字为0都会触发默认值
type User6 struct {
	ID   int64
	Name string `gorm:"default:'小王子'"`
	Age  int64  `gorm:"default:'18'"`
}

func main() {
	db, err := connect.Connect()
	if err != nil {
		panic(err)
	}

	db.AutoMigrate(User6{})
	user := User6{Name: "q1mi", Age: 18}

	db.NewRecord(user) // 主键为空返回`true`
	db.Create(&user)   // 创建user
	db.NewRecord(user) // 创建`user`后返回`false`

	//空字符串也会触发默认值
	user1 := User6{Name: "", Age: 0}
	db.Create(&user1)

	// 为Instert语句添加扩展SQL选项
	db.Set("gorm:insert_option", "ON CONFLICT").Create(&user1)
	// INSERT INTO user1 (name, age) VALUES ("name", "age") ON CONFLICT;

	defer db.Close()
}
