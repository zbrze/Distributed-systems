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

public interface ThermostatPrx extends com.zeroc.Ice.ObjectPrx
{
    default float getCurrentTemperature()
    {
        return getCurrentTemperature(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default float getCurrentTemperature(java.util.Map<String, String> context)
    {
        return _iceI_getCurrentTemperatureAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.lang.Float> getCurrentTemperatureAsync()
    {
        return _iceI_getCurrentTemperatureAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Float> getCurrentTemperatureAsync(java.util.Map<String, String> context)
    {
        return _iceI_getCurrentTemperatureAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Float> _iceI_getCurrentTemperatureAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Float> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getCurrentTemperature", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     float ret;
                     ret = istr.readFloat();
                     return ret;
                 });
        return f;
    }

    default DaySchedule[] getWeekSchedule()
    {
        return getWeekSchedule(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default DaySchedule[] getWeekSchedule(java.util.Map<String, String> context)
    {
        return _iceI_getWeekScheduleAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<DaySchedule[]> getWeekScheduleAsync()
    {
        return _iceI_getWeekScheduleAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<DaySchedule[]> getWeekScheduleAsync(java.util.Map<String, String> context)
    {
        return _iceI_getWeekScheduleAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<DaySchedule[]> _iceI_getWeekScheduleAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<DaySchedule[]> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getWeekSchedule", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     DaySchedule[] ret;
                     ret = weekScheduleHelper.read(istr);
                     return ret;
                 });
        return f;
    }

    default DaySchedule getDaySchedule(dayOfWeek day)
    {
        return getDaySchedule(day, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default DaySchedule getDaySchedule(dayOfWeek day, java.util.Map<String, String> context)
    {
        return _iceI_getDayScheduleAsync(day, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<DaySchedule> getDayScheduleAsync(dayOfWeek day)
    {
        return _iceI_getDayScheduleAsync(day, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<DaySchedule> getDayScheduleAsync(dayOfWeek day, java.util.Map<String, String> context)
    {
        return _iceI_getDayScheduleAsync(day, context, false);
    }

    /**
     * @hidden
     * @param iceP_day -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<DaySchedule> _iceI_getDayScheduleAsync(dayOfWeek iceP_day, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<DaySchedule> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getDaySchedule", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, ostr -> {
                     dayOfWeek.ice_write(ostr, iceP_day);
                 }, istr -> {
                     DaySchedule ret;
                     ret = DaySchedule.ice_read(istr);
                     return ret;
                 });
        return f;
    }

    default float getTemperatureScheduledForHour(dayOfWeek day, int hour)
        throws IncorrectHourException
    {
        return getTemperatureScheduledForHour(day, hour, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default float getTemperatureScheduledForHour(dayOfWeek day, int hour, java.util.Map<String, String> context)
        throws IncorrectHourException
    {
        try
        {
            return _iceI_getTemperatureScheduledForHourAsync(day, hour, context, true).waitForResponseOrUserEx();
        }
        catch(IncorrectHourException ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<java.lang.Float> getTemperatureScheduledForHourAsync(dayOfWeek day, int hour)
    {
        return _iceI_getTemperatureScheduledForHourAsync(day, hour, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Float> getTemperatureScheduledForHourAsync(dayOfWeek day, int hour, java.util.Map<String, String> context)
    {
        return _iceI_getTemperatureScheduledForHourAsync(day, hour, context, false);
    }

    /**
     * @hidden
     * @param iceP_day -
     * @param iceP_hour -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Float> _iceI_getTemperatureScheduledForHourAsync(dayOfWeek iceP_day, int iceP_hour, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Float> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getTemperatureScheduledForHour", com.zeroc.Ice.OperationMode.Idempotent, sync, _iceE_getTemperatureScheduledForHour);
        f.invoke(true, context, null, ostr -> {
                     dayOfWeek.ice_write(ostr, iceP_day);
                     ostr.writeInt(iceP_hour);
                 }, istr -> {
                     float ret;
                     ret = istr.readFloat();
                     return ret;
                 });
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_getTemperatureScheduledForHour =
    {
        IncorrectHourException.class
    };

    default void scheduleTemperatureForHour(dayOfWeek day, int hour, float temperature)
        throws IncorrectHourException
    {
        scheduleTemperatureForHour(day, hour, temperature, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void scheduleTemperatureForHour(dayOfWeek day, int hour, float temperature, java.util.Map<String, String> context)
        throws IncorrectHourException
    {
        try
        {
            _iceI_scheduleTemperatureForHourAsync(day, hour, temperature, context, true).waitForResponseOrUserEx();
        }
        catch(IncorrectHourException ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<Void> scheduleTemperatureForHourAsync(dayOfWeek day, int hour, float temperature)
    {
        return _iceI_scheduleTemperatureForHourAsync(day, hour, temperature, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> scheduleTemperatureForHourAsync(dayOfWeek day, int hour, float temperature, java.util.Map<String, String> context)
    {
        return _iceI_scheduleTemperatureForHourAsync(day, hour, temperature, context, false);
    }

    /**
     * @hidden
     * @param iceP_day -
     * @param iceP_hour -
     * @param iceP_temperature -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_scheduleTemperatureForHourAsync(dayOfWeek iceP_day, int iceP_hour, float iceP_temperature, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "scheduleTemperatureForHour", null, sync, _iceE_scheduleTemperatureForHour);
        f.invoke(true, context, null, ostr -> {
                     dayOfWeek.ice_write(ostr, iceP_day);
                     ostr.writeInt(iceP_hour);
                     ostr.writeFloat(iceP_temperature);
                 }, null);
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_scheduleTemperatureForHour =
    {
        IncorrectHourException.class
    };

    default void scheduleTemperatureForDay(dayOfWeek day, HourSchedule[] hoursSchedule)
        throws IncorrectHourException,
               NoInputException
    {
        scheduleTemperatureForDay(day, hoursSchedule, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void scheduleTemperatureForDay(dayOfWeek day, HourSchedule[] hoursSchedule, java.util.Map<String, String> context)
        throws IncorrectHourException,
               NoInputException
    {
        try
        {
            _iceI_scheduleTemperatureForDayAsync(day, hoursSchedule, context, true).waitForResponseOrUserEx();
        }
        catch(IncorrectHourException ex)
        {
            throw ex;
        }
        catch(NoInputException ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<Void> scheduleTemperatureForDayAsync(dayOfWeek day, HourSchedule[] hoursSchedule)
    {
        return _iceI_scheduleTemperatureForDayAsync(day, hoursSchedule, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> scheduleTemperatureForDayAsync(dayOfWeek day, HourSchedule[] hoursSchedule, java.util.Map<String, String> context)
    {
        return _iceI_scheduleTemperatureForDayAsync(day, hoursSchedule, context, false);
    }

    /**
     * @hidden
     * @param iceP_day -
     * @param iceP_hoursSchedule -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_scheduleTemperatureForDayAsync(dayOfWeek iceP_day, HourSchedule[] iceP_hoursSchedule, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "scheduleTemperatureForDay", null, sync, _iceE_scheduleTemperatureForDay);
        f.invoke(true, context, null, ostr -> {
                     dayOfWeek.ice_write(ostr, iceP_day);
                     hoursScheduleHelper.write(ostr, iceP_hoursSchedule);
                 }, null);
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_scheduleTemperatureForDay =
    {
        IncorrectHourException.class,
        NoInputException.class
    };

    default void setCurrentTemperature(float temperature)
    {
        setCurrentTemperature(temperature, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void setCurrentTemperature(float temperature, java.util.Map<String, String> context)
    {
        _iceI_setCurrentTemperatureAsync(temperature, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> setCurrentTemperatureAsync(float temperature)
    {
        return _iceI_setCurrentTemperatureAsync(temperature, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> setCurrentTemperatureAsync(float temperature, java.util.Map<String, String> context)
    {
        return _iceI_setCurrentTemperatureAsync(temperature, context, false);
    }

    /**
     * @hidden
     * @param iceP_temperature -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_setCurrentTemperatureAsync(float iceP_temperature, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "setCurrentTemperature", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     ostr.writeFloat(iceP_temperature);
                 }, null);
        return f;
    }

    default void changeUnit(temperatureUnits unit)
    {
        changeUnit(unit, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void changeUnit(temperatureUnits unit, java.util.Map<String, String> context)
    {
        _iceI_changeUnitAsync(unit, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> changeUnitAsync(temperatureUnits unit)
    {
        return _iceI_changeUnitAsync(unit, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> changeUnitAsync(temperatureUnits unit, java.util.Map<String, String> context)
    {
        return _iceI_changeUnitAsync(unit, context, false);
    }

    /**
     * @hidden
     * @param iceP_unit -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_changeUnitAsync(temperatureUnits iceP_unit, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "changeUnit", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     temperatureUnits.ice_write(ostr, iceP_unit);
                 }, null);
        return f;
    }

    default temperatureUnits getCurrentUnit()
    {
        return getCurrentUnit(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default temperatureUnits getCurrentUnit(java.util.Map<String, String> context)
    {
        return _iceI_getCurrentUnitAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<temperatureUnits> getCurrentUnitAsync()
    {
        return _iceI_getCurrentUnitAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<temperatureUnits> getCurrentUnitAsync(java.util.Map<String, String> context)
    {
        return _iceI_getCurrentUnitAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<temperatureUnits> _iceI_getCurrentUnitAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<temperatureUnits> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getCurrentUnit", null, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     temperatureUnits ret;
                     ret = temperatureUnits.ice_read(istr);
                     return ret;
                 });
        return f;
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static ThermostatPrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), ThermostatPrx.class, _ThermostatPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static ThermostatPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), ThermostatPrx.class, _ThermostatPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static ThermostatPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), ThermostatPrx.class, _ThermostatPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static ThermostatPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), ThermostatPrx.class, _ThermostatPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static ThermostatPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, ThermostatPrx.class, _ThermostatPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static ThermostatPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, ThermostatPrx.class, _ThermostatPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default ThermostatPrx ice_context(java.util.Map<String, String> newContext)
    {
        return (ThermostatPrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default ThermostatPrx ice_adapterId(String newAdapterId)
    {
        return (ThermostatPrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default ThermostatPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (ThermostatPrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default ThermostatPrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (ThermostatPrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default ThermostatPrx ice_invocationTimeout(int newTimeout)
    {
        return (ThermostatPrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default ThermostatPrx ice_connectionCached(boolean newCache)
    {
        return (ThermostatPrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default ThermostatPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (ThermostatPrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default ThermostatPrx ice_secure(boolean b)
    {
        return (ThermostatPrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default ThermostatPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (ThermostatPrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default ThermostatPrx ice_preferSecure(boolean b)
    {
        return (ThermostatPrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default ThermostatPrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (ThermostatPrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default ThermostatPrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (ThermostatPrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default ThermostatPrx ice_collocationOptimized(boolean b)
    {
        return (ThermostatPrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default ThermostatPrx ice_twoway()
    {
        return (ThermostatPrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default ThermostatPrx ice_oneway()
    {
        return (ThermostatPrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default ThermostatPrx ice_batchOneway()
    {
        return (ThermostatPrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default ThermostatPrx ice_datagram()
    {
        return (ThermostatPrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default ThermostatPrx ice_batchDatagram()
    {
        return (ThermostatPrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default ThermostatPrx ice_compress(boolean co)
    {
        return (ThermostatPrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default ThermostatPrx ice_timeout(int t)
    {
        return (ThermostatPrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default ThermostatPrx ice_connectionId(String connectionId)
    {
        return (ThermostatPrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default ThermostatPrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (ThermostatPrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::thermostatController::Thermostat";
    }
}
