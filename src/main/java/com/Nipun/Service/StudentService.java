package com.Nipun.Service;

import com.Nipun.Dao.StudentDao;
import com.Nipun.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Nipun on 12/24/16.
 */
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Collection<Student> getAllStudents(){
        return this.studentDao.getAllStudents();
    }

    public Student getStudent(int id){
        return this.studentDao.getStudent(id);
    }

    //UPDATE STUDENTS
    public void updateStudent(Student student){

        this.studentDao.updateStudent(student);
    }
    //REMOVE STUDENT
    public void removeStudent(Student student){
        this.studentDao.removeStudent(student);
    }

    //ADD STUDENTS
    public void addStudent(Student student){
        if(this.studentDao.getStudent(student.getId()) == null){
            this.studentDao.addStudent(student);
        }
    }


}
