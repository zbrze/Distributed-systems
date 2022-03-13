import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.util.Arrays;

public class MulticastThread implements Runnable{
    private Client client;
    private int port = 1234;
    private InetSocketAddress groupAddress;
    private NetworkInterface networkInterface;
    private MulticastSocket socket;

    private boolean shutdown = false;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public MulticastThread(Client client, InetSocketAddress groupAddress, NetworkInterface networkInterface){
        this.client = client;
        this.groupAddress = groupAddress;
        this.networkInterface = networkInterface;
    }


    public void setShutdown(){
        shutdown = true;
    }

    @Override
    public void run() {
        try {
            this.socket = new MulticastSocket(port);
            socket.joinGroup(groupAddress, networkInterface);
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] buff = new byte[1024];
        while(!shutdown){
            Arrays.fill(buff, (byte)0);
            DatagramPacket packet = new DatagramPacket(buff, buff.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                System.out.println("Multicast receive error");
                e.printStackTrace();
            }
            String msg = new String(packet.getData()).trim();
            System.out.println(ANSI_PURPLE + msg + ANSI_RESET);
        }

        System.out.println("Multicast receive channel closed");
        System.exit(0);
    }
}
