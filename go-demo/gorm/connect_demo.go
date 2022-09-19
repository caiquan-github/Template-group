package main

import (
	"gorm/connect"
)

func main() {
	db, _ := connect.Connect()
	defer db.Close()
}
