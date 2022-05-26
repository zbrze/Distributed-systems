package server;

import com.zeroc.Ice.Current;
import flowerpotController.*;

public class FlowerpotI implements Flowerpot {
    private int humidityPercentage = 12;
    private lightPowerLevel lightPowerLevel = flowerpotController.lightPowerLevel.MEDIUM;
    @Override
    public int getCurrentHumidity(Current current) {
        return this.humidityPercentage;
    }

    @Override
    public void water(int mililiters, Current current) throws OverwaterError {
        int newHumidity = this.humidityPercentage + mililiters/100;
        if(newHumidity > 90) throw new OverwaterError();
        this.humidityPercentage = newHumidity;
    }

    @Override
    public lightPowerLevel getCurrentLightPowerLevel(Current current) {
        return this.lightPowerLevel;
    }

    @Override
    public void setLightPowerLeveL(lightPowerLevel powerLevel, Current current) throws OverdryError {
        if(this.lightPowerLevel.value() < powerLevel.value()){
            if(this.humidityPercentage - 15 < 0) throw new OverdryError();
            this.humidityPercentage -= 15;
        }
        this.lightPowerLevel = powerLevel;

    }
}
