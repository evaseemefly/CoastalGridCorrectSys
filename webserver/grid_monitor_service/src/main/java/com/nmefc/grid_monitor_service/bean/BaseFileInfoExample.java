package com.nmefc.grid_monitor_service.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseFileInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseFileInfoExample() {
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

        public Criteria andGmtCreatedIsNull() {
            addCriterion("gmt_created is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNotNull() {
            addCriterion("gmt_created is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedEqualTo(Date value) {
            addCriterion("gmt_created =", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotEqualTo(Date value) {
            addCriterion("gmt_created <>", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThan(Date value) {
            addCriterion("gmt_created >", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_created >=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThan(Date value) {
            addCriterion("gmt_created <", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_created <=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIn(List<Date> values) {
            addCriterion("gmt_created in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotIn(List<Date> values) {
            addCriterion("gmt_created not in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedBetween(Date value1, Date value2) {
            addCriterion("gmt_created between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_created not between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Byte value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Byte value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Byte value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Byte value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Byte value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Byte> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Byte> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Byte value1, Byte value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Byte value1, Byte value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIssurerIdIsNull() {
            addCriterion("issurer_id is null");
            return (Criteria) this;
        }

        public Criteria andIssurerIdIsNotNull() {
            addCriterion("issurer_id is not null");
            return (Criteria) this;
        }

        public Criteria andIssurerIdEqualTo(Integer value) {
            addCriterion("issurer_id =", value, "issurerId");
            return (Criteria) this;
        }

        public Criteria andIssurerIdNotEqualTo(Integer value) {
            addCriterion("issurer_id <>", value, "issurerId");
            return (Criteria) this;
        }

        public Criteria andIssurerIdGreaterThan(Integer value) {
            addCriterion("issurer_id >", value, "issurerId");
            return (Criteria) this;
        }

        public Criteria andIssurerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("issurer_id >=", value, "issurerId");
            return (Criteria) this;
        }

        public Criteria andIssurerIdLessThan(Integer value) {
            addCriterion("issurer_id <", value, "issurerId");
            return (Criteria) this;
        }

        public Criteria andIssurerIdLessThanOrEqualTo(Integer value) {
            addCriterion("issurer_id <=", value, "issurerId");
            return (Criteria) this;
        }

        public Criteria andIssurerIdIn(List<Integer> values) {
            addCriterion("issurer_id in", values, "issurerId");
            return (Criteria) this;
        }

        public Criteria andIssurerIdNotIn(List<Integer> values) {
            addCriterion("issurer_id not in", values, "issurerId");
            return (Criteria) this;
        }

        public Criteria andIssurerIdBetween(Integer value1, Integer value2) {
            addCriterion("issurer_id between", value1, value2, "issurerId");
            return (Criteria) this;
        }

        public Criteria andIssurerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("issurer_id not between", value1, value2, "issurerId");
            return (Criteria) this;
        }

        public Criteria andForecastTimeIsNull() {
            addCriterion("forecast_time is null");
            return (Criteria) this;
        }

        public Criteria andForecastTimeIsNotNull() {
            addCriterion("forecast_time is not null");
            return (Criteria) this;
        }

        public Criteria andForecastTimeEqualTo(Date value) {
            addCriterion("forecast_time =", value, "forecastTime");
            return (Criteria) this;
        }

        public Criteria andForecastTimeNotEqualTo(Date value) {
            addCriterion("forecast_time <>", value, "forecastTime");
            return (Criteria) this;
        }

        public Criteria andForecastTimeGreaterThan(Date value) {
            addCriterion("forecast_time >", value, "forecastTime");
            return (Criteria) this;
        }

        public Criteria andForecastTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("forecast_time >=", value, "forecastTime");
            return (Criteria) this;
        }

        public Criteria andForecastTimeLessThan(Date value) {
            addCriterion("forecast_time <", value, "forecastTime");
            return (Criteria) this;
        }

        public Criteria andForecastTimeLessThanOrEqualTo(Date value) {
            addCriterion("forecast_time <=", value, "forecastTime");
            return (Criteria) this;
        }

        public Criteria andForecastTimeIn(List<Date> values) {
            addCriterion("forecast_time in", values, "forecastTime");
            return (Criteria) this;
        }

        public Criteria andForecastTimeNotIn(List<Date> values) {
            addCriterion("forecast_time not in", values, "forecastTime");
            return (Criteria) this;
        }

        public Criteria andForecastTimeBetween(Date value1, Date value2) {
            addCriterion("forecast_time between", value1, value2, "forecastTime");
            return (Criteria) this;
        }

        public Criteria andForecastTimeNotBetween(Date value1, Date value2) {
            addCriterion("forecast_time not between", value1, value2, "forecastTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNull() {
            addCriterion("product_type is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNotNull() {
            addCriterion("product_type is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeEqualTo(Integer value) {
            addCriterion("product_type =", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotEqualTo(Integer value) {
            addCriterion("product_type <>", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThan(Integer value) {
            addCriterion("product_type >", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_type >=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThan(Integer value) {
            addCriterion("product_type <", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThanOrEqualTo(Integer value) {
            addCriterion("product_type <=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeIn(List<Integer> values) {
            addCriterion("product_type in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotIn(List<Integer> values) {
            addCriterion("product_type not in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeBetween(Integer value1, Integer value2) {
            addCriterion("product_type between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("product_type not between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andForecastTypeIsNull() {
            addCriterion("forecast_type is null");
            return (Criteria) this;
        }

        public Criteria andForecastTypeIsNotNull() {
            addCriterion("forecast_type is not null");
            return (Criteria) this;
        }

        public Criteria andForecastTypeEqualTo(Integer value) {
            addCriterion("forecast_type =", value, "forecastType");
            return (Criteria) this;
        }

        public Criteria andForecastTypeNotEqualTo(Integer value) {
            addCriterion("forecast_type <>", value, "forecastType");
            return (Criteria) this;
        }

        public Criteria andForecastTypeGreaterThan(Integer value) {
            addCriterion("forecast_type >", value, "forecastType");
            return (Criteria) this;
        }

        public Criteria andForecastTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("forecast_type >=", value, "forecastType");
            return (Criteria) this;
        }

        public Criteria andForecastTypeLessThan(Integer value) {
            addCriterion("forecast_type <", value, "forecastType");
            return (Criteria) this;
        }

        public Criteria andForecastTypeLessThanOrEqualTo(Integer value) {
            addCriterion("forecast_type <=", value, "forecastType");
            return (Criteria) this;
        }

        public Criteria andForecastTypeIn(List<Integer> values) {
            addCriterion("forecast_type in", values, "forecastType");
            return (Criteria) this;
        }

        public Criteria andForecastTypeNotIn(List<Integer> values) {
            addCriterion("forecast_type not in", values, "forecastType");
            return (Criteria) this;
        }

        public Criteria andForecastTypeBetween(Integer value1, Integer value2) {
            addCriterion("forecast_type between", value1, value2, "forecastType");
            return (Criteria) this;
        }

        public Criteria andForecastTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("forecast_type not between", value1, value2, "forecastType");
            return (Criteria) this;
        }

        public Criteria andForecastAreaIsNull() {
            addCriterion("forecast_area is null");
            return (Criteria) this;
        }

        public Criteria andForecastAreaIsNotNull() {
            addCriterion("forecast_area is not null");
            return (Criteria) this;
        }

        public Criteria andForecastAreaEqualTo(Integer value) {
            addCriterion("forecast_area =", value, "forecastArea");
            return (Criteria) this;
        }

        public Criteria andForecastAreaNotEqualTo(Integer value) {
            addCriterion("forecast_area <>", value, "forecastArea");
            return (Criteria) this;
        }

        public Criteria andForecastAreaGreaterThan(Integer value) {
            addCriterion("forecast_area >", value, "forecastArea");
            return (Criteria) this;
        }

        public Criteria andForecastAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("forecast_area >=", value, "forecastArea");
            return (Criteria) this;
        }

        public Criteria andForecastAreaLessThan(Integer value) {
            addCriterion("forecast_area <", value, "forecastArea");
            return (Criteria) this;
        }

        public Criteria andForecastAreaLessThanOrEqualTo(Integer value) {
            addCriterion("forecast_area <=", value, "forecastArea");
            return (Criteria) this;
        }

        public Criteria andForecastAreaIn(List<Integer> values) {
            addCriterion("forecast_area in", values, "forecastArea");
            return (Criteria) this;
        }

        public Criteria andForecastAreaNotIn(List<Integer> values) {
            addCriterion("forecast_area not in", values, "forecastArea");
            return (Criteria) this;
        }

        public Criteria andForecastAreaBetween(Integer value1, Integer value2) {
            addCriterion("forecast_area between", value1, value2, "forecastArea");
            return (Criteria) this;
        }

        public Criteria andForecastAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("forecast_area not between", value1, value2, "forecastArea");
            return (Criteria) this;
        }

        public Criteria andForecastPeriodIsNull() {
            addCriterion("forecast_period is null");
            return (Criteria) this;
        }

        public Criteria andForecastPeriodIsNotNull() {
            addCriterion("forecast_period is not null");
            return (Criteria) this;
        }

        public Criteria andForecastPeriodEqualTo(Integer value) {
            addCriterion("forecast_period =", value, "forecastPeriod");
            return (Criteria) this;
        }

        public Criteria andForecastPeriodNotEqualTo(Integer value) {
            addCriterion("forecast_period <>", value, "forecastPeriod");
            return (Criteria) this;
        }

        public Criteria andForecastPeriodGreaterThan(Integer value) {
            addCriterion("forecast_period >", value, "forecastPeriod");
            return (Criteria) this;
        }

        public Criteria andForecastPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("forecast_period >=", value, "forecastPeriod");
            return (Criteria) this;
        }

        public Criteria andForecastPeriodLessThan(Integer value) {
            addCriterion("forecast_period <", value, "forecastPeriod");
            return (Criteria) this;
        }

        public Criteria andForecastPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("forecast_period <=", value, "forecastPeriod");
            return (Criteria) this;
        }

        public Criteria andForecastPeriodIn(List<Integer> values) {
            addCriterion("forecast_period in", values, "forecastPeriod");
            return (Criteria) this;
        }

        public Criteria andForecastPeriodNotIn(List<Integer> values) {
            addCriterion("forecast_period not in", values, "forecastPeriod");
            return (Criteria) this;
        }

        public Criteria andForecastPeriodBetween(Integer value1, Integer value2) {
            addCriterion("forecast_period between", value1, value2, "forecastPeriod");
            return (Criteria) this;
        }

        public Criteria andForecastPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("forecast_period not between", value1, value2, "forecastPeriod");
            return (Criteria) this;
        }

        public Criteria andForecastIntervalIsNull() {
            addCriterion("forecast_interval is null");
            return (Criteria) this;
        }

        public Criteria andForecastIntervalIsNotNull() {
            addCriterion("forecast_interval is not null");
            return (Criteria) this;
        }

        public Criteria andForecastIntervalEqualTo(Integer value) {
            addCriterion("forecast_interval =", value, "forecastInterval");
            return (Criteria) this;
        }

        public Criteria andForecastIntervalNotEqualTo(Integer value) {
            addCriterion("forecast_interval <>", value, "forecastInterval");
            return (Criteria) this;
        }

        public Criteria andForecastIntervalGreaterThan(Integer value) {
            addCriterion("forecast_interval >", value, "forecastInterval");
            return (Criteria) this;
        }

        public Criteria andForecastIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("forecast_interval >=", value, "forecastInterval");
            return (Criteria) this;
        }

        public Criteria andForecastIntervalLessThan(Integer value) {
            addCriterion("forecast_interval <", value, "forecastInterval");
            return (Criteria) this;
        }

        public Criteria andForecastIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("forecast_interval <=", value, "forecastInterval");
            return (Criteria) this;
        }

        public Criteria andForecastIntervalIn(List<Integer> values) {
            addCriterion("forecast_interval in", values, "forecastInterval");
            return (Criteria) this;
        }

        public Criteria andForecastIntervalNotIn(List<Integer> values) {
            addCriterion("forecast_interval not in", values, "forecastInterval");
            return (Criteria) this;
        }

        public Criteria andForecastIntervalBetween(Integer value1, Integer value2) {
            addCriterion("forecast_interval between", value1, value2, "forecastInterval");
            return (Criteria) this;
        }

        public Criteria andForecastIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("forecast_interval not between", value1, value2, "forecastInterval");
            return (Criteria) this;
        }

        public Criteria andForecastElementIsNull() {
            addCriterion("forecast_element is null");
            return (Criteria) this;
        }

        public Criteria andForecastElementIsNotNull() {
            addCriterion("forecast_element is not null");
            return (Criteria) this;
        }

        public Criteria andForecastElementEqualTo(Integer value) {
            addCriterion("forecast_element =", value, "forecastElement");
            return (Criteria) this;
        }

        public Criteria andForecastElementNotEqualTo(Integer value) {
            addCriterion("forecast_element <>", value, "forecastElement");
            return (Criteria) this;
        }

        public Criteria andForecastElementGreaterThan(Integer value) {
            addCriterion("forecast_element >", value, "forecastElement");
            return (Criteria) this;
        }

        public Criteria andForecastElementGreaterThanOrEqualTo(Integer value) {
            addCriterion("forecast_element >=", value, "forecastElement");
            return (Criteria) this;
        }

        public Criteria andForecastElementLessThan(Integer value) {
            addCriterion("forecast_element <", value, "forecastElement");
            return (Criteria) this;
        }

        public Criteria andForecastElementLessThanOrEqualTo(Integer value) {
            addCriterion("forecast_element <=", value, "forecastElement");
            return (Criteria) this;
        }

        public Criteria andForecastElementIn(List<Integer> values) {
            addCriterion("forecast_element in", values, "forecastElement");
            return (Criteria) this;
        }

        public Criteria andForecastElementNotIn(List<Integer> values) {
            addCriterion("forecast_element not in", values, "forecastElement");
            return (Criteria) this;
        }

        public Criteria andForecastElementBetween(Integer value1, Integer value2) {
            addCriterion("forecast_element between", value1, value2, "forecastElement");
            return (Criteria) this;
        }

        public Criteria andForecastElementNotBetween(Integer value1, Integer value2) {
            addCriterion("forecast_element not between", value1, value2, "forecastElement");
            return (Criteria) this;
        }

        public Criteria andRevisalTypeIsNull() {
            addCriterion("revisal_type is null");
            return (Criteria) this;
        }

        public Criteria andRevisalTypeIsNotNull() {
            addCriterion("revisal_type is not null");
            return (Criteria) this;
        }

        public Criteria andRevisalTypeEqualTo(Integer value) {
            addCriterion("revisal_type =", value, "revisalType");
            return (Criteria) this;
        }

        public Criteria andRevisalTypeNotEqualTo(Integer value) {
            addCriterion("revisal_type <>", value, "revisalType");
            return (Criteria) this;
        }

        public Criteria andRevisalTypeGreaterThan(Integer value) {
            addCriterion("revisal_type >", value, "revisalType");
            return (Criteria) this;
        }

        public Criteria andRevisalTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("revisal_type >=", value, "revisalType");
            return (Criteria) this;
        }

        public Criteria andRevisalTypeLessThan(Integer value) {
            addCriterion("revisal_type <", value, "revisalType");
            return (Criteria) this;
        }

        public Criteria andRevisalTypeLessThanOrEqualTo(Integer value) {
            addCriterion("revisal_type <=", value, "revisalType");
            return (Criteria) this;
        }

        public Criteria andRevisalTypeIn(List<Integer> values) {
            addCriterion("revisal_type in", values, "revisalType");
            return (Criteria) this;
        }

        public Criteria andRevisalTypeNotIn(List<Integer> values) {
            addCriterion("revisal_type not in", values, "revisalType");
            return (Criteria) this;
        }

        public Criteria andRevisalTypeBetween(Integer value1, Integer value2) {
            addCriterion("revisal_type between", value1, value2, "revisalType");
            return (Criteria) this;
        }

        public Criteria andRevisalTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("revisal_type not between", value1, value2, "revisalType");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileFullNameIsNull() {
            addCriterion("file_full_name is null");
            return (Criteria) this;
        }

        public Criteria andFileFullNameIsNotNull() {
            addCriterion("file_full_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileFullNameEqualTo(String value) {
            addCriterion("file_full_name =", value, "fileFullName");
            return (Criteria) this;
        }

        public Criteria andFileFullNameNotEqualTo(String value) {
            addCriterion("file_full_name <>", value, "fileFullName");
            return (Criteria) this;
        }

        public Criteria andFileFullNameGreaterThan(String value) {
            addCriterion("file_full_name >", value, "fileFullName");
            return (Criteria) this;
        }

        public Criteria andFileFullNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_full_name >=", value, "fileFullName");
            return (Criteria) this;
        }

        public Criteria andFileFullNameLessThan(String value) {
            addCriterion("file_full_name <", value, "fileFullName");
            return (Criteria) this;
        }

        public Criteria andFileFullNameLessThanOrEqualTo(String value) {
            addCriterion("file_full_name <=", value, "fileFullName");
            return (Criteria) this;
        }

        public Criteria andFileFullNameLike(String value) {
            addCriterion("file_full_name like", value, "fileFullName");
            return (Criteria) this;
        }

        public Criteria andFileFullNameNotLike(String value) {
            addCriterion("file_full_name not like", value, "fileFullName");
            return (Criteria) this;
        }

        public Criteria andFileFullNameIn(List<String> values) {
            addCriterion("file_full_name in", values, "fileFullName");
            return (Criteria) this;
        }

        public Criteria andFileFullNameNotIn(List<String> values) {
            addCriterion("file_full_name not in", values, "fileFullName");
            return (Criteria) this;
        }

        public Criteria andFileFullNameBetween(String value1, String value2) {
            addCriterion("file_full_name between", value1, value2, "fileFullName");
            return (Criteria) this;
        }

        public Criteria andFileFullNameNotBetween(String value1, String value2) {
            addCriterion("file_full_name not between", value1, value2, "fileFullName");
            return (Criteria) this;
        }

        public Criteria andFileExtIsNull() {
            addCriterion("file_ext is null");
            return (Criteria) this;
        }

        public Criteria andFileExtIsNotNull() {
            addCriterion("file_ext is not null");
            return (Criteria) this;
        }

        public Criteria andFileExtEqualTo(String value) {
            addCriterion("file_ext =", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtNotEqualTo(String value) {
            addCriterion("file_ext <>", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtGreaterThan(String value) {
            addCriterion("file_ext >", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtGreaterThanOrEqualTo(String value) {
            addCriterion("file_ext >=", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtLessThan(String value) {
            addCriterion("file_ext <", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtLessThanOrEqualTo(String value) {
            addCriterion("file_ext <=", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtLike(String value) {
            addCriterion("file_ext like", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtNotLike(String value) {
            addCriterion("file_ext not like", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtIn(List<String> values) {
            addCriterion("file_ext in", values, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtNotIn(List<String> values) {
            addCriterion("file_ext not in", values, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtBetween(String value1, String value2) {
            addCriterion("file_ext between", value1, value2, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtNotBetween(String value1, String value2) {
            addCriterion("file_ext not between", value1, value2, "fileExt");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(Float value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(Float value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(Float value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(Float value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(Float value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(Float value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<Float> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<Float> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(Float value1, Float value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(Float value1, Float value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("path is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("path is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("path =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("path <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("path >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("path >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("path <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("path <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("path like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("path not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("path in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("path not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("path between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("path not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andIsStandardIsNull() {
            addCriterion("is_standard is null");
            return (Criteria) this;
        }

        public Criteria andIsStandardIsNotNull() {
            addCriterion("is_standard is not null");
            return (Criteria) this;
        }

        public Criteria andIsStandardEqualTo(Byte value) {
            addCriterion("is_standard =", value, "isStandard");
            return (Criteria) this;
        }

        public Criteria andIsStandardNotEqualTo(Byte value) {
            addCriterion("is_standard <>", value, "isStandard");
            return (Criteria) this;
        }

        public Criteria andIsStandardGreaterThan(Byte value) {
            addCriterion("is_standard >", value, "isStandard");
            return (Criteria) this;
        }

        public Criteria andIsStandardGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_standard >=", value, "isStandard");
            return (Criteria) this;
        }

        public Criteria andIsStandardLessThan(Byte value) {
            addCriterion("is_standard <", value, "isStandard");
            return (Criteria) this;
        }

        public Criteria andIsStandardLessThanOrEqualTo(Byte value) {
            addCriterion("is_standard <=", value, "isStandard");
            return (Criteria) this;
        }

        public Criteria andIsStandardIn(List<Byte> values) {
            addCriterion("is_standard in", values, "isStandard");
            return (Criteria) this;
        }

        public Criteria andIsStandardNotIn(List<Byte> values) {
            addCriterion("is_standard not in", values, "isStandard");
            return (Criteria) this;
        }

        public Criteria andIsStandardBetween(Byte value1, Byte value2) {
            addCriterion("is_standard between", value1, value2, "isStandard");
            return (Criteria) this;
        }

        public Criteria andIsStandardNotBetween(Byte value1, Byte value2) {
            addCriterion("is_standard not between", value1, value2, "isStandard");
            return (Criteria) this;
        }

        public Criteria andEventTypeIsNull() {
            addCriterion("event_type is null");
            return (Criteria) this;
        }

        public Criteria andEventTypeIsNotNull() {
            addCriterion("event_type is not null");
            return (Criteria) this;
        }

        public Criteria andEventTypeEqualTo(String value) {
            addCriterion("event_type =", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotEqualTo(String value) {
            addCriterion("event_type <>", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeGreaterThan(String value) {
            addCriterion("event_type >", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeGreaterThanOrEqualTo(String value) {
            addCriterion("event_type >=", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeLessThan(String value) {
            addCriterion("event_type <", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeLessThanOrEqualTo(String value) {
            addCriterion("event_type <=", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeLike(String value) {
            addCriterion("event_type like", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotLike(String value) {
            addCriterion("event_type not like", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeIn(List<String> values) {
            addCriterion("event_type in", values, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotIn(List<String> values) {
            addCriterion("event_type not in", values, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeBetween(String value1, String value2) {
            addCriterion("event_type between", value1, value2, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotBetween(String value1, String value2) {
            addCriterion("event_type not between", value1, value2, "eventType");
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