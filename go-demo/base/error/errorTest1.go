package main

import (
	"fmt"
	"os"
)

func main() {

	f, err := os.Open("/test.txt")
	if err != nil {
		//不等于空 代表有错误
		fmt.Println("有错误发生")
		fmt.Println(err)
		return
	}
	fmt.Println(f.Name(), "opened successfully")
}
