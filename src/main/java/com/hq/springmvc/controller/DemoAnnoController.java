package com.hq.springmvc.controller;

import com.hq.springmvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hq on 17/10/15.
 */
@Controller
@RequestMapping(value = "/anno")
public class DemoAnnoController {

    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public @ResponseBody String index(HttpServletRequest request) {
        System.out.println("方法在执行 !");
        return "url:" + request.getRequestURL() + " can access";
    }

    @RequestMapping(value = "pathvar/{str}", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String DemoPathVar(@PathVariable(name = "str") String str, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access , str:" + str;
    }

    @RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String passRequestParam(Long id, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access ,id:" + id;
    }

    @RequestMapping(value = "/obj", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String pasObj(DemoObj obj, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access, obj id:" + obj.getId() + " name:" + obj.getName();
    }

    @RequestMapping(value = {"/name1", "/name2"}, produces = "text/plain;charset=UTF-8")
    public @ResponseBody String remove(HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access";
    }
}
