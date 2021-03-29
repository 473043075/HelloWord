package org.example.dao;

import org.example.db.JDBCUtil;
import org.example.javabean.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    public User selectOne(String username){
        User user=null;
        try(ResultSet rs= JDBCUtil.getInstance().executeQueryRS("SELECT * FROM borrow_card WHERE username=?",
                new Object[]{username})){
            while (rs.next()){
                user=new User(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("reader"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}
