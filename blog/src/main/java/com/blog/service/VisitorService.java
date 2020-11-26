package com.blog.service;

import com.blog.pojo.Visitor;

import java.util.HashSet;

public interface VisitorService {
    Visitor findIp(Visitor visitor);
    void insertVisitor(Visitor visitor);
}
