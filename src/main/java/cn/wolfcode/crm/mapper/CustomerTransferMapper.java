package cn.wolfcode.crm.mapper;

import cn.wolfcode.crm.domain.CustomerTransfer;
import cn.wolfcode.crm.query.QueryObject;
import java.util.List;

public interface CustomerTransferMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerTransfer record);

    CustomerTransfer selectByPrimaryKey(Long id);

    List<CustomerTransfer> selectAll();

    int updateByPrimaryKey(CustomerTransfer record);

    List<CustomerTransfer> selectForList(QueryObject qo);
}