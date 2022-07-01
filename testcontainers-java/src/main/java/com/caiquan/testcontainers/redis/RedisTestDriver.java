package com.caiquan.testcontainers.redis;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(classes = TestcontainerApplication.class)
@RunWith(SpringRunner.class)
public class RedisTestDriver {

    @Autowired
    private RedisTemplate redisTemplate;

    //准备Redis容器，使用withExposedPorts方法暴露端口
    @ClassRule
    public static GenericContainer redis = new GenericContainer("redis:5.0.5")
            .withExposedPorts(6379);

    //注意这个注解，要在类加载之前，这样的话，Spring才能拿到这个配置来装配Bean，不然这个配置没有意义
    @BeforeClass
    public static void init() {
        //获取容器的IP地址，如果不加设置的话，就是localhost
        System.setProperty("spring.redis.host", redis.getContainerIpAddress());
        // 获取容器映射出来的端口，如果只有一个，可以使用redis.getFirstMappedPort()
        System.setProperty("spring.redis.port", redis.getFirstMappedPort().toString());
        //可以使用另外的方法，明确指定找拿个端口的映射出来的端口，当有多个端口暴露出来的时候，使用这个比较好。
//    System.setProperty("spring.redis.port", redis.getMappedPort(6379).toString());
    }


    @Test
    public void test() {
        redisTemplate.opsForValue().set("k1", "v1");
        assert "v1".equals(redisTemplate.opsForValue().get("k1"));
    }

    @After
    public void destory() {
        redis.stop();
    }

}
