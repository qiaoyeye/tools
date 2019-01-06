package com.restful.up.controller;

import com.alibaba.fastjson.JSONObject;
import com.restful.up.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class Login {

    @Autowired
    LoginService loginServiceI;

    @RequestMapping(value = "/Userlogin", method=RequestMethod.POST)
    @ResponseBody
    public Boolean login(@RequestBody JSONObject data) {
       Boolean result = false;
        String username = data.getString( "username" );
        String password = data.getString( "password" );
        if((!username.equals( " " ) && username != null)|| (!password.equals( " " )&& password!=null)) {
            result  =   loginServiceI.login( username,password );
        }

        return result ;
    }

    @RequestMapping(value = "/index")
    public String index(){
            return "index";
    }
    @RequestMapping(value = "/stack")
    public String stack(){
        return "stack";
    }


//        /**
//         * 登录
//         * @param username
//         * @param password
//         * @return
//         */
//        @ResponseBody
//        @RequestMapping(value = "/login", method = RequestMethod.POST)
//        public Object login(String username, String password) {
//            ModelAndView mv = new ModelAndView();
//            UserestModel user = createUserService.login(username);
//            if(user != null){
//                if (username.equals(user.getUsername())) {
//                    if (password.equals(user.getPassword())) {
//                        List<MenuModel> menuitemList = menuitemService.getMenus();
//                        System.out.println(menuitemList.get(1));
//                        //  mv.setViewName("views/menu");
//                        mv.setViewName("http");
//                        mv.addObject("menuitemList", menuitemList);
//
//                    }else {
//                        mv.setViewName("login");
//                    }
//                }else {
//                    mv.setViewName("login");
//                }
//            }else {
//                mv.setViewName("login");
//            }
//            return mv;
//        }









}
