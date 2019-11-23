package cn.cq.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @ClassName GoodsController
 * @Auther: ToisKwon
 * @Date: 2019-11-24 02:46
 * @Description:
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {




    @RequestMapping("/getGoods")
    @ResponseBody
    public String getGoods(){

        return "diannao";
    }
}
