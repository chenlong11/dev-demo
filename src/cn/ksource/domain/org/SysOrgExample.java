package cn.ksource.domain.org;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysOrgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysOrgExample() {
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

        public Criteria andLv1IdIsNull() {
            addCriterion("lv1_id is null");
            return (Criteria) this;
        }

        public Criteria andLv1IdIsNotNull() {
            addCriterion("lv1_id is not null");
            return (Criteria) this;
        }

        public Criteria andLv1IdEqualTo(Long value) {
            addCriterion("lv1_id =", value, "lv1Id");
            return (Criteria) this;
        }

        public Criteria andLv1IdNotEqualTo(Long value) {
            addCriterion("lv1_id <>", value, "lv1Id");
            return (Criteria) this;
        }

        public Criteria andLv1IdGreaterThan(Long value) {
            addCriterion("lv1_id >", value, "lv1Id");
            return (Criteria) this;
        }

        public Criteria andLv1IdGreaterThanOrEqualTo(Long value) {
            addCriterion("lv1_id >=", value, "lv1Id");
            return (Criteria) this;
        }

        public Criteria andLv1IdLessThan(Long value) {
            addCriterion("lv1_id <", value, "lv1Id");
            return (Criteria) this;
        }

        public Criteria andLv1IdLessThanOrEqualTo(Long value) {
            addCriterion("lv1_id <=", value, "lv1Id");
            return (Criteria) this;
        }

        public Criteria andLv1IdIn(List<Long> values) {
            addCriterion("lv1_id in", values, "lv1Id");
            return (Criteria) this;
        }

        public Criteria andLv1IdNotIn(List<Long> values) {
            addCriterion("lv1_id not in", values, "lv1Id");
            return (Criteria) this;
        }

        public Criteria andLv1IdBetween(Long value1, Long value2) {
            addCriterion("lv1_id between", value1, value2, "lv1Id");
            return (Criteria) this;
        }

        public Criteria andLv1IdNotBetween(Long value1, Long value2) {
            addCriterion("lv1_id not between", value1, value2, "lv1Id");
            return (Criteria) this;
        }

        public Criteria andLv1NameIsNull() {
            addCriterion("lv1_name is null");
            return (Criteria) this;
        }

        public Criteria andLv1NameIsNotNull() {
            addCriterion("lv1_name is not null");
            return (Criteria) this;
        }

        public Criteria andLv1NameEqualTo(String value) {
            addCriterion("lv1_name =", value, "lv1Name");
            return (Criteria) this;
        }

        public Criteria andLv1NameNotEqualTo(String value) {
            addCriterion("lv1_name <>", value, "lv1Name");
            return (Criteria) this;
        }

        public Criteria andLv1NameGreaterThan(String value) {
            addCriterion("lv1_name >", value, "lv1Name");
            return (Criteria) this;
        }

        public Criteria andLv1NameGreaterThanOrEqualTo(String value) {
            addCriterion("lv1_name >=", value, "lv1Name");
            return (Criteria) this;
        }

        public Criteria andLv1NameLessThan(String value) {
            addCriterion("lv1_name <", value, "lv1Name");
            return (Criteria) this;
        }

        public Criteria andLv1NameLessThanOrEqualTo(String value) {
            addCriterion("lv1_name <=", value, "lv1Name");
            return (Criteria) this;
        }

        public Criteria andLv1NameLike(String value) {
            addCriterion("lv1_name like", value, "lv1Name");
            return (Criteria) this;
        }

        public Criteria andLv1NameNotLike(String value) {
            addCriterion("lv1_name not like", value, "lv1Name");
            return (Criteria) this;
        }

        public Criteria andLv1NameIn(List<String> values) {
            addCriterion("lv1_name in", values, "lv1Name");
            return (Criteria) this;
        }

        public Criteria andLv1NameNotIn(List<String> values) {
            addCriterion("lv1_name not in", values, "lv1Name");
            return (Criteria) this;
        }

        public Criteria andLv1NameBetween(String value1, String value2) {
            addCriterion("lv1_name between", value1, value2, "lv1Name");
            return (Criteria) this;
        }

        public Criteria andLv1NameNotBetween(String value1, String value2) {
            addCriterion("lv1_name not between", value1, value2, "lv1Name");
            return (Criteria) this;
        }

        public Criteria andLv2IdIsNull() {
            addCriterion("lv2_id is null");
            return (Criteria) this;
        }

        public Criteria andLv2IdIsNotNull() {
            addCriterion("lv2_id is not null");
            return (Criteria) this;
        }

        public Criteria andLv2IdEqualTo(Long value) {
            addCriterion("lv2_id =", value, "lv2Id");
            return (Criteria) this;
        }

        public Criteria andLv2IdNotEqualTo(Long value) {
            addCriterion("lv2_id <>", value, "lv2Id");
            return (Criteria) this;
        }

        public Criteria andLv2IdGreaterThan(Long value) {
            addCriterion("lv2_id >", value, "lv2Id");
            return (Criteria) this;
        }

        public Criteria andLv2IdGreaterThanOrEqualTo(Long value) {
            addCriterion("lv2_id >=", value, "lv2Id");
            return (Criteria) this;
        }

        public Criteria andLv2IdLessThan(Long value) {
            addCriterion("lv2_id <", value, "lv2Id");
            return (Criteria) this;
        }

        public Criteria andLv2IdLessThanOrEqualTo(Long value) {
            addCriterion("lv2_id <=", value, "lv2Id");
            return (Criteria) this;
        }

        public Criteria andLv2IdIn(List<Long> values) {
            addCriterion("lv2_id in", values, "lv2Id");
            return (Criteria) this;
        }

        public Criteria andLv2IdNotIn(List<Long> values) {
            addCriterion("lv2_id not in", values, "lv2Id");
            return (Criteria) this;
        }

        public Criteria andLv2IdBetween(Long value1, Long value2) {
            addCriterion("lv2_id between", value1, value2, "lv2Id");
            return (Criteria) this;
        }

        public Criteria andLv2IdNotBetween(Long value1, Long value2) {
            addCriterion("lv2_id not between", value1, value2, "lv2Id");
            return (Criteria) this;
        }

        public Criteria andLv2NameIsNull() {
            addCriterion("lv2_name is null");
            return (Criteria) this;
        }

        public Criteria andLv2NameIsNotNull() {
            addCriterion("lv2_name is not null");
            return (Criteria) this;
        }

        public Criteria andLv2NameEqualTo(String value) {
            addCriterion("lv2_name =", value, "lv2Name");
            return (Criteria) this;
        }

        public Criteria andLv2NameNotEqualTo(String value) {
            addCriterion("lv2_name <>", value, "lv2Name");
            return (Criteria) this;
        }

        public Criteria andLv2NameGreaterThan(String value) {
            addCriterion("lv2_name >", value, "lv2Name");
            return (Criteria) this;
        }

        public Criteria andLv2NameGreaterThanOrEqualTo(String value) {
            addCriterion("lv2_name >=", value, "lv2Name");
            return (Criteria) this;
        }

        public Criteria andLv2NameLessThan(String value) {
            addCriterion("lv2_name <", value, "lv2Name");
            return (Criteria) this;
        }

        public Criteria andLv2NameLessThanOrEqualTo(String value) {
            addCriterion("lv2_name <=", value, "lv2Name");
            return (Criteria) this;
        }

        public Criteria andLv2NameLike(String value) {
            addCriterion("lv2_name like", value, "lv2Name");
            return (Criteria) this;
        }

        public Criteria andLv2NameNotLike(String value) {
            addCriterion("lv2_name not like", value, "lv2Name");
            return (Criteria) this;
        }

        public Criteria andLv2NameIn(List<String> values) {
            addCriterion("lv2_name in", values, "lv2Name");
            return (Criteria) this;
        }

        public Criteria andLv2NameNotIn(List<String> values) {
            addCriterion("lv2_name not in", values, "lv2Name");
            return (Criteria) this;
        }

        public Criteria andLv2NameBetween(String value1, String value2) {
            addCriterion("lv2_name between", value1, value2, "lv2Name");
            return (Criteria) this;
        }

        public Criteria andLv2NameNotBetween(String value1, String value2) {
            addCriterion("lv2_name not between", value1, value2, "lv2Name");
            return (Criteria) this;
        }

        public Criteria andLv3IdIsNull() {
            addCriterion("lv3_id is null");
            return (Criteria) this;
        }

        public Criteria andLv3IdIsNotNull() {
            addCriterion("lv3_id is not null");
            return (Criteria) this;
        }

        public Criteria andLv3IdEqualTo(Long value) {
            addCriterion("lv3_id =", value, "lv3Id");
            return (Criteria) this;
        }

        public Criteria andLv3IdNotEqualTo(Long value) {
            addCriterion("lv3_id <>", value, "lv3Id");
            return (Criteria) this;
        }

        public Criteria andLv3IdGreaterThan(Long value) {
            addCriterion("lv3_id >", value, "lv3Id");
            return (Criteria) this;
        }

        public Criteria andLv3IdGreaterThanOrEqualTo(Long value) {
            addCriterion("lv3_id >=", value, "lv3Id");
            return (Criteria) this;
        }

        public Criteria andLv3IdLessThan(Long value) {
            addCriterion("lv3_id <", value, "lv3Id");
            return (Criteria) this;
        }

        public Criteria andLv3IdLessThanOrEqualTo(Long value) {
            addCriterion("lv3_id <=", value, "lv3Id");
            return (Criteria) this;
        }

        public Criteria andLv3IdIn(List<Long> values) {
            addCriterion("lv3_id in", values, "lv3Id");
            return (Criteria) this;
        }

        public Criteria andLv3IdNotIn(List<Long> values) {
            addCriterion("lv3_id not in", values, "lv3Id");
            return (Criteria) this;
        }

        public Criteria andLv3IdBetween(Long value1, Long value2) {
            addCriterion("lv3_id between", value1, value2, "lv3Id");
            return (Criteria) this;
        }

        public Criteria andLv3IdNotBetween(Long value1, Long value2) {
            addCriterion("lv3_id not between", value1, value2, "lv3Id");
            return (Criteria) this;
        }

        public Criteria andLv3NameIsNull() {
            addCriterion("lv3_name is null");
            return (Criteria) this;
        }

        public Criteria andLv3NameIsNotNull() {
            addCriterion("lv3_name is not null");
            return (Criteria) this;
        }

        public Criteria andLv3NameEqualTo(String value) {
            addCriterion("lv3_name =", value, "lv3Name");
            return (Criteria) this;
        }

        public Criteria andLv3NameNotEqualTo(String value) {
            addCriterion("lv3_name <>", value, "lv3Name");
            return (Criteria) this;
        }

        public Criteria andLv3NameGreaterThan(String value) {
            addCriterion("lv3_name >", value, "lv3Name");
            return (Criteria) this;
        }

        public Criteria andLv3NameGreaterThanOrEqualTo(String value) {
            addCriterion("lv3_name >=", value, "lv3Name");
            return (Criteria) this;
        }

        public Criteria andLv3NameLessThan(String value) {
            addCriterion("lv3_name <", value, "lv3Name");
            return (Criteria) this;
        }

        public Criteria andLv3NameLessThanOrEqualTo(String value) {
            addCriterion("lv3_name <=", value, "lv3Name");
            return (Criteria) this;
        }

        public Criteria andLv3NameLike(String value) {
            addCriterion("lv3_name like", value, "lv3Name");
            return (Criteria) this;
        }

        public Criteria andLv3NameNotLike(String value) {
            addCriterion("lv3_name not like", value, "lv3Name");
            return (Criteria) this;
        }

        public Criteria andLv3NameIn(List<String> values) {
            addCriterion("lv3_name in", values, "lv3Name");
            return (Criteria) this;
        }

        public Criteria andLv3NameNotIn(List<String> values) {
            addCriterion("lv3_name not in", values, "lv3Name");
            return (Criteria) this;
        }

        public Criteria andLv3NameBetween(String value1, String value2) {
            addCriterion("lv3_name between", value1, value2, "lv3Name");
            return (Criteria) this;
        }

        public Criteria andLv3NameNotBetween(String value1, String value2) {
            addCriterion("lv3_name not between", value1, value2, "lv3Name");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNull() {
            addCriterion("org_name is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNotNull() {
            addCriterion("org_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("org_name =", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("org_name <>", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("org_name >", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("org_name >=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThan(String value) {
            addCriterion("org_name <", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("org_name <=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLike(String value) {
            addCriterion("org_name like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotLike(String value) {
            addCriterion("org_name not like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("org_name in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("org_name not in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("org_name between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("org_name not between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNull() {
            addCriterion("org_code is null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNotNull() {
            addCriterion("org_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeEqualTo(String value) {
            addCriterion("org_code =", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotEqualTo(String value) {
            addCriterion("org_code <>", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThan(String value) {
            addCriterion("org_code >", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("org_code >=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThan(String value) {
            addCriterion("org_code <", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThanOrEqualTo(String value) {
            addCriterion("org_code <=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLike(String value) {
            addCriterion("org_code like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotLike(String value) {
            addCriterion("org_code not like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIn(List<String> values) {
            addCriterion("org_code in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotIn(List<String> values) {
            addCriterion("org_code not in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeBetween(String value1, String value2) {
            addCriterion("org_code between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotBetween(String value1, String value2) {
            addCriterion("org_code not between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andLvIsNull() {
            addCriterion("lv is null");
            return (Criteria) this;
        }

        public Criteria andLvIsNotNull() {
            addCriterion("lv is not null");
            return (Criteria) this;
        }

        public Criteria andLvEqualTo(Byte value) {
            addCriterion("lv =", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvNotEqualTo(Byte value) {
            addCriterion("lv <>", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvGreaterThan(Byte value) {
            addCriterion("lv >", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvGreaterThanOrEqualTo(Byte value) {
            addCriterion("lv >=", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvLessThan(Byte value) {
            addCriterion("lv <", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvLessThanOrEqualTo(Byte value) {
            addCriterion("lv <=", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvIn(List<Byte> values) {
            addCriterion("lv in", values, "lv");
            return (Criteria) this;
        }

        public Criteria andLvNotIn(List<Byte> values) {
            addCriterion("lv not in", values, "lv");
            return (Criteria) this;
        }

        public Criteria andLvBetween(Byte value1, Byte value2) {
            addCriterion("lv between", value1, value2, "lv");
            return (Criteria) this;
        }

        public Criteria andLvNotBetween(Byte value1, Byte value2) {
            addCriterion("lv not between", value1, value2, "lv");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Long value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Long value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Long value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Long value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Long value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Long value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Long> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Long> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Long value1, Long value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Long value1, Long value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andOrgPathIsNull() {
            addCriterion("org_path is null");
            return (Criteria) this;
        }

        public Criteria andOrgPathIsNotNull() {
            addCriterion("org_path is not null");
            return (Criteria) this;
        }

        public Criteria andOrgPathEqualTo(String value) {
            addCriterion("org_path =", value, "orgPath");
            return (Criteria) this;
        }

        public Criteria andOrgPathNotEqualTo(String value) {
            addCriterion("org_path <>", value, "orgPath");
            return (Criteria) this;
        }

        public Criteria andOrgPathGreaterThan(String value) {
            addCriterion("org_path >", value, "orgPath");
            return (Criteria) this;
        }

        public Criteria andOrgPathGreaterThanOrEqualTo(String value) {
            addCriterion("org_path >=", value, "orgPath");
            return (Criteria) this;
        }

        public Criteria andOrgPathLessThan(String value) {
            addCriterion("org_path <", value, "orgPath");
            return (Criteria) this;
        }

        public Criteria andOrgPathLessThanOrEqualTo(String value) {
            addCriterion("org_path <=", value, "orgPath");
            return (Criteria) this;
        }

        public Criteria andOrgPathLike(String value) {
            addCriterion("org_path like", value, "orgPath");
            return (Criteria) this;
        }

        public Criteria andOrgPathNotLike(String value) {
            addCriterion("org_path not like", value, "orgPath");
            return (Criteria) this;
        }

        public Criteria andOrgPathIn(List<String> values) {
            addCriterion("org_path in", values, "orgPath");
            return (Criteria) this;
        }

        public Criteria andOrgPathNotIn(List<String> values) {
            addCriterion("org_path not in", values, "orgPath");
            return (Criteria) this;
        }

        public Criteria andOrgPathBetween(String value1, String value2) {
            addCriterion("org_path between", value1, value2, "orgPath");
            return (Criteria) this;
        }

        public Criteria andOrgPathNotBetween(String value1, String value2) {
            addCriterion("org_path not between", value1, value2, "orgPath");
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