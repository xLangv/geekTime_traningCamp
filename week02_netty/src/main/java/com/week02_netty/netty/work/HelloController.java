package com.week02_netty.netty.work;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController Spring4之后新加入的注解，原来返回json需要@ResponseBody和@Controller配合。
 * 即@RestController是@ResponseBody和@Controller的组合注解。
 * @Controller 如果直接使用@Controller这个注解，当运行该SpringBoot项目后，在浏览器中输入：local:8080/hello,会得到如下错误提示：
 * 出现这种情况的原因在于：没有使用模版。即@Controller 用来响应页面，@Controller必须配合模版来使用。spring-boot 支持多种模版引擎包括：
 * 1，FreeMarker
 */
@RestController
public class HelloController {
    @GetMapping(value = "/")
    public String sayHello() {
        return "Hello";
    }
}
