package com.xie.mina.core;

import com.alibaba.fastjson.JSON;
import com.xie.model.bean.MinaMessage;
import com.xie.model.bean.User;
import com.xie.model.response.BaseResponse;
import com.xie.service.UserService;
import com.xie.service.core.PAI;
import com.xie.service.core.Room;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
@Component
public class ReceiveMinaHandle extends IoHandlerAdapter {
    public final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    MinaMessage.Message.Builder builder = MinaMessage.Message.newBuilder();

    public static ConcurrentHashMap<Long, IoSession> sessionsConcurrentHashMap = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Integer, Room> userRoom = new ConcurrentHashMap<>();

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

        if (msg.getType().equals(MinaMessage.Type.REQUEST)) {
            builder.clear();
            switch (msg.getId()) {
                case NetManager.MSG_USER_REGISTER:
                    User user_register = JSON.parseObject(msg.getData(), User.class);
                    User user1 = userService.getByName(user_register.getName());
                    if (user1 != null) {
                        builder.setType(MinaMessage.Type.RESPONSE);
                        builder.setId(NetManager.MSG_USER_REGISTER);
                        builder.setData(JSON.toJSONString(BaseResponse.fail("the user exist!")));
                        session.write(builder.build());
                    } else {
                        if (userService.insert(user_register) > 0) {

                            builder.setType(MinaMessage.Type.RESPONSE);
                            builder.setId(NetManager.MSG_USER_REGISTER);
                            builder.setData(JSON.toJSONString(BaseResponse.fail()));
                            session.write(builder.build());
                        } else {

                            builder.setType(MinaMessage.Type.RESPONSE);
                            builder.setId(NetManager.MSG_USER_REGISTER);
                            builder.setData(JSON.toJSONString(BaseResponse.fail("insert failed")));
                            session.write(builder.build());
                        }
                    }
                    break;
                case NetManager.MSG_USER_LOGIN:
                    User user = JSON.parseObject(msg.getData(), User.class);
                    User user2 = userService.getByName(user.getName());
                    if (user2 != null && user2.getPassword().equals(user.getPassword())) {

                        builder.setType(MinaMessage.Type.RESPONSE);
                        builder.setId(NetManager.MSG_USER_LOGIN);
                        builder.setData(JSON.toJSONString(BaseResponse.ok()));
                        session.write(builder.build());
                    } else {

                        builder.setType(MinaMessage.Type.RESPONSE);
                        builder.setId(NetManager.MSG_USER_LOGIN);
                        builder.setData(JSON.toJSONString(BaseResponse.fail()));
                        session.write(builder.build());
                    }
                    break;
                case NetManager.CMD_BEGIN_CARDS:

                    builder.setType(MinaMessage.Type.COMMAND);
                    builder.setId(NetManager.CMD_BEGIN_CARDS);
                    List<Integer> list=new ArrayList<>();
                    Integer[] data = {PAI.B1.getCode(), PAI.B2.getCode(), PAI.B3.getCode(),
                            PAI.W1.getCode(), PAI.W1.getCode(), PAI.W1.getCode(),
                            PAI.T5.getCode(), PAI.T6.getCode(), PAI.T7.getCode(), PAI.ZH.getCode()};
                    builder.setData(JSON.toJSONString(BaseResponse.ok(JSON.toJSONString(data))));
                    session.write(builder.build());
                    break;
                case NetManager.CMD_CREATE_ROOM:
                    User user_room = JSON.parseObject(msg.getData(), User.class);
                    Room room = new Room(2, 2);
                    userRoom.put(user_room.getId(), room);
                    builder.setType(MinaMessage.Type.COMMAND);
                    builder.setId(NetManager.CMD_CREATE_ROOM);
                    builder.setData(JSON.toJSONString(BaseResponse.ok(JSON.toJSONString(room.getGameFrame(0)))));
                    session.write(builder.build());
                    break;
            }
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
