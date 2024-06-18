//package com.springboot.ibmcloud;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class TcpServer {
//
//    private static String receivedMessage = "The song remais the same";
//
//    public static void main(String[] args) {
//    	int port = 5432;
//
//        try (ServerSocket serverSocket = new ServerSocket(port)) {
//            System.out.println("Servidor TCP iniciado na porta " + port);
//
//            while (true) {
//                try (Socket clientSocket = serverSocket.accept()) {
//                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                    PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);
//
//                    String message;
//                    while ((message = in.readLine()) != null) {
//                        System.out.println("Recebido: " + message);
//                        setReceivedMessage(message);
//                        out.println("Mensagem recebida: " + message);
//                    }
//                } catch (Exception e) {
//                    System.out.println("Erro na comunicação com o cliente: " + e.getMessage());
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Erro ao iniciar o servidor: " + e.getMessage());
//        }
//    }
//
//    public static synchronized String getReceivedMessage() {
//        return receivedMessage;
//    }
//
//    public static synchronized void setReceivedMessage(String message) {
//        receivedMessage = message;
//    }
//}



package com.springboot.ibmcloud;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer implements Runnable {

    private String receivedMessage = "The song remains the same";
    private final int port;

    public TcpServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor TCP iniciado na porta " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);

                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Recebido: " + message);
                        setReceivedMessage(message);
                        out.println("Mensagem recebida: " + message);
                    }
                } catch (Exception e) {
                    System.out.println("Erro na comunicação com o cliente: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao iniciar o servidor: " + e.getMessage());
        }
    }

    public synchronized String getReceivedMessage() {
        return receivedMessage;
    }

    public synchronized void setReceivedMessage(String message) {
        this.receivedMessage = message;
    }
}
