package test;

import com.xie.model.bean.MinaMessage;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.util.List;

/**
 * @Author xie
 * @Date 17/1/24 上午8:35.
 */
public class HandlerOne extends IoHandlerAdapter {
    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception {
        // TODO Auto-generated method stub
        super.messageReceived(session, message);
        MinaMessage.Message student = (MinaMessage.Message) message;
        System.out.println("ID:" + student.getId());
        System.out.println("Username:" + student.getData());
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

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        super.messageSent(session, message);
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {

        super.sessionCreated(session);
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
    }

}