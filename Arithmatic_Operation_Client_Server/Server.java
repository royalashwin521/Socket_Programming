package Arithmatic_Operation_Client_Server;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Waiting For Client");
        ServerSocket server_socket = new ServerSocket(9000);
        Socket soc = server_socket.accept();
        System.out.println("Client Connected");

        BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));

        String input_line = br.readLine();
        String str[] = input_line.split(" ");
        String operation = str[0];
        int first_integer = Integer.parseInt(str[1]);
        int second_integer = Integer.parseInt(str[2]);
        System.out.println(operation+","+first_integer+","+second_integer);
        int result = -1;
        if (operation.equals("add")){
            result = first_integer + second_integer ;
        }
        else if (operation.equals("subtract")){
            result = first_integer + second_integer ;
        }
        else if (operation.equals("multiply")){
            result = first_integer + second_integer ;
        }
        else if (operation.equals("divide")){
            result = first_integer + second_integer ;
        }

        PrintWriter out = new PrintWriter(soc.getOutputStream(),true);
        out.println("Hi Client result: " + result);
    }
}
