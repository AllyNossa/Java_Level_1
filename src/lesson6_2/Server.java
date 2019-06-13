package lesson6_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Socket socket;
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String messageClient = in.readUTF();
                if (messageClient.equalsIgnoreCase("/end")) {
                    break;
                }
                System.out.println("UserClient: " + messageClient);

                String messageFromServer = scanner.next();
                try {
                    out.writeUTF("User 2: " + messageFromServer + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
