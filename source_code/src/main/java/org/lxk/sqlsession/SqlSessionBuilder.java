package org.lxk.sqlsession;

import org.dom4j.DocumentException;
import org.lxk.config.XMLConfigBuilder;
import org.lxk.pojo.Configuration;
import org.lxk.sqlsession.impl.DefaultSqlSessionFactory;

import java.io.InputStream;

/**
 * @author lxk
 */
public class SqlSessionBuilder {

    public SqlSessionFactory builder(InputStream inputStream) throws DocumentException {
        //解析配置文件（dom4j+XPath），封装Configuration
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        Configuration configuration=xmlConfigBuilder.parse(inputStream);
        return new DefaultSqlSessionFactory(configuration);
    }
}
