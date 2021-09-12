package com.example.week05springbootautoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "student")
@Data
public class StudentProperties {

    private Stu student123;
    private Stu student100;

    @Data
    public static class Stu {
        private int id;
        private String name;
    }
}
