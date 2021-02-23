package Send_File_Client_Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static DataInputStream dataInputStream = null;

    public static void main(String[] args) throws IOException {

        System.out.println("Waiting For Client");
        ServerSocket server_socket = new ServerSocket(9000);
        Socket client_socket = server_socket.accept();
        System.out.println("Client Connected");

        dataInputStream = new DataInputStream(client_socket.getInputStream());


        int bytes = 0;
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\client_file.txt");

        long size = dataInputStream.readLong();
        byte[] buffer = new byte[(int) size];

        while ((size > 0 && size < 250*1024*1024)) {
            bytes = dataInputStream.read(buffer, 0, buffer.length);
            fileOutputStream.write(buffer,0,bytes);
            size -= bytes;
        }
        fileOutputStream.close();
        dataInputStream.close();
        client_socket.close();
    }
}
