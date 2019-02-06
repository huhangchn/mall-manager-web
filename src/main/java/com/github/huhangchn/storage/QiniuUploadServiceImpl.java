package com.github.huhangchn.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class QiniuUploadServiceImpl implements UploadService {

    @Value("${uploadBasePath}")
    private String uploadBasePath;

    @Autowired
    private QiniuUtil qiniuUtil;

    @Override
    public File saveToLocal(MultipartFile multipartFile) {
        String path = getPath();
        try {
            File file = new File(path);
            multipartFile.transferTo(file);
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String uploadFile(File file) {
        return qiniuUtil.uoload2Qiniu(file);
    }

    @Override
    public List<String> uploadFiles(File[] files) {
        List<String> ret = new ArrayList<>();
        for (File file : files) {
            ret.add(uploadFile(file));
        }
        return ret;
    }

    @Override
    public String uploadFile(MultipartFile multipartFile) {
        File file = saveToLocal(multipartFile);
        return uploadFile(file);
    }

    @Override
    public List<String> uploadFiles(MultipartFile[] multipartFiles) {
        List<String> ret = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            ret.add(uploadFile(multipartFile));
        }
        return ret;
    }

    private String getPath(){
        return uploadBasePath + UUID.randomUUID().toString();
    }
}
