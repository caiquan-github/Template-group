package main

import (
	"fmt"
	"time"
)

func main() {

	//安排助手看邮件
	ch := make(chan string)
	go assistant1(ch)
	//等待5秒后
	time.Sleep(time.Second * 5)
	//邀请助手喝奶茶
	ch <- "喝奶茶去呗"

	//同样，主函数的<-ch也会一直阻塞，直到助理回复消息。另外有两点需要注意，第一，如果main函数赶在goroutine之前执行完毕，那么goroutine也会销毁；第二，main也是goroutine。
	resp := <-ch
	//打印助手的回信
	fmt.Println(resp)

	//最后，关闭通道，其实通道关闭不是必须的，它与文件不同，如果没有goroutine使用到channel，就会自动销毁，而close的作用是用来通知通道的另一端不再发送消息了，另一端可以通过<-ch的第二个参数来获取通道关闭情况。
	close(ch)

	//main 线程运行
	time.Sleep(time.Second * 6) //开会

	fmt.Println("工作完成了")
}

//安排助手看邮件
func assistant1(ch chan string) {

	//模拟助手在看邮件
	go func() {
		for {
			fmt.Println("看了一封邮件")
			time.Sleep(time.Second * 1)
		}
	}()

	//老板如果找自己了
	msg := <-ch
	if msg == "喝奶茶去呗" {
		ch <- "好啊"
	}
}
