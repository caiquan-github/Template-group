import com.github.rholder.retry.*;
import com.google.common.base.Predicates;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Kwon
 */
public class RetryTest {
    public static void main(String[] args) throws ExecutionException, RetryException {
        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
                .retryIfException() //发送异常则充实
                .retryIfResult(Predicates.equalTo(false)) //对返回的结果判断，是否 重试   为false 就重试
                .withStopStrategy(StopStrategies.stopAfterAttempt(5)) //停止策略 最多5次 然后抛出异常
                .build();
        //Retryer调用
        retryer.call(() -> {
            System.out.println("执行n次");
            if (1==1){
                throw new RuntimeException("test");
            }
        return true;
        });
    }
}
