package com.forezp.controller;

import com.forezp.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Admin on 2019/11/24.
 */
@Controller
public class hahaController {

    @RequestMapping("/haha")
    @ResponseBody
    public String haha (@RequestBody  Book book){
        System.out.println(book);
        return "sdldls";
    }
}
