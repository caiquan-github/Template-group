package main

import (
	"fmt"
	"time"
)

func recovery() {
	if r := recover(); r != nil {
		fmt.Println("recovered:", r)
	}
}

func a() {
	defer recovery()
	//执行 1
	fmt.Println("Inside A")
	//这里调用了 协程  ,defer recovery()并不会对它有什么帮助
	go b()
	time.Sleep(1 * time.Second)
}

func b() {
	//执行2
	fmt.Println("Inside B")
	//执行3
	panic("oh! B panicked")
}

func main() {
	a()

	//也不会执行
	fmt.Println("normally returned from main")
}
