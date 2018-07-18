package com.flaming.test.dbutilsfull.handler;

import com.flaming.test.dbutilsfull.entity.Business;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Qualifier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author xiaolin.tang
 * @date 2018/7/18 11:21
 */
public class BusinessHandler{

    private static final String QUERY_BUSINESS_BY_ID = "SELECT * FROM shop.business WHERE id = ?";

    private static final String QUERY_BUSINESS_ALL = "SELECT * FROM shop.business";

    private static final String INSERT_BUSINESS_ALL = "INSERT INTO shop.business(id, imgurl, memo, nick_name, open_date, password, telephone, username) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String DELETE_BUSINESS_BY_ID = "DELETE FROM shop.business WHERE id = ?";

    private static class BusinessListHandler extends AbstractListHandler<Business>{
        @Override
        protected Business handleRow(ResultSet resultSet) throws SQLException {
            Business business = new Business();
            business.setId(resultSet.getString("id"));
            business.setImgurl(resultSet.getString("imgurl"));
            business.setMemo(resultSet.getString("memo"));
            business.setNick_name(resultSet.getString("nick_name"));
            business.setOpen_date(resultSet.getDate("open_date"));
            business.setPassword(resultSet.getString("password"));
            business.setTelephone(resultSet.getString("telephone"));
            business.setUsername(resultSet.getString("username"));
            return business;
        }
    }

    public static List<Business> findBusinessById(QueryRunner queryRunner, String id) throws SQLException{
        return queryRunner.query(QUERY_BUSINESS_BY_ID, new BusinessListHandler(), id);
    }

    public static List<Business> findBusinessAll(QueryRunner queryRunner) throws SQLException{
        return queryRunner.query(QUERY_BUSINESS_ALL, new BusinessListHandler());
    }

    public static int insertBusinessAll(QueryRunner queryRunner, String nick_name, Date open_date) throws SQLException{
        Object[] params = new Object[]{UUID.randomUUID().toString().replaceAll("-",""), "imgurl", "memo", nick_name, open_date, "password", "telephone", "username"};

        return queryRunner.update(INSERT_BUSINESS_ALL, params);
    }

    public static int deleteBusinessById(QueryRunner queryRunner, String id) throws SQLException{
        return queryRunner.update(DELETE_BUSINESS_BY_ID, id);
    }

    public static int[] batchInsert(QueryRunner queryRunner, List<String> nick_names, List<Date> dates) throws SQLException{
        Object[][] params = new Object[nick_names.size()][];
        for(int i = 0; i < nick_names.size(); i++){
            params[i] = new Object[8];
            params[i][0] = UUID.randomUUID().toString().replaceAll("-","");
            params[i][1] = "imgurl";
            params[i][2] = "memo";
            params[i][3] = nick_names.get(i);
            params[i][4] = dates.get(i);
            params[i][5] = "password";
            params[i][6] = "telephone";
            params[i][7] = "username";
        }
        return queryRunner.batch(INSERT_BUSINESS_ALL, params);
    }

    public static int[] batchDelete(QueryRunner queryRunner, List<String> ids) throws SQLException{
        Object[][] params = new Object[ids.size()][];
        for(int i = 0; i < ids.size(); i++){
            params[i] = new Object[1];
            params[i][0] = ids.get(i);
        }
        return queryRunner.batch(DELETE_BUSINESS_BY_ID, params);
    }

}
