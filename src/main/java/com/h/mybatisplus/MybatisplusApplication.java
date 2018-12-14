package com.h.mybatisplus;

import com.h.mybatisplus.dao.SysUserMapper;
import com.h.mybatisplus.entity.SysUser;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//@EnableAspectJAutoProxy//这个是让@Aspect生效的东西
@EnableCaching//这个是保证redis生效的
@EnableScheduling
@EnableTransactionManagement
@MapperScan("com.h.mybatisplus.dao")
@SpringBootApplication(scanBasePackages = {"com.h","hanhan"})
public class MybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusApplication.class, args);
    }




}

