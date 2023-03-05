package org.lxk.sqlsession.impl;

import org.lxk.pojo.Configuration;
import org.lxk.sqlsession.SqlSessionFactory;

/**
 * @author lxk
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    public DefaultSqlSessionFactory() {
    }
}
