package com.flaming.test.dbutilsfull.controller;

import com.flaming.test.dbutilsfull.entity.Business;
import com.flaming.test.dbutilsfull.entity.Test;
import com.flaming.test.dbutilsfull.handler.BusinessHandler;
import com.flaming.test.dbutilsfull.handler.TestHandler;
import com.flaming.test.dbutilsfull.service.BusinessService;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author xiaolin.tang
 * @date 2018/7/18 11:31
 */
@RestController("businessController")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @GetMapping("/findById")
    public List<Business> findBusinessById(@RequestParam(name = "id") String id){
        try{
            return businessService.findBusinessById(id);
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/findAll")
    public List<Business> findBusinessAll(){
        try {
            return businessService.findBusinessAll();
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/insert")
    public int insertBusinessAll(@RequestParam String nick_name){
        try{
            return businessService.insertBusinessAll(nick_name, new Date());
        } catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    @GetMapping("/deleteById")
    public int deleteBusinessById(String id){
        try{
            return businessService.deleteBusinessById(id);
        } catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    @Autowired
    @Qualifier("mysqlDataSource")
    private DataSource dataSource;

    @SneakyThrows
    @GetMapping("/test")
    public Test test(@RequestParam String name){
        return TestHandler.insertTest(new QueryRunner(dataSource), name);
    }

    @SneakyThrows
    @GetMapping("/batchInsert")
    public int[] batchInsert(@RequestParam List<String> nick_name){
        List<Date> dates = new ArrayList<>();
        for(int i = 0; i < nick_name.size(); i ++){
            dates.add(new Date());
        }
        return BusinessHandler.batchInsert(new QueryRunner(dataSource), nick_name, dates);
    }

    @SneakyThrows
    @GetMapping("/batchDelete")
    public int[] batchDelete(@RequestParam List<String> ids){
        return BusinessHandler.batchDelete(new QueryRunner(dataSource), ids);
    }

}
