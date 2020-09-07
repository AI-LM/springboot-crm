package cn.wolfcode.crm.web.controller;

import cn.wolfcode.crm.domain.Employee;
import cn.wolfcode.crm.service.IEmployeeService;
import cn.wolfcode.crm.service.IPermissionService;
import cn.wolfcode.crm.util.JsonResult;
import cn.wolfcode.crm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IPermissionService permissionService;


    @RequestMapping("/loginUser")
    @ResponseBody
    public JsonResult login(String username, String password, HttpSession session){
        try {
            Employee employee = employeeService.login(username, password);
            //把登录用户存到session中
            UserContext.setCurrentUser(employee);
            //如果不是超管,就要把用户的权限数据存到session中
            if(!employee.isAdmin()){
                List<String> permissions = permissionService.selectByEmpId(employee.getId());
                UserContext.setPermissions(permissions);
            }
            return new JsonResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,"账号或密码错误");
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }



}
