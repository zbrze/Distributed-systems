

#ifndef FLOWERPOTCONTROLLER_ICE
#define FLOWERPOTCONTROLLER_ICE

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
        void setLightPowerLevel(lightPowerLevel powerLevel) throws OverdryError ;
    };
};

#endif