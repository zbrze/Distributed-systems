import calendar
import Ice
import sys
import serverMiddleware
import airPurifierController as airPurifier
import flowerpotController as flowerpot
import thermostatController as thermostat

def int_to_weekday(i):
    if i == 1:
        return thermostat.dayOfWeek.MONDAY
    if i == 2:
        return thermostat.dayOfWeek.TUESDAY
    if i == 3:
        return thermostat.dayOfWeek.WEDNESDAY
    if i == 4:
        return thermostat.dayOfWeek.THURSDAY
    if i == 5:
        return thermostat.dayOfWeek.FRIDAY
    if i == 6:
        return thermostat.dayOfWeek.SATURDAY
    if i == 7:
        return thermostat.dayOfWeek.SUNDAY

class Client:
    def __init__(self):
        pass


if __name__ == "__main__":

    communicator = Ice.initialize(sys.argv)
    server_middleware_proxy = communicator.stringToProxy("server/server:tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p 10000 -z")
    try:
        server = serverMiddleware.ServerPrx.checkedCast(server_middleware_proxy)
    except ConnectionRefusedError:
        print("Exception occurred during connection. Server refused connection.")

    if not server:
        raise  RuntimeError("Proxy error")

    devices_list = server.listAllDevices()
    thermostats = {}
    air_purifiers = {}
    flowerpots = {}
    for device in devices_list:
        if(device.category == "thermostat"):
            thermostat_proxy = communicator.stringToProxy(device.category +"/" + device.name +":" +device.port)
            try:
                thermostats.update({device.name : thermostat.ThermostatPrx.checkedCast(thermostat_proxy)})
            except ConnectionRefusedError:
                print("Exception occurred during thermostat connection. Server refused connection.")
            if not thermostats[device.name]:
                raise RuntimeError("Thermostat proxy error")
        if(device.category == "flowerpot"):
            flowerpot_proxy = communicator.stringToProxy(device.category + "/" + device.name + ":" + device.port)
            try:
                flowerpots.update({device.name: flowerpot.FlowerpotPrx.checkedCast(flowerpot_proxy)})
            except ConnectionRefusedError:
                print("Exception occurred during flowerpot connection. Server refused connection.")
            if not flowerpots[device.name]:
                raise RuntimeError("Flowerpot proxy error")
        if(device.category == "airpurifier"):
            air_purifier_proxy = communicator.stringToProxy(device.category + "/" + device.name + ":" + device.port)
            try:
                air_purifiers.update({device.name: airPurifier.AirPurifierPrx.checkedCast(air_purifier_proxy)})
            except ConnectionRefusedError:
                print("Exception occurred during air purifier connection. Server refused connection.")
            if not air_purifiers[device.name]:
                raise RuntimeError("Airpurifier proxy error")
        if (device.category == "airpurifierwithhumidifier"):
            air_purifier_proxy = communicator.stringToProxy(device.category + "/" + device.name + ":" + device.port)
            try:
                air_purifiers.update({device.name: airPurifier.AirPurifierWithHumidifierPrx.checkedCast(air_purifier_proxy)})
            except ConnectionRefusedError:
                print("Exception occurred during air purifier connection. Server refused connection.")
            if not air_purifiers[device.name]:
                raise RuntimeError("Air purifier with humidifier proxy error")

    air_purifier_commands = "Air purifier commands:\n" \
                            "->changeFilter(1) - changes device filter (makes it's wear percentage go to zero)\n" \
                            "->filterInfo(2) (returns filter wear percentage)\n" \
                            "->setPower(3) [1/2/3] - sets device power (contributes to wear of filter - if filter is worn out it might be impossible to change power)\n" \
                            "->getPower(4) - returns current power level\n" \
                            "->airQuality(5) - returns current air quality\n"

    air_purifier_with_humidifier_commands = "Air purifier with humidifier commands:\n" \
                                            "->on(6) - turns humidifier mode on \n" \
                                            "->off(7) - turns humidifier mode off \n" \
                                            "->state(8) - returns if humidifier is on or off\n" \
                                            "->getHumidity(9) - returns current humidity\n" \
                                            "->waterTankLevel(10) - returns current water tank level\n" \
                                            "->refillTank(11) - refill tans to full\n" \

    flowerpot_commands = "Flowerpot commands:\n" \
                         "->water(1) [int - mililiters] - waters the plant if possible (if plant is already watered enough throws an error)\n" \
                         "->getHumidity(2) - returns current humidity percentage\n" \
                         "->setLightPower(3) [1/2/3] - sets the power of light (could be impossible if humidity is too low - Overdry error is thrown then\n" \
                         "->getLightPower(4) - returns current light power level\n"

    thermostat_commands = "Thermostat commands:\n" \
                          "->currentTemperature(1) - returns current temperature\n" \
                          "->getSchedule(2) [1/2/3/4/5/6/7] [0-23] - returns temperatures schedulded for provided day and hour\n" \
                          "->getSchedule(2) [1/2/3/4/5/6/7] - returns temperatures schedulded for provided day\n" \
                          "->getSchedule(2) - returns whole week schedule\n" \
                          "->schedule(3) [1/2/3/4/5/6/7] [0-23] [FLOAT] - schedules temperature (float) on provided day and hour\n" \
                          "->schedule(3) [1/2/3/4/5/6/7] [(0-23;FLOAT),(0-23;FLOAT),...] - schedules provided temperatures (float) and hours on provided day\n" \
                          "->setTempature(4) [FLOAT] - sets current temperature\n" \
                          "->changeUnit(5) [K/C/F] - sets current unit (Kelvin/Celsius/Fahrenheit)\n"

    print("To close write 'exit'")


    line = ""
    device =""
    while True:
        device = input("provide device to use [ " + str(thermostats.keys()).strip("dict_keys").strip("(['").strip("'])")
                       + ",  " + str(flowerpots.keys()).strip("dict_keys").strip("(['").strip("'])")
                       + ", " + str(air_purifiers.keys()).strip("dict_keys").strip("(['").strip("'])") + " ]: ")
        if device == "exit": break
        if "thermostat" in device.lower() and device.lower().strip() in thermostats:
            print(thermostat_commands)
            line = input("provide command: ")
            command = line.split()[0].lower()
            if command == "exit": break
            if command == "currenttemperature" or command == "1":
                print("Current temperature set on " + device + ": " + str(thermostats[device.lower()].getCurrentTemperature()) + " " + str(thermostats[device.lower()].getCurrentUnit()))

            if command == "getschedule" or command == "2":
                if len(line.split()) == 1:
                    request = thermostats[device.lower()].getWeekSchedule()
                    for day_schedule in request:
                        print(day_schedule.day)
                        schedule = ""
                        for hour_schedule in day_schedule.hoursSchedule:
                            schedule += (str(hour_schedule.hour) +":00 - " + str(hour_schedule.temperature)) + " " + str(thermostats[device.lower()].getCurrentUnit()) + " | "
                        print(schedule + "\n")

                elif len(line.split()) == 2:
                    try:
                        day = int_to_weekday(int(line.split()[1]))
                        request = thermostats[device.lower()].getDaySchedule(day)
                        schedule = ""
                        for hour_schedule in request.hoursSchedule:
                            schedule += (str(hour_schedule.hour) + ":00 - " + str(
                                hour_schedule.temperature)) + " " + str(
                                thermostats[device.lower()].getCurrentUnit()) + " | "
                        print(schedule + "\n")
                    except IndexError:
                        print("No argument provided")
                    except ValueError:
                        print("Wrong value provided")

                elif len(line.split()) == 3:
                    try:
                        day = int_to_weekday(int(line.split()[1]))
                        hour = int(line.split()[2])
                        request = thermostats[device.lower()].getTemperatureScheduledForHour(day, hour)
                        print("Temperature scheduled for " + str(day) +" " + str(hour) + ":00 - " + str(request) + " "+ str(thermostats[device.lower()].getCurrentUnit()))
                    except IndexError:
                        print("No argument provided")
                    except ValueError:
                        print("Wrong value provided")
            if command == "schedule" or command == "3":
                if len(line.split()) == 4:
                    try:
                        day = int_to_weekday(int(line.split()[1]))
                        hour = int(line.split()[2])
                        temperature = float(line.split()[3])
                        print("scheduling " + str(temperature) + " " + str(thermostats[device.lower()].getCurrentUnit()) +" for " + str(day) + " " + str(hour) + ":00" )
                        request = thermostats[device.lower()].scheduleTemperatureForHour(day, hour, temperature)
                    except IndexError:
                        print("No argument provided")
                    except ValueError:
                        print("Wrong value provided")
                if len(line.split()) == 3:
                    try:
                        day = calendar.day_name[int(line.split()[1]) -1]
                        day_schedule = []
                        hours = (line.split()[2]).split(",")
                        for hour in hours:
                            hour_temperature = hour.strip("(").strip(")").split(";")
                            hour_schedule = thermostat.HourSchedule()
                            hour_schedule.hour = int(hour_temperature[0])
                            hour_schedule.temperature = float(hour_temperature[1])
                            day_schedule.append(hour_schedule)
                        request = thermostats[device.lower()].scheduleTemperatureForDay(day, day_schedule)
                    except:
                        print("input error")
                else:
                    print("wrong number of arguments")

            if command == "settemperature" or command == "4":
                try:
                    arg = float(line.split()[1])
                    request = thermostats[device.lower()].setCurrentTemperature(arg)
                    print("Current temperature set on " + device.lower() +": " + thermostats[device.lower()].getCurrentTemperature())
                except IndexError:
                    print("No argument provided")
                except ValueError:
                     print("Wrong value provided")

            if command == "changeunit" or command == "5":
                try:
                    arg = line.split()[1].lower()
                    unit = power = thermostat.temperatureUnits.K if arg == "k" else \
                        (thermostat.temperatureUnits.C if arg == "c" else
                         (thermostat.temperatureUnits.F  if arg == "f" else "error"))
                    request = thermostats[device.lower()].changeUnit(unit)
                    print("Current unit: " + str(thermostats[device.lower()].getCurrentUnit()))
                except IndexError:
                    print("No argument provided")
                except ValueError:
                     print("Wrong value provided")


        if ("airpurifier" in device.lower() or "airpurifierwithhumidifier" in device.lower()) and device.lower().strip() in air_purifiers:
            print(air_purifier_commands)
            if "airpurifierwithhumidifier" in device.lower():
                print(air_purifier_with_humidifier_commands)
            line = input("provide command: ")
            command = line.split()[0].lower()
            if command == "exit": break
            if command == "changefilter" or command == "1":
                request = air_purifiers[device.lower()].changeFilter()
                print("Filter changed, current filter wear percentage: " + str(air_purifiers[device.lower()].getFilterWearPercentage()))

            if command == "filterinfo" or command == "2":
                print("Current filter wear percentage: "  + str(air_purifiers[device.lower()].getFilterWearPercentage()))

            if command == "setpower" or command == "3":
                try:
                    arg = int(line.split()[1])
                    power = airPurifier.powerLevel.LOW if arg == 1 else \
                        (airPurifier.powerLevel.MEDIUM if arg == 2 else
                         (airPurifier.powerLevel.HIGH  if arg == 3 else "error"))
                    request = air_purifiers[device.lower()].setCurrentPower(power)
                except ValueError:
                     print("Wrong value provided")
                except IndexError:
                    print("No argument provided")
                except airPurifier.WornoutFilterException:
                    print("Filter is worn out - need to change it before setting power")
            if command == "getpower" or command == "4":
                print("Current power: " + air_purifiers[device.lower()].getCurrentPower())
            if command == "airquality" or command == "5":
                print("Current air quality: " + air_purifiers[device.lower()].getCurrentPower())
            if "airpurifierwithhumidifier" in device.lower():
                if command == "on" or command == "6":
                    if(air_purifiers[device.lower()].isHumidifierTurnedOn()):
                        print("Humidifier mode already on")
                    else:
                        try:
                            air_purifiers[device.lower()].turnOnHumidifierMode()
                            print(str(air_purifiers[device.lower()]) +": humidifier mode turned on")
                        except airPurifier.EmptyWaterTankException:
                            print("Cant turn humidifier mode on - refill the water tank first")
                if command == "off" or command == "7":
                    if not air_purifiers[device.lower()].isHumidifierTurnedOn():
                        print("Humidifier mode already off")
                    else:
                        air_purifiers[device.lower()].turnOffHumidifierMode()
                        print(str(air_purifiers[device.lower()]) +": humidifier mode turned off")
                if command == "state" or command == "8":
                    if air_purifiers[device.lower()].isHumidifierTurnedOn():
                        print(str(air_purifiers[device.lower()]) + " is on")
                    else:
                        print(str(air_purifiers[device.lower()]) + " is off")
                if command == "gethumidity" or command == "9":
                    try:
                        print("Current humidity percentage: " + str(air_purifiers[device.lower()].getHumidityPercentage()))
                    except airPurifier.TurnedOffException:
                        print("Turn on th mumidifier mode first")
                if command == "watertanklevel" or command == "10":
                    print(device.lower() + "'s water tank percentage: " + str(air_purifiers[device.lower()].getWaterTankLevel()))
                if command == "refilltank" or command == "11":
                    air_purifiers[device.lower()].refillTank()
                    print(device.lower() +"'s tank is refilled")

        if "flowerpot" in device.lower() and device.lower().strip() in flowerpots:
            print(flowerpot_commands)
            line = input("provide command: ")
            command = line.split()[0].lower()
            if command == "exit": break

            if command == "water" or command == "1":
                try:
                    ml = int(line.split()[1])
                    request = flowerpots[device.lower()].water(ml)
                    print("Flower watered")
                except IndexError:
                    print("No argument provided")
                except ValueError:
                     print("Wrong value provided")
                except flowerpot.OverwaterError:
                    print("Your flower is aleady swimming")

            if command == "gethumidity" or command == "2":
                print("Current humidity is: " + str(flowerpots[device.lower()].getCurrentHumidity()))

            if command == "setlightpower" or command == "3":
                try:
                    arg = int(line.split()[1])
                    power = flowerpot.lightPowerLevel.LOW if arg == 1 else (
                        flowerpot.lightPowerLevel.MEDIUM if arg == 2 else (
                        flowerpot.lightPowerLevel.HIGH if arg == 3 else "error"))
                    request = flowerpots[device.lower()].setLightPowerLevel(power)
                except IndexError:
                    print("No argument provided")
                except ValueError:
                     print("Wrong value provided")
                except flowerpot.OverdryError:
                    print("Your flower has no water! You cant set higher light power.")
            if command == "getlightpower" or command == "4":
                print(device.lower() + " current light power level: " + str(flowerpots[device.lower()].getCurrentLightPowerLevel()))

    if communicator is not None:
        communicator.destroy()
