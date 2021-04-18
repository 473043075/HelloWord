package org.example.service;

import org.example.dao.BookDao;
import org.example.javabean.Book;

import java.util.List;

public class BookService {
    private BookDao bookDao = new BookDao();

    public List<Book> searchAllBooks(int pageNum, int pageSize) {

        List<Book> books = bookDao.selectAll(pageNum, pageSize);

        return books;
    }

    public int countNum() {
        return bookDao.selectAllCount();
    }
}
