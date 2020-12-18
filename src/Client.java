import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    static final int port = 1200;

    public static void main(String[] args) throws Exception {

        System.out.println("connection request");

        //Create a client socket
        Socket socket = new Socket("127.0.0.1", port);
        System.out.println("Connection established");

        // create in / out
        BufferedReader inClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outClient = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        System.out.println("Donner un entier positif");
        String  nbr ;
        Scanner sc =new Scanner(System.in);
        nbr=sc.nextLine();

        int nb=Integer.parseInt(nbr);
        while(nb<0){
            System.out.println("Veuillez saisir un entier positif svp5");
            nbr=sc.nextLine();

            nb=Integer.parseInt(nbr);
        }
        outClient.println(nbr); // send msg

        //close in / out
        inClient.close();
        outClient.close();

        // close client socket
        socket.close();
    }
}
