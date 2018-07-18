package com.flaming.test.dbutilsfull.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author xiaolin.tang
 * @date 2018/7/18 11:19
 */
@Data
public class Business {

    private String id;
    private String imgurl;
    private String memo;
    private String nick_name;
    private Date open_date;
    private String password;
    private String telephone;
    private String username;

}
