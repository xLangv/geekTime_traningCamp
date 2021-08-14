package com.jvm.week01_jvm.work;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Description: 自定义类加载器
 * @author: lang.xia
 * @date 2021/8/5 11:55
 */
@Slf4j
public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            Class<?> hello = new HelloClassLoader().loadClass("Hello");
            for (Method m : hello.getDeclaredMethods()) {
                System.out.println(hello.getSimpleName() + "." + m.getName());
            }
            Object instance = hello.newInstance();
            Method method = hello.getMethod("hello");
            method.invoke(instance);
        } catch (ClassNotFoundException e) {
            log.error("错误信息：", e);
            e.printStackTrace();
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) {
        Class<?> aClass = null;
        try {
            File file = ResourceUtils.getFile("classpath:Hello.xlass");
            byte[] bytes = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (255 - bytes[i]);
            }
            Files.write(Paths.get("D:\\traningCamp\\Hello.class"), bytes);
            aClass = defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aClass;
    }
}
