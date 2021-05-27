package org.example.service;

import org.example.dao.BorrowDao;
import org.example.javabean.Borrow;

import java.util.List;

public class BorrowService {
    private BorrowDao borrowDao=new BorrowDao();
    public List<Borrow> searchAllBorrow(int pageNum,int pageSize){
        List<Borrow> borrows=borrowDao.selectAll(pageNum,pageSize);
        return borrows;
    }
    public int countNum() {
        return borrowDao.selectAllCount();
    }
}
