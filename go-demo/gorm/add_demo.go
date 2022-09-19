package main

import "gorm/connect"

type User6 struct {
	ID   int64
	Name string `gorm:"default:'小王子'"`
	Age  int64
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

	defer db.Close()
}
