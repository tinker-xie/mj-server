package test;

import com.xie.mina.coder.MinaProtobufDecoder;
import com.xie.mina.coder.MinaProtobufEncoder;
import com.xie.model.bean.StudentMsg;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class ApplicationTests {

    @Test
    public void minaTest() {
        NioSocketConnector connector = new NioSocketConnector();
        connector.getFilterChain().addLast("logger", new LoggingFilter());
        connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new MinaProtobufEncoder(), new MinaProtobufDecoder())); //设置编码过滤器
        connector.setHandler(new HandlerOne());//设置事件处理器
        ConnectFuture cf = connector.connect(new InetSocketAddress("127.0.0.1", 9001));//建立连接
        cf.awaitUninterruptibly();//等待连接创建完成
        IoSession ioSession=cf.getSession();

        StudentMsg.Student.Builder builder = StudentMsg.Student.newBuilder();
        builder.setId(8);
        builder.setUsername("客户端");
        builder.setAction(StudentMsg.Student.Action.LOGIN);
        builder.setPassword("65536");
        StudentMsg.Student student2 = builder.build();
        ioSession.write(student2);

        ioSession.closeOnFlush();
        ioSession.getCloseFuture().awaitUninterruptibly();//等待连接断开
        connector.dispose();
    }

}