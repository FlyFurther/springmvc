package com.hq.springmvc.controller;

import com.hq.springmvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hq on 17/10/17.
 */
@Controller
public class AdviceController {

    @RequestMapping("/advice")
    public String getSome(@ModelAttribute("msg") String msg, DemoObj obj) {
        throw new IllegalArgumentException("传递的参数有误  " + "来自ModelAttribute的数据:" + msg);
    }
}
