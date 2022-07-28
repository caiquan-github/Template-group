package main

import "fmt"

func main() {

	//定义 num =10 再 if num%2 ==0
	if num := 10; num%2 == 0 { //checks if number is even
		fmt.Println(num, "is even")
	} else {
		fmt.Println(num, "is odd")
	}

}
