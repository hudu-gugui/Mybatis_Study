package com.hudu.dao;

import com.hudu.pojo.Student2;

import java.util.List;

public interface Student2Mapper {
    //获取所有学生信息以及他的老师
    List<Student2> getStudent();
    List<Student2> getStudent2();
}
