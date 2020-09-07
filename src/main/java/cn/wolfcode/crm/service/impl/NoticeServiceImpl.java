package cn.wolfcode.crm.service.impl;

import cn.wolfcode.crm.domain.Employee;
import cn.wolfcode.crm.domain.Notice;
import cn.wolfcode.crm.mapper.NoticeMapper;
import cn.wolfcode.crm.query.QueryObject;
import cn.wolfcode.crm.service.INoticeService;
import cn.wolfcode.crm.util.UserContext;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImpl implements INoticeService {

    @Autowired
    private NoticeMapper noticeMapper;


    @Override
    public List<Notice> listAll() {
        return noticeMapper.selectAll();
    }


    public PageInfo query(QueryObject qo, Long id) {
        //使用分页插件,传入当前页,每页显示数量
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        List<Notice> list = noticeMapper.selectForList(qo,id);
        return new PageInfo(list);
    }


    @Override
    public void save(Notice notice) {
        Employee employee = UserContext.getCurrentUser();
        notice.setEmployee(employee);
        notice.setPubDate(new Date());
        noticeMapper.insert(notice);
    }

    @Override
    public void update(Notice notice) {
        Employee employee = UserContext.getCurrentUser();
        notice.setEmployee(employee);
        notice.setPubDate(new Date());
        noticeMapper.update(notice);
    }

    @Override
    public void delete(Long id) {
        noticeMapper.delete(id);
        noticeMapper.deleteRelation(id);
    }

  /*  @Override
    public Notice selectById(Long id) {
        return noticeMapper.selectById(id);
    }*/
/*
    @Override
    public Notice selectById(Long id) {
        return null;
    }*/

    @Override
    public Notice selectById(Long id) {
        return noticeMapper.select(id);
    }

    @Override
    public void insert(Long noticeId, Long employeeId) {
        //根据noticeId拿到员工id,跟传进来的比较
        List<Long> employeeIds = noticeMapper.selectById(noticeId);
        for (Long id : employeeIds) {
            if(id!=employeeId){
                noticeMapper.insertRelation(noticeId,employeeId);
            }
        }


    }


}
