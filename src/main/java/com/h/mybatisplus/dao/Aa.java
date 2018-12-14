package com.h.mybatisplus.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by IBM on 2018/11/4.
 */
public interface Aa {

    //    select username from sys_user where id='abc'
    @Select({"${sql001}"})
    public String getUsername(@Param("sql001") String sql001);


}
