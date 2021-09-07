package com.example.week05springbootautoconfigure;

import com.example.week05_spring.teacherDemo.spring01.Student;
import com.example.week05_spring.teacherDemo.spring02.Klass;
import com.example.week05_spring.teacherDemo.spring02.School;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 直接复用了秦老师课上的类
 */
@Configuration
@ConditionalOnClass({Student.class, Klass.class, School.class})
public class Week05SpringBootAutoconfigure {

    @Bean
    @ConditionalOnMissingBean(name = {"student123"})
    @ConditionalOnProperty(name = "greeting.enabled", havingValue = "true", matchIfMissing = true)
    public Student student123() {
        return new Student(123,"kk123",null,null);
    }

    @Bean
    @ConditionalOnMissingBean(name = {"student100"})
    @ConditionalOnProperty(name = "greeting.enabled", havingValue = "true", matchIfMissing = true)
    public Student student100() {
        return new Student(100,"kk1100",null,null);
    }

    @Bean
    @ConditionalOnMissingBean(Klass.class)
    @ConditionalOnProperty(name = "greeting.enabled", havingValue = "true", matchIfMissing = true)
    public Klass klass() {
        Klass k = new Klass();
        List<Student> s = new ArrayList<Student>();
        s.add(student100());
        s.add(student123());
        k.setStudents(s);
        return k;
    }

    @Bean
    @ConditionalOnMissingBean(School.class)
    @ConditionalOnProperty(name = "greeting.enabled", havingValue = "true", matchIfMissing = true)
    public School school() {
        return new School();
    }
}
