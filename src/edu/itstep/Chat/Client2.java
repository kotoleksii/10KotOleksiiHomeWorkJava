package edu.itstep.Chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 56789)) {

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("connect");

            Scanner scanner = new Scanner(System.in);
            String message;
            ClientThread clientThread = new ClientThread(socket);
            clientThread.start();

            do {
                message = scanner.nextLine();
                printWriter.println(message);
//                printWriter.flush();
            } while (!message.equals("exit"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
