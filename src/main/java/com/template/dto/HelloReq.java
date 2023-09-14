package com.template.dto;

import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import lombok.Data;

import java.io.Serializable;

/** 请求 */
@ProtobufClass
@Data
public class HelloReq  {
    
    /** 注释 */
    private String name;
}