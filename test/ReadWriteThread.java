// ReadWriteThread.java                                                         
                                                                                
import java.io.*;                                                               
                                                                                
public class ReadWriteThread extends Thread {                                   
                                                                                
   private BufferedReader input;                                                
   private PrintWriter output;
    private String s;
                                                                                
    public ReadWriteThread(InputStream input, OutputStream output, String s) {             
      this.input = new BufferedReader(new InputStreamReader(input));            
      this.output = new PrintWriter(output, true);
      this.s = s;
   }                                                                            
                                                                                
   public void run() {                                                          
      try {                                                                     
         String line;                                                           
         while ((line = input.readLine()) != null) {
             output.print(s);
            output.println(line);                                               
         }                                                                      
      } catch (IOException e) {   
         e.printStackTrace();                                                   
      }                                                                         
   }                                                                            
}          
