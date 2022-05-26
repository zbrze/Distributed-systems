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

public enum airQuality implements java.io.Serializable
{
    GOOD(0),
    MODERATE(1),
    UNHEALTHY(2);

    public int value()
    {
        return _value;
    }

    public static airQuality valueOf(int v)
    {
        switch(v)
        {
        case 0:
            return GOOD;
        case 1:
            return MODERATE;
        case 2:
            return UNHEALTHY;
        }
        return null;
    }

    private airQuality(int v)
    {
        _value = v;
    }

    public void ice_write(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeEnum(_value, 2);
    }

    public static void ice_write(com.zeroc.Ice.OutputStream ostr, airQuality v)
    {
        if(v == null)
        {
            ostr.writeEnum(airPurifierController.airQuality.GOOD.value(), 2);
        }
        else
        {
            ostr.writeEnum(v.value(), 2);
        }
    }

    public static airQuality ice_read(com.zeroc.Ice.InputStream istr)
    {
        int v = istr.readEnum(2);
        return validate(v);
    }

    public static void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<airQuality> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    public static void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, airQuality v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.Size))
        {
            ice_write(ostr, v);
        }
    }

    public static java.util.Optional<airQuality> ice_read(com.zeroc.Ice.InputStream istr, int tag)
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

    private static airQuality validate(int v)
    {
        final airQuality e = valueOf(v);
        if(e == null)
        {
            throw new com.zeroc.Ice.MarshalException("enumerator value " + v + " is out of range");
        }
        return e;
    }

    private final int _value;
}
