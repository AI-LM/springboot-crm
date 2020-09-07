package cn.wolfcode.crm.service;

import cn.wolfcode.crm.domain.Notice;
import cn.wolfcode.crm.query.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface INoticeService {


    List<Notice> listAll();

    /**
     * 分页
     * @param qo
     * @param id
     * @return
     */
    PageInfo query(QueryObject qo, Long id);

    void save(Notice notice);

    void update(Notice notice);

    void delete(Long id);

    //Notice selectBy(Long id);

    Notice selectById(Long id);


    void insert(Long noticeId, Long employeeId);
}
