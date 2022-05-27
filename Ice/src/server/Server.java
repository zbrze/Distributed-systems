package server;

import airPurifierController.AirPurifier;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;
import flowerpotController.Flowerpot;
import serverMiddleware.Device;
import thermostatController.Thermostat;

import java.util.ArrayList;

public class Server {
    private ServerMiddlewareI middleware;
    ArrayList<Flowerpot> flowerpots = new ArrayList<>();
    ArrayList<AirPurifier> airPurifiers = new ArrayList<>();
    ArrayList<Thermostat> thermostats= new ArrayList<>();

    public Server(){
    }
    public void run(String[] args){
        Communicator communicator = null;
        try{
            communicator = Util.initialize(args);
            ArrayList<Device> devices = new ArrayList<>();

            ObjectAdapter serverAdapter = communicator.createObjectAdapterWithEndpoints("ServerAdapter", "tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p 10000 -z");
            ObjectAdapter adapter1 = communicator.createObjectAdapterWithEndpoints("Adapter1", "tcp -h 127.0.0.2 -p 10001 -z : udp -h 127.0.0.2 -p 10001 -z");
            ObjectAdapter adapter2 = communicator.createObjectAdapterWithEndpoints("Adapter2", "tcp -h 127.0.0.2 -p 10002 -z : udp -h 127.0.0.2 -p 10002 -z");

            this.flowerpots.add(new FlowerpotI());
            adapter1.add(this.flowerpots.get(0), new Identity("flowerpot1", "flowerpot"));
            devices.add(new Device("flowerpot1", "flowerpot", "tcp -h 127.0.0.2 -p 10001 -z : udp -h 127.0.0.2 -p 10001 -z"));
            this.flowerpots.add(new FlowerpotI());
            adapter2.add(this.flowerpots.get(0), new Identity("flowerpot2", "flowerpot"));
            devices.add(new Device("flowerpot2", "flowerpot", "tcp -h 127.0.0.2 -p 10002 -z : udp -h 127.0.0.2 -p 10002 -z"));

            this.airPurifiers.add(new AirPurifierI());
            adapter1.add(this.airPurifiers.get(0), new Identity("airpurifier1", "airpurifier"));
            devices.add(new Device("airpurifier1", "airpurifier", "tcp -h 127.0.0.2 -p 10001 -z : udp -h 127.0.0.2 -p 10001 -z"));

            this.airPurifiers.add(new AirPurifierWithHumidifierI());
            adapter2.add(this.airPurifiers.get(1), new Identity("airpurifierwithhumidifier1", "airpurifierwithhumidifier"));
            devices.add(new Device("airpurifierwithhumidifier1", "airpurifierwithhumidifier", "tcp -h 127.0.0.2 -p 10002 -z : udp -h 127.0.0.2 -p 10002 -z"));

            this.thermostats.add(new ThermostatI());
            adapter1.add((com.zeroc.Ice.Object) this.thermostats.get(0), new Identity("thermostat1", "thermostat"));
            devices.add(new Device("thermostat1", "thermostat", "tcp -h 127.0.0.2 -p 10001 -z : udp -h 127.0.0.2 -p 10001 -z"));
            adapter1.activate();
            adapter2.activate();

            ServerMiddlewareI serverMiddleware = new ServerMiddlewareI(devices);
            serverAdapter.add(serverMiddleware, new Identity("server", "server"));
            serverAdapter.activate();

            System.out.println("Entering event processing loop...");

            communicator.waitForShutdown();

        }
        catch (Exception e) {
            System.err.println(e);
        }
        if (communicator != null) {
            try {
                communicator.destroy();
            }
            catch (Exception e) {
                System.err.println(e);
            }
        }
        System.exit(0);
    }
    public static void main(String[] args)
    {
        Server app = new Server();
        app.run(args);
    }

}
