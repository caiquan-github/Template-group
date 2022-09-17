package main

import (
	"github.com/gin-gonic/gin"
	"net/http"
)

//http://127.0.0.1:9100/users/index
//http://127.0.0.1:9100/posts/index
func main() {
	r := gin.Default()
	r.LoadHTMLGlob("html_demo/templates/**/*")
	//r.LoadHTMLFiles("templates/posts/index.html", "templates/users/index.html")
	r.GET("/posts/index", func(c *gin.Context) {
		c.HTML(http.StatusOK, "posts/index.html", gin.H{
			"title": "posts/index",
		})
	})

	r.GET("users/index", func(c *gin.Context) {
		c.HTML(http.StatusOK, "users/index.html", gin.H{
			"title": "users/index",
		})
	})

	r.Run(":9100")
}
