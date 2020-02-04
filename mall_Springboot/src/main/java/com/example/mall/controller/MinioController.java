package com.example.mall.controller;

import com.example.mall.Dto.MinioUploadDto;
import com.example.mall.Service.FileService;
import com.example.mall.entity.File;
import com.example.mall.mapper.FileMapper;
import com.example.mall.utils.CommonResult;
import io.minio.MinioClient;
import io.minio.policy.PolicyType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.LoggerFactory;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created  by lizixi on 2020-01-08
 **/
@Api(tags = "MinioController", description = "MinIO对象存储管理")
@Controller
@RequestMapping("/minio")
public class MinioController {

    private static final Logger LOGGER =  LoggerFactory.getLogger(MinioController.class);
    @Value("${minio.endpoint}")
    private String ENDPOINT;
    @Value("${minio.bucketName}")
    private String BUCKET_NAME;
    @Value("${minio.accessKey}")
    private String ACCESS_KEY;
    @Value("${minio.secretKey}")
    private String SECRET_KEY;
    @Autowired
    FileMapper fileMapper;
    @Autowired
    FileService  fileService;
    @ApiOperation("文件上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult upload(@RequestParam("file") MultipartFile file) {
        File file1 =fileService.upload(file);
        if(file1.getUrl()==null) {
            return CommonResult.failed();
        }else {
            return CommonResult.success(file1);
        }
    }
    @ApiOperation("获取文件url链接")
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult get(@RequestParam Integer id) {
        File file1 =fileService.getUrl(id);
        if(file1==null) {
            return CommonResult.failed();
        }else {
            return CommonResult.success(file1.getUrl());
        }
    }

    @ApiOperation("文件删除")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("objectName") String objectName) {
        try {
            MinioClient minioClient = new MinioClient(ENDPOINT, ACCESS_KEY, SECRET_KEY);
            minioClient.removeObject(BUCKET_NAME, objectName);
            return CommonResult.success(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CommonResult.failed();
    }
}