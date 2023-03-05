package org.lxk.io;

import java.io.InputStream;

/**
 * @author lxk
 */
public class Resource {


    /**
     * 获取数据库配置文件的字节输入流 存入内存当中
     * @param path
     * @return
     */
    public static InputStream getResourceAsStream(String path){
        InputStream inputStream = Resource.class.getClassLoader().getResourceAsStream(path);
        return inputStream;
    }
}
