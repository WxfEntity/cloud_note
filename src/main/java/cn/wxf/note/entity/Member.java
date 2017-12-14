package cn.wxf.note.entity;

import cn.wxf.note.annotation.DBTable;
import cn.wxf.note.annotation.Id;
import cn.wxf.note.annotation.SQLClolum;

import java.sql.Timestamp;

/**
 * Created by TYZ027 on 2017/12/12.
 */
@DBTable(name = "MEMBER")
public class Member {
    //主键ID
    @Id(autoCreat = false)
    @SQLClolum
    private String id;

    @SQLClolum
    private String name;

    @SQLClolum
    private int age;

    @SQLClolum
    private String description;//个人描述

   @SQLClolum(length = 25)
    private Long num;

    @SQLClolum(name = "createime")
    private Timestamp createime;

    @SQLClolum(name = "reale")
    private Boolean reale;

    @SQLClolum
    private Double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
