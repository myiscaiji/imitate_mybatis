package com.lxk.io;

import org.junit.Test;
import org.lxk.io.Resource;

import java.io.InputStream;

public class InputStreamTest {

    /**
     * 传统模式 没有使用mapper代理模式
     */
    @Test
    public void test1(){

        InputStream inputStream = Resource.getResourceAsStream("ImitateMybatisConfig.xml");
    }
}
