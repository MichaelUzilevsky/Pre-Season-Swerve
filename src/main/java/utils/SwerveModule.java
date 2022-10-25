package utils;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.AbsoluteSensorRange;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import frc.robot.Constants;

public class SwerveModule {
    private TalonFX moveMotor;
    private TalonFX steerMotor;
    private CANCoder encouder;
    private PIDController steerController;

    public SwerveModule(int moveMotorId, int steerMotorId, int encoderId) {
        this.setMoveMotor(new TalonFX(moveMotorId));
        this.setSteerMotor(new TalonFX(steerMotorId));
        this.setEncouder(new CANCoder(encoderId));
    }

    public void setMoveMotor(TalonFX moveMotor) {
        this.moveMotor = moveMotor;
    }

    public void setSteerMotor(TalonFX steerMotor) {
        this.steerMotor = steerMotor;
    }

    public void setEncouder(CANCoder encouder) {
        this.encouder = encouder;
    }

    public double getAbsolutePosition() {
        return encouder.getAbsolutePosition();
    }

    // meter per second
    public double getVelocity() {
        return Helper.pulses_per_01second_to_meter_per_second(moveMotor.getSelectedSensorVelocity());
    }

    public double meterPerSecondToPulses(double x) {
        return x / 10.0 * Constants.PULSES_PER_METER;
    }

    public void configCANEncoder() {
        this.encouder.setPositionToAbsolute();
        this.encouder.configAbsoluteSensorRange(AbsoluteSensorRange.Unsigned_0_to_360);
    }

    public double getMoveFF(double x) {
        return Constants.moveKs * Math.signum(x) + x * Constants.moveKv;
    }

    public void setMoveVelocity(double velocity) {
        moveMotor.set(ControlMode.Velocity, meterPerSecondToPulses(velocity), DemandType.ArbitraryFeedForward,
                getMoveFF(velocity));
    }

    public void setSteerAngle(double angle) {
        steerMotor.set(ControlMode.Position, steerMotor.getSelectedSensorPosition() + angle);
    }

    public double getAbsolutePositionCANCoder() {
        return encouder.getAbsolutePosition();
    }

}
