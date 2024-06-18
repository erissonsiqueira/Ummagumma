package com.springboot.ibmcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    private final TcpServer tcpServer;

    @Autowired
    public IndexController(TcpServer tcpServer) {
        this.tcpServer = tcpServer;
    }

    @RequestMapping("/message")
    public String index() {
        return tcpServer.getReceivedMessage();
    }
}

