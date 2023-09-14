package com.template.server;

import com.iohao.game.action.skeleton.core.BarSkeleton;
import com.iohao.game.action.skeleton.core.BarSkeletonBuilderParamConfig;
import com.iohao.game.action.skeleton.core.flow.interal.DebugInOut;
import com.iohao.game.bolt.broker.client.AbstractBrokerClientStartup;
import com.iohao.game.bolt.broker.core.client.BrokerAddress;
import com.iohao.game.bolt.broker.core.client.BrokerClient;
import com.iohao.game.bolt.broker.core.client.BrokerClientBuilder;
import com.iohao.game.common.kit.NetworkKit;
import com.template.action.TestAction;

public class MyLogicServer extends AbstractBrokerClientStartup {
    @Override
    public BarSkeleton createBarSkeleton() {
        // 业务框架构建器 配置
        var config = new BarSkeletonBuilderParamConfig() .scanActionPackage(TestAction.class);
        // 业务框架构建器
        var builder = config.createBuilder();
        // 添加控制台输出插件
        builder.addInOut(new DebugInOut());
        return builder.build();
    }

    @Override
    public BrokerClientBuilder createBrokerClientBuilder() {
        return BrokerClient.newBuilder().appName("demo游戏逻辑服");
    }

//    @Override
//    public BrokerAddress createBrokerAddress() {
//        // 类似 127.0.0.1 ，但这里是本机的 ip
//        String localIp = NetworkKit.LOCAL_IP;
//        // broker （游戏网关）默认端口
//        int brokerPort = 10200;
//        return new BrokerAddress(localIp, brokerPort);
//    }
}