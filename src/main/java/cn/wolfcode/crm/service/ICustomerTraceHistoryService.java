package cn.wolfcode.crm.service;

import cn.wolfcode.crm.domain.CustomerTraceHistory;
import cn.wolfcode.crm.query.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ICustomerTraceHistoryService {
    void delete(Long id);
    void save(CustomerTraceHistory customerTraceHistory);
    CustomerTraceHistory get(Long id);
    List<CustomerTraceHistory> listAll();
    void update(CustomerTraceHistory customerTraceHistory);

    /**
     * 分页
     * @param qo
     * @return
     */
    PageInfo query(QueryObject qo);
}
