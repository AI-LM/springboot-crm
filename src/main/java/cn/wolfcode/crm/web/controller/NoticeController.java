package cn.wolfcode.crm.web.controller;

import cn.wolfcode.crm.domain.Employee;
import cn.wolfcode.crm.domain.Notice;
import cn.wolfcode.crm.mapper.NoticeMapper;
import cn.wolfcode.crm.query.QueryObject;
import cn.wolfcode.crm.service.INoticeService;
import cn.wolfcode.crm.util.JsonResult;
import cn.wolfcode.crm.util.RequiredPermission;
import cn.wolfcode.crm.util.UserContext;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    
    @Autowired
    private INoticeService noticeService;

    // 提供一个方法处理查询所有部门数据请求，响应 HTML
    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo") QueryObject qo){
        Employee employee = UserContext.getCurrentUser();
        PageInfo pageInfo = noticeService.query(qo,employee.getId());
        model.addAttribute("result", pageInfo);
        return "notice/list"; // /WEB-INF/views/notice/potentialList.ftl
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public JsonResult saveOrUpdate(Notice notice,Long id){
        if(notice.getId() == null){ // 代表新增
        }else { // 代表修改
            noticeService.update(notice);

        }
        return new JsonResult();
    }


    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(Long id){
        noticeService.delete(id);
        return new JsonResult();
    }


    @RequestMapping("/show")
    public String show(Model model,Long id){
        Notice notice = noticeService.selectById(id);
        noticeService.insert(id,notice.getEmployee().getId());
        model.addAttribute("notice",notice);
        return "/notice/show";
    }





}
