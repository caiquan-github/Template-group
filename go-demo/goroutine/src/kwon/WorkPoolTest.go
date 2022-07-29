package main

import (
	"fmt"
	"math/rand"
	"sync"
	"time"
)

type Job struct {
	id       int
	randomno int // 用于计算其每位数之和
}
type Result struct {
	job         Job
	sumofdigits int //表示计算的结果（每位数字之和）
}

var jobs = make(chan Job, 10)
var results = make(chan Result, 10)

//digits 函数的任务实际上就是计算整数的每一位之和，最后返回该结果。为了模拟出 digits 在计算过程中花费了一段时间，我们在函数内添加了两秒的休眠时间。
//输入 258  输出 2+5+8
func digits(number int) int {
	sum := 0
	no := number
	for no != 0 {
		digit := no % 10
		sum += digit
		no /= 10
	}
	time.Sleep(2 * time.Second)
	return sum
}

//工作
func worker(wg *sync.WaitGroup) {
	//进行 jobs任务队列的消费    jobs 不关闭一直会阻塞
	for job := range jobs {
		//output 是计算结果
		output := Result{job, digits(job.randomno)}
		//传给结果队列 results 结果队列的消费者会打印数据的
		results <- output
	}
	wg.Done()
}

//创建工作池
func createWorkerPool(noOfWorkers int) {
	//创建一个 WaitGroup
	var wg sync.WaitGroup
	for i := 0; i < noOfWorkers; i++ {
		//WaitGroup +1
		wg.Add(1)
		//协程调用任务 将 WaitGroup 传递过去  开了10个协程
		go worker(&wg)
	}
	wg.Wait()
	close(results)
}

// 把任务安排一下 noOfJobs 任务数量
func allocate(noOfJobs int) {
	for i := 0; i < noOfJobs; i++ {
		//随机数
		randomno := rand.Intn(999)
		//丢进通道
		job := Job{i, randomno}
		//由于 jobs 的buffer设定为10 这里实际会阻塞
		jobs <- job
	}
	//关闭通道
	close(jobs)
}

//返回
func result(done chan bool) {
	// 打印结果
	//results 是信道 只要没关闭 这里会一直循环
	for result := range results {
		fmt.Printf("Job id %d, input random no %d , sum of digits %d\n", result.job.id, result.job.randomno, result.sumofdigits)
	}
	done <- true
}
func main() {
	//获取当前时间
	startTime := time.Now()

	//分配工作 协程
	noOfJobs := 100
	go allocate(noOfJobs)

	//创建一个通道
	done := make(chan bool)

	//调用携程
	go result(done)
	//创建工作池
	noOfWorkers := 10
	createWorkerPool(noOfWorkers)
	//读取通道
	<-done

	//结束了 总结时间
	endTime := time.Now()
	diff := endTime.Sub(startTime)
	fmt.Println("total time taken ", diff.Seconds(), "seconds")
}
