package cn.ksource.mapper.module;

import cn.ksource.domain.module.SysModule;
import cn.ksource.domain.module.SysModuleExample.Criteria;
import cn.ksource.domain.module.SysModuleExample.Criterion;
import cn.ksource.domain.module.SysModuleExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SysModuleSqlProvider {

    public String countByExample(SysModuleExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_module");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SysModuleExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_module");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SysModule record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_module");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getModuleType() != null) {
            sql.VALUES("module_type", "#{moduleType,jdbcType=TINYINT}");
        }
        
        if (record.getModuleCode() != null) {
            sql.VALUES("module_code", "#{moduleCode,jdbcType=VARCHAR}");
        }
        
        if (record.getModuleName() != null) {
            sql.VALUES("module_name", "#{moduleName,jdbcType=VARCHAR}");
        }
        
        if (record.getModuleUrl() != null) {
            sql.VALUES("module_url", "#{moduleUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getPid() != null) {
            sql.VALUES("pid", "#{pid,jdbcType=BIGINT}");
        }
        
        if (record.getLv() != null) {
            sql.VALUES("lv", "#{lv,jdbcType=TINYINT}");
        }
        
        if (record.getSn() != null) {
            sql.VALUES("sn", "#{sn,jdbcType=SMALLINT}");
        }
        
        if (record.getCreateDate() != null) {
            sql.VALUES("create_date", "#{createDate,jdbcType=DATE}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIME}");
        }
        
        if (record.getState() != null) {
            sql.VALUES("state", "#{state,jdbcType=TINYINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SysModuleExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("module_type");
        sql.SELECT("module_code");
        sql.SELECT("module_name");
        sql.SELECT("module_url");
        sql.SELECT("pid");
        sql.SELECT("lv");
        sql.SELECT("sn");
        sql.SELECT("create_date");
        sql.SELECT("create_time");
        sql.SELECT("state");
        sql.FROM("sys_module");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysModule record = (SysModule) parameter.get("record");
        SysModuleExample example = (SysModuleExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_module");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getModuleType() != null) {
            sql.SET("module_type = #{record.moduleType,jdbcType=TINYINT}");
        }
        
        if (record.getModuleCode() != null) {
            sql.SET("module_code = #{record.moduleCode,jdbcType=VARCHAR}");
        }
        
        if (record.getModuleName() != null) {
            sql.SET("module_name = #{record.moduleName,jdbcType=VARCHAR}");
        }
        
        if (record.getModuleUrl() != null) {
            sql.SET("module_url = #{record.moduleUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getPid() != null) {
            sql.SET("pid = #{record.pid,jdbcType=BIGINT}");
        }
        
        if (record.getLv() != null) {
            sql.SET("lv = #{record.lv,jdbcType=TINYINT}");
        }
        
        if (record.getSn() != null) {
            sql.SET("sn = #{record.sn,jdbcType=SMALLINT}");
        }
        
        if (record.getCreateDate() != null) {
            sql.SET("create_date = #{record.createDate,jdbcType=DATE}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIME}");
        }
        
        if (record.getState() != null) {
            sql.SET("state = #{record.state,jdbcType=TINYINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_module");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("module_type = #{record.moduleType,jdbcType=TINYINT}");
        sql.SET("module_code = #{record.moduleCode,jdbcType=VARCHAR}");
        sql.SET("module_name = #{record.moduleName,jdbcType=VARCHAR}");
        sql.SET("module_url = #{record.moduleUrl,jdbcType=VARCHAR}");
        sql.SET("pid = #{record.pid,jdbcType=BIGINT}");
        sql.SET("lv = #{record.lv,jdbcType=TINYINT}");
        sql.SET("sn = #{record.sn,jdbcType=SMALLINT}");
        sql.SET("create_date = #{record.createDate,jdbcType=DATE}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIME}");
        sql.SET("state = #{record.state,jdbcType=TINYINT}");
        
        SysModuleExample example = (SysModuleExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysModule record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_module");
        
        if (record.getModuleType() != null) {
            sql.SET("module_type = #{moduleType,jdbcType=TINYINT}");
        }
        
        if (record.getModuleCode() != null) {
            sql.SET("module_code = #{moduleCode,jdbcType=VARCHAR}");
        }
        
        if (record.getModuleName() != null) {
            sql.SET("module_name = #{moduleName,jdbcType=VARCHAR}");
        }
        
        if (record.getModuleUrl() != null) {
            sql.SET("module_url = #{moduleUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getPid() != null) {
            sql.SET("pid = #{pid,jdbcType=BIGINT}");
        }
        
        if (record.getLv() != null) {
            sql.SET("lv = #{lv,jdbcType=TINYINT}");
        }
        
        if (record.getSn() != null) {
            sql.SET("sn = #{sn,jdbcType=SMALLINT}");
        }
        
        if (record.getCreateDate() != null) {
            sql.SET("create_date = #{createDate,jdbcType=DATE}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIME}");
        }
        
        if (record.getState() != null) {
            sql.SET("state = #{state,jdbcType=TINYINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SysModuleExample example, boolean includeExamplePhrase) {
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