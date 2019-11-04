package cn.itcast.dao;

import cn.itcast.domain.Stutend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Admin on 2019/7/19.
 */
public interface StutendDao extends JpaRepository<Stutend,Integer>,JpaSpecificationExecutor<Stutend> {

    @Modifying
    public void removeById (int id);
}
