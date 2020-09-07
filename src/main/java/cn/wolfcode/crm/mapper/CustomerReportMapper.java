package cn.wolfcode.crm.mapper;

import cn.wolfcode.crm.query.QueryObject;

import java.util.List;
import java.util.Map;

public interface CustomerReportMapper {

    List<Map> selectCustomerReport(QueryObject qo);
}
