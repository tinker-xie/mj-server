package com.xie.mina.core;

import com.xie.model.bean.StudentMsg;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class ReceiveMinaHandle extends IoHandlerAdapter {
    public final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
        StudentMsg.Student.Builder builder = StudentMsg.Student.newBuilder();
        builder.setId(9);
        builder.setUsername("服务器");
        builder.setAction(StudentMsg.Student.Action.LOGOUT);
        builder.setPassword("76777");
        StudentMsg.Student student2 = builder.build();
        session.write(student2);
    }

    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception {
        // TODO Auto-generated method stub

        StudentMsg.Student student = (StudentMsg.Student) message;
        System.out.println("ID:" + student.getId());
        System.out.println("Username:" + student.getUsername());
        System.out.println("Password:" + student.getPassword());

        // 新建一个Student对象传到客户端
        StudentMsg.Student.Builder builder = StudentMsg.Student.newBuilder();
        builder.setId(9);
        builder.setUsername("服务器");
        builder.setAction(StudentMsg.Student.Action.LOGOUT);
        builder.setPassword("76777");
        StudentMsg.Student student2 = builder.build();
        session.write(student2);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        // TODO Auto-generated method stub
        super.sessionClosed(session);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status)
            throws Exception {
        // TODO Auto-generated method stub
        super.sessionIdle(session, status);
    }
}
