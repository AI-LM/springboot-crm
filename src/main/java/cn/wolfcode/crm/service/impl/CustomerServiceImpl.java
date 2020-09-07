package cn.wolfcode.crm.service.impl;

import cn.wolfcode.crm.domain.Customer;
import cn.wolfcode.crm.domain.Employee;
import cn.wolfcode.crm.mapper.CustomerMapper;
import cn.wolfcode.crm.query.QueryObject;
import cn.wolfcode.crm.service.ICustomerService;
import cn.wolfcode.crm.util.UserContext;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void delete(Long id) {
        customerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void save(Customer customer) {
        //获取当前登录用户
        Employee employee = UserContext.getCurrentUser();
        //设置录入人
        customer.setInputuser(employee);
        //设置销售人员
        customer.setSeller(employee);
        //设置录入时间
        customer.setInputTime(new Date());

        customerMapper.insert(customer);
    }

    @Override
    public Customer get(Long id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Customer> listAll() {
        return customerMapper.selectAll();
    }

    @Override
    public void update(Customer customer) {
        customerMapper.updateByPrimaryKey(customer);
    }

    public PageInfo query(QueryObject qo) {
        //使用分页插件,传入当前页,每页显示数量,按照录入时间倒序排序
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize(),"input_time desc");
        //查询结果集
        List<Customer> list = customerMapper.selectForList(qo);
        return new PageInfo(list);
    }
}
