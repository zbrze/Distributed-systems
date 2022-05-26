
#ifndef SMARTHOME_ICE
#define SMARTHOME_ICE


module thermostatController{
enum dayOfWeek { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY};
    struct HourSchedule{
        float temperature;
        int hour;
    };
    sequence<HourSchedule> hoursSchedule;

    struct DaySchedule{
        dayOfWeek day;
        hoursSchedule hoursSchedule;
    };

     exception NoInputException {
        string reason = "no hours schedule provided";
     };

     exception IncorrectHourException {
        string reason = "provided hour should be in range 0-23";
     };

    sequence<DaySchedule> weekSchedule;

    enum temperatureUnits {C, K, F};

    interface Thermostat{
        idempotent float getCurrentTemperature();
        idempotent weekSchedule getWeekSchedule();
        idempotent DaySchedule getDaySchedule(dayOfWeek day);
        idempotent float getTemperatureScheduledForHour(dayOfWeek day, int hour) throws IncorrectHourException;
        void scheduleTemperatureForHour(dayOfWeek day, int hour, float temperature) throws IncorrectHourException;
        void scheduleTemperatureForDay(dayOfWeek day, hoursSchedule hoursSchedule) throws NoInputException, IncorrectHourException;
        void setCurrentTemperature(float temperature);
        void changeUnit(temperatureUnits unit);
    };

};

#endif