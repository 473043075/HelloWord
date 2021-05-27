package org.example.dao;

import org.example.db.JDBCUtil;
import org.example.javabean.Borrow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowDao {
    public List<Borrow> selectAll(int pageNum,int pageSize){
        String sql="SELECT * FROM borrow_books a LEFT JOIN books b ON a.book_id=b.id limit ?,?";
        List<Borrow>borrows=new ArrayList<>();
        try(ResultSet rs =
                    JDBCUtil.getInstance().executeQueryRS(sql,
                            new Object[]{(pageNum - 1) * pageSize,
                                    pageSize})) {
            while (rs.next()){
                Borrow borrow=new Borrow(rs.getString("name"),
                        rs.getDate("borrow_date"),
                        rs.getDate("end_date"),
                        rs.getDate("return_date"),
                        rs.getString("illegal"),
                        rs.getString("manager_id"));
                borrows.add(borrow);
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
