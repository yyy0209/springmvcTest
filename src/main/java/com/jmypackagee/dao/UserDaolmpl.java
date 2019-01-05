package com.jmypackagee.dao;  /*这个包存放的是对数据库操作*/

import com.jmypackagee.pojo.User;
import com.jmypackagee.utilTest.JdbcUtil;
import com.jmypackagee.utilTest.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaolmpl implements IUserDao {
    @Override
    public int insert(User user) {  //插入数据的方法实现
        return JdbcUtil.executeUpdate("insert into user(username,password,tele,grade_id) values(?,?,?,?)",user.getUsername(),user.getPassword(),user.getTele(),"3");
    }

    @Override
    public List<User> getLists() {  //查询
        return JdbcUtil.executQuery("select * from user", new RowMap<User>() {
            @Override
            public User rowMapping(ResultSet rs) {    //把ResultSet类型对象转换为Product类型
                User user = new User();
                try {
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setTele(rs.getString("tele"));
                    user.setGrade_id(rs.getInt("grade_id"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return user;
            }
        }, null);
    }

    @Override
    public User getOne(String username) {  //通过用户名查找出这个用户
        /*调用工具层查找单个用户对象的方法*/
        return JdbcUtil.queryOne("select * from user where username=?", new RowMap<User>() {
            @Override
            public User rowMapping(ResultSet rs) {   //把ResultSet类型对象转换为User类型
                User u = new User();
                try {
                    u.setId(rs.getInt("id"));
                    u.setUsername(rs.getString("username"));
                    u.setPassword(rs.getString("password"));
                    u.setTele(rs.getString("tele"));
                    u.setGrade_id(rs.getInt("grade_id"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return u;
            }
        }, username);
    }

    @Override
    public int amend(User user) {   //修改
        int k = JdbcUtil.executeUpdate("update user set id=?,username=?,password=?,tele=?,grade_id=? where id=?",user.getId(),user.getUsername(),user.getPassword(),user.getTele(),user.getGrade_id(),user.getId());
        return k;
    }

    @Override
    public int deleUser(int id) {  //删除
        return JdbcUtil.executeUpdate("delete from user where id=?",id);
    }

    @Override
    public User getOne(int id) {   //查找一个
        return JdbcUtil.queryOne("select * from user where id=?", new RowMap<User>() {
            @Override
            public User rowMapping(ResultSet rs) {   //把ResultSet类型对象转换为User类型
                User u = new User();
                try {
                    u.setId(rs.getInt("id"));
                    u.setUsername(rs.getString("username"));
                    u.setPassword(rs.getString("password"));
                    u.setTele(rs.getString("tele"));
                    u.setGrade_id(rs.getInt("grade_id"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return u;
            }
        }, id);
    }
}
