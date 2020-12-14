package com.austin.custom.spring.pojo;

import java.util.ArrayList;
import java.util.List;

public class BeanConfig {

    private List<Bean> beans = new ArrayList<>();

    public List<Bean> getBeans() {
        return beans;
    }

    public void setBeans(List<Bean> beans) {
        this.beans = beans;
    }
}
