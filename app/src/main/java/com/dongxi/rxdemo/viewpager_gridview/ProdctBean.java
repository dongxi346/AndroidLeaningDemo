package com.dongxi.rxdemo.viewpager_gridview;

/**
 * Created by Administrator on 2017/11/9.
 */

public class ProdctBean {
    private String name ;
    private int url ;

    public ProdctBean(String name, int image) {
        this.name = name ;
        this.url = image ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }
}
