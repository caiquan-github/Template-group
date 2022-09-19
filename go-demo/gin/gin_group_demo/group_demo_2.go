package main

import (
	"fmt"
	"github.com/gin-gonic/gin"
)

func main() {
	r := gin.Default()
	shopGroup := r.Group("/shop")
	{
		//http://127.0.0.1:8080/shop/index
		shopGroup.GET("/index", func(c *gin.Context) { fmt.Println("get index") })
		shopGroup.GET("/cart", func(c *gin.Context) { fmt.Println("get cart") })
		shopGroup.POST("/checkout", func(c *gin.Context) { fmt.Println("post checkout") })
		// 嵌套路由组
		// http://127.0.0.1:8080/shop/xx/oo
		xx := shopGroup.Group("xx")
		xx.GET("/oo", func(c *gin.Context) { fmt.Println("get xx oo") })
	}
	r.Run()
}
