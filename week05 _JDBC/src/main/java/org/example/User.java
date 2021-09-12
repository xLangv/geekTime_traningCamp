package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Data ： 注在类上，提供类的get、set、equals、hashCode、canEqual、toString方法
 * @AllArgsConstructor ： 注在类上，提供类的全参构造
 * @NoArgsConstructor ： 注在类上，提供类的无参构造
 * @Setter ： 注在属性上，提供 set 方法
 * @Getter ： 注在属性上，提供 get 方法
 * @EqualsAndHashCode ： 注在类上，提供对应的 equals 和 hashCode 方法
 * @Log4j/@Slf4j ： 注在类上，提供对应的 Logger 对象，变量名为 log
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String sex;
    private Date birthday;
    private String address;
}
