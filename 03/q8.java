import java.io.*;  // import the package

public class q8 {
    public static void main(String[] args) throws IOException {
        int a;
        System.out.println("Enter a Character:");
        try {
            a = System.in.read();
            System.out.println("You entered " + a);
        }
        catch (IOException e){
            System.out.println("Error reading from user");
        }
    }
}
