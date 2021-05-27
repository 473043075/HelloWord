package org.example.service;

import org.example.dao.FavoriteDao;
import org.example.javabean.Favorite;

import java.util.List;

public class FavoriteService {
    private FavoriteDao favoriteDao=new FavoriteDao();
    public List<Favorite> searchAllBorrow(int pageNum,int pageSize){
        List<Favorite> favorites=favoriteDao.selectAll(pageNum,pageSize);
        return  favorites;
    }
    public int countNum() {
        return favoriteDao.selectAllCount();
    }
}
