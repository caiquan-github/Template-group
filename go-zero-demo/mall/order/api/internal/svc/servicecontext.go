package svc

import (
	"go-zero-demo/mall/order/api/internal/config"
	"go-zero-demo/mall/user/rpc/userclient"

	"github.com/zeromicro/go-zero/zrpc"
)

type ServiceContext struct {
	Config  config.Config
	UserRpc userclient.User
}

func NewServiceContext(c config.Config) *ServiceContext {
	return &ServiceContext{
		Config: c,
		//用户rpc远程调用信息
		UserRpc: userclient.NewUser(zrpc.MustNewClient(c.UserRpc)),
	}
}
