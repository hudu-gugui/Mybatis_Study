import com.hudu.dao.Student2Mapper;
import com.hudu.dao.StudentMapper;
import com.hudu.dao.TeacherMapper;
import com.hudu.pojo.Student;
import com.hudu.pojo.Student2;
import com.hudu.pojo.StudentT;
import com.hudu.pojo.Teacher;
import com.hudu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class test {
    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudents();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.deleteStudent(5);
        sqlSession.close();
    }

    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.updateStudent(new Student(5,"小刘",2));
        sqlSession.close();
    }

    @Test
    public void test4() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<StudentT> students2 = mapper.getStudents2();
        for (StudentT studentT : students2) {
            System.out.println(studentT);
        }
        sqlSession.close();
    }

    @Test
    public void test5() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.getStudentById(1);
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void test6() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Student2Mapper mapper = sqlSession.getMapper(Student2Mapper.class);
        List<Student2> students = mapper.getStudent();
        for (Student2 student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void test7() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeacher2(1);
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }

    @Test
    public void test8() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        HashMap map = new HashMap();
        map.put("sid",1);
        List<Student> students = mapper.getStudentBy(map);
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void test9() {
        //二级缓存只有当在文档里才行，注解开发不起作用
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        SqlSession sqlSession2 = MybatisUtil.getSqlSession();

        HashMap map = new HashMap();
        map.put("sid",1);

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

//        Student student = mapper.getStudentById(2);
        List<Student> students = mapper.getStudentBy(map);
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();

//        sqlSession.clearCache();
//        Student student3 = mapper.getStudentById(2);
//        System.out.println(student3);
        System.out.println("-----------------------");
        StudentMapper mapper2 = sqlSession2.getMapper(StudentMapper.class);
        List<Student> students2s = mapper2.getStudentBy(map);
        for (Student student2 : students2s) {
            System.out.println(student2);
        }

        System.out.println(students == students2s);
        sqlSession2.close();
    }
}
