package org.lxk.pojo;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lxk 用以存放数据库配置文件实体类（对应xml文件定义）
 */
public class Configuration {

    private DataSource dataSource;


    private Map<String,MapperedStatement> mapperMap=new HashMap<>();

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map<String, MapperedStatement> getMapperMap() {
        return mapperMap;
    }

    public void setMapperMap(Map<String, MapperedStatement> mapperMap) {
        this.mapperMap = mapperMap;
    }

    public Configuration(DataSource dataSource, Map<String, MapperedStatement> mapperMap) {
        this.dataSource = dataSource;
        this.mapperMap = mapperMap;
    }

    public Configuration() {
    }
}
