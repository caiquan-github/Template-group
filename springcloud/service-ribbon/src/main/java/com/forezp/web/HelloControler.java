package com.forezp.web;

import com.forezp.service.Book;
import com.forezp.service.HelloService;
import com.forezp.service.HiFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fangzhipeng on 2017/4/6.
 */
@RestController
public class HelloControler {

   @Autowired
   private HiFeign hiFeign;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        Book book = new Book();
        book.setName(name);
        return hiFeign.haha(book);
    }


}
