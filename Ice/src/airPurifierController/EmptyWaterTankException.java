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

public class EmptyWaterTankException extends com.zeroc.Ice.UserException
{
    public EmptyWaterTankException()
    {
    }

    public EmptyWaterTankException(Throwable cause)
    {
        super(cause);
    }

    public String ice_id()
    {
        return "::airPurifierController::EmptyWaterTankException";
    }

    /** @hidden */
    @Override
    protected void _writeImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice("::airPurifierController::EmptyWaterTankException", -1, true);
        ostr_.endSlice();
    }

    /** @hidden */
    @Override
    protected void _readImpl(com.zeroc.Ice.InputStream istr_)
    {
        istr_.startSlice();
        istr_.endSlice();
    }

    /** @hidden */
    public static final long serialVersionUID = 870205896785161952L;
}