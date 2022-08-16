package main

import "fmt"

func main() {
	var a [3]int //int array with length 3
	a[0] = 12    // array index starts at 0
	a[1] = 78
	a[2] = 50
	fmt.Println(a)
	fmt.Println("---------------------------------")

	a1 := [3]int{12, 78, 50} // short hand declaration to create array
	fmt.Println(a1)
	fmt.Println("---------------------------------")

	a2 := [...]int{12, 78, 50} // ... makes the compiler determine the length
	fmt.Println(a2)
	fmt.Println("---------------------------------")

	//var b [5]int
	//b = a1 // 数组的大小是类型的一部分。因此 [5]int 和 [25]int 是不同类型。数组不能调整大小

	a4 := [...]string{"USA", "China", "India", "Germany", "France"}
	b := a4                  // 拷贝a4分配给b
	b[0] = "Singapore"       //操作b 并不会改变a
	fmt.Println("a is ", a4) // [USA China India Germany France]
	fmt.Println("b is ", b)  //[Singapore China India Germany France]
	fmt.Println("---------------------------------")

	num := [...]int{5, 6, 7, 8, 8}
	fmt.Println("before passing to function ", num)
	changeLocal(num) //数组不会因为函数调用而改变
	fmt.Println("after passing to function ", num)
	fmt.Println("---------------------------------")

	//遍历
	a5 := [...]float64{67.7, 89.8, 21, 78}
	sum := float64(0)
	for index, value := range a5 { //range returns both the index and value
		fmt.Printf("%d the element of a is %.2f\n", index, value)
		sum += value
	}
	fmt.Println("\nsum of all elements of a", sum)
	fmt.Println("---------------------------------")

	//切片 切片是由数组建立的一种方便、灵活且功能强大的包装（Wrapper）。切片本身不拥有任何数据。它们只是对现有数组的引用。
	a6 := [5]int{76, 77, 78, 79, 80}
	var b1 []int = a6[1:4] // creates a slice from a[1] to a[3]
	fmt.Println(b1)
	fmt.Println("---------------------------------")

	//切片的修改
	darr := [...]int{57, 89, 90, 82, 100, 78, 67, 69, 59}
	dslice := darr[2:5]
	fmt.Println("array before", darr)
	for i := range dslice {
		dslice[i]++
	}
	fmt.Println("array after", darr)

}

func changeLocal(num [5]int) {
	num[0] = 55 //这里并不能改动调用方的数组内容
	fmt.Println("inside function ", num)
}
