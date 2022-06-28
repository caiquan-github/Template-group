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
                .retryIfResult(Predicates.equalTo(false)) //对返回的结果判断，是否 重试
                .withAttemptTimeLimiter(AttemptTimeLimiters.fixedTimeLimit(1, TimeUnit.SECONDS)) //执行时间限制策略
                .withStopStrategy(StopStrategies.stopAfterAttempt(5)) //停止策略
                .build();
//Retryer调用
        retryer.call(() -> true);
    }
}
