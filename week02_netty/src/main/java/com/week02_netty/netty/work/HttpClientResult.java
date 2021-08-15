package com.week02_netty.netty.work;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HttpClientResult implements Serializable {

    private static final long serialVersionUID = 1;
    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应数据
     */
    private String content;
}