package com.zfc.cart.domain;

import com.zfc.book.domain.Book;

public class Cart {
    private int count;
    private Book bname;

    public Cart() {
    }

    public Cart(int count, Book bname) {
        this.count = count;
        this.bname = bname;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "count='" + count + '\'' +
                ", bname='" + bname + '\'' +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Book getBname() {
        return bname;
    }

    public void setBname(Book bname) {
        this.bname = bname;
    }
}
