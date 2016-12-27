package com.Nipun.Controller;

import com.Nipun.Entity.Student;
import com.Nipun.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 * Created by Nipun on 12/24/16.
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET )
    public Collection<Student> getAllStudents(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable("id") int id ){
        return studentService.getStudent(id);
    }
    @RequestMapping(method = RequestMethod.PUT , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity removeStudent(@RequestBody Student student) {
        studentService.removeStudent(student);
        return new ResponseEntity(HttpStatus.OK);
    }




}
