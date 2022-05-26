package server;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;

public class Server {
    public void run(String[] args){
        Communicator communicator = null;
        try{
            communicator = Util.initialize(args);

            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("Adapter1", "tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p 10000 -z");

            AirPurifierI airPurifierServant1 = new AirPurifierI();
//            AirPurifierWithHumidifierI airPurifierWithHumidifierServant1 = new AirPurifierWithHumidifierI();
//            ThermostatI thermostatServant = new ThermostatI();
            adapter.add((com.zeroc.Ice.Object) airPurifierServant1, new Identity("airPurifier1", "airPurifier"));
            adapter.activate();
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
