package com.template;

import com.iohao.game.simple.SimpleHelper;
import com.template.server.MyLogicServer;

import java.util.List;

/**
 * @author lc
 * @since 2023/1/12
 */
public class GameApp {
    public static void main(String[] args) {
        // 游戏对外服端口
        int port = 10100;
        // 逻辑服
        var logicServer = new MyLogicServer();
        // 启动 对外服、网关服、逻辑服; 并生成游戏业务文档
        SimpleHelper.run(port, List.of(logicServer));
    }
}
