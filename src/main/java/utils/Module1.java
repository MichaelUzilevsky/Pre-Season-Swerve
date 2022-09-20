package utils;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.CANCoder;

public class Module1 {
    private TalonFX move_motor;
    private TalonFX turn_motor;
    private CANCoder encouder;

    public Module1(int move_motor_id, int turn_motor_id, int encouder_id) {
        this.move_motor = new TalonFX(move_motor_id);
        this.turn_motor = new TalonFX(turn_motor_id);
        this.encouder = new CANCoder(encouder_id);
    }

    public TalonFX getMove_motor() {
        return move_motor;
    }

    public TalonFX getTurn_motor() {
        return turn_motor;
    }

    public CANCoder getEncouder() {
        return encouder;
    }

}
