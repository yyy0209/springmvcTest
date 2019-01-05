package com.jmypackagee.web;

import com.jmypackagee.pojo.User;
import com.jmypackagee.service.IUserService;
import com.jmypackagee.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller/*加这个注解能把我们定义的类扫描到HandleMapping*/
public class WebTest {
    private IUserService service = new UserServiceImpl();
    @RequestMapping("/a.do")  //加注解声明处理的是那个请求
    public String web(ModelMap map){   //第1种
        //map.addAttribute("a","map attribute"); //1
        map.put("a","map test");   //2
        return "a";
    }
    /*@RequestMapping("/a.do")  //加注解声明处理的是那个请求
    public String web(Model map){   第2种
        map.addAttribute("a","map attribute");
        return "a";
    }*/
    /*@RequestMapping("/a.do")  //加注解声明处理的是那个请求
    public String web(HttpServletRequest request){   第3种
        request.setAttribute("a","hhhhhhhh");   //这说明了是转发
        return "a";
    }*/
    /*@RequestMapping("/a.do")  //加注解声明处理的是那个请求
    public String web(Map<String,Object> map){   //第4种
        map.put("a","map test");
        return "a";
    }*/
    /*@RequestMapping("/b.do")
    public String b(String name, String pwd){
        System.out.println(name + "   " + pwd);
        return "";
    }*/
   /* @RequestMapping("/a.do")  //加注解声明处理的是那个请求
    public String web(){
        //redirect:这个是重定向
        return "redirect:b.do";
    }*/
    @RequestMapping("/b.do")
    public String b(@RequestParam("name") String abc, String pwd){   //加注解较正参数
        System.out.println(abc + "   " + pwd);
        return "";
    }
    /*@RequestMapping("/b.do")
    public String b(UserQ userQ){
        System.out.println(userQ);
        return "";
    }*/
    @RequestMapping("/list.do")
    public String list(ModelMap map){
        List<User> users = service.getLists();  //查询全部对象
        map.put("users",users);  //带数据
        return "list";  //转发
    }
    @RequestMapping("/addUser.do")
    public String addUser(){
        return "addUser";   //转发
    }
    @RequestMapping("/doAddUser.do")
    public String doAddUser(User user){
        service.insert(user);  //添加对象
        //redirect:重定向
        return "redirect:list.do";
    }
    @RequestMapping("/deleteUser.do")
    public String deleteUser(int id){
        service.deleUser(id); //删除对象
        //重定向
        return "redirect:list.do";
    }
    @RequestMapping("/updateUser.do")
    public String updateUser(ModelMap map, int id){
        User user = service.getOne(id); //查询这个对象
        map.put("user", user);  //带数据
        return "updateUser";   //转发
    }
    @RequestMapping("/doUpdateUser.do")
    public String doUpdateUser(User user){
        service.amend(user);  //修改对象
        return "redirect:list.do";
    }
}
