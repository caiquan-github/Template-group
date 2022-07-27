package main

import "fmt"

/*
Go语言中有种不错的设计，即延迟（defer）语句，你可以在函数中添加多个defer语句。当函数执行到最后时，这些defer语句会按照逆序执行

*/
func main() {
	for i := 0; i < 5; i++ {
		defer fmt.Printf("%d ", i)
	}
}
