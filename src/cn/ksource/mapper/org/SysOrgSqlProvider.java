package cn.ksource.mapper.org;

import cn.ksource.domain.org.SysOrg;
import cn.ksource.domain.org.SysOrgExample.Criteria;
import cn.ksource.domain.org.SysOrgExample.Criterion;
import cn.ksource.domain.org.SysOrgExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SysOrgSqlProvider {

    public String countByExample(SysOrgExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_org");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SysOrgExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_org");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SysOrg record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_org");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getLv1Id() != null) {
            sql.VALUES("lv1_id", "#{lv1Id,jdbcType=BIGINT}");
        }
        
        if (record.getLv1Name() != null) {
            sql.VALUES("lv1_name", "#{lv1Name,jdbcType=VARCHAR}");
        }
        
        if (record.getLv2Id() != null) {
            sql.VALUES("lv2_id", "#{lv2Id,jdbcType=BIGINT}");
        }
        
        if (record.getLv2Name() != null) {
            sql.VALUES("lv2_name", "#{lv2Name,jdbcType=VARCHAR}");
        }
        
        if (record.getLv3Id() != null) {
            sql.VALUES("lv3_id", "#{lv3Id,jdbcType=BIGINT}");
        }
        
        if (record.getLv3Name() != null) {
            sql.VALUES("lv3_name", "#{lv3Name,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgName() != null) {
            sql.VALUES("org_name", "#{orgName,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgCode() != null) {
            sql.VALUES("org_code", "#{orgCode,jdbcType=VARCHAR}");
        }
        
        if (record.getLv() != null) {
            sql.VALUES("lv", "#{lv,jdbcType=TINYINT}");
        }
        
        if (record.getPid() != null) {
            sql.VALUES("pid", "#{pid,jdbcType=BIGINT}");
        }
        
        if (record.getOrgPath() != null) {
            sql.VALUES("org_path", "#{orgPath,jdbcType=VARCHAR}");
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

    public String selectByExample(SysOrgExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("lv1_id");
        sql.SELECT("lv1_name");
        sql.SELECT("lv2_id");
        sql.SELECT("lv2_name");
        sql.SELECT("lv3_id");
        sql.SELECT("lv3_name");
        sql.SELECT("org_name");
        sql.SELECT("org_code");
        sql.SELECT("lv");
        sql.SELECT("pid");
        sql.SELECT("org_path");
        sql.SELECT("sn");
        sql.SELECT("create_date");
        sql.SELECT("create_time");
        sql.SELECT("state");
        sql.FROM("sys_org");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysOrg record = (SysOrg) parameter.get("record");
        SysOrgExample example = (SysOrgExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_org");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getLv1Id() != null) {
            sql.SET("lv1_id = #{record.lv1Id,jdbcType=BIGINT}");
        }
        
        if (record.getLv1Name() != null) {
            sql.SET("lv1_name = #{record.lv1Name,jdbcType=VARCHAR}");
        }
        
        if (record.getLv2Id() != null) {
            sql.SET("lv2_id = #{record.lv2Id,jdbcType=BIGINT}");
        }
        
        if (record.getLv2Name() != null) {
            sql.SET("lv2_name = #{record.lv2Name,jdbcType=VARCHAR}");
        }
        
        if (record.getLv3Id() != null) {
            sql.SET("lv3_id = #{record.lv3Id,jdbcType=BIGINT}");
        }
        
        if (record.getLv3Name() != null) {
            sql.SET("lv3_name = #{record.lv3Name,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgName() != null) {
            sql.SET("org_name = #{record.orgName,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgCode() != null) {
            sql.SET("org_code = #{record.orgCode,jdbcType=VARCHAR}");
        }
        
        if (record.getLv() != null) {
            sql.SET("lv = #{record.lv,jdbcType=TINYINT}");
        }
        
        if (record.getPid() != null) {
            sql.SET("pid = #{record.pid,jdbcType=BIGINT}");
        }
        
        if (record.getOrgPath() != null) {
            sql.SET("org_path = #{record.orgPath,jdbcType=VARCHAR}");
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
        sql.UPDATE("sys_org");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("lv1_id = #{record.lv1Id,jdbcType=BIGINT}");
        sql.SET("lv1_name = #{record.lv1Name,jdbcType=VARCHAR}");
        sql.SET("lv2_id = #{record.lv2Id,jdbcType=BIGINT}");
        sql.SET("lv2_name = #{record.lv2Name,jdbcType=VARCHAR}");
        sql.SET("lv3_id = #{record.lv3Id,jdbcType=BIGINT}");
        sql.SET("lv3_name = #{record.lv3Name,jdbcType=VARCHAR}");
        sql.SET("org_name = #{record.orgName,jdbcType=VARCHAR}");
        sql.SET("org_code = #{record.orgCode,jdbcType=VARCHAR}");
        sql.SET("lv = #{record.lv,jdbcType=TINYINT}");
        sql.SET("pid = #{record.pid,jdbcType=BIGINT}");
        sql.SET("org_path = #{record.orgPath,jdbcType=VARCHAR}");
        sql.SET("sn = #{record.sn,jdbcType=SMALLINT}");
        sql.SET("create_date = #{record.createDate,jdbcType=DATE}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIME}");
        sql.SET("state = #{record.state,jdbcType=TINYINT}");
        
        SysOrgExample example = (SysOrgExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysOrg record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_org");
        
        if (record.getLv1Id() != null) {
            sql.SET("lv1_id = #{lv1Id,jdbcType=BIGINT}");
        }
        
        if (record.getLv1Name() != null) {
            sql.SET("lv1_name = #{lv1Name,jdbcType=VARCHAR}");
        }
        
        if (record.getLv2Id() != null) {
            sql.SET("lv2_id = #{lv2Id,jdbcType=BIGINT}");
        }
        
        if (record.getLv2Name() != null) {
            sql.SET("lv2_name = #{lv2Name,jdbcType=VARCHAR}");
        }
        
        if (record.getLv3Id() != null) {
            sql.SET("lv3_id = #{lv3Id,jdbcType=BIGINT}");
        }
        
        if (record.getLv3Name() != null) {
            sql.SET("lv3_name = #{lv3Name,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgName() != null) {
            sql.SET("org_name = #{orgName,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgCode() != null) {
            sql.SET("org_code = #{orgCode,jdbcType=VARCHAR}");
        }
        
        if (record.getLv() != null) {
            sql.SET("lv = #{lv,jdbcType=TINYINT}");
        }
        
        if (record.getPid() != null) {
            sql.SET("pid = #{pid,jdbcType=BIGINT}");
        }
        
        if (record.getOrgPath() != null) {
            sql.SET("org_path = #{orgPath,jdbcType=VARCHAR}");
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

    protected void applyWhere(SQL sql, SysOrgExample example, boolean includeExamplePhrase) {
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