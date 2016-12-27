package com.Nipun.Dao;

import com.Nipun.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nipun on 12/24/16.
 */
@Repository
public class StudentDao {

    private static Map<Integer , Student> students;

    static {
        students = new HashMap<Integer, Student>(){
            {
                put(1 , new Student(1 , "Nipun" , "Software Engineering"));
                put(2 , new Student(2 , "Sakshi" , "Photography"));
                put(3 , new Student(3 , "Vihaan" , "Dangal"));
            }
        };

    }

    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    public Student getStudent(int id){
        return this.students.get(id);
    }

    public void updateStudent(Student student){

        this.students.put(student.getId() ,student);
    }

    public void removeStudent(Student student){
        this.students.remove(student.getId());
    }

}
