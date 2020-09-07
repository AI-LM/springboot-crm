package cn.wolfcode.crm.service;

import cn.wolfcode.crm.domain.Role;
import cn.wolfcode.crm.query.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IRoleService {
    void delete(Long id);
    void save(Role role, Long[] ids);
    Role get(Long id);
    List<Role> listAll();
    void update(Role role, Long[] ids);

    /**
     * 分页
     * @param qo
     * @return
     */
    PageInfo query(QueryObject qo);
}
