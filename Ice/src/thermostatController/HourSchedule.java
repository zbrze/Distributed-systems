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

public class HourSchedule implements java.lang.Cloneable,
                                     java.io.Serializable
{
    public float temperature;

    public int hour;

    public HourSchedule()
    {
    }

    public HourSchedule(float temperature, int hour)
    {
        this.temperature = temperature;
        this.hour = hour;
    }

    public boolean equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        HourSchedule r = null;
        if(rhs instanceof HourSchedule)
        {
            r = (HourSchedule)rhs;
        }

        if(r != null)
        {
            if(this.temperature != r.temperature)
            {
                return false;
            }
            if(this.hour != r.hour)
            {
                return false;
            }

            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int h_ = 5381;
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::thermostatController::HourSchedule");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, temperature);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, hour);
        return h_;
    }

    public HourSchedule clone()
    {
        HourSchedule c = null;
        try
        {
            c = (HourSchedule)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeFloat(this.temperature);
        ostr.writeInt(this.hour);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.temperature = istr.readFloat();
        this.hour = istr.readInt();
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, HourSchedule v)
    {
        if(v == null)
        {
            _nullMarshalValue.ice_writeMembers(ostr);
        }
        else
        {
            v.ice_writeMembers(ostr);
        }
    }

    static public HourSchedule ice_read(com.zeroc.Ice.InputStream istr)
    {
        HourSchedule v = new HourSchedule();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<HourSchedule> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, HourSchedule v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.VSize))
        {
            ostr.writeSize(8);
            ice_write(ostr, v);
        }
    }

    static public java.util.Optional<HourSchedule> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.VSize))
        {
            istr.skipSize();
            return java.util.Optional.of(HourSchedule.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final HourSchedule _nullMarshalValue = new HourSchedule();

    /** @hidden */
    public static final long serialVersionUID = -2443070043408224475L;
}
