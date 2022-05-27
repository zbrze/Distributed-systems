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

public enum dayOfWeek implements java.io.Serializable
{
    MONDAY(0),
    TUESDAY(1),
    WEDNESDAY(2),
    THURSDAY(3),
    FRIDAY(4),
    SATURDAY(5),
    SUNDAY(6);

    public int value()
    {
        return _value;
    }

    public static dayOfWeek valueOf(int v)
    {
        switch(v)
        {
        case 0:
            return MONDAY;
        case 1:
            return TUESDAY;
        case 2:
            return WEDNESDAY;
        case 3:
            return THURSDAY;
        case 4:
            return FRIDAY;
        case 5:
            return SATURDAY;
        case 6:
            return SUNDAY;
        }
        return null;
    }

    private dayOfWeek(int v)
    {
        _value = v;
    }

    public void ice_write(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeEnum(_value, 6);
    }

    public static void ice_write(com.zeroc.Ice.OutputStream ostr, dayOfWeek v)
    {
        if(v == null)
        {
            ostr.writeEnum(thermostatController.dayOfWeek.MONDAY.value(), 6);
        }
        else
        {
            ostr.writeEnum(v.value(), 6);
        }
    }

    public static dayOfWeek ice_read(com.zeroc.Ice.InputStream istr)
    {
        int v = istr.readEnum(6);
        return validate(v);
    }

    public static void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<dayOfWeek> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    public static void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, dayOfWeek v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.Size))
        {
            ice_write(ostr, v);
        }
    }

    public static java.util.Optional<dayOfWeek> ice_read(com.zeroc.Ice.InputStream istr, int tag)
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

    private static dayOfWeek validate(int v)
    {
        final dayOfWeek e = valueOf(v);
        if(e == null)
        {
            throw new com.zeroc.Ice.MarshalException("enumerator value " + v + " is out of range");
        }
        return e;
    }

    private final int _value;
}
