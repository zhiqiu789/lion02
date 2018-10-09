package com.lion.mapper;

import com.lion.domain.Student;
import org.apache.ibatis.annotations.Insert;

/**
 * @Author Jipengchao
 * @CreatedTime: 2018/9/29 20:42
 */

public interface StudentMapper {
    @Insert("insert into student (name)values (#{name})")
    int insert(Student student);
}
