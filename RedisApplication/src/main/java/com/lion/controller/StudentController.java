package com.lion.controller;


import com.lion.domain.Student;
import com.lion.serviceInterface.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Jipengchao
 * @CreatedTime: 2018/9/29 22:11
 */
@RestController
public class StudentController {
    @Autowired
    private StudentServiceInterface studentServiceInterface;
    @RequestMapping("/add")
    public void add(Student student, HttpServletResponse response) throws IOException {
      response.getWriter().print(studentServiceInterface.addStudent(student));

    }
}
