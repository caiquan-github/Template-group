package main

import "fmt"

//命名的结构体（Named Structure）
type Employee struct {
	firstName, lastName string
	age, salary         int
}

//匿名结构体（Anonymous Structure）
var employee struct {
	firstName, lastName string
	age                 int
}



func main() {

	//creating structure using field names
	emp1 := Employee{
		firstName: "Sam",
		age:       25,
		salary:    500,
		lastName:  "Anderson",
	}

	//creating structure without using field names
	emp2 := Employee{"Thomas", "Paul", 29, 800}
	emp2.lastName = "121"

	fmt.Println("Employee 1", emp1)
	fmt.Println("Employee 2", emp2)
	fmt.Println("-------------------------------")
	emp3 := struct {
		firstName, lastName string
		age, salary         int
	}{
		firstName: "Andreah",
		lastName:  "Nikola",
		age:       31,
		salary:    5000,
	}

	fmt.Println("Employee 3", emp3)

}
