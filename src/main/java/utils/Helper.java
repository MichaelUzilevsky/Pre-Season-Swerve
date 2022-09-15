package utils;

import frc.robot.Constants;

public  class Helper {

    public static double pulses_per_meter_to_meter(double pulses){
        return pulses / Constants.PULSES_PER_METER; 
    }
    public static double pulses_per_01second_to_meter_per_second(double pulses){
        return pulses / Constants.PULSES_PER_METER * 10;
    }
}
