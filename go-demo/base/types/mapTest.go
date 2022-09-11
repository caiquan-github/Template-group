package main

import "fmt"

func main() {
	var personSalary map[string]int
	if personSalary == nil {
		fmt.Println("map is nil. Going to make one.")
		//其中键是 string 类型，而值是 int 类型
		personSalary = make(map[string]int)
		fmt.Println("------------------------------")

		personSalary := make(map[string]int)
		personSalary["steve"] = 12000
		personSalary["jamie"] = 15000
		personSalary["mike"] = 9000
		personSalary["mike"] = 32222
		fmt.Println("personSalary map contents:", personSalary)
		fmt.Println("------------------------------")

		personSalary1 := map[string]int{
			"steve": 12000,
			"jamie": 15000,
		}
		personSalary1["mike"] = 9000
		fmt.Println("personSalary map contents:", personSalary1)

		//就算 key 不存在 也不会报错 只会获得0的值
		fmt.Println("of is", personSalary1["23242232"])
		//如何知道key是否存在呢
		_, ok := personSalary1["23242232"]
		fmt.Println(" is not null:", ok)

		fmt.Println("------------------------------")
		//删除
		delete(personSalary1, "key")

	}
}
