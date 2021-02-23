package Arithmatic_Operation_Client_Server;

import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) throws IOException {

        Socket client_socket = new Socket("localhost", 9000);

        BufferedReader user_input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the string in operation number1 number2 format");
        String operation = user_input.readLine();

        PrintWriter out = new PrintWriter(client_socket.getOutputStream(), true);
        out.println(operation);

        BufferedReader in = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
        System.out.println(in.readLine());

    }
}