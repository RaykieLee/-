package com.example.mall.Service;

import com.example.mall.entity.File;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created  by lizixi on 2020-01-16
 **/
public interface FileService {
    File getUrl(Integer id);
    File upload(MultipartFile file);
}
