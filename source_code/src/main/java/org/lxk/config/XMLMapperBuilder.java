package org.lxk.config;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.lxk.io.Resource;
import org.lxk.pojo.Configuration;
import org.lxk.pojo.MapperedStatement;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lxk
 */
public class XMLMapperBuilder {

    private Configuration  configuration;

    public XMLMapperBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public XMLMapperBuilder() {
    }

    public void parse(InputStream resourceAsStream) throws DocumentException {
        Document configuration = new SAXReader().read(resourceAsStream);
        Element rootElement = configuration.getRootElement();
        String nameSpace = rootElement.attributeValue("nameSpace");
        List<Element> list = rootElement.selectNodes("//select");
        if (list != null && list.size() > 0){
            for (Element element : list) {
                String id = element.attributeValue("id");
                String resultType = element.attributeValue("resultType");
                String parameterType = element.attributeValue("parameterType");
                String sql = element.getTextTrim();
                //封装
                MapperedStatement mapperedStatement=new MapperedStatement();
                mapperedStatement.setStatementId(nameSpace+"."+id);
                mapperedStatement.setResultType(resultType);
                mapperedStatement.setParameterType(parameterType);
                mapperedStatement.setSql(sql);

                this.configuration.getMapperMap().put(mapperedStatement.getStatementId(),mapperedStatement);

            }
        }
    }
}
