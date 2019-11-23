package cn.cq.FeignInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName GoodsClient
 * @Auther: ToisKwon
 * @Date: 2019-11-24 04:13
 * @Description:
 */
@FeignClient("project-goods")
public interface GoodsClient {
    @RequestMapping("/goods/getGoods")
    String getGoods();
}
