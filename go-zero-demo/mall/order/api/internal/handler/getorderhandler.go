package handler

import (
	"fmt"
	"github.com/zeromicro/go-zero/rest/httpx"
	"go-zero-demo/mall/order/api/internal/logic"
	"go-zero-demo/mall/order/api/internal/svc"
	"go-zero-demo/mall/order/api/internal/types"
	"net/http"
)

func getOrderHandler(svcCtx *svc.ServiceContext) http.HandlerFunc {
	return func(w http.ResponseWriter, r *http.Request) {
		req, err := parse(r)
		if err != nil {
			httpx.Error(w, err)
			fmt.Print(req)
			return
		}

		//调用业务函数，获取新的订单登录 结构体实例
		l := logic.NewGetOrderLogic(r.Context(), svcCtx)
		//调用获取订单方法 传入实例
		resp, err := l.GetOrder(&req)
		if err != nil {
			httpx.Error(w, err)
		} else {
			httpx.OkJson(w, resp)
		}
	}
}
func getUserNameHandler(svcCtx *svc.ServiceContext) http.HandlerFunc {

	return func(w http.ResponseWriter, r *http.Request) {
		req, err := parse(r)
		if err != nil {
			httpx.Error(w, err)
			fmt.Print(req)
			return
		}

		//调用业务函数，获取新的订单登录 结构体实例
		l := logic.NewGetOrderLogic(r.Context(), svcCtx)
		//调用获取订单方法 传入实例
		resp, err := l.GetUserName(&req)
		if err != nil {
			httpx.Error(w, err)
		} else {
			httpx.OkJson(w, resp)
		}

	}

}

func parse(r *http.Request) (types.OrderReq, error) {
	var req types.OrderReq
	//解析request到 req中
	if err := httpx.Parse(r, &req); err != nil {
		//如果失败 将错误写入response中
		//httpx.Error(w, err)
		return types.OrderReq{}, err
	}
	return req, nil
}
