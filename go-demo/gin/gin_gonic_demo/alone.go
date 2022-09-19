package main

import (
	"github.com/gin-gonic/gin"
	"log"
	"net/http"
)

// s1
func s1() gin.HandlerFunc {
	return func(c *gin.Context) {
		log.Println("s1 start")
		c.Next()
		log.Println("s1 end")
	}
}

// s2
func s2() gin.HandlerFunc {
	return func(c *gin.Context) {
		log.Println("s2 start")
		c.Next()
		log.Println("s2 end")
	}
}

func main() {
	// 新建一个没有任何默认中间件的路由
	r := gin.New()
	// 注册一个全局中间件
	r.GET("/test2", s1(), s2(), func(c *gin.Context) {
		c.JSON(http.StatusOK, gin.H{
			"message": "Hello world!",
		})
	})
	r.Run()
}
