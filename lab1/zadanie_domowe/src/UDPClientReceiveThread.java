import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.util.Arrays;

public class UDPClientReceiveThread implements Runnable{
    private final Client client;
    private boolean shutdown = false;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public UDPClientReceiveThread(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        byte[] buff = new byte[1024];
        String msg;
        while (!shutdown) {
            Arrays.fill(buff, (byte)0);
            DatagramPacket packet = new DatagramPacket(buff, buff.length);
            try {
                client.getUDPSocket().receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            msg = new String(packet.getData()).trim();

            if (msg.equalsIgnoreCase("exit")) {
                System.out.println("Server has shut down ");
                client.setShutdown();
                setShutdown();
            } else {
                System.out.println(ANSI_BLUE + msg + ANSI_RESET);
            }

        }
        System.out.println("UDP receive channel closed");
        System.exit(0);
    }

    public void setShutdown(){
        shutdown = true;
    }

}
