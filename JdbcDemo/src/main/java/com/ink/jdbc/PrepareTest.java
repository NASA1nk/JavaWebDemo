package com.ink.jdbc;

import java.sql.*;

public class PrepareTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        配置信息
//        解决乱码问题
        String url = "jdbc:mysql://10.2.14.105:3305/test?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String username = "root";
        String password = "1";

//        加载驱动
//        驱动通过反射获取
        Class.forName("com.mysql.jdbc.Driver");
//        连接数据库，connection就代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);
//        先编写sql
        String sql = "insert into users (id,name,password,email,birthday) values (?,?,?,?,?);";
//        预编译sql
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        编译完后对具体字段赋值
//        第一个占位符
        preparedStatement.setInt(1,5);
//        第二个占位符
        preparedStatement.setString(2,"赵信");
        preparedStatement.setString(3,"123456");
        preparedStatement.setString(4,"111@qq.com");
//        外面的Date是sql包下的,里面的Date是util包下的
        preparedStatement.setDate(5,new Date(new java.util.Date().getTime()));

//        执行sql，返回表中被影响的行数
        int i = preparedStatement.executeUpdate();
        System.out.println(i);
        if(i > 0){
            System.out.println("插入成功");
        }
//        关闭连接
        preparedStatement.close();
        connection.close();
    }
}
