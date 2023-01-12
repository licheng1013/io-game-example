package com.template.dto;

import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import lombok.Data;

/** 请求 */
@ProtobufClass
@Data
public class HelloReq {
    private String name;
}