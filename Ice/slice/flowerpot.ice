

#ifndef SMARTHOME_ICE
#define SMARTHOME_ICE

module flowerpotController{
        enum lightPowerLevel { LOW, MEDIUM, HIGH };

     exception OverwaterError {
        string reason = "your plant is literally swimming";
     };

     exception OverdryError {
             string reason = "your plant is literally swimming";
          };


    interface Flowerpot{
        idempotent int getCurrentHumidity();
        void water(int mililiters) throws OverwaterError ;
        idempotent lightPowerLevel getCurrentLightPowerLevel();
        void setLightPowerLeveL(lightPowerLevel powerLevel) throws OverdryError ;
    };
};

#endif