package com.blog.service.impl;

import com.blog.dao.VisitorDao;
import com.blog.pojo.Visitor;
import com.blog.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    VisitorDao visitorDao;

    @Override
    public Visitor findIp(Visitor visitor) {
        return visitorDao.findIp(visitor);
    }

    @Override
    public void insertVisitor(Visitor visitor) {
        if(findIp(visitor)==null){
             visitorDao.insertVisitor(visitor);
        }

    }
}
