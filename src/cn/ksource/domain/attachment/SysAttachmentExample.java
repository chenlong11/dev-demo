package cn.ksource.domain.attachment;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysAttachmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysAttachmentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIsNull() {
            addCriterion("business_id is null");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIsNotNull() {
            addCriterion("business_id is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessIdEqualTo(Long value) {
            addCriterion("business_id =", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotEqualTo(Long value) {
            addCriterion("business_id <>", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdGreaterThan(Long value) {
            addCriterion("business_id >", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdGreaterThanOrEqualTo(Long value) {
            addCriterion("business_id >=", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLessThan(Long value) {
            addCriterion("business_id <", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLessThanOrEqualTo(Long value) {
            addCriterion("business_id <=", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIn(List<Long> values) {
            addCriterion("business_id in", values, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotIn(List<Long> values) {
            addCriterion("business_id not in", values, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdBetween(Long value1, Long value2) {
            addCriterion("business_id between", value1, value2, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotBetween(Long value1, Long value2) {
            addCriterion("business_id not between", value1, value2, "businessId");
            return (Criteria) this;
        }

        public Criteria andAttTypeIsNull() {
            addCriterion("att_type is null");
            return (Criteria) this;
        }

        public Criteria andAttTypeIsNotNull() {
            addCriterion("att_type is not null");
            return (Criteria) this;
        }

        public Criteria andAttTypeEqualTo(String value) {
            addCriterion("att_type =", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeNotEqualTo(String value) {
            addCriterion("att_type <>", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeGreaterThan(String value) {
            addCriterion("att_type >", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeGreaterThanOrEqualTo(String value) {
            addCriterion("att_type >=", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeLessThan(String value) {
            addCriterion("att_type <", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeLessThanOrEqualTo(String value) {
            addCriterion("att_type <=", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeLike(String value) {
            addCriterion("att_type like", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeNotLike(String value) {
            addCriterion("att_type not like", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeIn(List<String> values) {
            addCriterion("att_type in", values, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeNotIn(List<String> values) {
            addCriterion("att_type not in", values, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeBetween(String value1, String value2) {
            addCriterion("att_type between", value1, value2, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeNotBetween(String value1, String value2) {
            addCriterion("att_type not between", value1, value2, "attType");
            return (Criteria) this;
        }

        public Criteria andAttNameIsNull() {
            addCriterion("att_name is null");
            return (Criteria) this;
        }

        public Criteria andAttNameIsNotNull() {
            addCriterion("att_name is not null");
            return (Criteria) this;
        }

        public Criteria andAttNameEqualTo(String value) {
            addCriterion("att_name =", value, "attName");
            return (Criteria) this;
        }

        public Criteria andAttNameNotEqualTo(String value) {
            addCriterion("att_name <>", value, "attName");
            return (Criteria) this;
        }

        public Criteria andAttNameGreaterThan(String value) {
            addCriterion("att_name >", value, "attName");
            return (Criteria) this;
        }

        public Criteria andAttNameGreaterThanOrEqualTo(String value) {
            addCriterion("att_name >=", value, "attName");
            return (Criteria) this;
        }

        public Criteria andAttNameLessThan(String value) {
            addCriterion("att_name <", value, "attName");
            return (Criteria) this;
        }

        public Criteria andAttNameLessThanOrEqualTo(String value) {
            addCriterion("att_name <=", value, "attName");
            return (Criteria) this;
        }

        public Criteria andAttNameLike(String value) {
            addCriterion("att_name like", value, "attName");
            return (Criteria) this;
        }

        public Criteria andAttNameNotLike(String value) {
            addCriterion("att_name not like", value, "attName");
            return (Criteria) this;
        }

        public Criteria andAttNameIn(List<String> values) {
            addCriterion("att_name in", values, "attName");
            return (Criteria) this;
        }

        public Criteria andAttNameNotIn(List<String> values) {
            addCriterion("att_name not in", values, "attName");
            return (Criteria) this;
        }

        public Criteria andAttNameBetween(String value1, String value2) {
            addCriterion("att_name between", value1, value2, "attName");
            return (Criteria) this;
        }

        public Criteria andAttNameNotBetween(String value1, String value2) {
            addCriterion("att_name not between", value1, value2, "attName");
            return (Criteria) this;
        }

        public Criteria andAttPathIsNull() {
            addCriterion("att_path is null");
            return (Criteria) this;
        }

        public Criteria andAttPathIsNotNull() {
            addCriterion("att_path is not null");
            return (Criteria) this;
        }

        public Criteria andAttPathEqualTo(String value) {
            addCriterion("att_path =", value, "attPath");
            return (Criteria) this;
        }

        public Criteria andAttPathNotEqualTo(String value) {
            addCriterion("att_path <>", value, "attPath");
            return (Criteria) this;
        }

        public Criteria andAttPathGreaterThan(String value) {
            addCriterion("att_path >", value, "attPath");
            return (Criteria) this;
        }

        public Criteria andAttPathGreaterThanOrEqualTo(String value) {
            addCriterion("att_path >=", value, "attPath");
            return (Criteria) this;
        }

        public Criteria andAttPathLessThan(String value) {
            addCriterion("att_path <", value, "attPath");
            return (Criteria) this;
        }

        public Criteria andAttPathLessThanOrEqualTo(String value) {
            addCriterion("att_path <=", value, "attPath");
            return (Criteria) this;
        }

        public Criteria andAttPathLike(String value) {
            addCriterion("att_path like", value, "attPath");
            return (Criteria) this;
        }

        public Criteria andAttPathNotLike(String value) {
            addCriterion("att_path not like", value, "attPath");
            return (Criteria) this;
        }

        public Criteria andAttPathIn(List<String> values) {
            addCriterion("att_path in", values, "attPath");
            return (Criteria) this;
        }

        public Criteria andAttPathNotIn(List<String> values) {
            addCriterion("att_path not in", values, "attPath");
            return (Criteria) this;
        }

        public Criteria andAttPathBetween(String value1, String value2) {
            addCriterion("att_path between", value1, value2, "attPath");
            return (Criteria) this;
        }

        public Criteria andAttPathNotBetween(String value1, String value2) {
            addCriterion("att_path not between", value1, value2, "attPath");
            return (Criteria) this;
        }

        public Criteria andAttSizeIsNull() {
            addCriterion("att_size is null");
            return (Criteria) this;
        }

        public Criteria andAttSizeIsNotNull() {
            addCriterion("att_size is not null");
            return (Criteria) this;
        }

        public Criteria andAttSizeEqualTo(String value) {
            addCriterion("att_size =", value, "attSize");
            return (Criteria) this;
        }

        public Criteria andAttSizeNotEqualTo(String value) {
            addCriterion("att_size <>", value, "attSize");
            return (Criteria) this;
        }

        public Criteria andAttSizeGreaterThan(String value) {
            addCriterion("att_size >", value, "attSize");
            return (Criteria) this;
        }

        public Criteria andAttSizeGreaterThanOrEqualTo(String value) {
            addCriterion("att_size >=", value, "attSize");
            return (Criteria) this;
        }

        public Criteria andAttSizeLessThan(String value) {
            addCriterion("att_size <", value, "attSize");
            return (Criteria) this;
        }

        public Criteria andAttSizeLessThanOrEqualTo(String value) {
            addCriterion("att_size <=", value, "attSize");
            return (Criteria) this;
        }

        public Criteria andAttSizeLike(String value) {
            addCriterion("att_size like", value, "attSize");
            return (Criteria) this;
        }

        public Criteria andAttSizeNotLike(String value) {
            addCriterion("att_size not like", value, "attSize");
            return (Criteria) this;
        }

        public Criteria andAttSizeIn(List<String> values) {
            addCriterion("att_size in", values, "attSize");
            return (Criteria) this;
        }

        public Criteria andAttSizeNotIn(List<String> values) {
            addCriterion("att_size not in", values, "attSize");
            return (Criteria) this;
        }

        public Criteria andAttSizeBetween(String value1, String value2) {
            addCriterion("att_size between", value1, value2, "attSize");
            return (Criteria) this;
        }

        public Criteria andAttSizeNotBetween(String value1, String value2) {
            addCriterion("att_size not between", value1, value2, "attSize");
            return (Criteria) this;
        }

        public Criteria andAttExtIsNull() {
            addCriterion("att_ext is null");
            return (Criteria) this;
        }

        public Criteria andAttExtIsNotNull() {
            addCriterion("att_ext is not null");
            return (Criteria) this;
        }

        public Criteria andAttExtEqualTo(String value) {
            addCriterion("att_ext =", value, "attExt");
            return (Criteria) this;
        }

        public Criteria andAttExtNotEqualTo(String value) {
            addCriterion("att_ext <>", value, "attExt");
            return (Criteria) this;
        }

        public Criteria andAttExtGreaterThan(String value) {
            addCriterion("att_ext >", value, "attExt");
            return (Criteria) this;
        }

        public Criteria andAttExtGreaterThanOrEqualTo(String value) {
            addCriterion("att_ext >=", value, "attExt");
            return (Criteria) this;
        }

        public Criteria andAttExtLessThan(String value) {
            addCriterion("att_ext <", value, "attExt");
            return (Criteria) this;
        }

        public Criteria andAttExtLessThanOrEqualTo(String value) {
            addCriterion("att_ext <=", value, "attExt");
            return (Criteria) this;
        }

        public Criteria andAttExtLike(String value) {
            addCriterion("att_ext like", value, "attExt");
            return (Criteria) this;
        }

        public Criteria andAttExtNotLike(String value) {
            addCriterion("att_ext not like", value, "attExt");
            return (Criteria) this;
        }

        public Criteria andAttExtIn(List<String> values) {
            addCriterion("att_ext in", values, "attExt");
            return (Criteria) this;
        }

        public Criteria andAttExtNotIn(List<String> values) {
            addCriterion("att_ext not in", values, "attExt");
            return (Criteria) this;
        }

        public Criteria andAttExtBetween(String value1, String value2) {
            addCriterion("att_ext between", value1, value2, "attExt");
            return (Criteria) this;
        }

        public Criteria andAttExtNotBetween(String value1, String value2) {
            addCriterion("att_ext not between", value1, value2, "attExt");
            return (Criteria) this;
        }

        public Criteria andSnIsNull() {
            addCriterion("sn is null");
            return (Criteria) this;
        }

        public Criteria andSnIsNotNull() {
            addCriterion("sn is not null");
            return (Criteria) this;
        }

        public Criteria andSnEqualTo(Short value) {
            addCriterion("sn =", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotEqualTo(Short value) {
            addCriterion("sn <>", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThan(Short value) {
            addCriterion("sn >", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThanOrEqualTo(Short value) {
            addCriterion("sn >=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThan(Short value) {
            addCriterion("sn <", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThanOrEqualTo(Short value) {
            addCriterion("sn <=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnIn(List<Short> values) {
            addCriterion("sn in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotIn(List<Short> values) {
            addCriterion("sn not in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnBetween(Short value1, Short value2) {
            addCriterion("sn between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotBetween(Short value1, Short value2) {
            addCriterion("sn not between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNull() {
            addCriterion("create_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNotNull() {
            addCriterion("create_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIdEqualTo(Long value) {
            addCriterion("create_id =", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotEqualTo(Long value) {
            addCriterion("create_id <>", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThan(Long value) {
            addCriterion("create_id >", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("create_id >=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThan(Long value) {
            addCriterion("create_id <", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThanOrEqualTo(Long value) {
            addCriterion("create_id <=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdIn(List<Long> values) {
            addCriterion("create_id in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotIn(List<Long> values) {
            addCriterion("create_id not in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdBetween(Long value1, Long value2) {
            addCriterion("create_id between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotBetween(Long value1, Long value2) {
            addCriterion("create_id not between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCTime("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCTime("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCTime("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}