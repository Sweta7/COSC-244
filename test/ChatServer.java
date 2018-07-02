import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer{
    private static List<ClientHandler> clients = new LinkedList<ClientHandler>();
    public static void main(String [] args){
        try{
            new ChatServer().startServer(Integer.parseInt(args[0]));
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("\nUsage: Java ChatServer <port>");
        }
    }

    public void startServer(int port) throws Exception{
        ServerSocket serverSocket = new ServerSocket(port);
        System.err.println("ChatSever started.");
        while(true){
            ClientHandler cl = new ClientHandler(serverSocket.accept());
            System.err.println("Accepting connection from " + cl);
            synchronized(clients){
                clients.add(cl);
            }
            cl.start();
        }
    }

    public static void sendAll(String line, ClientHandler sender){
        System.err.println("Sending " + line + "to: " + clients);
        synchronized(clients){
            for(ClientHandler cl: clients){
                cl.send(sender + ":" + line);
            }
        }
    }

    public static class ClientHandler extends Thread{
        private BufferedReader input;
        private PrintWriter output;
        private String id;
        private static int count =0;

        public ClientHandler(Socket socket) throws Exception{
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            id = "Clients_" + ++count;
        }

        public void send(String line){
            output.println(line);
        }

        public String toString(){
            return id;
        }

        public void run(){
            try{
            send("Welcome! you are " + this + ".");
            String line;
            while((line=input.readLine())!=null){
                sendAll(line, this);
            }
            }catch(IOException e){
                e.printStackTrace();
            }finally{
                synchronized(clients){
                    clients.remove(this);
                }
                System.err.println(this + " closed connection.");
            }
        }
    }
}
            
            
            
                                         
