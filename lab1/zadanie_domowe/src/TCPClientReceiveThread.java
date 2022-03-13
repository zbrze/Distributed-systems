import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TCPClientReceiveThread implements Runnable {
    private final Client client;
    private BufferedReader in = null;
    private boolean shutdown = false;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public TCPClientReceiveThread(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            this.in = new BufferedReader(new InputStreamReader(
                    this.client.getTCPSocket().getInputStream()));
        } catch (IOException e) {
            System.out.println("Break");
            e.printStackTrace();
        }
        String msg = null;
        while (!shutdown){
            try {
                msg = in.readLine();
                if(msg.equalsIgnoreCase("exit")){
                    System.out.println("Server has shut down ");
                    client.setShutdown();
                    setShutdown();
                }else {
                    System.out.println(ANSI_YELLOW + msg + ANSI_RESET);
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
        System.out.println("TCP receive channel closed");
        System.exit(0);
    }

    public void setShutdown(){
        shutdown = true;
    }
}
