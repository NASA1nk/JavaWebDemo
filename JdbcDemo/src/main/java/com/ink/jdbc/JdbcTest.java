package com.ink.jdbc;

import java.sql.*;

public class JdbcTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        配置信息
//        解决乱码问题
        String url = "jdbc:mysql://10.2.14.105:3305/test?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "1";

//        加载驱动
//        驱动通过反射获取
        Class.forName("com.mysql.jdbc.Driver");
//        连接数据库，connection就代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);
//       statement是向数据库发送sql的对象，用于crud
//       不安全，可能会发生sql注入
        Statement statement = connection.createStatement();
//        编写sql
        String sql = "select * from users;";
//        执行sql，返回结果集
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            System.out.println("id=" + rs.getObject("id"));
            System.out.println("name=" + rs.getObject("name"));
            System.out.println("password=" + rs.getObject("password"));
            System.out.println("email=" + rs.getObject("email"));
            System.out.println("birthday=" + rs.getObject("birthday"));
        }
//        关闭连接，先开的后关
        rs.close();
        statement.close();
        connection.close();

    }
}
