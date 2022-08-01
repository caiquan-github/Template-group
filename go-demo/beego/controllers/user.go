package controllers

import (
	beego "github.com/beego/beego/v2/server/web"
)

type UserDb struct {
	Id   int    `json:"id" 	orm:"column(id)"`
	Name string `json:"name"  orm:"column(name)"`
	Psw  string `json:"psw"  orm:"column(psw)"`
}

type UserController struct {
	beego.Controller
}

func (c *UserController) Get() {
	user := UserDb{1, "kwon", "123456"}
	c.Data["json"] = map[string]interface{}{
		"code": 0,
		"msg":  "",
		"data": user,
	}

	c.ServeJSON() //对json进行序列化输出
	c.StopRun()   //终止执行逻辑

}
