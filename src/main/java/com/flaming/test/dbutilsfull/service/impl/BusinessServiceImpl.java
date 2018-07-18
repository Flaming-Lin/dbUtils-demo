package com.flaming.test.dbutilsfull.service.impl;

import com.flaming.test.dbutilsfull.entity.Business;
import com.flaming.test.dbutilsfull.handler.BusinessHandler;
import com.flaming.test.dbutilsfull.service.BusinessService;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @Author xiaolin.tang
 * @date 2018/7/18 11:29
 */
@Service("businessService")
public class BusinessServiceImpl implements BusinessService {

    private QueryRunner queryRunner;

    @Autowired
    public BusinessServiceImpl(@Qualifier("mysqlDataSource")DataSource dataSource){
        this.queryRunner = new QueryRunner(dataSource);
    }

    @Override
    public List<Business> findBusinessAll() throws SQLException {
        return BusinessHandler.findBusinessAll(queryRunner);
    }

    @Override
    public List<Business> findBusinessById(String id) throws SQLException{
        return BusinessHandler.findBusinessById(queryRunner, id);
    }

    @Override
    public int insertBusinessAll(String nick_name, Date open_date) throws SQLException {
        return BusinessHandler.insertBusinessAll(queryRunner, nick_name, open_date);
    }

    @Override
    public int deleteBusinessById(String id) throws SQLException {
        return BusinessHandler.deleteBusinessById(queryRunner, id);
    }
}
