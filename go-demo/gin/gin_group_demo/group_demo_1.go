package main

import (
	"fmt"
	"github.com/gin-gonic/gin"
)

func main() {
	r := gin.Default()
	userGroup := r.Group("/user")
	{
		userGroup.GET("/index", func(c *gin.Context) { fmt.Println("get index") })
		userGroup.GET("/login", func(c *gin.Context) { fmt.Println("get login") })
		userGroup.POST("/login", func(c *gin.Context) { fmt.Println("post login") })

	}
	shopGroup := r.Group("/shop")
	{
		shopGroup.GET("/index", func(c *gin.Context) {})
		shopGroup.GET("/cart", func(c *gin.Context) {})
		shopGroup.POST("/checkout", func(c *gin.Context) {})
	}
	r.Run()
}
