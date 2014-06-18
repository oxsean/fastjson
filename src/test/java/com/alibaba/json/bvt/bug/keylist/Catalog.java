package com.alibaba.json.bvt.bug.keylist;

public class Catalog {
    private String name;
    private KeyList<String, Book> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public KeyList<String, Book> getBooks() {
        return books;
    }

    public void setBooks(KeyList<String, Book> books) {
        this.books = books;
    }
}
