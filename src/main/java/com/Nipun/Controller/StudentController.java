package com.Nipun.Controller;

import com.Nipun.Entity.Student;
import com.Nipun.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 * Created by Nipun on 12/24/16.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //GET ALL STUDENTS
    @RequestMapping(method = RequestMethod.GET )
    public Collection<Student> getAllStudents() {

        return studentService.getAllStudents();
    }

    //GET SINGLE STUDENT
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable("id") int id ){
        return studentService.getStudent(id);
    }


    @RequestMapping(method = RequestMethod.PUT )
    public ResponseEntity updateStudent(@RequestBody Student student , HttpServletResponse response){
        
        studentService.updateStudent(student);
        return new ResponseEntity(HttpStatus.OK);
    }

    //DELETE STUDENT
    @RequestMapping( value ="/delete" ,method = RequestMethod.POST )
    public void removeStudent(@RequestBody Student student ) {
        //response.addHeader("Access-Control-Allow-Origin", "*");
        studentService.removeStudent(student);
        //return new ResponseEntity(HttpStatus.OK);
    }

    //ADD STUDENT
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addStudent(@RequestBody Student student){
        //response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            studentService.addStudent(student);
            return  new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
           e.printStackTrace();
            return  new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }



}
