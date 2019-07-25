package com.lvshihao.shiro;

import com.lvshihao.entity.User;
import com.lvshihao.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * @author: lvshihao
 * @Date: $ $
 * @Description:
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        //给资源进行授权
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();

        //这个是从SimpleAuthenticationInfo中获取第一个参数,得到传入的值
        User user=(User)SecurityUtils.getSubject().getPrincipal();
        //根据登陆者的id再次查询这个用户的信息
        User byId = userService.findById(user.getId());
        //将再次获取用户的信息获取,并将这个用户的权限添加到授权里面
        info.addStringPermission(byId.getPERMS());
        System.out.println("--------------");
        System.out.println(user);
        System.out.println(byId);
        System.out.println("--------------");
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        User user = userService.findByName(token.getUsername());
        //编写shiro判断逻辑,判断用户名和密码
        //1.判断用户名
        if(Objects.isNull(user)){
            //用户名不存在
            return null;//shiro底层会抛出UnknowAccountException
        }
        //2.判断密码
        return new SimpleAuthenticationInfo(user,user.getPASSWORD(),"");
    }
}
