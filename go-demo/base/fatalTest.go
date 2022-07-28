package main

import (
	"fmt"
	"log"
)

func main() {
	fmt.Println("start")
	log.Fatalf("这个会中断程序运行 并且打印日志")
	fmt.Println("end")

}
