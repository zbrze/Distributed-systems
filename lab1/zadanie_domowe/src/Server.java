import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private final static int portNo = 9008;
    private ServerSocket TCPSocket = null;
    private DatagramSocket UDPSocket = null;
    private List<ChannelThread> channels = new ArrayList<ChannelThread>();
    private UDPServerThread udpServer = null;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public Server(){}

    public void startServer() throws IOException {

        TCPSocket = new ServerSocket(portNo);
        UDPSocket = new DatagramSocket(portNo);

        udpServer = new UDPServerThread(this, UDPSocket);
        new Thread(udpServer).start();

        System.out.println("Server running, waiting for clients to connect");
        while(true){

            //connecting client
            Socket clientSocket = TCPSocket.accept();

            //creating new thread for client
            ChannelThread channelThread = new ChannelThread(clientSocket, this);
            channels.add(channelThread);
            new Thread(channelThread).start();
        }


    }

    public void sendMsg(String msg, ChannelThread channelThread){
        System.out.println(ANSI_YELLOW + msg + ANSI_RESET);
        for(ChannelThread c: channels){
            if(c != channelThread){
                try {
                    c.sendMsg(msg);
                }catch (Exception x){
                    System.out.println("Client deleted");
                }
            }
        }
    }

    public void sendMsgUDP(String msg, int port){
        System.out.println(ANSI_BLUE + msg + ANSI_RESET);
        for(ChannelThread c: channels){
            if(c.getClientPort() != port){
                c.sendMsgUDP(msg);
            }
        }
    }

    public void disconnectClient(ChannelThread channelThread){
        System.out.println("disconnecting client: " + channelThread.getNick());
        channelThread.setShutdown();
        channels.remove(channelThread);
    }

    public DatagramSocket getUDPSocket(){
        return this.UDPSocket;
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        Thread hook = new Thread(){
            public void run()
            {
                for(ChannelThread c: server.channels){
                    System.out.println("disconnecting: " + c.getNick());
                    c.setShutdown();
                }
                System.out.println("Server ended work");
                server.sendMsg("exit", null);
                server.udpServer.setShutdown();
            }
        };

        Runtime.getRuntime().addShutdownHook(hook);

        server.startServer();

    }
}
