package com.restful.up.service;

import com.restful.up.dao.LoginServiceDao;
import com.restful.up.model.UserModel;
import jdk.nashorn.internal.runtime.GlobalConstants;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.catalina.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginService {

    @Autowired
    private LoginServiceDao loginServiceDao;

    public Boolean login(String userName, String passWord) {
        UserModel userModel =  loginServiceDao.login( userName );
        String pwd = userModel.getPassWord();
        String name = userModel.getUserName();
        if (passWord.equals(pwd)){
            return true;
        }
        return false;

    }
}
