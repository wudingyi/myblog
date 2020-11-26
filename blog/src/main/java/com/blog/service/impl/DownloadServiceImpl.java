package com.blog.service.impl;

import com.blog.service.DownloadService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class DownloadServiceImpl implements DownloadService {


    @Override
    public List<String> getFileName() {
        String[] fileName = { "//Users//stanfile//Downloads//反思与总结.pdf " ,"//Users//stanfile//Downloads//学习思想.pdf "};

        List<String> fileList = new ArrayList<>(Arrays.asList(fileName));
        return fileList;
    }
}
