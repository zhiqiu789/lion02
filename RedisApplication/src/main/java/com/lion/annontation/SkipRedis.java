package com.lion.annontation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Jipengchao
 * @CreatedTime: 2018/9/29 9:02
 *
 * 声明该注解的作用是忽略redis,凡是被此注解修饰的属性,都不会被放到redis中
 * 注意:Object对象中不是所有的属性都要放进redis中,不安全; 例如:密码  工资等等;
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SkipRedis {
}
