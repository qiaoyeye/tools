//package com.restful.up.dao.impl;
//
//import com.restful.up.dao.LoginServiceDao;
//import com.restful.up.model.UserModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class LoginServiceI implements LoginServiceDao {
//
//    @Autowired
//    private LoginServiceDao loginServiceDao;
//
//
//    public Boolean login(String userName, String passWord) {
//        UserModel userModel =  loginServiceDao.login( userName );
//        String pwd = userModel.getPassWord();
//        String name = userModel.getUserName();
//        if (passWord.equals(pwd)){
//            return true;
//        }
//        return false;
//
//    }
//}
