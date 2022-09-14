// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import utils.Modul;
import utils.Side;

public class Chassis extends SubsystemBase {
  private Modul front_right, front_left, back_right, back_left;

  Translation2d frontLeftLocation = new Translation2d(Constants.FRONT_LEFT_LOCATION_X, Constants.FRONT_LEFT_LOCATION_Y);
  Translation2d frontRightLocation = new Translation2d(Constants.FRONT_RIGHT_LOCATION_X,
      Constants.FRONT_RIGHT_LOCATION_Y);
  Translation2d backLeftLocation = new Translation2d(Constants.BACK_LEFT_LOCATION_X, Constants.BACK_LEFT_LOCATION_Y);
  Translation2d backRightLocation = new Translation2d(Constants.BACK_RIGHT_LOCATION_X, Constants.BACK_RIGHT_LOCATION_Y);

  SwerveDriveKinematics kinematics = new SwerveDriveKinematics(
      frontLeftLocation, frontRightLocation, backLeftLocation, backRightLocation);
  /** Creates a new Chassis. */

  {

    this.front_right = new Modul(Side.FRONT_RIGHT);
    this.back_right = new Modul(Side.BACK_RIGHT);
    this.front_left = new Modul(Side.FRONT_LEFT);
    this.back_left = new Modul(Side.BACK_LEFT);

  } // i need you to find me the encouder of the turn motor ty :>

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public SwerveModuleState[] angle_and_speed(double vx, double vy, double radians_per_second) { // read about it on the
                                                                                                // internet
    ChassisSpeeds speeds = new ChassisSpeeds(vx, vy, radians_per_second);
    SwerveModuleState[] moduleStates = kinematics.toSwerveModuleStates(speeds);
    SwerveModuleState frontLeft = moduleStates[0];
    SwerveModuleState frontRight = moduleStates[1];
    SwerveModuleState backLeft = moduleStates[2];
    SwerveModuleState backRight = moduleStates[3];
    return null;
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
