package com.zhuanglide.demo.module.test.entry;

import java.io.Serializable;


public class Test implements Serializable{
    private static final long serialVersionUID = 2806350473536565902L;
    
    private long id;
    private String name;
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
}
