//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.7
//
// <auto-generated>
//
// Generated from file `flowerpot.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package flowerpotController;

public enum lightPowerLevel implements java.io.Serializable
{
    LOW(0),
    MEDIUM(1),
    HIGH(2);

    public int value()
    {
        return _value;
    }

    public static lightPowerLevel valueOf(int v)
    {
        switch(v)
        {
        case 0:
            return LOW;
        case 1:
            return MEDIUM;
        case 2:
            return HIGH;
        }
        return null;
    }

    private lightPowerLevel(int v)
    {
        _value = v;
    }

    public void ice_write(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeEnum(_value, 2);
    }

    public static void ice_write(com.zeroc.Ice.OutputStream ostr, lightPowerLevel v)
    {
        if(v == null)
        {
            ostr.writeEnum(flowerpotController.lightPowerLevel.LOW.value(), 2);
        }
        else
        {
            ostr.writeEnum(v.value(), 2);
        }
    }

    public static lightPowerLevel ice_read(com.zeroc.Ice.InputStream istr)
    {
        int v = istr.readEnum(2);
        return validate(v);
    }

    public static void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<lightPowerLevel> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    public static void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, lightPowerLevel v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.Size))
        {
            ice_write(ostr, v);
        }
    }

    public static java.util.Optional<lightPowerLevel> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.Size))
        {
            return java.util.Optional.of(ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static lightPowerLevel validate(int v)
    {
        final lightPowerLevel e = valueOf(v);
        if(e == null)
        {
            throw new com.zeroc.Ice.MarshalException("enumerator value " + v + " is out of range");
        }
        return e;
    }

    private final int _value;
}