import java.io.*;  // import the package

public class program1{
    public static void main(String[] args) throws IOException {
        // DataOutputStream ops = new DataOutputStream (System.out);
        InputStream in = System.in;
        OutputStream out = System.out;
        try{
            while(true){
                int n = in.read();
                if( n ==-1){
                    break;
                }
                out.write(n);   
            }
        } catch (Exception e) {
            System.out.println(e);
        }
                
    }
}
        
