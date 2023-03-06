package com.lxk.io;

import org.dom4j.DocumentException;
import org.junit.Test;
import org.lxk.io.Resource;
import org.lxk.sqlsession.SqlSessionBuilder;
import org.lxk.sqlsession.SqlSessionFactory;

import java.io.InputStream;
import java.util.UUID;

public class InputStreamTest {

    /**
     * 传统模式 没有使用mapper代理模式
     */
    @Test
    public void test1() throws DocumentException {

        InputStream inputStream = Resource.getResourceAsStream("ImitateMybatisConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionBuilder().builder(inputStream);

//        sqlSessionFactory.openSession();


    }

    @Test
    public void test2(){
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
    }
}
