package com.hq.springmvc.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by hq on 17/10/17.
 */
@Controller
public class DemoUploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Boolean upload(MultipartFile file) throws IOException {
        FileUtils.writeByteArrayToFile(new File("/Users/hq/Desktop/" + file.getOriginalFilename()), file.getBytes());
        return true;
    }
}
