package com.xie.mina.core;

import com.xie.model.bean.MinaMessage;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author xie
 * @Date 17/2/14 下午3:25.
 */
public class MyKeepAliveMessageFactory implements KeepAliveMessageFactory {
    private final Logger LOG = LoggerFactory.getLogger(MyKeepAliveMessageFactory.class);

    /**
     * 心跳包内容
     */
    private static final int HEARTBEATREQUEST = 1024;
    private static final int HEARTBEATRESPONSE = 1025;

    public Object getRequest(IoSession session) {
        MinaMessage.Message.Builder builder = MinaMessage.Message.newBuilder();
        builder.setType(MinaMessage.Type.HEART);
        builder.setId(HEARTBEATREQUEST);
        return builder.build();
    }

    public Object getResponse(IoSession session, Object request) {

        MinaMessage.Message.Builder builder = MinaMessage.Message.newBuilder();
        builder.setType(MinaMessage.Type.HEART);
        builder.setId(HEARTBEATRESPONSE);
        return builder.build();
    }

    public boolean isRequest(IoSession session, Object message) {
        MinaMessage.Message msg = (MinaMessage.Message) message;
        if (msg.getId() == HEARTBEATREQUEST)
            return true;
        return false;
    }

    public boolean isResponse(IoSession session, Object message) {
        MinaMessage.Message msg = (MinaMessage.Message) message;
        if (msg.getId() == HEARTBEATRESPONSE)
            return true;
        return false;
    }
}
