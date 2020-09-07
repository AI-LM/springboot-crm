package cn.wolfcode.crm.service;

import cn.wolfcode.crm.domain.CustomerTransfer;
import cn.wolfcode.crm.query.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ICustomerTrasferService {
    void save(CustomerTransfer customerTransfer);
    CustomerTransfer get(Long id);
    List<CustomerTransfer> listAll();
    void update(CustomerTransfer customerTransfer);

    /**
     * 分页
     * @param qo
     * @return
     */
    PageInfo query(QueryObject qo);
}
