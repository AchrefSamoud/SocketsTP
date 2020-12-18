import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static final int port = 1200;
    static boolean isPrime(int a){

        boolean prime=true;

        for (int i=2;i<=a/2;i++){
            if(a%i==0){
                prime=false;
                break;
            }


        }
        return prime;
    }

    public static void main(String[] args) throws Exception {

        // Listen to a specific port

        ServerSocket s = new ServerSocket(port);
        System.out.println("Waiting for connection");
        Socket socClient = s.accept(); // Accept a client socket
        System.out.println("Connection established");

        // Initialize in / out

        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);

        // Read message sent by the client
        String str = inServer.readLine();
        int nb=Integer.parseInt(str);
        System.out.println("les nombres premiers inférieurs ou égales à "+nb);
        for(int i=2;i<nb;i++){
             if(isPrime(i))
                 System.out.println(i);

        }

        // Close in / out
        inServer.close();
        outServer.close();

        // Close client socket
        socClient.close();
    }
}

