package com.forezp.service;

/**
 * Created by Admin on 2019/11/24.
 */
public class Book {
    private String name;
    private int sum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", sum=" + sum +
                '}';
    }
}