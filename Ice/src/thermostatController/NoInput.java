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

public class NoInput extends com.zeroc.Ice.UserException
{
    public NoInput()
    {
        this.reason = "no hours schedule provided";
    }

    public NoInput(Throwable cause)
    {
        super(cause);
        this.reason = "no hours schedule provided";
    }

    public NoInput(String reason)
    {
        this.reason = reason;
    }

    public NoInput(String reason, Throwable cause)
    {
        super(cause);
        this.reason = reason;
    }

    public String ice_id()
    {
        return "::thermostatController::NoInput";
    }

    public String reason;

    /** @hidden */
    @Override
    protected void _writeImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice("::thermostatController::NoInput", -1, true);
        ostr_.writeString(reason);
        ostr_.endSlice();
    }

    /** @hidden */
    @Override
    protected void _readImpl(com.zeroc.Ice.InputStream istr_)
    {
        istr_.startSlice();
        reason = istr_.readString();
        istr_.endSlice();
    }

    /** @hidden */
    public static final long serialVersionUID = 4827580455099541432L;
}
