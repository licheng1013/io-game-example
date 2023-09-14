package com.template;

import com.iohao.game.action.skeleton.core.IoGameGlobalSetting;
import com.iohao.game.action.skeleton.core.codec.JsonDataCodec;
import com.iohao.game.bolt.broker.core.client.BrokerAddress;
import com.iohao.game.bolt.broker.core.common.IoGameGlobalConfig;
import com.iohao.game.external.core.ExternalServer;
import com.iohao.game.external.core.config.ExternalJoinEnum;
import com.iohao.game.external.core.netty.DefaultExternalServer;
import com.template.server.MyLogicServer;
import com.iohao.game.external.core.netty.simple.NettySimpleHelper;

import java.util.List;

/**
 * @author lc
 * @since 2023/1/12
 */
public class GameApp {
    public static void main(String[] args) {
        IoGameGlobalSetting.setDataCodec(new JsonDataCodec());

        // 游戏对外服端口
        int port = 10100;
        // 逻辑服
        var logicServer = new MyLogicServer();
        // 启动 对外服、网关服、逻辑服; 并生成游戏业务文档
        NettySimpleHelper.run(port, List.of(logicServer));
    }
}
