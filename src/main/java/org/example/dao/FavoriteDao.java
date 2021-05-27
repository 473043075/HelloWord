package org.example.dao;

import org.example.db.JDBCUtil;
import org.example.javabean.Favorite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavoriteDao {
    public List<Favorite> selectAll(int pageNum,int pageSize) {
        String sql="SELECT a.id,b.name AS bookname,b.author,c.name AS sortname,c.description FROM favorite a \n" +
                "LEFT JOIN books b ON a.book_id=b.id\n" +
                "LEFT JOIN book_sort c ON b.sort_id=c.id limit ?,?";
        List<Favorite> favorites=new ArrayList<>();
        try (ResultSet rs =
                     JDBCUtil.getInstance().executeQueryRS(sql,
                             new Object[]{(pageNum - 1) * pageSize,
                                     pageSize})){
            while (rs.next()){
                Favorite favorite=new Favorite(rs.getInt("id"),
                        rs.getString("bookname"),
                        rs.getString("author"),
                        rs.getString("sortname"),
                        rs.getString("description"));
                favorites.add(favorite);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return favorites;
    }
    public int selectAllCount() {
        return 0;
    }
}
