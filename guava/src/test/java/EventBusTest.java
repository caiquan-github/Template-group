import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.junit.Test;

/**
 * @author Kwon
 */
public class EventBusTest {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus("lwl");
        eventBus.register(new OrderEventListener());
        eventBus.post(new OrderMessage("csc"));

    }
}


class OrderMessage {
    private String message;

    public OrderMessage(String csc) {
        message=csc;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

class OrderEventListener {
    @Subscribe
    public void dealWithEvent(OrderMessage event) {
        System.out.println("内容：" + event.getMessage());
    }
}