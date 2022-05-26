package server;

import airPurifierController.AirPurifier;
import airPurifierController.WornoutFilterException;
import airPurifierController.airQuality;
import airPurifierController.powerLevel;
import com.zeroc.Ice.Current;

public class AirPurifierI implements AirPurifier {

    private powerLevel powerLevel = airPurifierController.powerLevel.MEDIUM;
    private int filterWearPercentage = 10;
    private airQuality airQuality = airPurifierController.airQuality.MODERATE;

    @Override
    public powerLevel getCurrentPowerLevel(Current current) {
        return this.powerLevel;
    }

    @Override
    public void changeFilter(Current current) {
        this.filterWearPercentage = 0;

    }

    @Override
    public int getFilterWearPercentage(Current current) {
        return filterWearPercentage;
    }

    @Override
    public void setCurrentPower(airPurifierController.powerLevel powerLevel, Current current) throws WornoutFilterException {

        switch (powerLevel){
            case HIGH:
                if(this.filterWearPercentage + 15 > 100 ) throw new WornoutFilterException();
                airQuality = airPurifierController.airQuality.GOOD;
                this.filterWearPercentage += 15;
                break;

            case MEDIUM:
                if(this.filterWearPercentage + 10 > 100 ) throw new WornoutFilterException();
                airQuality = airPurifierController.airQuality.MODERATE;
                this.filterWearPercentage += 10;
                break;

            case LOW:
                if(this.filterWearPercentage + 5 > 100 ) throw new WornoutFilterException();
                airQuality = airPurifierController.airQuality.UNHEALTHY;
                this.filterWearPercentage += 0;
                break;
        }

        this.powerLevel = powerLevel;
    }

    @Override
    public airQuality getCurentAirQuality(Current current) {
        return this.airQuality;
    }
}
