package main

import (
	_ "beego/routers"
	"embed"
	"fmt"
	beego "github.com/beego/beego/v2/server/web"
	"io/fs"
	"io/ioutil"
)

//go:embed views
var f embed.FS

func main() {
	data, _ := f.ReadDir("views")

	as, _ := fs.Sub(f, "views")
	hi, _ := as.Open("index.tpl")
	data1, _ := ioutil.ReadAll(hi)
	fmt.Println(string(data1))
	fmt.Println(data)
	beego.Run()
}
