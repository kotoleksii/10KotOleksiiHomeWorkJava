package edu.itstep.Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientListener extends Thread {
    private Socket socket;
    //    private Scanner scanner;
    private ArrayList<ClientListener> threadList;
    private PrintWriter output;
    private int port;

    public ClientListener(Socket socket, ArrayList<ClientListener> threadList, int port) {
        this.socket = socket;
        this.threadList = threadList;
        this.port = port;
//        try {
//            scanner = new Scanner(socket.getInputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            
            while (true) {
//                System.out.println(scanner.nextLine());
                String outputString = input.readLine();
                if (outputString.equals("exit")) {
                    break;
                }
                sendToAllClients(outputString);
                System.out.println("Server received from the " + this.port + ": " + outputString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendToAllClients(String outputString) {
        for (ClientListener cL : threadList)
            cL.output.println(port + " say: " + outputString);
    }
}
