package com.MyProject.schedule.model.dao;

import com.MyProject.schedule.util.JDBCUtil;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
    public int executeUpdate(String sql,Object... params) throws Exception {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        if (params != null && params.length > 0){
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1,params[i]);
            }
        }

        int update = preparedStatement.executeUpdate();

        return update;
    }

    public <T> List<T> executeQuery(Class<T> clazz,String sql,Object... params) throws Exception {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        if (params != null && params.length > 0){
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1,params[i]);
            }
        }

        ArrayList<T> list = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()){
            T t = clazz.getDeclaredConstructor().newInstance();
            for (int i = 1; i <= columnCount; i++) {

                Object value = resultSet.getObject(i);
                String fieldName = metaData.getColumnLabel(i);

                Field declaredField = clazz.getDeclaredField(fieldName);
                declaredField.setAccessible(true);
                declaredField.set(t,value);


            }
            list.add(t);
        }
        return list;
    }

    public <T> T executeQueryBean(Class<T> clazz,String sql,Object... params) throws Exception {
        List<T> list = this.executeQuery(clazz, sql, params);

        if (list == null || list.size() ==0){
            return null;
        }

        return list.get(0);
    }
}
