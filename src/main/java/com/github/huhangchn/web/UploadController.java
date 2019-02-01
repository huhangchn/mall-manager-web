package com.github.huhangchn.web;

import com.github.huhangchn.result.Result;
import com.github.huhangchn.service.impl.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @PostMapping("/uploadFile")
    @ResponseBody
    public Result upload(@RequestParam("file") MultipartFile file) {
        return uploadService.upload(file);
    }
}
