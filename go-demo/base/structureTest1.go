package main

import "fmt"

type Address struct {
	city, state string
}
type Person struct {
	name string
	age  int
	Address
}

func main() {
	var p Person
	p.name = "Naveen"
	p.age = 50
	p.Address = Address{
		city:  "Chicago",
		state: "Illinois",
	}
	fmt.Println("Name:", p.name)
	fmt.Println("Age:", p.age)
	fmt.Println("City:", p.city)   //city is promoted field
	fmt.Println("State:", p.state) //state is promoted field

}
