package com.mooc.controller;

import com.mooc.Object.Admin;
import com.mooc.Object.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xiongpc on 2017/8/19.
 */
@Controller
public class TestController {

    @RequestMapping(value = "baseType.do",method = RequestMethod.GET)
    @ResponseBody
    public String baseType(@RequestParam("xage") int age){

        return "age:"+age;
    }

    @RequestMapping(value = "baseType2.do",method = RequestMethod.GET)
    @ResponseBody
    public String baseType2(Integer age){

        return "age:"+age;
    }

    @RequestMapping(value = "array.do",method = RequestMethod.GET)
    @ResponseBody
    public String array(String[] name){

        //return "age:"+age;
        StringBuffer stringBuffer = new StringBuffer();
        for (String s : name){
            stringBuffer.append(s).append(" ");
        }
        return stringBuffer.toString();
    }

    //todo http://localhost:8080/object.do?name=lisi&age=18&contactInfo.phone=10086

    //TODO http://localhost:8080/object.do?user.name=zhangsan&admin.name=lisi&age=19

    @RequestMapping(value = "object.do",method = RequestMethod.GET)
    @ResponseBody
    public String object(User user, Admin admin){

        return user.toString()+" "+admin.toString();
    }

    @InitBinder("user")
    public void initUser(WebDataBinder binder){
        binder.setFieldDefaultPrefix("user.");
    }
    @InitBinder("admin")
    public void initAdmin(WebDataBinder binder){
        binder.setFieldDefaultPrefix("admin.");
    }
}
