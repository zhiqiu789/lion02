package com.lion.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lion.domain.Student;
import com.lion.mapper.StudentMapper;
import com.lion.serviceInterface.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @Author Jipengchao
 * @CreatedTime: 2018/9/29 20:49
 */
@Service(interfaceClass = StudentServiceInterface.class)
public class StudentServiceImpl implements StudentServiceInterface,Serializable {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public int addStudent(Student student) {
        int insert = studentMapper.insert(student);
        return insert;
    }
}
