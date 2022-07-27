package main

import "fmt"

func main() {
	for index := 10; index > 0; index-- {
		if index == 5 {
			break // 或者continue
		}
		fmt.Println(index)
	}
	// break打印出来10、9、8、7、6
	// continue打印出来10、9、8、7、6、4、3、2、1
}
