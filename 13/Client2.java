// Client2.java                                                                  
                                                                                
import java.net.*;                                                              
                                                                                
public class Client2 {                                                           
                                                                                
   public static void main(String[] args) {                                     
      try {                                                                     
         int port = Integer.parseInt(args[0]);                                  
         String host = args[1];                                                 
         Socket socket = new Socket(host, port);  
         System.err.println("Connected to " + socket.getInetAddress() + 
         " on port " + socket.getPort() + " using local port " +
         socket.getLocalPort());                              
         System.err.println("Connected to " + host + " on port " + port);       
         new ReadWriteThread(System.in, socket.getOutputStream()).start();      
         new ReadWriteThread(socket.getInputStream(), System.out).start();      
      } catch (Exception e) {                                                   
         e.printStackTrace();                                                   
         System.err.println("\nUsage: java Client2 <port> <host>");              
      }                                                                         
   }                                                                            
                                                                                
}                                                                               
