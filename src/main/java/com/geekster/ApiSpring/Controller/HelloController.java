package com.geekster.ApiSpring.Controller;

import com.geekster.ApiSpring.IStudentRepo;
import com.geekster.ApiSpring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    IStudentRepo sr;
    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping(value = "/get")
    public List<Student> student(){
        List<Student> all= (List<Student>) this.sr.findAll();
        return all;
    }

    @PostMapping(value = "/post")
    public void std(@RequestBody Student student){
        sr.save(student);
    }
}
