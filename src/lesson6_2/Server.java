package lesson6_2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        Socket socket;
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                while (true) {
                    String messageClient = null;
                    try {
                        messageClient = in.readUTF();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (messageClient != null && messageClient.equalsIgnoreCase("/end")) {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    System.out.println("UserClient: " + messageClient);
                }
                System.out.println("Stop waiting clients requests");
                System.out.flush();
            }).start();

            new Thread(() -> {
                while (!socket.isClosed()) {
                    try {
                        if (!reader.ready()) {
                            continue;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    String messageFromServer = null;
                    try {
                        messageFromServer = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        out.writeUTF("User 2: " + messageFromServer + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        out.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Stop reading from console");
                System.out.flush();
            }).start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
