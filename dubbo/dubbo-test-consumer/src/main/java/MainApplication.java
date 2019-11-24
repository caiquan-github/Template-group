import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.caiquan.gmall.service.ConsumerService;

public class MainApplication {
	 @SuppressWarnings("resources")
	 public static void main(String[] args) throws Exception {
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
	        ConsumerService consumerService=context.getBean(ConsumerService.class);
	        String s=consumerService.consumer();
	        System.out.println(s);
	  
	        System.in.read(); 
	    }
}
