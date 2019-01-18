package com.example.rocketmqdemo1.entity;

import java.io.Serializable;

/**
 * Title:com.example.rocketmqdemo1.entity.User
 * Description:
 * Copyright: Copyright (c) 2019
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2019/01/09  18:04
 */
public class User implements Serializable {

    String name;

    int age;

    int prk;

    public int getPrk() {
        return prk;
    }

    public void setPrk(int prk) {
        this.prk = prk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", prk=" + prk +
                '}';
    }
}
