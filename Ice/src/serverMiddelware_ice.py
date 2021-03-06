# -*- coding: utf-8 -*-
#
# Copyright (c) ZeroC, Inc. All rights reserved.
#
#
# Ice version 3.7.7
#
# <auto-generated>
#
# Generated from file `serverMiddelware.ice'
#
# Warning: do not edit this file.
#
# </auto-generated>
#

from sys import version_info as _version_info_
import Ice, IcePy

# Start of module serverMiddleware
_M_serverMiddleware = Ice.openModule('serverMiddleware')
__name__ = 'serverMiddleware'

if 'Device' not in _M_serverMiddleware.__dict__:
    _M_serverMiddleware.Device = Ice.createTempClass()
    class Device(object):
        def __init__(self, name='', category='', port=''):
            self.name = name
            self.category = category
            self.port = port

        def __hash__(self):
            _h = 0
            _h = 5 * _h + Ice.getHash(self.name)
            _h = 5 * _h + Ice.getHash(self.category)
            _h = 5 * _h + Ice.getHash(self.port)
            return _h % 0x7fffffff

        def __compare(self, other):
            if other is None:
                return 1
            elif not isinstance(other, _M_serverMiddleware.Device):
                return NotImplemented
            else:
                if self.name is None or other.name is None:
                    if self.name != other.name:
                        return (-1 if self.name is None else 1)
                else:
                    if self.name < other.name:
                        return -1
                    elif self.name > other.name:
                        return 1
                if self.category is None or other.category is None:
                    if self.category != other.category:
                        return (-1 if self.category is None else 1)
                else:
                    if self.category < other.category:
                        return -1
                    elif self.category > other.category:
                        return 1
                if self.port is None or other.port is None:
                    if self.port != other.port:
                        return (-1 if self.port is None else 1)
                else:
                    if self.port < other.port:
                        return -1
                    elif self.port > other.port:
                        return 1
                return 0

        def __lt__(self, other):
            r = self.__compare(other)
            if r is NotImplemented:
                return r
            else:
                return r < 0

        def __le__(self, other):
            r = self.__compare(other)
            if r is NotImplemented:
                return r
            else:
                return r <= 0

        def __gt__(self, other):
            r = self.__compare(other)
            if r is NotImplemented:
                return r
            else:
                return r > 0

        def __ge__(self, other):
            r = self.__compare(other)
            if r is NotImplemented:
                return r
            else:
                return r >= 0

        def __eq__(self, other):
            r = self.__compare(other)
            if r is NotImplemented:
                return r
            else:
                return r == 0

        def __ne__(self, other):
            r = self.__compare(other)
            if r is NotImplemented:
                return r
            else:
                return r != 0

        def __str__(self):
            return IcePy.stringify(self, _M_serverMiddleware._t_Device)

        __repr__ = __str__

    _M_serverMiddleware._t_Device = IcePy.defineStruct('::serverMiddleware::Device', Device, (), (
        ('name', (), IcePy._t_string),
        ('category', (), IcePy._t_string),
        ('port', (), IcePy._t_string)
    ))

    _M_serverMiddleware.Device = Device
    del Device

if '_t_devices' not in _M_serverMiddleware.__dict__:
    _M_serverMiddleware._t_devices = IcePy.defineSequence('::serverMiddleware::devices', (), _M_serverMiddleware._t_Device)

_M_serverMiddleware._t_Server = IcePy.defineValue('::serverMiddleware::Server', Ice.Value, -1, (), False, True, None, ())

if 'ServerPrx' not in _M_serverMiddleware.__dict__:
    _M_serverMiddleware.ServerPrx = Ice.createTempClass()
    class ServerPrx(Ice.ObjectPrx):

        def listAllDevices(self, context=None):
            return _M_serverMiddleware.Server._op_listAllDevices.invoke(self, ((), context))

        def listAllDevicesAsync(self, context=None):
            return _M_serverMiddleware.Server._op_listAllDevices.invokeAsync(self, ((), context))

        def begin_listAllDevices(self, _response=None, _ex=None, _sent=None, context=None):
            return _M_serverMiddleware.Server._op_listAllDevices.begin(self, ((), _response, _ex, _sent, context))

        def end_listAllDevices(self, _r):
            return _M_serverMiddleware.Server._op_listAllDevices.end(self, _r)

        def addDevice(self, device, context=None):
            return _M_serverMiddleware.Server._op_addDevice.invoke(self, ((device, ), context))

        def addDeviceAsync(self, device, context=None):
            return _M_serverMiddleware.Server._op_addDevice.invokeAsync(self, ((device, ), context))

        def begin_addDevice(self, device, _response=None, _ex=None, _sent=None, context=None):
            return _M_serverMiddleware.Server._op_addDevice.begin(self, ((device, ), _response, _ex, _sent, context))

        def end_addDevice(self, _r):
            return _M_serverMiddleware.Server._op_addDevice.end(self, _r)

        @staticmethod
        def checkedCast(proxy, facetOrContext=None, context=None):
            return _M_serverMiddleware.ServerPrx.ice_checkedCast(proxy, '::serverMiddleware::Server', facetOrContext, context)

        @staticmethod
        def uncheckedCast(proxy, facet=None):
            return _M_serverMiddleware.ServerPrx.ice_uncheckedCast(proxy, facet)

        @staticmethod
        def ice_staticId():
            return '::serverMiddleware::Server'
    _M_serverMiddleware._t_ServerPrx = IcePy.defineProxy('::serverMiddleware::Server', ServerPrx)

    _M_serverMiddleware.ServerPrx = ServerPrx
    del ServerPrx

    _M_serverMiddleware.Server = Ice.createTempClass()
    class Server(Ice.Object):

        def ice_ids(self, current=None):
            return ('::Ice::Object', '::serverMiddleware::Server')

        def ice_id(self, current=None):
            return '::serverMiddleware::Server'

        @staticmethod
        def ice_staticId():
            return '::serverMiddleware::Server'

        def listAllDevices(self, current=None):
            raise NotImplementedError("servant method 'listAllDevices' not implemented")

        def addDevice(self, device, current=None):
            raise NotImplementedError("servant method 'addDevice' not implemented")

        def __str__(self):
            return IcePy.stringify(self, _M_serverMiddleware._t_ServerDisp)

        __repr__ = __str__

    _M_serverMiddleware._t_ServerDisp = IcePy.defineClass('::serverMiddleware::Server', Server, (), None, ())
    Server._ice_type = _M_serverMiddleware._t_ServerDisp

    Server._op_listAllDevices = IcePy.Operation('listAllDevices', Ice.OperationMode.Idempotent, Ice.OperationMode.Idempotent, False, None, (), (), (), ((), _M_serverMiddleware._t_devices, False, 0), ())
    Server._op_addDevice = IcePy.Operation('addDevice', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, None, (), (((), _M_serverMiddleware._t_Device, False, 0),), (), None, ())

    _M_serverMiddleware.Server = Server
    del Server

# End of module serverMiddleware
