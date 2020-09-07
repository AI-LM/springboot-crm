package cn.wolfcode.crm.service;

import cn.wolfcode.crm.domain.Customer;
import cn.wolfcode.crm.query.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ICustomerService {
    void delete(Long id);
    void save(Customer customer);
    Customer get(Long id);
    List<Customer> listAll();
    void update(Customer customer);

    /**
     * 分页
     * @param qo
     * @return
     */
    PageInfo query(QueryObject qo);
}
