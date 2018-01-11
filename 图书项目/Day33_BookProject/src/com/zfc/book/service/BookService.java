package com.zfc.book.service;

import com.zfc.book.dao.BookDao;
import com.zfc.book.domain.Book;
import com.zfc.cart.domain.Cart;
import com.zfc.category.domain.Category;

import javax.servlet.http.HttpSession;
import java.util.List;

public class BookService {
    BookDao bookDao = new BookDao();
    Category category = new Category();
    public List<Book> queryClassifyBook(String name){
        if (name != null){
            if (name.equals("1")){
                category.setCname("JavaSE");
                System.out.println(category.getCname());
            }
            if (name.equals("2")){
                category.setCname("JavaEE");
            }
            if (name.equals("3")){
                category.setCname("Javascript");
            }
            if (name.equals("s")){
                List<Book> books = bookDao.queryAllifyBook();
                return books;
            }
            List<Book> books = bookDao.queryClassifyBook(category);
            return books;
        }else {
            System.out.println("抛异常");
        }
        return null;
    }

    int a= 0;
    public Book queryByBid(String bid){
        if (bid != null){
            Book book = bookDao.queryBybid(bid);
            System.out.println(a);
            a++;
            return book;
        }
        return null;
    }

    public List<Cart> deleteByBid(List<Cart> car,String bid){
            for (Cart cart : car) {
                Book bname = cart.getBname();
                if (bname.getBid().equals(bid)){
                    System.out.println(bname.getBid());
                    System.out.println(cart);
                    car.remove(cart);
                    return car;
                }
            }
            return null;
    }

}
