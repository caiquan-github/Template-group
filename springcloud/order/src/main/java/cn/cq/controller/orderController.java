package cn.cq.controller;

import cn.cq.FeignInterface.GoodsClient;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName orderController
 * @Auther: ToisKwon
 * @Date: 2019-11-24 04:09
 * @Description:
 */
@Controller
@RequestMapping("/order")
public class orderController {
    @Autowired
    GoodsClient goodsClient;

    @RequestMapping("/addOrder")
    @ResponseBody
    public String addOrder(){
        String s=(String)goodsClient.getGoods();
        System.out.println(s);

        return goodsClient.getGoods();
    }

}
