package org.lxk.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.lxk.io.Resource;
import org.lxk.pojo.Configuration;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author lxk 解析核心xml配置文件
 */
public class XMLConfigBuilder {

    private Configuration configuration;

    public XMLConfigBuilder() {
        this.configuration=new Configuration();
    }

    /**
     * 解析核心配置文件 封装Configuration对象
     * @param inputStream
     * @return
     */
    public Configuration parse(InputStream inputStream) throws DocumentException {
        //读取到xml文件 解析成document对象
        Document document = new SAXReader().read(inputStream);
        //获取根节点<configuration>
        Element rootElement = document.getRootElement();
        Properties property=new Properties();
        // //是xpath表达式  表示任意位置  获取数据库连接信息
        List<Element> list = rootElement.selectNodes("//property");
        for (Element element : list) {
            String name = element.attributeValue("name");
            String value = element.attributeValue("value");
            property.setProperty(name,value);
        }
        //使用连接池来解决频繁连接数据库的问题
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(property.getProperty("driveClassName"));
        druidDataSource.setUrl(property.getProperty("url"));
        druidDataSource.setUsername(property.getProperty("userName"));
        druidDataSource.setPassword(property.getProperty("password"));

        configuration.setDataSource(druidDataSource);

        // 解析mapper.xml文件的路径
        List<Element> mapperList = rootElement.selectNodes("//mapper");
        for (Element element : mapperList) {
            String path = element.attributeValue("resource");
            InputStream resourceAsStream = Resource.getResourceAsStream(path);
            XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(configuration);
            xmlMapperBuilder.parse(resourceAsStream);
        }
        return configuration;
    }
}
