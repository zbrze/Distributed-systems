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
                raise RuntimeError("Thermostat proxy error")


    air_purifier_commands = "Air purifier commands:\n" \
                            "->changeFilter(1) - changes device filter (makes it's wear percentage go to zero)\n" \
                            "->filterInfo(2) (returns filter wear percentage)\n" \
                            "->setPower(3) [1/2/3] - sets device power (contributes to wear of filter - if filter is worn out it might be impossible to change power)\n" \
                            "->getPower(4) - returns current power level\n" \
                            "->airQuality(5) - returns current air quality\n"

    flowerpot_commands = "Flowerpot commands:\n" \
                         "->water(1) [int - mililiters] - waters the plant if possible (if plant is already watered enough throws an error)\n" \
                         "->getHumidity(2) - returns current humidity percentage\n" \
                         "->setLightPower(3) [LOW/MEDIUM/HIGH] - sets the power of light (could be impossible if humidity is too low - Overdry error is thrown then\n" \
                         "->getLightPower(4) - returns current light power level\n"

    thermostat_commands = "Thermostat commands:\n" \
                          "->currentTemperature(1) - returns current temperature\n" \
                          "->getSchedule(2) [1/2/3/4/5/6/7] [0-23] - returns temperatures schedulded for provided day and hour" \
                          "->getSchedule(2) [1/2/3/4/5/6/7] - returns temperatures schedulded for provided day" \
                          "->getSchedule(2) - returns whole week schedule\n" \
                          "->schedule(3) [1/2/3/4/5/6/7] [0-23] [FLOAT] - schedules temperature (float) on provided day and hour\n" \
                          "->schedule(3) [1/2/3/4/5/6/7] [(0-23;FLOAT),(0-23;FLOAT),...] - schedules provided temperatures (float) and hours on provided day\n" \
                          "->setTempature(4) [FLOAT] - sets current temperature\n" \
                          "->changeUnit(5) [K/C/F] - sets current unit (Kelvin/Celsius/Fahrenheit)\n"

    print("To close write 'exit'")


    line = ""
    while line != "exit" or device != "exit":
        device = input("provide device to use [ " + str(thermostats.keys()).strip("dict_keys").strip("(['").strip("'])")
                       + ",  " + str(flowerpots.keys()).strip("dict_keys").strip("(['").strip("'])")
                       + ", " + str(air_purifiers.keys()).strip("dict_keys").strip("(['").strip("'])") + " ]: ")
        if "thermostat" in device.lower():
            print(thermostat_commands)
            line = input("provide command: ")
            command = line.split()[0].lower()
            if command == "currenttemperature" or command == "1":
                print("Current temperature set on " + device + ": " + str(thermostats[device.lower()].getCurrentTemperature()))
            if command == "getschedule" or command == "2":
                if len(line.split()) == 1:
                    request = thermostats[device.lower()].getWeekSchedule()
                    for day_schedule in request:
                        print(day_schedule.day)
                        schedule = ""
                        for hour_schedule in day_schedule.hoursSchedule:
                            schedule += (str(hour_schedule.hour) +":00 - " + str(hour_schedule.temperature)) + " | "
                        print(schedule + "\n")
                elif len(line.split()) == 2:
                    try:
                        day = calendar.day_name[int(line.split()[1]) -1]
                        request = thermostats[device.lower()].getDaySchedule(day)
                    except:
                        print("wrong input")
                elif len(line.split()) == 3:
                    try:
                        day = calendar.day_name[int(line.split()[1]) - 1]
                        request = thermostats[device.lower()].getDayaSchedule(day, int(line.split()[2]))
                    except:
                        print("wrong arguments")
            if command == "schedule" or command == "3":
                if len(line.split()) == 4:
                    try:
                        day = int_to_weekday(int(line.split()[1]))
                        hour = int(line.split()[2])
                        temperature = float(line.split()[3])
                        print("scheduling " + str(temperature) +" for " + str(calendar.day_name[day] -1) + " " + str(hour) )
                        request = thermostats[device.lower()].scheduleTemperatureForHour(day, hour, temperature)
                    except:
                        print("wrong arguments")
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
        if "airpurifier" in device.lower():
            print(air_purifier_commands)
            line = input("provide command: ")
            command = line.split()[0].lower()
            if command == "changefilter" or command == "1":
                request = air_purifiers[device.lower()].changeFilter()
                print("Filter changed, current filter wear percentage: " + str(air_purifiers[device.lower()].getFilterWearPercentage()))
            if command == "filterinfo" or command == "2":
                print("Current filter wear percentage: "  + str(air_purifiers[device.lower()].getFilterWearPercentage()))
            if command == "setpower" or command == "3":
                try:
                    arg = int(line.split()[1])
                    power = airPurifier.powerLevel.LOW if arg == 1 else (airPurifier.powerLevel.MEDIUM if arg == 2 else (airPurifier.powerLevel.HIGH  if arg == 3 else "error"))
                    request = air_purifiers[device.lower()].setCurrentPower(power)
                except ValueError:
                     print("Wrong value provided")
            if command == "getpower" or command == "4":
                print("Current power: " + air_purifiers[device.lower()].getCurrentPower())

        if "flowerpot" in device.lower():
            print(flowerpot_commands)
            line = input("provide command: ")
            command = line.split()[0].lower()
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

