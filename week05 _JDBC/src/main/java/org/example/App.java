package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        String urlMySql = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=true&useOldAliasMetadataBehavior=true&serverTimezone=Asia/Shanghai";
        String usernameMySql = "root";
        String passwordMySql = "123456";
        Connection connection = DriverManager.getConnection(urlMySql, usernameMySql, passwordMySql);
        //3.获取sql语句执行对象
        Statement statement = connection.createStatement();
        //4.获取结果集
        ResultSet resultSet = statement.executeQuery("SELECT * FROM `user`");
        //4.1遍历结果集
        while (resultSet.next()) {
            //4.2封装对象
            User user = new User();
            int id = resultSet.getInt("id");
            user.setId(id);
            String username = resultSet.getString("username");
            user.setUsername(username);
            String sex = resultSet.getString("sex");
            user.setSex(sex);
            Date birthday = resultSet.getDate("birthday");
            user.setBirthday(birthday);
            String address = resultSet.getString("address");
            user.setAddress(address);
            System.out.println(user);
        }
        //5.关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
