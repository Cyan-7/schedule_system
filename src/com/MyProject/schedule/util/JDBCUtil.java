package com.MyProject.schedule.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    private static Connection connection;
    private static final DataSource dataSource;
    private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static{
        try {
            InputStream stream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(stream);

            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        if (threadLocal.get() == null){
           connection = dataSource.getConnection();
           threadLocal.set(connection);
        }
        return connection;
    }

    public static void release() throws SQLException {
        if (threadLocal.get() != null){
            threadLocal.remove();
            connection.close();
        }
    }
}
