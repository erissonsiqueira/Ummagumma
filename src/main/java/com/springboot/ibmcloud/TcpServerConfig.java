package com.springboot.ibmcloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TcpServerConfig {

    @Bean
    public TcpServer tcpServer() {
        TcpServer tcpServer = new TcpServer(5432);
        new Thread(tcpServer).start();
        return tcpServer;
    }
}

