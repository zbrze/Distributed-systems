
#ifndef SMARTHOME_ICE
#define SMARTHOME_ICE

module SmartHome
{
    enum powerLevel { LOW, MEDIUM, HIGH }

    class Flowerpot{
        powerLevel lightPower = LOW;
        int humidityPercentage = 10;
    };

    interface FlowerpotController {
        idempotent int getCurrentHumidity();
        void water(int mililiters) throws NoInput;
        idempotent powerLevel getCurrentPowerLevel();
        void setPowerLeveL(powerLevel powerLevel) throws NoInput;
    };

    enum airQuality {GOOD, MODERATE, UNHEALTHY};

    interface AirPurifier {
//        airQuality airQuality = MODERATE;
//        powerLevel powerMode = MEDIUM;
//        int filterWearPercentage = 50;
        idempotent powerLevel getCurrentPowerLevel();
        void changeFilter();
        int getFilterWearPercentage();
    };

    interface AirPurifierWithHumidifier extends AirPurifier {
//        bool humidifierTurnedOn = true;
//        int humidityPercentage = 20;
//        float waterTankLevel = 60;
        idempotent int getHumidityPercentage();
        idempotent int getWAterTankLevel();
        idempotent void refillTank();
        idempotent void turnOnHumidifierMode();
        idempotent void turnOffHumidifierMode();
    };

    enum dayOfWeek { MON, TUE, WED, THU, FRI, SAT, SUN};

    struct DaySchedule{
        float temperature;
        dayOfWeek day;
    };

    sequence<DaySchedule> WeekSchedule;

    enum temperatureUnits {C, K, F};

    interface Thermostat{
//        temperatureUnits currentUnit = C;
//        weekSchedule weekSchedule;
        idempotent float getCurrentTemperature();
        idempotent float getScheduldedTemperature(dayOfWeek day) throws NoInput;
        void scheduleTemperatureForDay(dayOfWeek day, float temperature) throws NoInput;
        void scheduleTemperatureForWeek(WeekSchedule weekSchedule) throws NoInput;
        void setCurrentTemperature(float temperature);
        void changeUnit(temperatureUnits unit);
    };

};

#endif