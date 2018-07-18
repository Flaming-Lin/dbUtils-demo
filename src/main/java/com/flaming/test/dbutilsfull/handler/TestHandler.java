package com.flaming.test.dbutilsfull.handler;

import com.flaming.test.dbutilsfull.entity.Test;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @Author xiaolin.tang
 * @date 2018/7/18 14:33
 */
public class TestHandler {

    private static final String INSERT_TEST = "INSERT INTO test(name) " +
            "VALUES(?)";

    public static Test insertTest(QueryRunner queryRunner, String name) throws SQLException{
        return queryRunner.insert(INSERT_TEST, new BeanHandler<>(Test.class), name);
    }
}
