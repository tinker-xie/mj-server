package com.xie.mina.config;

import com.xie.mina.coder.MinaProtobufDecoder;
import com.xie.mina.coder.MinaProtobufEncoder;
import com.xie.mina.core.MyKeepAliveMessageFactory;
import com.xie.mina.core.ReceiveMinaHandle;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.filter.logging.MdcInjectionFilter;
import org.apache.mina.integration.beans.InetSocketAddressEditor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyEditor;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * mina配置
 * Created by Scott on 16/8/24.
 */
@Configuration
@ConfigurationProperties(prefix = "mina")
public class MinaSocketConfig {

    /**
     * 监听端口号
     */
    private int port;

    private static Map<Class<?>, Class<? extends PropertyEditor>> customEditors = new HashMap<>();

    @Bean
    public static CustomEditorConfigurer customEditorConfigurer() {
        customEditors.put(SocketAddress.class, InetSocketAddressEditor.class);
        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
        customEditorConfigurer.setCustomEditors(customEditors);
        return customEditorConfigurer;
    }


    @Bean(initMethod = "bind", destroyMethod = "unbind")
    public NioSocketAcceptor nioSocketAcceptor(ReceiveMinaHandle receiveMinaHandle, DefaultIoFilterChainBuilder defaultIoFilterChainBuilder) {

        NioSocketAcceptor nioSocketAcceptor = new NioSocketAcceptor();
        nioSocketAcceptor.setDefaultLocalAddress(new InetSocketAddress(port));
        nioSocketAcceptor.setReuseAddress(true);
        nioSocketAcceptor.setFilterChainBuilder(defaultIoFilterChainBuilder);
        nioSocketAcceptor.setHandler(receiveMinaHandle);
        return nioSocketAcceptor;
    }


    @Bean
    public DefaultIoFilterChainBuilder defaultIoFilterChainBuilder(ExecutorFilter executorFilter, MdcInjectionFilter mdcInjectionFilter, ProtocolCodecFilter protocolCodecFilter, LoggingFilter loggingFilter) {
        DefaultIoFilterChainBuilder defaultIoFilterChainBuilder = new DefaultIoFilterChainBuilder();
        Map<String, IoFilter> filters = new LinkedHashMap<>();
//        filters.put("executor", executorFilter);
//        filters.put("mdcInjectionFilter", mdcInjectionFilter);
        filters.put("codecFilter", new ProtocolCodecFilter(new MinaProtobufEncoder(), new MinaProtobufDecoder()));
        filters.put("keepAliveFilter", new KeepAliveFilter(new MyKeepAliveMessageFactory()));
//        filters.put("loggingFilter", loggingFilter);
        defaultIoFilterChainBuilder.setFilters(filters);
        return defaultIoFilterChainBuilder;
    }

    @Bean
    public ExecutorFilter executorFilter() {
        return new ExecutorFilter();
    }

    @Bean
    public MdcInjectionFilter mdcInjectionFilter() {
        return new MdcInjectionFilter(MdcInjectionFilter.MdcKey.remoteAddress);
    }

    @Bean
    public ProtocolCodecFilter protocolCodecFilter(MinaCodeFactory minaCodeFactory) {
        return new ProtocolCodecFilter(minaCodeFactory);
    }

    @Bean
    public LoggingFilter loggingFilter() {
        return new LoggingFilter();
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
