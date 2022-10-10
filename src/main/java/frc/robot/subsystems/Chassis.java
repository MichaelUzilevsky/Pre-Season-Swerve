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
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import utils.SwerveMudule;

public class Chassis extends SubsystemBase {
  private final SwerveMudule[] swerveModules;
  private final SwerveMudule front_right, back_right, front_left, back_left;

  private final PigeonIMU gyro;

  private DifferentialDriveOdometry odometry;

  private DifferentialDriveKinematics kinematics;
  private DifferentialDriveWheelSpeeds wspeed;

  public Chassis() {
    this.gyro = new PigeonIMU(Constants.GYRO);

    // odometry
    odometry = new DifferentialDriveOdometry(getGyroHeading(), new Pose2d(0, 0,  new Rotation2d(0)));
    // odometry.update

    // kinematic
    kinematics = new DifferentialDriveKinematics(Constants.LEFT_RIGHT_WHEEL_DISTANCE_METER);

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

  /**
   * @param fowardVelocity   meter per second
   * @param sidewaysVelocity meter per second
   * @param angularVelocity  radians
   */
  public void drive(double fowardVelocity, double sidewaysVelocity, double angularVelocity) {
    wspeed = kinematics.toWheelSpeeds(new ChassisSpeeds(fowardVelocity, 0, angularVelocity));
    ChassisSpeeds chassisSpeeds = kinematics.toChassisSpeeds(wspeed);

    // Linear velocity
    double linearVelocity = chassisSpeeds.vxMetersPerSecond;
    
    // Angular velocity
    double angularVelocity2 = chassisSpeeds.omegaRadiansPerSecond;
    
    setVelocity(linearVelocity , sidewaysVelocity , angularVelocity2);
    

    // ChassisSpeeds speed = new ChassisSpeeds(fowardVelocity, sidewaysVelocity,
    // angularVelocity);
    for (int i = 0; i < swerveModules.length; i++) {

    }

  }

  public ChassisSpeeds setVelocity(Double vxMPR , Double vyMPR, Double angularVelocity){
    // ChassisSpeeds speed  = new ChassisSpeeds(vxMPR,vyMPR,angularVelocity);
    return new ChassisSpeeds(vxMPR,vyMPR,angularVelocity);
  }


  public double getGyroHeading(){
    return gyro.getFusedHeading();
  }

  public double get_angle_cancoder() {
    return front_right.getEncouder().getAbsolutePosition();
  }


  public Rotation2d getHeading() {
    return Rotation2d.fromDegrees(-gyro.getFusedHeading());
  }

  public int get_motor_id() {
    return (int) SmartDashboard.getNumber("motor port to check", 0);
  }

  public void periodic() {
    SmartDashboard.getNumber("motor port to check", 0);
    // This method will be called once per scheduler run
  }
}