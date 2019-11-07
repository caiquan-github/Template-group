import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
	
	  public static void main(String[] args) throws Exception {
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
	        context.start();
	        System.in.read(); 
	    }
}
