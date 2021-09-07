package com.example.week05_spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({User.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class UserConfig {
}
