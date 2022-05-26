
#ifndef SMARTHOME_ICE
#define SMARTHOME_ICE

module airPurifierController{
    enum airQuality {GOOD, MODERATE, UNHEALTHY};

    enum powerLevel { LOW = 0 , MEDIUM = 1, HIGH = 2 };

    exception WornoutFilterException{
//        string reason = "You cant set power level while the filter is worn out";
    };

exception EmptyWaterTankException{
//        string reason = "You cant turn on the humidifier because water tank is empty";
    };


    interface AirPurifier {
        idempotent powerLevel getCurrentPowerLevel();
        void changeFilter();
        int getFilterWearPercentage();
        void setCurrentPower(powerLevel powerLevel) throws WornoutFilterException;
        idempotent airQuality getCurentAirQuality();
    };

    interface AirPurifierWithHumidifier extends AirPurifier {
        idempotent int getHumidityPercentage();
        idempotent int getWaterTankLevel();
        idempotent void refillTank();
        idempotent void turnOnHumidifierMode();
        idempotent void turnOffHumidifierMode();
        idempotent bool isHumidifierTurnedOn();

    };
};
#endif