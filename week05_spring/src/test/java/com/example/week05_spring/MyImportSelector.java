package com.example.week05_spring;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    /**
     * @param annotationMetadata：当前标注@Import注解类的所有注解信息
     * @return java.lang.String[]
     * @description 获取要导入到容器的组件全类名
     * @author ONESTAR
     * @date 2021/2/25 15:49
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.example.week05_spring.Person"};
    }
}
