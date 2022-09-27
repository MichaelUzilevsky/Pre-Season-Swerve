package utils;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.AbsoluteSensorRange;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.math.controller.PIDController;

public class SwerveMudule {
    private TalonFX move_motor;
    private TalonFX steer_motor;
    private CANCoder encouder;
    private PIDController steer_Controller;

    public SwerveMudule(int move_motor_id, int steer_motor_id, int encouder_id) {
        this.setMove_motor(new TalonFX(move_motor_id));
        this.setSteer_motor(new TalonFX(steer_motor_id));
        this.setEncouder(new CANCoder(encouder_id));
    }

    
    public TalonFX getMove_motor() {
        return move_motor;
    }

    public void setMove_motor(TalonFX move_motor) {
        this.move_motor = move_motor;
    }

    public TalonFX getSteer_motor() {
        return steer_motor;
    }

    public void setSteer_motor(TalonFX steer_motor) {
        this.steer_motor = steer_motor;
    }

    public CANCoder getEncouder() {
        return encouder;
    }

    public void setEncouder(CANCoder encouder) {
        this.encouder = encouder;
    }

    //meter per second
    public double get_velocity() {
       return Helper.pulses_per_01second_to_meter_per_second(move_motor.getSelectedSensorVelocity());
    }

    public void config_CANEncoder(){
        this.encouder.setPositionToAbsolute();
        this.encouder.configAbsoluteSensorRange(AbsoluteSensorRange.Unsigned_0_to_360);
    }


}
