package com.flaming.test.dbutilsfull.service;

import com.flaming.test.dbutilsfull.entity.Business;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @Author xiaolin.tang
 * @date 2018/7/18 11:27
 */
public interface BusinessService {

    public List<Business> findBusinessById(String id) throws SQLException;

    public List<Business> findBusinessAll() throws SQLException;

    public int insertBusinessAll(String nick_name, Date open_date) throws SQLException;

    public int deleteBusinessById(String id) throws SQLException;

}
