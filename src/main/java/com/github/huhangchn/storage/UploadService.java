package com.github.huhangchn.storage;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface UploadService {

    /**
     * 保存到本地
     */
    File saveToLocal(MultipartFile multipartFile);
    /**
     * 单文件上传
     */
    String uploadFile(File file);

    /**
     * 多文件上传
     */
    List<String> uploadFiles(File[] files);

    /**
     * 单文件上传 spring mvc
     */
    String uploadFile(MultipartFile multipartFile);

    /**
     * 多文件上传 spring mvc
     */
    List<String> uploadFiles(MultipartFile[] multipartFiles);
}
