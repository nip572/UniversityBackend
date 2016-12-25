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

}
