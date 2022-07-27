package main

import (
	"fmt"
	"time"
)

/*
模拟超时

除此之外，有些情况下我们不希望通道阻塞太久，假设5秒钟还取不出通道的数据，就超时退出，
那我们可以使用time.After方法来实现。time.After会返回一个通道类型，
它的作用是传入一个目标时间（比如5s），我们在5秒后就可以通过通道获取预设置的超时通知，这样就达到了定时器的目的。

*/
func main() {

	ch1 := make(chan int)
	ch2 := make(chan int)

	go func() {
		for {
			select {
			case d := <-ch1:
				fmt.Println("ch1", d)
			case d := <-ch2:
				fmt.Println("ch2", d)
			case <-time.After(time.Second * 5):
				fmt.Println("接收超时")
			}
		}
	}()

	time.Sleep(time.Second * 6)
}
