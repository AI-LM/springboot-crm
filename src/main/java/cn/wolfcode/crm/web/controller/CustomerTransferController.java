package cn.wolfcode.crm.web.controller;

import cn.wolfcode.crm.domain.CustomerTransfer;
import cn.wolfcode.crm.query.QueryObject;
import cn.wolfcode.crm.service.ICustomerTrasferService;
import cn.wolfcode.crm.util.JsonResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customerTransfer")
public class CustomerTransferController {
    
    @Autowired
    private ICustomerTrasferService customerTransferService;

    // 提供一个方法处理查询所有部门数据请求，响应 HTML
    @RequestMapping("/list")
    //必须要有指定的权限才能访问该方法
    public String list(Model model, @ModelAttribute("qo") QueryObject qo){
        PageInfo pageInfo = customerTransferService.query(qo);
        model.addAttribute("result", pageInfo);
        return "customerTransfer/list"; // /WEB-INF/views/customerTransfer/potentialList.ftl
    }


    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public JsonResult saveOrUpdate(CustomerTransfer customerTransfer){
        if(customerTransfer.getId() == null){ // 代表新增
            customerTransferService.save(customerTransfer);
        }else { // 代表修改
            customerTransferService.update(customerTransfer);
        }
        return new JsonResult();
    }

}
