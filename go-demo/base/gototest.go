package main

func main() {
	myFunc()
}

func myFunc() {
	i := 0
Here: //这行的第一个词，以冒号结束作为标签
	println(i)
	i++
	goto Here //跳转到Here去
}
