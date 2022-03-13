import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPServerThread implements Runnable{
    private final Server server;
    private final DatagramSocket datagramSocket;
    private boolean shutdown=false;

    public UDPServerThread(Server server, DatagramSocket datagramSocket) {
        this.server = server;
        this.datagramSocket = datagramSocket;
    }

    public void setShutdown(){
        shutdown = true;
    }

    @Override
    public void run() {
        byte[] buff = new byte[1024];
        System.out.println("UDP server started");
        while(!shutdown){
            Arrays.fill(buff, (byte)0);
            DatagramPacket packet = new DatagramPacket(buff, buff.length);
            try {
                datagramSocket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String msg = new String(packet.getData()).trim();
            server.sendMsgUDP(msg, packet.getPort());
        }
    }

}
