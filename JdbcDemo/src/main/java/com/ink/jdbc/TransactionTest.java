package com.ink.jdbc;

import org.junit.Test;

import java.sql.*;

public class TransactionTest {
    @Test
    public void test(){
        String url = "jdbc:mysql://10.2.14.105:3305/test?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String username = "root";
        String password = "1";

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

//            通知数据库,开启事务,false是开启,true是关闭
            connection.setAutoCommit(false);

            String sql1 = "update account set money=money-100 where name = 'A';";
            connection.prepareStatement(sql1).executeUpdate();

//            制造错误,让后续不能执行
//            int i = 1/0;

            String sql2 = "update account set money=money+100 where name = 'B';";
            connection.prepareStatement(sql2).executeUpdate();

//            两条sql都执行成功就提交事务
            connection.commit();
            System.out.println("提交成功");
        } catch (Exception e) {
//            如果有异常,通知数据库回滚
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
