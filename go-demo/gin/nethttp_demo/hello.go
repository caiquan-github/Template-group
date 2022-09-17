package main

import (
	"fmt"
	"io/ioutil"
	"net/http"
)

// http.ResponseWriter：代表响应，传递到前端的
// *http.Request：表示请求，从前端传递过来的
func sayHello(w http.ResponseWriter, r *http.Request) {
	html, _ := ioutil.ReadFile("nethttp_demo/template/hello.html")
	_, _ = fmt.Fprintln(w, string(html))
}

//http://127.0.0.1:9090/hello
func main() {
	http.HandleFunc("/hello", sayHello)
	err := http.ListenAndServe(":9090", nil)
	if err != nil {
		fmt.Println("http server failed, err:%v \n", err)
		return
	}
}
