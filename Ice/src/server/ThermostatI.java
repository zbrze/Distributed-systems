package server;

import com.zeroc.Ice.Current;
import thermostatController.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static thermostatController.temperatureUnits.C;

public class ThermostatI implements thermostatController.Thermostat {
    temperatureUnits currentUnit = C;
    private ArrayList<DaySchedule> weekSchedule;

    public ThermostatI(){
        this.weekSchedule = new ArrayList<>(7);
        this.weekSchedule.add(new DaySchedule(dayOfWeek.MONDAY, new HourSchedule[24]));
        this.weekSchedule.add(new DaySchedule(dayOfWeek.TUESDAY, new HourSchedule[24]));
        this.weekSchedule.add(new DaySchedule(dayOfWeek.WEDNESDAY, new HourSchedule[24]));
        this.weekSchedule.add(new DaySchedule(dayOfWeek.THURSDAY, new HourSchedule[24]));
        this.weekSchedule.add(new DaySchedule(dayOfWeek.FRIDAY, new HourSchedule[24]));
        this.weekSchedule.add(new DaySchedule(dayOfWeek.SATURDAY, new HourSchedule[24]));
        this.weekSchedule.add(new DaySchedule(dayOfWeek.SUNDAY, new HourSchedule[24]));
        for( DaySchedule daySchedule: this.weekSchedule){
            for(int i = 0; i < 24; i++){
                daySchedule.hoursSchedule[i] = new HourSchedule();
                daySchedule.hoursSchedule[i].hour = i;
                daySchedule.hoursSchedule[i].temperature = 11;
            }
        }
    }
    @Override
    public float getCurrentTemperature(Current current) {
        return this.weekSchedule.get(LocalDate.now().getDayOfWeek().getValue() - 1).hoursSchedule[LocalTime.now().getHour()].temperature;
    }

    @Override
    public DaySchedule[] getWeekSchedule(Current current) {
        return this.weekSchedule.toArray(DaySchedule[] :: new);
    }


    @Override
    public DaySchedule getDaySchedule(dayOfWeek day, Current current) {
        System.out.println(day.value());
        return this.weekSchedule.get(day.value());
    }

    @Override
    public float getTemperatureScheduledForHour(dayOfWeek day, int hour, Current current) throws IncorrectHourException {
        if(hour == 24) hour = 0;
        if(hour > 23) throw new IncorrectHourException();
        return this.weekSchedule.get(day.value()).hoursSchedule[hour].temperature;
    }

    @Override
    public void scheduleTemperatureForHour(dayOfWeek day, int hour, float temperature, Current current) throws IncorrectHourException {
        if(hour == 24) hour = 0;
        if(hour > 23) throw new IncorrectHourException();
        this.weekSchedule.get(day.value()).hoursSchedule[hour].temperature = temperature;
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
        this.weekSchedule.get(LocalDate.now().getDayOfWeek().getValue() - 1).hoursSchedule[LocalTime.now().getHour()].temperature = temperature;

    }

    @Override
    public void changeUnit(temperatureUnits unit, Current current) {
        switch (this.currentUnit){
            case C:
                switch (unit) {
                    case K:
                        this.weekSchedule.forEach(d ->{for(HourSchedule h: d.hoursSchedule){h.temperature = (float) Math.round(( h.temperature + 273.15)); }});
                        break;
                    case C:
                        break;
                    case F:
                        this.weekSchedule.forEach(d ->{for(HourSchedule h: d.hoursSchedule){h.temperature = (float) Math.round((h.temperature  * 1.8 + 32)); }});
                        break;
                }
                break;
            case F:
                switch (unit) {
                    case K:
                        this.weekSchedule.forEach(d ->{for(HourSchedule h: d.hoursSchedule){h.temperature = (float) Math.round(( 5*( h.temperature + 459.67)/9)); }});
                        break;
                    case C:
                        this.weekSchedule.forEach(d ->{for(HourSchedule h: d.hoursSchedule){h.temperature = (float) Math.round( 5*( h.temperature -32 )/9); }});
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
                        this.weekSchedule.forEach(d ->{for(HourSchedule h: d.hoursSchedule){h.temperature = (float) Math.round(h.temperature - 273.15); }});
                        break;
                    case F:
                        this.weekSchedule.forEach(d ->{for(HourSchedule h: d.hoursSchedule){h.temperature = (float) Math.round(1.8*(h.temperature-273.15) + 32); }});
                        break;
                }
                break;
        }
        this.currentUnit = unit;
    }

    @Override
    public temperatureUnits getCurrentUnit(Current current) {
        return this.currentUnit;
    }
}
