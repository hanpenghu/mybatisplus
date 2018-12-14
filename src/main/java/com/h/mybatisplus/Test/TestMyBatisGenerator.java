package com.h.mybatisplus.Test;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.h.mybatisplus.dao.SysUserMapper;
import com.h.mybatisplus.entity.SysUser;
import com.h.mybatisplus.entity.SysUserExample;
import hanhan.pp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Component
public class TestMyBatisGenerator {
    private org.slf4j.Logger log= org.slf4j.LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SysUserMapper sysUserMapper;

//    mybatis-plus分页插件跟github的分页插件居然没有冲突
//    #如果用mybatis逆向这个必须配置(mybatis-plus不需要配置)
//    mybatis-plus.mapper-locations=classpath*:com/h/mybatisplus/dao/xml/*.xml
//    @Scheduled(initialDelay = 4000,fixedDelay = Long.MAX_VALUE)
    public void f1(){
        //        //2、设置分页,第一个参数是当前页页码,第二个参数是每页显示数
        PageHelper.startPage(2,3);
        SysUserExample sysUserExample =new SysUserExample();
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
//        pp.logInfoPretty(log,"sysUsers",sysUsers);
        //4、取分页后结果
        PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(sysUsers);
        pp.logInfoPretty(log,"pageInfo.getList()",pageInfo.getList());
    }

}
