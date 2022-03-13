import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Client {
    private String nick = null;
    private String hostName = "localhost";
    private final int portNo = 9008;
    private final int multicastPortNo = 1234;
    private final InetSocketAddress groupAddress = new InetSocketAddress("225.255.0.1", multicastPortNo);
    private final NetworkInterface networkInterface = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());

    private Socket TCPSocket = null;
    private DatagramSocket UDPSocket = null;
    private PrintWriter out = null;
    private BufferedReader in = null;

    private TCPClientReceiveThread TCPReceiveThread;
    private UDPClientReceiveThread UDPReceiveThread;
    private MulticastThread multicastThread;

    private boolean shutdown = false;
    private char mode = 'T';

    public Client() throws SocketException, UnknownHostException {}

    public synchronized void connect() throws IOException {
        System.out.println("Starting client");
        System.out.println("Hello, please provide your nickname: ");
        in = new BufferedReader(new InputStreamReader(System.in));
        while(nick == null || nick.equalsIgnoreCase("") || nick.trim().equalsIgnoreCase("")){
            nick = in.readLine();
        }
        TCPSocket = new Socket(hostName, portNo);
        out = new PrintWriter(TCPSocket.getOutputStream(), true);

        UDPSocket = new DatagramSocket(TCPSocket.getLocalPort());

        System.out.println("Thank you, " + nick +", you can send messages now! \n" +
                "Type 'exit' to end work, 'U' ('u') to switch to UDP mode, 'T'('t') to turn back to TCP mode and \n"+
                "'M' ('m') to turn on multicast mode!");
        out.println(nick);

        this.TCPReceiveThread = new TCPClientReceiveThread(this);
        new Thread(TCPReceiveThread).start();
        this.UDPReceiveThread = new UDPClientReceiveThread(this);
        new Thread(UDPReceiveThread).start();
        this.multicastThread = new MulticastThread(this, groupAddress, networkInterface);
        new Thread((multicastThread)).start();

        String msg = null;
        while (!shutdown){
            try {
                msg = in.readLine();
                if(msg.equalsIgnoreCase("U")|| (msg.trim()).equalsIgnoreCase("U")){
                    System.out.println("Switching to UDP mode");
                    mode = 'U';
                }else if(msg.equalsIgnoreCase("T")|| (msg.trim()).equalsIgnoreCase("T")){
                    System.out.println("Switching back to TCP mode");
                    mode = 'T';
                }else if(msg.equalsIgnoreCase("M")|| (msg.trim()).equalsIgnoreCase("M")){
                    System.out.println("Switching to multicast mode");
                    mode = 'M';
                }else if(msg.equalsIgnoreCase("exit") || (msg.trim()).equalsIgnoreCase("exit")){
                    break;
                }else{
                    sendMsg(msg);
                }


            }catch (IOException e){

                System.out.println("Client has ended work");
                break;
            }
        }
        System.exit(0);

    }

    public void sendMsg(String msg){
        switch (mode) {
            case 'U':
                //sending msg via udp
                sendMsgUDP(msg);
                break;
            case 'M':
                //sending via multicast
                sendMsgMulticast(msg);
                break;
            case 'T':
                //sending via tcp
                out.println(msg);
                break;
            default:
                System.out.println("Mode ERROR");
                System.exit(1);
        }
    }

    private void sendMsgMulticast(String msg) {
        try {
            msg = nick+": " + msg;
            byte[] sendBuffer = msg.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, groupAddress);
            UDPSocket.send(sendPacket);
        } catch (IOException e) {
            System.out.println("Server Error: send message UDP");
            e.printStackTrace();
        }
    }

    public void sendMsgUDP(String msg){
        try {
            msg = nick+": " + msg;
            InetAddress address = InetAddress.getByName("localhost");
            byte[] sendBuffer = msg.getBytes();

            DatagramPacket packet = new DatagramPacket(sendBuffer, sendBuffer.length, address, portNo);
            UDPSocket.send(packet);
        } catch (IOException e) {
            System.out.println("Server Error: send message UDP");
            e.printStackTrace();
        }
    }

    public Socket getTCPSocket(){
        return this.TCPSocket;
    }
    public DatagramSocket getUDPSocket(){
        return this.UDPSocket;
    }
    public void setShutdown(){
        shutdown = true;
    }

    public boolean isShutdown(){
        return shutdown;
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        Thread hook = new Thread(){
            public void run()
            {
                System.out.println("Client ended work");
                if(!client.isShutdown()) {
                    try {
                        client.out.println("exit");
                        client.UDPReceiveThread.setShutdown();
                        client.TCPReceiveThread.setShutdown();
                        client.multicastThread.setShutdown();
                    }catch(Exception e){
                        System.out.println("Cause: server not responding");
                    }
                }
            }
        };

        Runtime.getRuntime().addShutdownHook(hook);
        try{
            client.connect();
        }catch (Exception e){
            System.out.println("Unable to connect");
        }

    }

}

