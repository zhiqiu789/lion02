package com.lion.redisconfig;

import com.lion.serviceImpl.StudentServiceImpl;
import com.lion.serviceInterface.StudentServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Jipengchao
 * @CreatedTime: 2018/9/30 10:33
 */
@Configuration
public class StudentConfig {
    @Bean
    public StudentServiceInterface stu(){
        return new StudentServiceImpl();
    }
}
