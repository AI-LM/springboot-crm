package cn.wolfcode.crm.service;

import cn.wolfcode.crm.domain.Permission;
import cn.wolfcode.crm.query.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IPermissionService {
    void delete(Long id);
    void save(Permission permission);
    Permission get(Long id);
    List<Permission> listAll();
    void update(Permission permission);

    /**
     * 分页
     * @param qo
     * @return
     */
    PageInfo query(QueryObject qo);

    /**
     * 加载权限
     */
    void reload();

    /**
     * 根据员工id查询权限数据
     * @param id
     * @return
     */
    List<String> selectByEmpId(Long id);

}
