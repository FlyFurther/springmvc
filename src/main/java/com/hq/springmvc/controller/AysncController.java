package com.hq.springmvc.controller;

import com.hq.springmvc.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import javax.inject.Inject;

/**
 * Created by hq on 17/10/19.
 */
@Controller
public class AysncController {

    @Autowired
    private PushService pushService;

    @RequestMapping(value = "/defer")
    @ResponseBody
    public DeferredResult<String> deferredCall() {
        return pushService.getAysncUpdate();
    }
}
