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

public class OverwaterError extends com.zeroc.Ice.UserException
{
    public OverwaterError()
    {
        this.reason = "your plant is literally swimming";
    }

    public OverwaterError(Throwable cause)
    {
        super(cause);
        this.reason = "your plant is literally swimming";
    }

    public OverwaterError(String reason)
    {
        this.reason = reason;
    }

    public OverwaterError(String reason, Throwable cause)
    {
        super(cause);
        this.reason = reason;
    }

    public String ice_id()
    {
        return "::flowerpotController::OverwaterError";
    }

    public String reason;

    /** @hidden */
    @Override
    protected void _writeImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice("::flowerpotController::OverwaterError", -1, true);
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
    public static final long serialVersionUID = -8492646011855674727L;
}
