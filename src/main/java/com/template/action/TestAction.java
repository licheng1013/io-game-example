package com.template.action;

import com.iohao.game.action.skeleton.annotation.ActionController;
import com.iohao.game.action.skeleton.annotation.ActionMethod;
import com.iohao.game.action.skeleton.core.exception.MsgException;
import com.template.dto.HelloReq;
import com.template.dto.UserReq;
import com.template.router.Router;
import com.template.router.UserRouter;

@ActionController(Router.USER)
public class TestAction {


    /**
     * 示例 here 方法
     */
    @ActionMethod(2)
    public HelloReq here(HelloReq helloReq) {
        HelloReq newHelloReq = new HelloReq();
        newHelloReq.setName(helloReq.getName() + ", I'm here ");
        return newHelloReq;
    }

    


    /**
     * 示例 异常机制演示
     */
    @ActionMethod(UserRouter.LOGIN)
    public UserReq jackson(UserReq helloReq) {
        String jacksonName = "jackson";
        if (!jacksonName.equals(helloReq.getName())) {
            throw new MsgException(100, "异常机制测试，name 必须是 jackson !");
        }
        helloReq.setName(helloReq.getName() + ", hello, jackson !");
        return helloReq;
    }

}
