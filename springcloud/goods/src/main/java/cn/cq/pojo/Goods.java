package cn.cq.pojo;

import sun.plugin2.message.Serializer;

import java.io.Serializable;

/**
 * @ClassName Goods
 * @Auther: ToisKwon
 * @Date: 2019-11-24 02:55
 * @Description:
 */
public class Goods implements Serializable {
    private Integer id;
    private String name;
    private Double mn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMn() {
        return mn;
    }

    public void setMn(Double mn) {
        this.mn = mn;
    }
}
