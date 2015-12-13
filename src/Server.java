import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by georgipavlov on 13.12.15.
 */
public class Server implements Runnable {
    Socket socket;
    Scanner scanner;
    File file;
    public Server(Socket socket){
        this.socket=socket;
        try {
            scanner = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void run() {
        StringBuilder b = new StringBuilder();
        while(!scanner.nextLine().equals("exit")){
            b.append(scanner.nextLine());
        }
        WriteToFile(b);
        scanner.close();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private synchronized void WriteToFile(StringBuilder b){
        File file = new File("thisFile");
        PrintStream printStream=null;
        try {
            printStream = new PrintStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }try {
            printStream.append(b);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        if(printStream != null){
            printStream.close();
        }
    }
}
