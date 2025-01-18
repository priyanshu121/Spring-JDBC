package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Program started..." );
        
        ApplicationContext con=new AnnotationConfigApplicationContext(JdbcConfig.class);
//        JdbcTemplate template= con.getBean("jdbcTemplate", JdbcTemplate.class);
//        
//        String query="insert into student(name, city) values (?,?)";
//        
//        int result=template.update(query, "abcd", "mnop");
//        System.out.println("number of record inserted..."+result);
        
        
        StudentDao studentDao=con.getBean("studentDao", StudentDao.class);
        Student student=new Student();
          // Insert...
        student.setName("abc");
        student.setCity("mnop");
        
        
        int res=studentDao.insert(student);
        System.out.print(res);
        
          // Update...
//        student.setId(3);
//        student.setName("Priyanshu");
//        student.setCity("Noida");
//        
//        int res=studentDao.update(student);
//        System.out.println(res+" rows affected");
        
          // Delete...
        
//        student.setId(2);
//        int res=studentDao.delete(student);
//        System.out.println(res+" row deleted...");
        
        //Select single data
        
//        Student student=studentDao.getStudent(3);
//        System.out.println(student);
        
        
        // Select all Student data
        List<Student> students=studentDao.getAllStudents();
        
        for(Student s: students) {
        	System.out.println(s);
        }
        
    }
}
