package com.h.mybatisplus.Test;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.h.mybatisplus.dao.SysUserMapper;
import com.h.mybatisplus.entity.SysUser;
import hanhan.pp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Component
public class TestMybatisPlus {
    private org.slf4j.Logger log= org.slf4j.LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SysUserMapper sysUserMapper;
//    mybatis-plus分页插件跟github的分页插件居然没有冲突
    //    #如果用mybatis逆向这个必须配置(mybatis-plus不需要配置)
//    mybatis-plus.mapper-locations=classpath*:com/h/mybatisplus/dao/xml/*.xml
//    @Scheduled(initialDelay = 4000,fixedDelay = Long.MAX_VALUE)
    public void f(){
        System.out.println("测试mybatisplus开始");
        List<SysUser> sysUserList = sysUserMapper.selectList(null);
        pp.logInfoPretty(log,"sysUserList",sysUserList);

        System.out.println("测试mybatisplus结束");
    }
    //    mybatis-plus分页插件跟github的分页插件居然没有冲突
    //    #如果用mybatis逆向这个必须配置(mybatis-plus不需要配置)
//    mybatis-plus.mapper-locations=classpath*:com/h/mybatisplus/dao/xml/*.xml
    //测试条件查询
//    @Scheduled(initialDelay = 4000,fixedDelay = Long.MAX_VALUE)
    public void f1(){
        LambdaQueryWrapper<SysUser> wrapper = new QueryWrapper<SysUser>().lambda().eq(SysUser::getUsername, "han2");
        List<SysUser> sysUsers = sysUserMapper.selectList(wrapper);
        pp.logInfoPretty(log,"sysUsers",sysUsers);
    }
    //    mybatis-plus分页插件跟github的分页插件居然没有冲突
    //    #如果用mybatis逆向这个必须配置(mybatis-plus不需要配置)
//    mybatis-plus.mapper-locations=classpath*:com/h/mybatisplus/dao/xml/*.xml
    //测试分页查询(需要再config文件夹配置分页插件)
    @Scheduled(initialDelay = 4000,fixedDelay = Long.MAX_VALUE)
    public void f2(){
        LambdaQueryWrapper<SysUser> wrapper = new QueryWrapper<SysUser>().lambda().eq(SysUser::getTenantId, "ipace");
        Page<SysUser> page = new Page<SysUser> (2, 3);
        IPage<SysUser> sysUserIPage = sysUserMapper.selectPage(page,wrapper);
        System.out.println("总条数 ------> " + sysUserIPage.getTotal());
        System.out.println("当前页数 ------> " + sysUserIPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + sysUserIPage.getSize());
        pp.logInfoPretty(log,"sysUsers",sysUserIPage);
    }








}
