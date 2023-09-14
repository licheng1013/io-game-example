package com.template;


import com.iohao.game.action.skeleton.core.codec.JsonDataCodec;
import com.iohao.game.external.core.message.ExternalMessage;
import com.template.dto.HelloReq;
import okhttp3.*;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ClientApp {
    public static void main(String[] args) {
        var client = new OkHttpClient();
        var request = new Request.Builder()
                .url("ws://127.0.0.1:10100/websocket")
                .build();
        var webSocket = client.newWebSocket(request, new WebSocketListener(){
            @Override
            public void onClosed(@NotNull WebSocket webSocket, int code, @NotNull String reason) {
                System.out.println("关闭");
                System.exit(0);
            }
            @Override
            public void onClosing(@NotNull WebSocket webSocket, int code, @NotNull String reason) {
                System.out.println("关闭中");
                System.exit(0);
            }
            @Override
            public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable t, @Nullable Response response) {
                System.out.println("错误"+t.getMessage());
                System.exit(0);
            }
            @Override
            public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
                System.out.println("text -> "+text);
            }
            @Override
            public void onMessage(@NotNull WebSocket webSocket, @NotNull ByteString bytes) {
                System.out.println("bytes -> "+ bytes);
            }
            @Override
            public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
                JsonDataCodec jsonDataCodec = new JsonDataCodec();
                ExternalMessage message = new ExternalMessage();
                message.setCmdCode(1);
                message.setCmdMerge(1245186);
                HelloReq req = new HelloReq();
                req.setName("Hi");
                message.setData(jsonDataCodec.encode(req));
                webSocket.send(ByteString.of(jsonDataCodec.encode(message)));
            }
        });

    }
}
