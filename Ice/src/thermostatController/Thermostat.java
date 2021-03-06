//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.7
//
// <auto-generated>
//
// Generated from file `thermostat.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package thermostatController;

public interface Thermostat extends com.zeroc.Ice.Object
{
    float getCurrentTemperature(com.zeroc.Ice.Current current);

    DaySchedule[] getWeekSchedule(com.zeroc.Ice.Current current);

    DaySchedule getDaySchedule(dayOfWeek day, com.zeroc.Ice.Current current);

    float getTemperatureScheduledForHour(dayOfWeek day, int hour, com.zeroc.Ice.Current current)
        throws IncorrectHourException;

    void scheduleTemperatureForHour(dayOfWeek day, int hour, float temperature, com.zeroc.Ice.Current current)
        throws IncorrectHourException;

    void scheduleTemperatureForDay(dayOfWeek day, HourSchedule[] hoursSchedule, com.zeroc.Ice.Current current)
        throws IncorrectHourException,
               NoInputException;

    void setCurrentTemperature(float temperature, com.zeroc.Ice.Current current);

    void changeUnit(temperatureUnits unit, com.zeroc.Ice.Current current);

    temperatureUnits getCurrentUnit(com.zeroc.Ice.Current current);

    /** @hidden */
    static final String[] _iceIds =
    {
        "::Ice::Object",
        "::thermostatController::Thermostat"
    };

    @Override
    default String[] ice_ids(com.zeroc.Ice.Current current)
    {
        return _iceIds;
    }

    @Override
    default String ice_id(com.zeroc.Ice.Current current)
    {
        return ice_staticId();
    }

    static String ice_staticId()
    {
        return "::thermostatController::Thermostat";
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_getCurrentTemperature(Thermostat obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(com.zeroc.Ice.OperationMode.Idempotent, current.mode);
        inS.readEmptyParams();
        float ret = obj.getCurrentTemperature(current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        ostr.writeFloat(ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_getWeekSchedule(Thermostat obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(com.zeroc.Ice.OperationMode.Idempotent, current.mode);
        inS.readEmptyParams();
        DaySchedule[] ret = obj.getWeekSchedule(current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        weekScheduleHelper.write(ostr, ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_getDaySchedule(Thermostat obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(com.zeroc.Ice.OperationMode.Idempotent, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        dayOfWeek iceP_day;
        iceP_day = dayOfWeek.ice_read(istr);
        inS.endReadParams();
        DaySchedule ret = obj.getDaySchedule(iceP_day, current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        DaySchedule.ice_write(ostr, ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
     * @throws com.zeroc.Ice.UserException -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_getTemperatureScheduledForHour(Thermostat obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        com.zeroc.Ice.Object._iceCheckMode(com.zeroc.Ice.OperationMode.Idempotent, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        dayOfWeek iceP_day;
        int iceP_hour;
        iceP_day = dayOfWeek.ice_read(istr);
        iceP_hour = istr.readInt();
        inS.endReadParams();
        float ret = obj.getTemperatureScheduledForHour(iceP_day, iceP_hour, current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        ostr.writeFloat(ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
     * @throws com.zeroc.Ice.UserException -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_scheduleTemperatureForHour(Thermostat obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        dayOfWeek iceP_day;
        int iceP_hour;
        float iceP_temperature;
        iceP_day = dayOfWeek.ice_read(istr);
        iceP_hour = istr.readInt();
        iceP_temperature = istr.readFloat();
        inS.endReadParams();
        obj.scheduleTemperatureForHour(iceP_day, iceP_hour, iceP_temperature, current);
        return inS.setResult(inS.writeEmptyParams());
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
     * @throws com.zeroc.Ice.UserException -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_scheduleTemperatureForDay(Thermostat obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        dayOfWeek iceP_day;
        HourSchedule[] iceP_hoursSchedule;
        iceP_day = dayOfWeek.ice_read(istr);
        iceP_hoursSchedule = hoursScheduleHelper.read(istr);
        inS.endReadParams();
        obj.scheduleTemperatureForDay(iceP_day, iceP_hoursSchedule, current);
        return inS.setResult(inS.writeEmptyParams());
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_setCurrentTemperature(Thermostat obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        float iceP_temperature;
        iceP_temperature = istr.readFloat();
        inS.endReadParams();
        obj.setCurrentTemperature(iceP_temperature, current);
        return inS.setResult(inS.writeEmptyParams());
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_changeUnit(Thermostat obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        temperatureUnits iceP_unit;
        iceP_unit = temperatureUnits.ice_read(istr);
        inS.endReadParams();
        obj.changeUnit(iceP_unit, current);
        return inS.setResult(inS.writeEmptyParams());
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_getCurrentUnit(Thermostat obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        inS.readEmptyParams();
        temperatureUnits ret = obj.getCurrentUnit(current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        temperatureUnits.ice_write(ostr, ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /** @hidden */
    final static String[] _iceOps =
    {
        "changeUnit",
        "getCurrentTemperature",
        "getCurrentUnit",
        "getDaySchedule",
        "getTemperatureScheduledForHour",
        "getWeekSchedule",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "scheduleTemperatureForDay",
        "scheduleTemperatureForHour",
        "setCurrentTemperature"
    };

    /** @hidden */
    @Override
    default java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceDispatch(com.zeroc.IceInternal.Incoming in, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        int pos = java.util.Arrays.binarySearch(_iceOps, current.operation);
        if(pos < 0)
        {
            throw new com.zeroc.Ice.OperationNotExistException(current.id, current.facet, current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return _iceD_changeUnit(this, in, current);
            }
            case 1:
            {
                return _iceD_getCurrentTemperature(this, in, current);
            }
            case 2:
            {
                return _iceD_getCurrentUnit(this, in, current);
            }
            case 3:
            {
                return _iceD_getDaySchedule(this, in, current);
            }
            case 4:
            {
                return _iceD_getTemperatureScheduledForHour(this, in, current);
            }
            case 5:
            {
                return _iceD_getWeekSchedule(this, in, current);
            }
            case 6:
            {
                return com.zeroc.Ice.Object._iceD_ice_id(this, in, current);
            }
            case 7:
            {
                return com.zeroc.Ice.Object._iceD_ice_ids(this, in, current);
            }
            case 8:
            {
                return com.zeroc.Ice.Object._iceD_ice_isA(this, in, current);
            }
            case 9:
            {
                return com.zeroc.Ice.Object._iceD_ice_ping(this, in, current);
            }
            case 10:
            {
                return _iceD_scheduleTemperatureForDay(this, in, current);
            }
            case 11:
            {
                return _iceD_scheduleTemperatureForHour(this, in, current);
            }
            case 12:
            {
                return _iceD_setCurrentTemperature(this, in, current);
            }
        }

        assert(false);
        throw new com.zeroc.Ice.OperationNotExistException(current.id, current.facet, current.operation);
    }
}
