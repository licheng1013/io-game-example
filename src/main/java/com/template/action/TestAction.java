package com.template.action;

import com.iohao.game.action.skeleton.annotation.ActionController;
import com.iohao.game.action.skeleton.annotation.ActionMethod;
import com.iohao.game.action.skeleton.core.exception.MsgException;
import com.template.dto.HelloReq;

@ActionController(1)
public class TestAction {
    /**
     * 示例 here 方法
     */
    @ActionMethod(0)
    public HelloReq here(HelloReq helloReq) {
        HelloReq newHelloReq = new HelloReq();
        newHelloReq.setName(helloReq.getName() + ", I'm here ");
        return newHelloReq;
    }

    /**
     * 示例 异常机制演示
     */
    @ActionMethod(1)
    public HelloReq jackson(HelloReq helloReq) {
        String jacksonName = "jackson";
        if (!jacksonName.equals(helloReq.getName())) {
            throw new MsgException(100, "异常机制测试，name 必须是 jackson !");
        }
        helloReq.setName(helloReq.getName() + ", hello, jackson !");
        return helloReq;
    }
}