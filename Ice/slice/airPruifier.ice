
#ifndef AIRPURIFIER_ICE
#define AIRPURIFIER_ICE

module airPurifierController{
    enum airQuality {GOOD, MODERATE, UNHEALTHY};

    enum powerLevel { LOW = 1, MEDIUM = 2, HIGH = 3 };

    exception WornoutFilterException{};
    exception IncorrectInputException{};
    exception TurnedOffException{};

exception EmptyWaterTankException{
    };


    interface AirPurifier {
        idempotent powerLevel getCurrentPowerLevel();
        void changeFilter();
        int getFilterWearPercentage();
        void setCurrentPower(powerLevel powerLevel) throws WornoutFilterException;
        idempotent airQuality getCurentAirQuality();
    };

    interface AirPurifierWithHumidifier extends AirPurifier {
        idempotent int getHumidityPercentage() throws TurnedOffException ;
        idempotent int getWaterTankLevel();
        idempotent void refillTank();
        idempotent void turnOnHumidifierMode() throws EmptyWaterTankException ;
        idempotent void turnOffHumidifierMode();
        idempotent bool isHumidifierTurnedOn();

    };
};
#endif