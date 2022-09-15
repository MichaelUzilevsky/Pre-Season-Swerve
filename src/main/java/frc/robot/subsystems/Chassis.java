// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import utils.Module;
import utils.Side;

public class Chassis extends SubsystemBase {

  private final Module front_right, back_right, front_left, back_left;
  private final Translation2d front_left_location, front_right_location, back_left_location , back_right_location;
  private final Module[] modules;
  private final SwerveDriveKinematics kinematics;
  private final SwerveDriveOdometry odometry;
  private final PigeonIMU gyro;
  private Pose2d robot_current_position;
  /** Creates a new Chassis. */
  public Chassis() {

    robot_current_position = new Pose2d(new Translation2d(Constants.STARTING_POSITION_X, Constants.STARTING_POSITION_Y), 
        new Rotation2d(Constants.STARTING_ANGLE));

    this.gyro = new PigeonIMU(Constants.GYRO);

    //define moduls
    this.front_right = new Module(Side.FRONT_RIGHT);
    this.back_right = new Module(Side.BACK_RIGHT);
    this.front_left = new Module(Side.FRONT_LEFT);
    this.back_left = new Module(Side.BACK_LEFT);

    //define moduls location
    front_left_location = new Translation2d(Constants.FRONT_LEFT_LOCATION_X, Constants.FRONT_LEFT_LOCATION_Y);
    front_right_location = new Translation2d(Constants.FRONT_RIGHT_LOCATION_X, Constants.FRONT_RIGHT_LOCATION_Y);
    back_left_location = new Translation2d(Constants.BACK_LEFT_LOCATION_X, Constants.BACK_LEFT_LOCATION_Y);
    back_right_location = new Translation2d(Constants.BACK_RIGHT_LOCATION_X, Constants.BACK_RIGHT_LOCATION_Y);

    kinematics = new SwerveDriveKinematics(front_left_location, front_right_location, back_left_location, back_right_location);

    odometry = new SwerveDriveOdometry(kinematics,getHeading(), robot_current_position);

    modules = new Module[4];
    modules[0] = front_left;
    modules[1] = front_right;
    modules[2] = back_left;
    modules[3] = back_right;

    configCoders();
// i need you to find me the encouder of the turn motor ty :>
  }

  @Override
  public void periodic() {
    //TODO
    // This method will be called once per scheduler run
    
    //robot_current_position =  odometry.update(();
  }

  public SwerveModuleState[] getModuleStates(double vx, double vy, double radians_per_second) {
    ChassisSpeeds chassisSpeeds = new ChassisSpeeds(vx, vy, radians_per_second);
    SwerveModuleState[] moduleStates = kinematics.toSwerveModuleStates(chassisSpeeds);
    return moduleStates;
  }

  public void configCoders() {
    for (Module m : modules) {
      m.getCanCoder().setPositionToAbsolute();
    }
  }

  public Rotation2d getHeading(){
    return  Rotation2d.fromDegrees(-gyro.getFusedHeading());
  }

  // public void turn_optimize(SwerveModuleState frontLeft, SwerveModuleState
  // frontRight, SwerveModuleState backLeft,
  // SwerveModuleState backRight) {
  // var frontLeftOptimized = SwerveModuleState.optimize(frontLeft.,
  // new Rotation2d(constam_turningEncoder.getDistance()));

  // var frontRightOptimized = SwerveModuleState.optimize(frontLeft,
  // new Rotation2d(m_turningEncoder.getDistance()));

  // var backLeftOptimized = SwerveModuleState.optimize(frontLeft,
  // new Rotation2d(m_turningEncoder.getDistance()));

  // var backRightOptimized = SwerveModuleState.optimize(frontLeft,
  // new Rotation2d(m_turningEncoder.getDistance()));

  // }

}
