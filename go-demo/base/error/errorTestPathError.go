package main

import (
	"fmt"
	"os"
)

//PathError 错误捕获
func main() {
	f, err := os.Open("/test.txt")
	if err, ok := err.(*os.PathError); ok {
		fmt.Println("File at path", err.Path, "failed to open")
		return
	}
	fmt.Println(f.Name(), "opened successfully")
}
