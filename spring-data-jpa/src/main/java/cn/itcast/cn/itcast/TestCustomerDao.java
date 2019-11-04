package cn.itcast.cn.itcast;

import cn.itcast.dao.StutendDao;
import cn.itcast.domain.Stutend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

/**
 * Created by Admin on 2019/7/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestCustomerDao {

    @Autowired
    private StutendDao stutendDao;

    /**
     * 保存客户：调用save(obj)方法
     */
    @Test

    public void test1() {

        Object s=stutendDao.findById(1);



    }

}
