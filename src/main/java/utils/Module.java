package utils;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.AbsoluteSensorRange;
import com.ctre.phoenix.sensors.CANCoder;

import frc.robot.Constants;

public class Module {
    private TalonFX move, turn;
    private CANCoder canCoder;
    private int move_id, turn_id, canCoder_id;

    public Module(Side side) {

        switch (side) {
            case FRONT_LEFT:
                move_id = Constants.FRONT_LEFT_MOVE;
                turn_id = Constants.FRONT_LEFT_TURN;
                canCoder_id = Constants.FRONT_LEFT_CODER;
                break;
            case FRONT_RIGHT:
                move_id = Constants.FRONT_RIGHT_MOVE;
                turn_id = Constants.FRONT_RIGHT_TURN;
                canCoder_id = Constants.FRONT_RIGHT_CODER;
                break;
            case BACK_RIGHT:
                move_id = Constants.BACK_RIGHT_MOVE;
                turn_id = Constants.BACK_RIGHT_TURN;
                canCoder_id = Constants.BACK_RIGHT_CODER;
                break;
            case BACK_LEFT:
                move_id = Constants.BACK_LEFT_MOVE;
                turn_id = Constants.BACK_LEFT_TURN;
                canCoder_id = Constants.BACK_LEFT_CODER;
                break;

        }
        
        setMove(new TalonFX(move_id));
        setTurn(new TalonFX(turn_id));
        setCanCoder(new CANCoder(canCoder_id));

        canCoder.configAbsoluteSensorRange(AbsoluteSensorRange.Signed_PlusMinus180);
    }

    public CANCoder getCanCoder() {
        return canCoder;
    }

    public void setCanCoder(CANCoder canCoder) {
        this.canCoder = canCoder;
    }

    public TalonFX getTurn() {
        return turn;
    }

    public void setTurn(TalonFX turn) {
        this.turn = turn;
    }

    public TalonFX getMove() {
        return move;
    }

    public void setMove(TalonFX move) {
        this.move = move;
    }

    //meter per second
    public double get_velocity() {
       return Helper.pulses_per_01second_to_meter_per_second(move.getSelectedSensorVelocity());
    }

    public void setEncoderToAbs(){
        this.canCoder.setPositionToAbsolute();
    }

}