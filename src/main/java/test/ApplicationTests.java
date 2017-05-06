package test;

import com.xie.mina.coder.MinaProtobufDecoder;
import com.xie.mina.coder.MinaProtobufEncoder;
import com.xie.model.bean.MinaMessage;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.junit.Test;

import java.net.InetSocketAddress;
import java.util.Scanner;

public class ApplicationTests {

    @Test
    public void minaTest() {
        NioSocketConnector connector = new NioSocketConnector();
//        connector.getFilterChain().addLast("logger", new LoggingFilter());
        connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new MinaProtobufEncoder(), new MinaProtobufDecoder())); //设置编码过滤器
        connector.setHandler(new HandlerOne());//设置事件处理器
        ConnectFuture cf = connector.connect(new InetSocketAddress("127.0.0.1", 9001));//建立连接
        cf.awaitUninterruptibly();//等待连接创建完成
        IoSession ioSession=cf.getSession();

        MinaMessage.Message.Builder builder = MinaMessage.Message.newBuilder();
        builder.setId(8);
        builder.setData("kehuduan");
        MinaMessage.Message student2 = builder.build();
        ioSession.write(student2);


        Scanner sc = new Scanner(System.in);
        System.out.println("输入第一个boolean值(true/false):");
        String str=sc.nextLine();
        ioSession.write(str);

        ioSession.closeOnFlush();
        ioSession.getCloseFuture().awaitUninterruptibly();//等待连接断开
        connector.dispose();
    }

    @Test
    public void test() {
        boolean result = "12020001/120720495/12020003/16111819182496/150714172109/16040119563699/150714173317/1604012012263".contains("12020001/120720495/12020003/16111819182496/150714172109");
        if (result)
            System.out.println("true");
    }

}