package org.example.dao;

import org.example.db.JDBCUtil;
import org.example.javabean.Borrow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowDao {
    public List<Borrow> selectAll(int pageNum,int pageSize){
        String sql="select borrow_books.*,borrow_books.book_id,borrow_books.borrow_date,borrow_books.end_date,borrow_books.return_date,borrow_books.illegal,borrow_books.manmger_id from borrow_books";
        List<Borrow>borrows=new ArrayList<>();
        try(ResultSet rs= JDBCUtil.getInstance().executeQueryRS(sql,new Object[]{(pageNum-1)*pageSize,pageSize})) {
            while (rs.next()){
                Borrow borrow=new Borrow(rs.getInt("id"),
                        rs.getDate("borrow_date"),
                        rs.getDate("end_data"),
                        rs.getDate("return_data"),
                        rs.getString("illegal"),
                        rs.getString("manager_id"));
                borrows.add(borrow);
                System.out.println(borrow.getBookname());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return borrows;
    }
    public int selectAllCount() {
        return 0;
    }
}
