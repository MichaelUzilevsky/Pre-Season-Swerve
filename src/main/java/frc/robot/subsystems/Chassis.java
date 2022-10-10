package frc.robot.subsystems;

import javax.swing.text.AbstractDocument.LeafElement;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import utils.SwerveMudule;

public class Chassis extends SubsystemBase {
  private final SwerveMudule[] swerveModules;
  private final SwerveMudule front_right, back_right, front_left, back_left;
  private final PigeonIMU gyro;
  private final CANCoder canCoder1;

  public Chassis() {
    this.canCoder1 = new CANCoder(2);
    this.gyro = new PigeonIMU(Constants.GYRO);

    // define moduls
    swerveModules = new SwerveMudule[4];

    front_right = new SwerveMudule(Constants.FRONT_RIGHT_MOVE, Constants.FRONT_RIGHT_TURN, Constants.FRONT_RIGHT_CODER);
    back_right = new SwerveMudule(Constants.BACK_RIGHT_MOVE, Constants.BACK_RIGHT_TURN, Constants.BACK_RIGHT_CODER);
    front_left = new SwerveMudule(Constants.FRONT_LEFT_MOVE, Constants.FRONT_LEFT_TURN, Constants.FRONT_LEFT_CODER);
    back_left = new SwerveMudule(Constants.BACK_LEFT_MOVE, Constants.BACK_LEFT_TURN, Constants.BACK_LEFT_CODER);

    swerveModules[0] = front_right;
    swerveModules[1] = front_left;
    swerveModules[2] = back_right;
    swerveModules[3] = back_left;

  }

  // @Override
  // not my code

  // public void drive(double x, double y, double rotation, boolean fieldRelative,
  // boolean isOpenLoop) {

  // Translation2d translation = new Translation2d(y, -x); // Converting to X
  // front positive and Y left positive
  // rotation *= -1; // Converting to CCW+
  // // set the desired states based on the given translation and rotation
  // SwerveModuleState[] swerveModuleStates =
  // Constants.SWERVE_KINEMATICS.toSwerveModuleStates(
  // fieldRelative ? ChassisSpeeds.fromFieldRelativeSpeeds( // if field relative,
  // convert to field relative speeds
  // translation.getX(),
  // translation.getY(),
  // rotation,
  // getAngle())
  // : new ChassisSpeeds( // if not field relative, just use the given translation
  // and rotation
  // translation.getX(),
  // translation.getY(),
  // rotation));

  // // making sure the speeds are within the max speed
  // SwerveDriveKinematics.desaturateWheelSpeeds(swerveModuleStates,
  // Constants.MAX_SPEED);
  // // if we are not moving or rotating at all, set the desired angle to the
  // current
  // // angle
  // if (translation.getNorm() == 0 && rotation == 0) {
  // for (int i = 0; i < swerveModules.length; i++) {
  // swerveModuleStates[i].angle = swerveModules[i].getState().angle;
  // }
  // }

  // // set the desired state for each module
  // for (int i = 0; i < swerveModules.length; i++) {
  // swerveModules[i].setDesiredState(swerveModuleStates[i], isOpenLoop, false);
  // }
  // }

  // public SwerveModuleState[] getStates() {
  // SwerveModuleState[] states = new SwerveModuleState[4];
  // for (int i = 0; i < swerveModules.length; i++) {
  // states[i] = swerveModules[i].getState();
  // }
  // return states;
  // }

  // public void setModuleStates(SwerveModuleState[] desiredStates) {
  // SwerveDriveKinematics.desaturateWheelSpeeds(desiredStates,
  // Constants.MAX_SPEED);

  // for (int i = 0; i < swerveModules.length; i++) {
  // swerveModules[i].setDesiredState(desiredStates[i], true, false);
  // }
  // }

  // my code :D
  public double get_angle_cancoder() {
    return front_right.getEncouder().getAbsolutePosition();
  }

  public void set_power(double power) {
    front_left.getMove_motor().set(ControlMode.PercentOutput, power);
  }

  public Rotation2d getHeading() {
    return Rotation2d.fromDegrees(-gyro.getFusedHeading());
  }

  public int get_motor_id() {
    return (int) SmartDashboard.getNumber("motor port to check", 0);
  }

  public void periodic() {
    SmartDashboard.getNumber("motor port to check", 0);
    SmartDashboard.putNumber("absolute position cancoder", get_angle_cancoder());
    // This method will be called once per scheduler run
  }
}