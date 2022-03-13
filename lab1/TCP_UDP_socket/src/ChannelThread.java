import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Objects;

public class ChannelThread implements Runnable{
    private final Socket clientSocket;
    private Server server;
    private PrintWriter out = null;
    private BufferedReader in = null;
    private String nick = null;
    private boolean shutdown = false;
    private int clientPort;


    public ChannelThread(Socket socket, Server server) throws IOException {
        this.clientSocket = socket;
        this.server = server;
        this.clientPort = clientSocket.getPort();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

    }


    @Override
    public void run() {
        try {
            nick = in.readLine();

            System.out.println("New client, nick: " + nick + " connected");

            while (!shutdown) {
                String msg = in.readLine();
                if(msg.equalsIgnoreCase( "exit") || msg.trim().equalsIgnoreCase( "exit")){
                    server.disconnectClient(this);
                }
                else if(msg.equalsIgnoreCase("T")){
                    System.out.println(nick + " switching back to TCP");
                }
                else if(msg.equalsIgnoreCase("U")){
                    System.out.println(nick + " switching to UDP");
                }
                else {
                    msg = nick + ": " + msg;
                    server.sendMsg(msg, this);
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
            server.disconnectClient(this);
        }

    }

    public void sendMsg(String msg){
        out.println(msg);
}

    public String getNick() {
        return this.nick;
    }

    public void setShutdown(){
        shutdown = true;
    }

    public int getClientPort(){
        return this.clientPort;
    }

    public void sendMsgUDP(String msg) {
        try {
            InetAddress address = InetAddress.getByName("localhost");
            byte[] sendBuffer = msg.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, address, clientPort);
            server.getUDPSocket().send(sendPacket);
        }catch (Exception e){
            System.out.println("Server Error: send message UDP");
            e.printStackTrace();
        }
    }
}
