package com.blog.dao;

import com.blog.pojo.Visitor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
@Mapper
@Repository
public interface VisitorDao {
    Visitor findIp(Visitor visitor);
    int insertVisitor(Visitor visitor);
}
