package com.github.huhangchn.storage;

import com.github.huhangchn.result.CodeMsg;
import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import org.apache.commons.lang3.StringUtils;
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
        String ret = uploadService.uploadFile(file);
        if(StringUtils.isNotEmpty(ret)){
            return ResultFactory.success(ret);
        }
        return ResultFactory.error(CodeMsg.UPLOAD_ERROR);
    }
}
