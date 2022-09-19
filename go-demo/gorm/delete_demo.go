package main

import "gorm/connect"

type User9 struct {
	ID   int64
	Name string `gorm:"default:'小王子'"`
	Age  int64  `gorm:"default:'18'"`
}

func (User9) TableName() string {
	return "user6"
}

func main() {
	db, _ := connect.Connect()
	defer db.Close()

	user := User9{}
	//警告 删除记录时，请确保主键字段有值，GORM 会通过主键去删除记录，如果主键为空，GORM 会删除该 model 的所有记录。
	// 删除现有记录
	user.ID = 1
	db.Delete(&user)
	//// DELETE from emails where id=10;

	// 为删除 SQL 添加额外的 SQL 操作
	db.Set("gorm:delete_option", "OPTION (OPTIMIZE FOR UNKNOWN)").Delete(&user)
	//// DELETE from emails where id=10 OPTION (OPTIMIZE FOR UNKNOWN);
}
