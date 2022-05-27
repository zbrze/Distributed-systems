//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.7
//
// <auto-generated>
//
// Generated from file `airPruifier.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package airPurifierController;

public interface AirPurifierWithHumidifierPrx extends AirPurifierPrx
{
    default int getHumidityPercentage()
        throws TurnedOffException
    {
        return getHumidityPercentage(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default int getHumidityPercentage(java.util.Map<String, String> context)
        throws TurnedOffException
    {
        try
        {
            return _iceI_getHumidityPercentageAsync(context, true).waitForResponseOrUserEx();
        }
        catch(TurnedOffException ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<java.lang.Integer> getHumidityPercentageAsync()
    {
        return _iceI_getHumidityPercentageAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Integer> getHumidityPercentageAsync(java.util.Map<String, String> context)
    {
        return _iceI_getHumidityPercentageAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Integer> _iceI_getHumidityPercentageAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Integer> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getHumidityPercentage", com.zeroc.Ice.OperationMode.Idempotent, sync, _iceE_getHumidityPercentage);
        f.invoke(true, context, null, null, istr -> {
                     int ret;
                     ret = istr.readInt();
                     return ret;
                 });
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_getHumidityPercentage =
    {
        TurnedOffException.class
    };

    default int getWaterTankLevel()
    {
        return getWaterTankLevel(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default int getWaterTankLevel(java.util.Map<String, String> context)
    {
        return _iceI_getWaterTankLevelAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.lang.Integer> getWaterTankLevelAsync()
    {
        return _iceI_getWaterTankLevelAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Integer> getWaterTankLevelAsync(java.util.Map<String, String> context)
    {
        return _iceI_getWaterTankLevelAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Integer> _iceI_getWaterTankLevelAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Integer> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getWaterTankLevel", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     int ret;
                     ret = istr.readInt();
                     return ret;
                 });
        return f;
    }

    default void refillTank()
    {
        refillTank(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void refillTank(java.util.Map<String, String> context)
    {
        _iceI_refillTankAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> refillTankAsync()
    {
        return _iceI_refillTankAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> refillTankAsync(java.util.Map<String, String> context)
    {
        return _iceI_refillTankAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_refillTankAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "refillTank", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(false, context, null, null, null);
        return f;
    }

    default void turnOnHumidifierMode()
        throws EmptyWaterTankException
    {
        turnOnHumidifierMode(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void turnOnHumidifierMode(java.util.Map<String, String> context)
        throws EmptyWaterTankException
    {
        try
        {
            _iceI_turnOnHumidifierModeAsync(context, true).waitForResponseOrUserEx();
        }
        catch(EmptyWaterTankException ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<Void> turnOnHumidifierModeAsync()
    {
        return _iceI_turnOnHumidifierModeAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> turnOnHumidifierModeAsync(java.util.Map<String, String> context)
    {
        return _iceI_turnOnHumidifierModeAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_turnOnHumidifierModeAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "turnOnHumidifierMode", com.zeroc.Ice.OperationMode.Idempotent, sync, _iceE_turnOnHumidifierMode);
        f.invoke(true, context, null, null, null);
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_turnOnHumidifierMode =
    {
        EmptyWaterTankException.class
    };

    default void turnOffHumidifierMode()
    {
        turnOffHumidifierMode(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void turnOffHumidifierMode(java.util.Map<String, String> context)
    {
        _iceI_turnOffHumidifierModeAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> turnOffHumidifierModeAsync()
    {
        return _iceI_turnOffHumidifierModeAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> turnOffHumidifierModeAsync(java.util.Map<String, String> context)
    {
        return _iceI_turnOffHumidifierModeAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_turnOffHumidifierModeAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "turnOffHumidifierMode", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(false, context, null, null, null);
        return f;
    }

    default boolean isHumidifierTurnedOn()
    {
        return isHumidifierTurnedOn(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default boolean isHumidifierTurnedOn(java.util.Map<String, String> context)
    {
        return _iceI_isHumidifierTurnedOnAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> isHumidifierTurnedOnAsync()
    {
        return _iceI_isHumidifierTurnedOnAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> isHumidifierTurnedOnAsync(java.util.Map<String, String> context)
    {
        return _iceI_isHumidifierTurnedOnAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> _iceI_isHumidifierTurnedOnAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "isHumidifierTurnedOn", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     boolean ret;
                     ret = istr.readBool();
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
    static AirPurifierWithHumidifierPrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), AirPurifierWithHumidifierPrx.class, _AirPurifierWithHumidifierPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static AirPurifierWithHumidifierPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), AirPurifierWithHumidifierPrx.class, _AirPurifierWithHumidifierPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static AirPurifierWithHumidifierPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), AirPurifierWithHumidifierPrx.class, _AirPurifierWithHumidifierPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static AirPurifierWithHumidifierPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), AirPurifierWithHumidifierPrx.class, _AirPurifierWithHumidifierPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static AirPurifierWithHumidifierPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, AirPurifierWithHumidifierPrx.class, _AirPurifierWithHumidifierPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static AirPurifierWithHumidifierPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, AirPurifierWithHumidifierPrx.class, _AirPurifierWithHumidifierPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default AirPurifierWithHumidifierPrx ice_context(java.util.Map<String, String> newContext)
    {
        return (AirPurifierWithHumidifierPrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default AirPurifierWithHumidifierPrx ice_adapterId(String newAdapterId)
    {
        return (AirPurifierWithHumidifierPrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default AirPurifierWithHumidifierPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (AirPurifierWithHumidifierPrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default AirPurifierWithHumidifierPrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (AirPurifierWithHumidifierPrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default AirPurifierWithHumidifierPrx ice_invocationTimeout(int newTimeout)
    {
        return (AirPurifierWithHumidifierPrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default AirPurifierWithHumidifierPrx ice_connectionCached(boolean newCache)
    {
        return (AirPurifierWithHumidifierPrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default AirPurifierWithHumidifierPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (AirPurifierWithHumidifierPrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default AirPurifierWithHumidifierPrx ice_secure(boolean b)
    {
        return (AirPurifierWithHumidifierPrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default AirPurifierWithHumidifierPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (AirPurifierWithHumidifierPrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default AirPurifierWithHumidifierPrx ice_preferSecure(boolean b)
    {
        return (AirPurifierWithHumidifierPrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default AirPurifierWithHumidifierPrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (AirPurifierWithHumidifierPrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default AirPurifierWithHumidifierPrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (AirPurifierWithHumidifierPrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default AirPurifierWithHumidifierPrx ice_collocationOptimized(boolean b)
    {
        return (AirPurifierWithHumidifierPrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default AirPurifierWithHumidifierPrx ice_twoway()
    {
        return (AirPurifierWithHumidifierPrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default AirPurifierWithHumidifierPrx ice_oneway()
    {
        return (AirPurifierWithHumidifierPrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default AirPurifierWithHumidifierPrx ice_batchOneway()
    {
        return (AirPurifierWithHumidifierPrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default AirPurifierWithHumidifierPrx ice_datagram()
    {
        return (AirPurifierWithHumidifierPrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default AirPurifierWithHumidifierPrx ice_batchDatagram()
    {
        return (AirPurifierWithHumidifierPrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default AirPurifierWithHumidifierPrx ice_compress(boolean co)
    {
        return (AirPurifierWithHumidifierPrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default AirPurifierWithHumidifierPrx ice_timeout(int t)
    {
        return (AirPurifierWithHumidifierPrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default AirPurifierWithHumidifierPrx ice_connectionId(String connectionId)
    {
        return (AirPurifierWithHumidifierPrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default AirPurifierWithHumidifierPrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (AirPurifierWithHumidifierPrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::airPurifierController::AirPurifierWithHumidifier";
    }
}
