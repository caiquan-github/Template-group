package logic

import (
	"context"
	"errors"
	"go-zero-demo/mall/order/api/internal/svc"
	"go-zero-demo/mall/order/api/internal/types"
	"go-zero-demo/mall/user/rpc/types/user"

	"github.com/zeromicro/go-zero/core/logx"
)

type GetOrderLogic struct {
	logx.Logger
	ctx    context.Context
	svcCtx *svc.ServiceContext
}

func NewGetOrderLogic(ctx context.Context, svcCtx *svc.ServiceContext) GetOrderLogic {
	return GetOrderLogic{
		Logger: logx.WithContext(ctx),
		ctx:    ctx,
		svcCtx: svcCtx,
	}
}

func (l *GetOrderLogic) GetOrder(req *types.OrderReq) (*types.OrderReply, error) {
	//远程调用
	user1, err := l.svcCtx.UserRpc.GetUser(l.ctx, &user.IdRequest{
		Id: "1",
	})

	//如果有错误 返回错误
	if err != nil {
		return nil, err
	}

	//如果用户名称不存在 返回错误 自定义描述
	if user1.Name != "test" {
		return nil, errors.New("用户不存在")
	}

	//调用正常
	return &types.OrderReply{
		Id:     req.Id,
		Name:   user1.Name,
		Gender: user1.Gender,
	}, nil
}
func (l *GetOrderLogic) GetUserName(req *types.OrderReq) (*types.OrderReply, error) {
	user, err := l.svcCtx.UserRpc.GetUserName(l.ctx, &user.IdRequest{
		Id: "2",
	})

	//如果有错误 返回错误
	if err != nil {
		return nil, err
	}
	return &types.OrderReply{
		Name: user.Name,
	}, nil
}
