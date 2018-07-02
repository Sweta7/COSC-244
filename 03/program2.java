import java.io.*;  // import the package

public class program2{
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader  ina= new InputStreamReader (in);
        BufferedReader br = new BufferedReader (ina);
        PrintStream out = System.out;
        try{
            while(true){
                System.out.println("what is your name");
                String n = br.readLine();// takes string iput from keyboard
                if( n == null)){
                    break;
                }

                StringBuilder st = new StringBuilder(n);
                st.reverse ();
                out.println(st);
                //out.write(n);   
            }
        } catch (Exception e) {
            System.out.println(e);
        }
                
    }
}
