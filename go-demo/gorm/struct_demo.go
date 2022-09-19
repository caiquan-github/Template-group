package main

import (
	"database/sql"
	"github.com/jinzhu/gorm"
	"time"
)

// User 将 `ID`, `CreatedAt`, `UpdatedAt`, `DeletedAt`字段注入到`User`模型中
type User struct {
	gorm.Model
	Name string
}

// User1 不使用gorm.Model，自行定义模型
type User1 struct {
	ID   int
	Name string
}

// User2 参考
type User2 struct {
	gorm.Model
	Name         string
	Age          sql.NullInt64
	Birthday     *time.Time
	Email        string  `gorm:"type:varchar(100);unique_index"`
	Role         string  `gorm:"size:255"`        // 设置字段大小为255
	MemberNumber *string `gorm:"unique;not null"` // 设置会员号（member number）唯一并且不为空
	Num          int     `gorm:"AUTO_INCREMENT"`  // 设置 num 为自增类型
	Address      string  `gorm:"index:addr"`      // 给address字段创建名为addr的索引
	IgnoreMe     int     `gorm:"-"`               // 忽略本字段
}

// User4 默认ID
type User4 struct {
	ID   string // 名为`ID`的字段会默认作为表的主键
	Name string
}

// Animal 使用`AnimalID`作为主键
type Animal struct {
	AnimalID int64 `gorm:"primary_key"`
	Name     string
	Age      int64
}

// User5 默认表明
type User5 struct{} // 默认表名是 `user5s`

// TableName User5 的表名设置为 `profiles`
func (User5) TableName() string {
	return "profiles"
}
