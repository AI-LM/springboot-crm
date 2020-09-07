package cn.wolfcode.crm;

import cn.wolfcode.crm.domain.Notice;
import cn.wolfcode.crm.query.QueryObject;
import cn.wolfcode.crm.service.INoticeService;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DepartmentServiceTest {
    @Autowired
    private INoticeService noticeService;

    @Test
    public void testList(){
        List<Notice> notices=noticeService.listAll();
        System.out.println(notices);
    }

}
