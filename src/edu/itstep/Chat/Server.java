package edu.itstep.Chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) {
        ArrayList<ClientListener> threadList = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(56789)) {
            System.out.println("started " + serverSocket.getLocalPort());

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("connected " + socket.getPort());
                ClientListener clientListener = new ClientListener(socket, threadList, socket.getPort());
                threadList.add(clientListener);
                clientListener.start();
//                new Thread(new ClientListener(socket, threadList)).start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
