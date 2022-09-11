package main

import "fmt"

func main() {
	h := "hello"
	fmt.Println(mutate([]rune(h)))
}

func mutate(s []rune) string {
	s[0] = 'a'
	return string(s)
}
