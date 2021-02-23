package Chat_Client_Server;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket client_socket = new Socket("localhost", 9000);

        DataInputStream din = new DataInputStream(client_socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(client_socket.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String my_msg_for_server = "";
        String server_msg = "";

        while (!server_msg.equals("Boom")) {
            my_msg_for_server = br.readLine();
            dout.writeUTF(my_msg_for_server);
            server_msg = din.readUTF();
            System.out.println(server_msg);
        }
        client_socket.close();
    }
}