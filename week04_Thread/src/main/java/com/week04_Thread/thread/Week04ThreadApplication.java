package com.week04_Thread.thread;

import com.example.week05_spring.teacherDemo.aop.ISchool;
import com.example.week05_spring.teacherDemo.spring01.Student;
import com.example.week05_spring.teacherDemo.spring02.Klass;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = {"com.*","com.example.week05_spring.teacherDemo"})
@EnableAspectJAutoProxy
public class Week04ThreadApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week04ThreadApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {

//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Student student123 = context.getBean(Student.class);
        ApplicationContext context = ctx;
        Student student123 = (Student) context.getBean("student123");
        System.out.println(student123.toString());

        student123.print();

        Student student100 = (Student) context.getBean("student100");
        System.out.println(student100.toString());

        student100.print();

        Klass class1 = context.getBean(Klass.class);
        System.out.println(class1);
        System.out.println("Klass对象AOP代理后的实际类型：" + class1.getClass());
        System.out.println("Klass对象AOP代理后的实际类型是否是Klass子类：" + (class1 instanceof Klass));

        ISchool school = context.getBean(ISchool.class);
        System.out.println(school);
        System.out.println("ISchool接口的对象AOP代理后的实际类型：" + school.getClass());

        ISchool school1 = context.getBean(ISchool.class);
        System.out.println(school1);
        System.out.println("ISchool接口的对象AOP代理后的实际类型：" + school1.getClass());

        school1.ding();

        class1.dong();

//        System.out.println("   context.getBeanDefinitionNames() ===>> "+ String.join(",", context.getBeanDefinitionNames()));
//
//        Student s101 = (Student) context.getBean("s101");
//        if (s101 != null) {
//            System.out.println(s101);
//        }
//        Student s102 = (Student) context.getBean("s102");
//        if (s102 != null) {
//            System.out.println(s102);
//        }


        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }
}
