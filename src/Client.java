import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by georgipavlov on 13.12.15.
 */
public class Client {
    Socket socket ;

    public Client(int soc){
        try {
            socket = new Socket("localhost",soc);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintStream printStream=null;
        try {
            printStream = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            try {
                printStream.print(scanner.nextLine());
            }catch (NullPointerException e){
                e.printStackTrace();
            }
        }
        try {
            printStream.close();
            socket.close();
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }catch (NullPointerException e){
        e.printStackTrace();
        }

    }
}
