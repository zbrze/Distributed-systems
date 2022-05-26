package server;

import com.zeroc.Ice.Current;
import thermostatController.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import static thermostatController.temperatureUnits.C;

public class ThermostatI implements thermostatController.Thermostat {
    temperatureUnits currentUnit = C;
    private DaySchedule[] weekSchedule = {new DaySchedule(dayOfWeek.MONDAY, new HourSchedule[24]),
            new DaySchedule( dayOfWeek.TUESDAY, new HourSchedule[24]), new DaySchedule(dayOfWeek.WEDNESDAY, new HourSchedule[24]),
            new DaySchedule(dayOfWeek.THURSDAY, new HourSchedule[24]), new DaySchedule(dayOfWeek.FRIDAY, new HourSchedule[24]),
            new DaySchedule(dayOfWeek.SATURDAY, new HourSchedule[24]),new DaySchedule( dayOfWeek.SUNDAY, new HourSchedule[24])};

    public ThermostatI(){
        System.out.println("Xd");
        for( DaySchedule daySchedule: this.weekSchedule){
            for(int i = 0; i < 24; i++){
                daySchedule.hoursSchedule[i].hour = i;
                daySchedule.hoursSchedule[i].temperature = 11;
            }
        }
    }
    @Override
    public float getCurrentTemperature(Current current) {
        return this.weekSchedule[LocalDate.now().getDayOfWeek().getValue() - 1].hoursSchedule[LocalTime.now().getHour()].temperature;
    }

    @Override
    public DaySchedule[] getWeekSchedule(Current current) {
        return this.weekSchedule;
    }

    @Override
    public DaySchedule getDaySchedule(dayOfWeek day, Current current) {
        return this.weekSchedule[day.value()];
    }

    @Override
    public float getTemperatureScheduledForHour(dayOfWeek day, int hour, Current current) throws IncorrectHourException {
        if(hour == 24) hour = 0;
        if(hour > 23) throw new IncorrectHourException();
        return this.weekSchedule[day.value()].hoursSchedule[hour].temperature;
    }

    @Override
    public void scheduleTemperatureForHour(dayOfWeek day, int hour, float temperature, Current current) throws IncorrectHourException {
        if(hour == 24) hour = 0;
        if(hour > 23) throw new IncorrectHourException();
        this.weekSchedule[day.value()].hoursSchedule[hour].temperature = temperature;
    }

    @Override
    public void scheduleTemperatureForDay(dayOfWeek day, HourSchedule[] hoursSchedule, Current current) throws NoInputException, IncorrectHourException {
        if(hoursSchedule.length == 0) throw new NoInputException();
        for(HourSchedule hourSchedule : hoursSchedule){
            this.scheduleTemperatureForHour(day, hourSchedule.hour, hourSchedule.temperature, current);
        }
    }

    @Override
    public void setCurrentTemperature(float temperature, Current current) {
        this.weekSchedule[LocalDate.now().getDayOfWeek().getValue() - 1].hoursSchedule[LocalTime.now().getHour()].temperature = temperature;

    }

    @Override
    public void changeUnit(temperatureUnits unit, Current current) {
        switch (this.currentUnit){
            case C:
                switch (unit) {
                    case K:
                        Arrays.stream(this.weekSchedule).map(e -> Arrays.stream(e.hoursSchedule).map( x -> x.temperature = (float) (x.temperature + 273.15)));
                        break;
                    case C:
                        break;
                    case F:
                        Arrays.stream(this.weekSchedule).map(e -> Arrays.stream(e.hoursSchedule).map( x -> x.temperature = (float) (x.temperature  * 1.8 + 32)));
                        break;
                }
                break;
            case F:
                switch (unit) {
                    case K:
                        Arrays.stream(this.weekSchedule).map(e -> Arrays.stream(e.hoursSchedule).map( x -> x.temperature = (float) ( 5*( x.temperature + 459.67)/9)));
                        break;
                    case C:
                        Arrays.stream(this.weekSchedule).map(e -> Arrays.stream(e.hoursSchedule).map( x -> x.temperature = (float) ( 5*( x.temperature -32 )/9)));
                        break;
                    case F:
                        break;
                }
                break;
            case K:
                switch (unit) {
                    case K:
                        break;
                    case C:
                        Arrays.stream(this.weekSchedule).map(e -> Arrays.stream(e.hoursSchedule).map( x -> x.temperature = (float) (x.temperature - 273.15)));
                        break;
                    case F:
                        Arrays.stream(this.weekSchedule).map(e -> Arrays.stream(e.hoursSchedule).map( x -> x.temperature = (float) (1.8*(x.temperature-273.15) + 32)));
                        break;
                }
                break;
        }
        this.currentUnit = unit;
    }
}
