package main

import (
	"fmt"
	"time"
)

func test() {
	time.Sleep(3 * time.Second)
	fmt.Println("----------------")
}

func main() {
	fmt.Println("路过1")

	go test()

	fmt.Println("end")
}
