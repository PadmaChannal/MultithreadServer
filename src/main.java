import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by georgipavlov on 13.12.15.
 */
public class main {
    public static void main(String[] args) {
        ServerSocket s=null;
        try {
            s= new ServerSocket(6666);

        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true){
            Socket socket=null;
            try {
                socket = s.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            new Thread(new Server(socket)).start();
        }
    }
}
