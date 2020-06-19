package com.hudu.dao;

import com.hudu.pojo.Student;
import com.hudu.pojo.StudentT;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    List<Student> getStudents();

    //给id属性起一个别名
    void deleteStudent(@Param("sid") int id);

    void addStudent(Student student);

    void updateStudent(Student student);

    List<StudentT> getStudents2();

    @Select("select * from student")
    List<Student> getStudents3();

    @Update("update student set name=#{name},tid=#{tid} where id=#{id}")
    void updateStudent2(Student student);

    @Select("select * from student where id = #{sid}")
    Student getStudentById(@Param("sid") int id);

    List<Student> getStudentBy(Map<String,Integer> map);
}
