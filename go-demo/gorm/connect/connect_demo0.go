package connect

import (
	"fmt"
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

func Connect() (*gorm.DB, error) {
	db, err := gorm.Open("mysql", "root:123456@(192.168.29.129)/go-demo?charset=utf8mb4&parseTime=True&loc=Local")
	if err != nil {
		fmt.Println(err)
		panic(err)
	}
	return db, nil
}
