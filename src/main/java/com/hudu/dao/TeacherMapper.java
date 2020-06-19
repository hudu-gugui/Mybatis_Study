package com.hudu.dao;

import com.hudu.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> getTeacher2(@Param("tid") int id);
}
