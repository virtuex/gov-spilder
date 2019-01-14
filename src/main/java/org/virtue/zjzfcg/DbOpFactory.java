package org.virtue.zjzfcg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Map;

public class DbOpFactory {
    static Logger logger = LoggerFactory.getLogger(DbOpFactory.class);
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/zhaobiao";
    public static DbOpFactory getInstance(){
        return new DbOpFactory();
    }

    private DbOpFactory(){

    }
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "xda265856";
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public void init() {
        // 注册 JDBC 驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage(),e);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
    }

    public void insert(Map test){
        try{
            stmt = conn.createStatement();
            String sql;
            sql = String.format("insert into zhaobiao(id,mainBidMenuName,title,projectCode,projectName,pubDate,districtName,type,typeName,keywords,url) values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')"
                    ,test.get("id"),test.get("mainBidMenuName"),test.get("title"),
                    test.get("projectCode"),test.get("projectName"),test.get("pubDate"),test.get("districtName"),
                    test.get("type"),test.get("typeName"),test.get("keywords"),test.get("url"));
            stmt.executeUpdate(sql);
        }catch(SQLException se){
            // 处理 JDBC 错误
            logger.error(se.getMessage(),se);
        }catch(Exception e){
            // 处理 Class.forName 错误
            logger.error(e.getMessage(),e);
        }
    }

    public void close(){
        // 完成后关闭
        try {
            stmt.close();
            conn.close();
        } catch (SQLException e) {
           logger.error(e.getMessage(),e);
        }

    }
}
