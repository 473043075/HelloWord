package org.example.dao;

import org.example.db.JDBCUtil;
import org.example.javabean.BorrowList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowListDao {
    public List<BorrowList> selectAll(int pageNum,int pageSize) {
        String sql = "SELECT a.borrow_id,b.name AS bookname,b.author,c.name AS sortname,c.description FROM borrow_list a \n" +
                "LEFT JOIN books b ON a.book_id=b.id\n" +
                "LEFT JOIN book_sort c ON b.sort_id=c.id";
        List<BorrowList> borrowLists = new ArrayList<>();
        try (ResultSet rs = JDBCUtil.getInstance().executeQueryRS(sql, new Object[]{(pageNum - 1) * pageSize, pageSize})) {
            while (rs.next()) {
                BorrowList borrowList = new BorrowList(rs.getInt("borrow_id"),
                        rs.getString("bookname"),
                        rs.getString("author"),
                        rs.getString("sortname"),
                        rs.getString("description"));
                borrowLists.add(borrowList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return borrowLists;
    }
    public int selectAllCount() {
        return 0;
    }
}
