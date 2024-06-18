//package com.springboot.ibmcloud;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class indexController {
//	
//	@RequestMapping("/")
//	public String index(){
//		//return "Is There Anybody Out There?";
//		return "Shine on you crazy diamond";
//	}
//
//}





//package com.springboot.ibmcloud;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class indexController {
//	
//	@RequestMapping("/")
//	public String index(){
//		return TcpServer.getReceivedMessage();
//	}
//
//}




//package com.springboot.ibmcloud;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class indexController {
//	
//	@RequestMapping("")
//	public String index(){
//		return TcpServer.getReceivedMessage();
//	}
//
//}




//package com.springboot.ibmcloud;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class indexController {
//	
//	@RequestMapping("")
//	public String index(){
//		return TcpServer.getReceivedMessage();
//	}
//
//}




//package com.springboot.ibmcloud;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class indexController {
//
//    private TcpServer tcpServer;
//
//    @Autowired
//    public indexController(TcpServer tcpServer) {
//        this.tcpServer = tcpServer;
//    }
//
//    @RequestMapping("/message")
//    public String index() {
//        return tcpServer.getReceivedMessage();
//    }
//}



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

