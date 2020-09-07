package cn.wolfcode.crm.service;

import cn.wolfcode.crm.domain.Department;
import cn.wolfcode.crm.query.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IDepartmentService {
    void delete(Long id);
    void save(Department department);
    Department get(Long id);
    List<Department> listAll();
    void update(Department department);

    /**
     * 分页
     * @param qo
     * @return
     */
    PageInfo query(QueryObject qo);
}
