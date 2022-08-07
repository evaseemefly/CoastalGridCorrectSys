package com.nmefc.grid_monitor_service.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DistrictCodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DistrictCodeExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNull() {
            addCriterion("gmt_modify is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNotNull() {
            addCriterion("gmt_modify is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyEqualTo(Date value) {
            addCriterion("gmt_modify =", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotEqualTo(Date value) {
            addCriterion("gmt_modify <>", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThan(Date value) {
            addCriterion("gmt_modify >", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modify >=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThan(Date value) {
            addCriterion("gmt_modify <", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modify <=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIn(List<Date> values) {
            addCriterion("gmt_modify in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotIn(List<Date> values) {
            addCriterion("gmt_modify not in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyBetween(Date value1, Date value2) {
            addCriterion("gmt_modify between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modify not between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Byte value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Byte value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Byte value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Byte value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Byte value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Byte> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Byte> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Byte value1, Byte value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Byte value1, Byte value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andAgentCodeIsNull() {
            addCriterion("agent_code is null");
            return (Criteria) this;
        }

        public Criteria andAgentCodeIsNotNull() {
            addCriterion("agent_code is not null");
            return (Criteria) this;
        }

        public Criteria andAgentCodeEqualTo(String value) {
            addCriterion("agent_code =", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotEqualTo(String value) {
            addCriterion("agent_code <>", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeGreaterThan(String value) {
            addCriterion("agent_code >", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("agent_code >=", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeLessThan(String value) {
            addCriterion("agent_code <", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeLessThanOrEqualTo(String value) {
            addCriterion("agent_code <=", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeLike(String value) {
            addCriterion("agent_code like", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotLike(String value) {
            addCriterion("agent_code not like", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeIn(List<String> values) {
            addCriterion("agent_code in", values, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotIn(List<String> values) {
            addCriterion("agent_code not in", values, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeBetween(String value1, String value2) {
            addCriterion("agent_code between", value1, value2, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotBetween(String value1, String value2) {
            addCriterion("agent_code not between", value1, value2, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentChineseNameIsNull() {
            addCriterion("agent_chinese_name is null");
            return (Criteria) this;
        }

        public Criteria andAgentChineseNameIsNotNull() {
            addCriterion("agent_chinese_name is not null");
            return (Criteria) this;
        }

        public Criteria andAgentChineseNameEqualTo(String value) {
            addCriterion("agent_chinese_name =", value, "agentChineseName");
            return (Criteria) this;
        }

        public Criteria andAgentChineseNameNotEqualTo(String value) {
            addCriterion("agent_chinese_name <>", value, "agentChineseName");
            return (Criteria) this;
        }

        public Criteria andAgentChineseNameGreaterThan(String value) {
            addCriterion("agent_chinese_name >", value, "agentChineseName");
            return (Criteria) this;
        }

        public Criteria andAgentChineseNameGreaterThanOrEqualTo(String value) {
            addCriterion("agent_chinese_name >=", value, "agentChineseName");
            return (Criteria) this;
        }

        public Criteria andAgentChineseNameLessThan(String value) {
            addCriterion("agent_chinese_name <", value, "agentChineseName");
            return (Criteria) this;
        }

        public Criteria andAgentChineseNameLessThanOrEqualTo(String value) {
            addCriterion("agent_chinese_name <=", value, "agentChineseName");
            return (Criteria) this;
        }

        public Criteria andAgentChineseNameLike(String value) {
            addCriterion("agent_chinese_name like", value, "agentChineseName");
            return (Criteria) this;
        }

        public Criteria andAgentChineseNameNotLike(String value) {
            addCriterion("agent_chinese_name not like", value, "agentChineseName");
            return (Criteria) this;
        }

        public Criteria andAgentChineseNameIn(List<String> values) {
            addCriterion("agent_chinese_name in", values, "agentChineseName");
            return (Criteria) this;
        }

        public Criteria andAgentChineseNameNotIn(List<String> values) {
            addCriterion("agent_chinese_name not in", values, "agentChineseName");
            return (Criteria) this;
        }

        public Criteria andAgentChineseNameBetween(String value1, String value2) {
            addCriterion("agent_chinese_name between", value1, value2, "agentChineseName");
            return (Criteria) this;
        }

        public Criteria andAgentChineseNameNotBetween(String value1, String value2) {
            addCriterion("agent_chinese_name not between", value1, value2, "agentChineseName");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictAreaIsNull() {
            addCriterion("fcst_district_area is null");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictAreaIsNotNull() {
            addCriterion("fcst_district_area is not null");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictAreaEqualTo(String value) {
            addCriterion("fcst_district_area =", value, "fcstDistrictArea");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictAreaNotEqualTo(String value) {
            addCriterion("fcst_district_area <>", value, "fcstDistrictArea");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictAreaGreaterThan(String value) {
            addCriterion("fcst_district_area >", value, "fcstDistrictArea");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictAreaGreaterThanOrEqualTo(String value) {
            addCriterion("fcst_district_area >=", value, "fcstDistrictArea");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictAreaLessThan(String value) {
            addCriterion("fcst_district_area <", value, "fcstDistrictArea");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictAreaLessThanOrEqualTo(String value) {
            addCriterion("fcst_district_area <=", value, "fcstDistrictArea");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictAreaLike(String value) {
            addCriterion("fcst_district_area like", value, "fcstDistrictArea");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictAreaNotLike(String value) {
            addCriterion("fcst_district_area not like", value, "fcstDistrictArea");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictAreaIn(List<String> values) {
            addCriterion("fcst_district_area in", values, "fcstDistrictArea");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictAreaNotIn(List<String> values) {
            addCriterion("fcst_district_area not in", values, "fcstDistrictArea");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictAreaBetween(String value1, String value2) {
            addCriterion("fcst_district_area between", value1, value2, "fcstDistrictArea");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictAreaNotBetween(String value1, String value2) {
            addCriterion("fcst_district_area not between", value1, value2, "fcstDistrictArea");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictChineseNameIsNull() {
            addCriterion("fcst_district_chinese_name is null");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictChineseNameIsNotNull() {
            addCriterion("fcst_district_chinese_name is not null");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictChineseNameEqualTo(String value) {
            addCriterion("fcst_district_chinese_name =", value, "fcstDistrictChineseName");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictChineseNameNotEqualTo(String value) {
            addCriterion("fcst_district_chinese_name <>", value, "fcstDistrictChineseName");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictChineseNameGreaterThan(String value) {
            addCriterion("fcst_district_chinese_name >", value, "fcstDistrictChineseName");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictChineseNameGreaterThanOrEqualTo(String value) {
            addCriterion("fcst_district_chinese_name >=", value, "fcstDistrictChineseName");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictChineseNameLessThan(String value) {
            addCriterion("fcst_district_chinese_name <", value, "fcstDistrictChineseName");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictChineseNameLessThanOrEqualTo(String value) {
            addCriterion("fcst_district_chinese_name <=", value, "fcstDistrictChineseName");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictChineseNameLike(String value) {
            addCriterion("fcst_district_chinese_name like", value, "fcstDistrictChineseName");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictChineseNameNotLike(String value) {
            addCriterion("fcst_district_chinese_name not like", value, "fcstDistrictChineseName");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictChineseNameIn(List<String> values) {
            addCriterion("fcst_district_chinese_name in", values, "fcstDistrictChineseName");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictChineseNameNotIn(List<String> values) {
            addCriterion("fcst_district_chinese_name not in", values, "fcstDistrictChineseName");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictChineseNameBetween(String value1, String value2) {
            addCriterion("fcst_district_chinese_name between", value1, value2, "fcstDistrictChineseName");
            return (Criteria) this;
        }

        public Criteria andFcstDistrictChineseNameNotBetween(String value1, String value2) {
            addCriterion("fcst_district_chinese_name not between", value1, value2, "fcstDistrictChineseName");
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

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
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