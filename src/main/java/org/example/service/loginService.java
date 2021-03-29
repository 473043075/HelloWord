package org.example.service;

import org.example.dao.LoginDao;
import org.example.javabean.User;

import javax.servlet.http.HttpSession;

public class loginService {
    private LoginDao loginDao=new LoginDao();
    public String login(String username, String password, HttpSession session) {
        User user=loginDao.selectOne(username);
        if (user==null){
            return "用户不存在";
        }else {
            if (password.equals(user.getPassword())){
                session.setAttribute("user",user);
                session.setAttribute("isLogin",true);
                return "1";
            }else {
                return "密码错误";
            }
        }
    }
}
