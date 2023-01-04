package main

import (
	"flag"
	"fmt"

	"go-zero-demo/mall/order/api/internal/config"
	"go-zero-demo/mall/order/api/internal/handler"
	"go-zero-demo/mall/order/api/internal/svc"

	"github.com/zeromicro/go-zero/core/conf"
	"github.com/zeromicro/go-zero/rest"
)

var configFile = flag.String("f", "etc/order.yaml", "the config file")

func main() {
	flag.Parse()

	//这是自己定义的结构体  ，结构体中有RestConf
	var c config.Config
	//加载配置文件 与结构体
	conf.MustLoad(*configFile, &c)

	//创建一个新服务，并且结束时关闭它
	server := rest.MustNewServer(c.RestConf)
	defer server.Stop()

	//获取上下文ctx servicecontext.go
	ctx := svc.NewServiceContext(c)
	//将api接口服务注册到上下文中
	handler.RegisterHandlers(server, ctx)

	//启动这个服务
	fmt.Printf("Starting server at %s:%d...\n", c.Host, c.Port)
	server.Start()
}
