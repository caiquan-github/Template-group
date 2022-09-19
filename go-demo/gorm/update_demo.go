package main

import "gorm/connect"

type User8 struct {
	ID   int64
	Name string `gorm:"default:'小王子'"`
	Age  int64  `gorm:"default:'18'"`
}

func (User8) TableName() string {
	return "user6"
}

func main() {
	db, _ := connect.Connect()
	defer db.Close()

	user := User8{}
	db.First(&user)
	user.Name = "七米"
	user.Age = 99
	//Save()默认会更新该对象的所有字段，即使你没有赋值。
	db.Save(&user)

	//更新修改字段
	// 更新单个属性，如果它有变化
	db.Model(&user).Update("name", "hello")
	//// UPDATE users SET name='hello', updated_at='2013-11-17 21:34:10' WHERE id=1;

	// 根据给定的条件更新单个属性
	db.Model(&user).Where("age = ?", 99).Update("name", "bb3")
	//// UPDATE users SET name='hello', updated_at='2013-11-17 21:34:10' WHERE id=111 AND age=90;

	// 使用 map 更新多个属性，只会更新其中有变化的属性
	db.Model(&user).Updates(map[string]interface{}{"name": "hello", "age": 18})
	//// UPDATE users SET name='hello',  age=12, updated_at='2013-11-17 21:34:10' WHERE id=1;

	// 使用 struct 更新多个属性，只会更新其中有变化且为非零值的字段
	db.Model(&user).Updates(User8{Name: "bcxbbdv", Age: 33})
	//// UPDATE users SET name='hello', age=18, updated_at = '2013-11-17 21:34:10' WHERE id = 1;

	// 警告：当使用 struct 更新时，GORM只会更新那些非零值的字段
	// 对于下面的操作，不会发生任何更新，"", 0, false 都是其类型的零值
	db.Model(&user).Updates(User8{Name: "", Age: 0})

}
