package com.h.mybatisplus.Test;


import com.h.mybatisplus.dao.Aa;
import hanhan.pp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Component
public class TestSql {
    private org.slf4j.Logger log= org.slf4j.LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Aa aa;



//    @Scheduled(initialDelay = 4000,fixedDelay = Long.MAX_VALUE)
    public void f1(){
        String abc="abc";
        String  sql001="select username from sys_user where id='"+abc+"' and status='1' ";
        String username = aa.getUsername(sql001);
        pp.logInfoPretty(log,"username",username);
    }




}
