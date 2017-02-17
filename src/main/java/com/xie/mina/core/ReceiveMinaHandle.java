package com.xie.mina.core;

import com.alibaba.fastjson.JSON;
import com.xie.model.bean.MinaMessage;
import com.xie.model.bean.User;
import com.xie.model.response.BaseResponse;
import com.xie.service.UserService;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
@Component
public class ReceiveMinaHandle extends IoHandlerAdapter {
    public final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    public static ConcurrentHashMap<Long, IoSession> sessionsConcurrentHashMap = new ConcurrentHashMap<>();

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        session.closeOnFlush();
        LOGGER.warn("session occured exception, so close it." + cause.getMessage());
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        super.sessionCreated(session);
        LOGGER.info("remote client [" + session.getRemoteAddress().toString() + "] connected.");
        Long time = System.currentTimeMillis();
        sessionsConcurrentHashMap.put(time, session);
        String remoteAddress = ((InetSocketAddress) session.getRemoteAddress()).getAddress().getHostAddress();
        session.setAttribute("ip", remoteAddress);
        session.setAttribute("id", time);
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
    }

    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception {
        // TODO Auto-generated method stub

        MinaMessage.Message msg = (MinaMessage.Message) message;
        switch (msg.getId()) {
            case NetManager.MSG_USER_LOGIN:
                User user = JSON.parseObject(msg.getData(), User.class);
                User user1 = userService.getByName(user.getName());
                if (user1 != null && user1.getPassword().equals(user.getPassword())) {
                    MinaMessage.Message.Builder builder = MinaMessage.Message.newBuilder();
                    builder.setType(MinaMessage.Type.RESPONSE);
                    builder.setId(msg.getId());
                    builder.setData(JSON.toJSONString(BaseResponse.ok()));
                    session.write(builder.build());
                } else {
                    MinaMessage.Message.Builder builder = MinaMessage.Message.newBuilder();
                    builder.setType(MinaMessage.Type.RESPONSE);
                    builder.setId(msg.getId());
                    builder.setData(JSON.toJSONString(BaseResponse.fail()));
                    session.write(builder.build());
                }
                break;
        }


    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        // TODO Auto-generated method stub
        super.sessionClosed(session);
        LOGGER.info("remote client [" + session.getRemoteAddress().toString() + "] disconnected.");
        session.closeOnFlush();
        sessionsConcurrentHashMap.remove(session.getAttribute("id"));
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status)
            throws Exception {
        // TODO Auto-generated method stub
        super.sessionIdle(session, status);
    }
}
