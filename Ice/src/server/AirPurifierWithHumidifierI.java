package server;

import airPurifierController.AirPurifierWithHumidifier;
import airPurifierController.WornoutFilterException;
import airPurifierController.airQuality;
import airPurifierController.powerLevel;
import com.zeroc.Ice.Current;

public class AirPurifierWithHumidifierI extends AirPurifierI implements AirPurifierWithHumidifier{
    private boolean humidifierTurnedOn = true;
    int humidityPercentage = 20;
    int waterTankLevel = 100;


    @Override
    public int getHumidityPercentage(Current current) {
        return this.humidityPercentage;
    }


    @Override
    public int getWaterTankLevel(Current current) {
        return this.waterTankLevel;
    }

    @Override
    public void refillTank(Current current) {
        this.waterTankLevel = 100;
    }

    @Override
    public void turnOnHumidifierMode(Current current) {
        if(waterTankLevel == 0)
        this.humidifierTurnedOn = true;
        this.waterTankLevel -= 10;
    }

    @Override
    public void turnOffHumidifierMode(Current current) {
        this.humidifierTurnedOn = false;
    }

    @Override
    public boolean isHumidifierTurnedOn(Current current) {
        return this.humidifierTurnedOn;
    }

}
