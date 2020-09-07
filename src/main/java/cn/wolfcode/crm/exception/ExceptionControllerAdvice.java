package cn.wolfcode.crm.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice//控制器增强器
public class ExceptionControllerAdvice {
    @ExceptionHandler(RuntimeException.class)//处理什么类型的异常
    public String handIException(RuntimeException e, Model model){
        return "error/404";//返回错误视图
    }
}
