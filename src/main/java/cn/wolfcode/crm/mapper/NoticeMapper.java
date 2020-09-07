package cn.wolfcode.crm.mapper;

import cn.wolfcode.crm.domain.Notice;
import cn.wolfcode.crm.query.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeMapper {

    List<Notice> selectAll();

    List<Notice> selectForList(@Param("qo") QueryObject qo, @Param("id") Long id);

    void insert(Notice notice);

    void update(Notice notice);

    void delete(Long id);

    void deleteRelation(Long id);

    List<Long> selectById(Long id);

    Notice select(Long id);



    void insertRelation(@Param("noticeId") Long noticeId,@Param("employeeId") Long employeeId);

    List selectRelation(Long noticeId);


    //void selectRelation(Long noticeId);
}