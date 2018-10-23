package cn.ksource.mapper.attachment;

import cn.ksource.domain.attachment.SysAttachment;
import cn.ksource.domain.attachment.SysAttachmentExample.Criteria;
import cn.ksource.domain.attachment.SysAttachmentExample.Criterion;
import cn.ksource.domain.attachment.SysAttachmentExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SysAttachmentSqlProvider {

    public String countByExample(SysAttachmentExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_attachment");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SysAttachmentExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_attachment");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SysAttachment record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_attachment");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getBusinessId() != null) {
            sql.VALUES("business_id", "#{businessId,jdbcType=BIGINT}");
        }
        
        if (record.getAttType() != null) {
            sql.VALUES("att_type", "#{attType,jdbcType=VARCHAR}");
        }
        
        if (record.getAttName() != null) {
            sql.VALUES("att_name", "#{attName,jdbcType=VARCHAR}");
        }
        
        if (record.getAttPath() != null) {
            sql.VALUES("att_path", "#{attPath,jdbcType=VARCHAR}");
        }
        
        if (record.getAttSize() != null) {
            sql.VALUES("att_size", "#{attSize,jdbcType=VARCHAR}");
        }
        
        if (record.getAttExt() != null) {
            sql.VALUES("att_ext", "#{attExt,jdbcType=VARCHAR}");
        }
        
        if (record.getSn() != null) {
            sql.VALUES("sn", "#{sn,jdbcType=SMALLINT}");
        }
        
        if (record.getCreateId() != null) {
            sql.VALUES("create_id", "#{createId,jdbcType=BIGINT}");
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

    public String selectByExample(SysAttachmentExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("business_id");
        sql.SELECT("att_type");
        sql.SELECT("att_name");
        sql.SELECT("att_path");
        sql.SELECT("att_size");
        sql.SELECT("att_ext");
        sql.SELECT("sn");
        sql.SELECT("create_id");
        sql.SELECT("create_date");
        sql.SELECT("create_time");
        sql.SELECT("state");
        sql.FROM("sys_attachment");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysAttachment record = (SysAttachment) parameter.get("record");
        SysAttachmentExample example = (SysAttachmentExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_attachment");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getBusinessId() != null) {
            sql.SET("business_id = #{record.businessId,jdbcType=BIGINT}");
        }
        
        if (record.getAttType() != null) {
            sql.SET("att_type = #{record.attType,jdbcType=VARCHAR}");
        }
        
        if (record.getAttName() != null) {
            sql.SET("att_name = #{record.attName,jdbcType=VARCHAR}");
        }
        
        if (record.getAttPath() != null) {
            sql.SET("att_path = #{record.attPath,jdbcType=VARCHAR}");
        }
        
        if (record.getAttSize() != null) {
            sql.SET("att_size = #{record.attSize,jdbcType=VARCHAR}");
        }
        
        if (record.getAttExt() != null) {
            sql.SET("att_ext = #{record.attExt,jdbcType=VARCHAR}");
        }
        
        if (record.getSn() != null) {
            sql.SET("sn = #{record.sn,jdbcType=SMALLINT}");
        }
        
        if (record.getCreateId() != null) {
            sql.SET("create_id = #{record.createId,jdbcType=BIGINT}");
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
        sql.UPDATE("sys_attachment");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("business_id = #{record.businessId,jdbcType=BIGINT}");
        sql.SET("att_type = #{record.attType,jdbcType=VARCHAR}");
        sql.SET("att_name = #{record.attName,jdbcType=VARCHAR}");
        sql.SET("att_path = #{record.attPath,jdbcType=VARCHAR}");
        sql.SET("att_size = #{record.attSize,jdbcType=VARCHAR}");
        sql.SET("att_ext = #{record.attExt,jdbcType=VARCHAR}");
        sql.SET("sn = #{record.sn,jdbcType=SMALLINT}");
        sql.SET("create_id = #{record.createId,jdbcType=BIGINT}");
        sql.SET("create_date = #{record.createDate,jdbcType=DATE}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIME}");
        sql.SET("state = #{record.state,jdbcType=TINYINT}");
        
        SysAttachmentExample example = (SysAttachmentExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysAttachment record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_attachment");
        
        if (record.getBusinessId() != null) {
            sql.SET("business_id = #{businessId,jdbcType=BIGINT}");
        }
        
        if (record.getAttType() != null) {
            sql.SET("att_type = #{attType,jdbcType=VARCHAR}");
        }
        
        if (record.getAttName() != null) {
            sql.SET("att_name = #{attName,jdbcType=VARCHAR}");
        }
        
        if (record.getAttPath() != null) {
            sql.SET("att_path = #{attPath,jdbcType=VARCHAR}");
        }
        
        if (record.getAttSize() != null) {
            sql.SET("att_size = #{attSize,jdbcType=VARCHAR}");
        }
        
        if (record.getAttExt() != null) {
            sql.SET("att_ext = #{attExt,jdbcType=VARCHAR}");
        }
        
        if (record.getSn() != null) {
            sql.SET("sn = #{sn,jdbcType=SMALLINT}");
        }
        
        if (record.getCreateId() != null) {
            sql.SET("create_id = #{createId,jdbcType=BIGINT}");
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

    protected void applyWhere(SQL sql, SysAttachmentExample example, boolean includeExamplePhrase) {
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