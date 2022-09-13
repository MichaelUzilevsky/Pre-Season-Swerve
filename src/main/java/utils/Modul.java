package utils;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.CANCoder;

import frc.robot.Constants;

public class Modul {
    private TalonFX move, turn;
    private CANCoder canCoder;
    private int move_id, turn_id, canCoder_id;

    public Modul(Side side){
        
        switch (side){
            case TOP_LEFT: 
                move_id = Constants.TOP_LEFT_MOVE;
                turn_id = Constants.TOP_LEFT_TURN;
                canCoder_id = Constants.TOP_LEFT_CODER;
                break;
            case TOP_RIGHT:
                move_id = Constants.TOP_RIGHT_MOVE;
                turn_id = Constants.TOP_RIGHT_TURN;
                canCoder_id = Constants.TOP_RIGHT_CODER;
                break;
            case BOTTOM_RIGHT:
                move_id = Constants.BOTTOM_RIGHT_MOVE;
                turn_id = Constants.BOTTOM_RIGHT_TURN;
                canCoder_id = Constants.BOTTOM_RIGHT_CODER;
                break;
            case BOTTOM_LEFT: 
                move_id = Constants.BOTTOM_LEFT_MOVE;
                turn_id = Constants.BOTTOM_LEFT_TURN;
                canCoder_id = Constants.BOTTOM_LEFT_CODER;
                break;

        }
        setMove(new TalonFX(move_id));
        setTurn(new TalonFX(turn_id));
        setCanCoder(new CANCoder(canCoder_id));
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
}