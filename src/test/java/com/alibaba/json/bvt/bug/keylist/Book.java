package com.alibaba.json.bvt.bug.keylist;

public class Book implements Keyable<String> {
    private String name;
    private String title;

    public Book(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getKey() {
        return name;
    }
}
