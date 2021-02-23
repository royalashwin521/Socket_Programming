package Send_File_Client_Server;

import java.io.*;
import java.net.Socket;

public class Client {
    private static DataOutputStream dataOutputStream = null;

    public static void main(String[] args) throws IOException {

        Socket client_socket = new Socket("localhost", 9000);

        dataOutputStream = new DataOutputStream(client_socket.getOutputStream());

        BufferedReader user_input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the File path");
        String file_path = user_input.readLine();

        byte[] buffer = new byte[file_path.length()];
        FileInputStream fr = new FileInputStream(file_path);
        int bytes = fr.read(buffer,0,buffer.length);
        dataOutputStream.write(buffer,0,bytes);

        fr.close();
        dataOutputStream.close();
        client_socket.close();

    }
}