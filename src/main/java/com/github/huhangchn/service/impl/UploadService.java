package com.github.huhangchn.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.huhangchn.result.CodeMsg;
import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
public class UploadService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadService.class);

    @Value("${uploadBasePath}")
    private String fileImgPath;

    @Value("${qiniu.accessKey}")
    private String access;

    @Value("${qiniu.secretKey}")
    private String secret;

    @Value("${storageServerBaseUrl}")
    private String storageServerBaseUrl;

    private UploadManager uploadManager = new UploadManager();

    public Result upload(MultipartFile file){
        return saveToLocal(file);
    }

    private Result saveToLocal(MultipartFile file){
        String fileName;
        try {
            if(!file.isEmpty()){
                String originalFilename = file.getOriginalFilename();
                String suffix = "";
                if (originalFilename != null) {
                    suffix =originalFilename.substring(originalFilename.lastIndexOf("."));
                }
                fileName = UUID.randomUUID().toString() + suffix;
                File dest = new File(fileImgPath + fileName);
                file.transferTo(dest);
            }else {
                return ResultFactory.error(CodeMsg.UPLOAD_ERROR);
            }
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
            return ResultFactory.error(CodeMsg.UPLOAD_ERROR);
        }
        return ResultFactory.success(storageServerBaseUrl + fileName);
    }

    @SuppressWarnings("unchecked")
    public String saveToQn(File filePath, String bucket, String key) throws IOException {
        Auth auth = Auth.create(access, secret);
        String upToke = auth.uploadToken(bucket, key);
        Response response = uploadManager.put(filePath, key, upToke);
        String body = response.bodyString();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = objectMapper.readValue(body, Map.class);
        return map.get("key");
    }
}
