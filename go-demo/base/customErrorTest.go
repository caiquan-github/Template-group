package main

import (
	"fmt"
	"math"
)

type AreaError struct {
	Err    string
	Radius float64
}

func (e *AreaError) Error() string {
	return fmt.Sprintf("Radius %0.2f: %s", e.Radius, e.Err)
}

func circleArea(radius float64) (float64, error) {
	if radius < 0 {
		return 0, &AreaError{"Radius is negative", radius}
	}
	return math.Pi * radius * radius, nil
}

func main() {
	radius := -20.0
	area, err := circleArea(radius)
	if err != nil {
		if err, ok := err.(*AreaError); ok {
			fmt.Printf("Radius %0.2f is less than zero", err.Radius)
			return
		}
		fmt.Println(err)
		return
	}
	fmt.Printf("Area of rectangle1 %0.2f", area)
}
