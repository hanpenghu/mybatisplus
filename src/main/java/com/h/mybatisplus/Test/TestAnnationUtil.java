package com.h.mybatisplus.Test;


import cn.hutool.core.annotation.AnnotationUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import hanhan.pp;

@TestAnn(name0 = "0000",stringArray = {"1","2","3"})
public class TestAnnationUtil {
    private org.slf4j.Logger log= org.slf4j.LoggerFactory.getLogger(this.getClass());
    
    @TestAnn(name2="fuck")
    public void f1() throws NoSuchMethodException {
        TestAnn annotation = AnnotationUtil.getAnnotation(TestAnnationUtil.class,TestAnn.class);
        String[] strings = annotation.stringArray();
        pp.logInfoPretty(log,"strigns",strings);
        TestAnn f1 = AnnotationUtil.getAnnotation(TestAnnationUtil.this.getClass().getMethod("f1"), TestAnn.class);
        pp.logInfoPretty(log,"f1.name2()",f1.name2());

    }

    public static void main(String[]args) throws NoSuchMethodException {
        new TestAnnationUtil().f1();
    }

}
