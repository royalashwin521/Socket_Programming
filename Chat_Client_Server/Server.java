package Chat_Client_Server;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Waiting For Client");
        ServerSocket server_socket = new ServerSocket(9000);
        Socket soc = server_socket.accept();
        System.out.println("Client Connected");

        DataInputStream din = new DataInputStream(soc.getInputStream());
        DataOutputStream dout = new DataOutputStream(soc.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String client_msg = "";
        String server_msg = "";

        while(!client_msg.equals("Boom")){
            client_msg = din.readUTF();
            System.out.println(client_msg);
            server_msg = br.readLine();
            dout.writeUTF(server_msg);
            dout.flush();
        }
        soc.close();
    }
}
