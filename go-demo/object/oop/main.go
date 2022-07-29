package main

import "object/oop/employee"

func main() {
	e := employee.Employee{
		FirstName:   "Sam",
		LastName:    "Adolf",
		TotalLeaves: 30,
		LeavesTaken: 20,
	}
	e.LeavesRemaining()
	println("")
	println("-------------------------")

	var e1 employee.Employee
	e1.LeavesRemaining()


}
