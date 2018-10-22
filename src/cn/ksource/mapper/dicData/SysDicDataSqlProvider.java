package cn.ksource.mapper.dicData;

import cn.ksource.domain.dicData.SysDicData;
import cn.ksource.domain.dicData.SysDicDataExample.Criteria;
import cn.ksource.domain.dicData.SysDicDataExample.Criterion;
import cn.ksource.domain.dicData.SysDicDataExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SysDicDataSqlProvider {

    public String countByExample(SysDicDataExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_dic_data");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SysDicDataExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_dic_data");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SysDicData record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_dic_data");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getDicId() != null) {
            sql.VALUES("dic_id", "#{dicId,jdbcType=BIGINT}");
        }
        
        if (record.getDataCode() != null) {
            sql.VALUES("data_code", "#{dataCode,jdbcType=VARCHAR}");
        }
        
        if (record.getDataVal() != null) {
            sql.VALUES("data_val", "#{dataVal,jdbcType=VARCHAR}");
        }
        
        if (record.getSn() != null) {
            sql.VALUES("sn", "#{sn,jdbcType=SMALLINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SysDicDataExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("dic_id");
        sql.SELECT("data_code");
        sql.SELECT("data_val");
        sql.SELECT("sn");
        sql.FROM("sys_dic_data");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysDicData record = (SysDicData) parameter.get("record");
        SysDicDataExample example = (SysDicDataExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_dic_data");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getDicId() != null) {
            sql.SET("dic_id = #{record.dicId,jdbcType=BIGINT}");
        }
        
        if (record.getDataCode() != null) {
            sql.SET("data_code = #{record.dataCode,jdbcType=VARCHAR}");
        }
        
        if (record.getDataVal() != null) {
            sql.SET("data_val = #{record.dataVal,jdbcType=VARCHAR}");
        }
        
        if (record.getSn() != null) {
            sql.SET("sn = #{record.sn,jdbcType=SMALLINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_dic_data");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("dic_id = #{record.dicId,jdbcType=BIGINT}");
        sql.SET("data_code = #{record.dataCode,jdbcType=VARCHAR}");
        sql.SET("data_val = #{record.dataVal,jdbcType=VARCHAR}");
        sql.SET("sn = #{record.sn,jdbcType=SMALLINT}");
        
        SysDicDataExample example = (SysDicDataExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysDicData record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_dic_data");
        
        if (record.getDicId() != null) {
            sql.SET("dic_id = #{dicId,jdbcType=BIGINT}");
        }
        
        if (record.getDataCode() != null) {
            sql.SET("data_code = #{dataCode,jdbcType=VARCHAR}");
        }
        
        if (record.getDataVal() != null) {
            sql.SET("data_val = #{dataVal,jdbcType=VARCHAR}");
        }
        
        if (record.getSn() != null) {
            sql.SET("sn = #{sn,jdbcType=SMALLINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SysDicDataExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}