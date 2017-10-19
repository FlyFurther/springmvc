package com.hq.springmvc.controller;

import com.hq.springmvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hq on 17/10/18.
 */
@Controller
public class ConverterController {

    @RequestMapping(value = "/converter", produces = "application/x-wisely")
    @ResponseBody
    public DemoObj converter(@RequestBody DemoObj demoObj) {
        return demoObj;
    }
}
