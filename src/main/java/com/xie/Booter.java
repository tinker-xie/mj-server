package com.xie;

import com.xie.config.MyBatisConfig;
import com.xie.mina.config.MinaSocketConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

/**
 * Created by xie on 16/11/23.
 */
@ComponentScan
@EnableAutoConfiguration
//@EnableWebSocket
public class Booter implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Booter.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MyBatisConfig.class);
        ctx.refresh();
        LOGGER.info("========                      mj-server 启动 开始                     ========");
        SpringApplication.run(Booter.class, args);
        LOGGER.info("========                      mj-server 启动 完成                     ========");
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("========                      mj-server 启动中 ...                    ========");
    }
}
