package org.example.service;

import org.example.dao.BorrowListDao;
import org.example.javabean.BorrowList;

import java.util.List;

public class BorrowListService {
    private BorrowListDao borrowListDao=new BorrowListDao();
    public List<BorrowList> searchAllBorrowList(int pageNum,int pageSize){
        List<BorrowList> borrowLists=borrowListDao.selectAll(pageNum,pageSize);
        return borrowLists;
    }
    public int countNum() {
        return borrowListDao.selectAllCount();
    }
}
