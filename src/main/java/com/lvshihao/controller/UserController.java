package com.lvshihao.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: lvshihao
 * @Date: 2019-7-23$ $
 * @Description:
 */
@Controller
public class UserController {
    /**
     * 登陆逻辑处理
     */
    @RequestMapping("/login")
    public String login(String name,String password,Model model){
        /**
         * 使用Shiro编写认证操作
         */
        //1.获取Subject
        Subject subject= SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token=new UsernamePasswordToken(name,password);
        //3.执行登陆方法
        try{
            subject.login(token);
            //登陆成功
            return "redirect:/testThymeleaf";
        }catch(UnknownAccountException e){
            //登陆失败:用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            //登陆失败:密码
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }
    @RequestMapping("/unAuth")
    public String unAuth(){
        return "unAuth";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/add")
    public String add(){
        return "user/add";
    }
    @RequestMapping("/update")
    public String update(){
        return "user/update";
    }
    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(Model model){
        //把数据存入model
        model.addAttribute("name","吕世昊程序员");
        //返回test.html
        return "test";
    }
}
