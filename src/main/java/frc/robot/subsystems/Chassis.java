package frc.robot.subsystems;

import javax.swing.text.AbstractDocument.LeafElement;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import utils.SwerveModule;

public class Chassis extends SubsystemBase {
  private final SwerveModule[] swerveModules;
  private final SwerveModule front_right, back_right, front_left, back_left;

  private final PigeonIMU gyro;
  private SwerveDriveOdometry odometry;

  public Chassis() {
    this.gyro = new PigeonIMU(Constants.GYRO);
    // odometry
    odometry = new SwerveDriveOdometry(Constants.SWERVE_KINEMATICS, getGyroHeading());

    // define moduls
    swerveModules = new SwerveModule[4];
    front_right = new SwerveModule(Constants.FRONT_RIGHT_MOVE_MOTOR_ID, Constants.FRONT_RIGHT_TURN_MOTOR_ID,
        Constants.FRONT_RIGHT_CODER_ID);
    back_right = new SwerveModule(Constants.BACK_RIGHT_MOVE_MOTOR_ID, Constants.BACK_RIGHT_TURN_MOTOR_ID,
        Constants.BACK_RIGHT_CODER_ID);
    front_left = new SwerveModule(Constants.FRONT_LEFT_MOVE_MOTOR_ID, Constants.FRONT_LEFT_TURN_MOTOR_ID,
        Constants.FRONT_LEFT_CODER_ID);
    back_left = new SwerveModule(Constants.BACK_LEFT_MOVE_MOTOR_ID, Constants.BACK_LEFT_TURN_MOTOR_ID,
        Constants.BACK_LEFT_CODER_ID);

    swerveModules[0] = front_right;
    swerveModules[1] = front_left;
    swerveModules[2] = back_right;
    swerveModules[3] = back_left;
  }

  /**
   * @param fowardVelocity   meter per second
   * @param sidewaysVelocity meter per second
   * @param angularVelocity  radians
   */
  public void drive(double fowardVelocity, double sidewaysVelocity, double angularVelocity) {
    var speeds = Constants.SWERVE_KINEMATICS.toSwerveModuleStates(
        ChassisSpeeds.fromFieldRelativeSpeeds(fowardVelocity, sidewaysVelocity, angularVelocity, getGyroHeading()));

    ChassisSpeeds chassisSpeeds = Constants.SWERVE_KINEMATICS.toChassisSpeeds(speeds);
    for (int i = 0; i < swerveModules.length; i++) {
      var yoav = SwerveModuleState.optimize(speeds[i], getGyroHeading());
      swerveModules[i].setMoveVelocity(speeds[i].speedMetersPerSecond);

    }

  }

  public double getangle() {
    return gyro.getFusedHeading();
  }

  public Rotation2d getGyroHeading() {
    return Rotation2d.fromDegrees(-gyro.getFusedHeading());
  }

  public void periodic() {
    // need to check how to make the odomentry
    // 1. getPose()
    // 2. odometry check if inzilazied right
    Field2d field2d = new Field2d();
    field2d.getRobotPose();
    SmartDashboard.putData("Robot position", field2d);
    SmartDashboard.putNumber("AbsolutePosition", front_left.getAbsolutePositionCANCoder());
    // This method will be called once per scheduler run
  }
}