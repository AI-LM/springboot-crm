package cn.wolfcode.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class nopermission {
    @RequestMapping("/nopermission")
    public String nopermission(){
        return "/common/nopermission";
    }
}
