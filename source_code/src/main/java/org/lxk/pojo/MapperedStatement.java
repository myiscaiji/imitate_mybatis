package org.lxk.pojo;

/**
 * @author lxk
 */
public class MapperedStatement {

    private String statementId;

    private String  resultType;

    private String parameterType;

    private String sql;

    public MapperedStatement(String statementId, String resultType, String parameterType, String sql) {
        this.statementId = statementId;
        this.resultType = resultType;
        this.parameterType = parameterType;
        this.sql = sql;
    }

    public MapperedStatement() {
    }

    public String getStatementId() {
        return statementId;
    }

    public void setStatementId(String statementId) {
        this.statementId = statementId;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
