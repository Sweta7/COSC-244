import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;


public class program2 {
  
    private PrintWriter output; // used to write data to a socket.
    private BufferedReader input;// used to read data from a socket.
    Date date = new Date();
  
    // constructor
    public program2(Socket socket) throws Exception {
        output = new PrintWriter(socket.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
  
    public void startReceiving() throws Exception {
        String line;
        while ((line = input.readLine()) != null) {
            System.out.println(line);
            Scanner scan = new Scanner(System.in);
            System.out.println("your turn");
            if(scan.hasNextLine()){
               
                output.println(scan.nextLine());
            }
        }
    }
    // .equals("")

    public void startSending()throws Exception {
        Scanner stdin = new Scanner(System.in);
        String line1;
        System.err.println("Please enter data here");
        while (stdin.hasNextLine()) {
            output.println(stdin.nextLine());
            line1=input.readLine();
            if(line1 !=null){
                System.out.println(line1);
            }
            System.out.println("Enter msg");
        }
        
    }
  
  
  
  
    public static void main(String[] args) {
        Socket socket = null;
        try {
            int port = Integer.parseInt(args[0]);
            if (args.length > 1) {
                socket = new Socket(args[1], port);
                System.err.println("Connected to " + args[1] + " on port " + port);
                program2 example = new program2(socket);
                example.startSending();
            } else {
                ServerSocket serverSocket = new ServerSocket(port);
                System.err.println("Waiting for someone to connect");
                socket = serverSocket.accept();
                System.err.println("Accepted connection on port " + port);
                program2 example = new program2(socket);
                example.startReceiving();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("\nUsage: java TCPExample <port> [host]");
        }
    }
}
