package main

import (
	"fmt"
	"path/filepath"
)

//PathError 错误捕获

func main() {
	files, error := filepath.Glob("[")
	//ErrBadPattern 模式错误
	if error != nil && error == filepath.ErrBadPattern {
		fmt.Println(error)
		return
	}
	fmt.Println("matched files", files)
}
