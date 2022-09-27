
package frc.robot.subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import utils.SwerveMudule;

public class Chassis extends SubsystemBase {

  private final SwerveMudule front_right, back_right, front_left, back_left;
  private final SwerveDriveKinematics kinematics;
  private final PigeonIMU gyro;

  public Chassis() {

    this.gyro = new PigeonIMU(Constants.GYRO);

    //define moduls
    this.front_right = new SwerveMudule(Constants.FRONT_RIGHT_MOVE, Constants.FRONT_RIGHT_TURN, Constants.FRONT_RIGHT_CODER);
    this.back_right = new SwerveMudule(Constants.BACK_RIGHT_MOVE, Constants.BACK_RIGHT_TURN, Constants.BACK_RIGHT_CODER);
    this.front_left = new SwerveMudule(Constants.FRONT_LEFT_MOVE, Constants.FRONT_LEFT_TURN, Constants.FRONT_LEFT_CODER);
    this.back_left = new SwerveMudule(Constants.BACK_LEFT_MOVE, Constants.BACK_LEFT_TURN, Constants.BACK_LEFT_CODER);

    kinematics = new SwerveDriveKinematics(Constants.FRONT_LEFT_LOCATION, 
                                           Constants.FRONT_RIGHT_LOCATION, 
                                           Constants.BACK_LEFT_LOCATION, 
                                           Constants.BACK_RIGHT_LOCATION);


// i need you to find me the encouder of the turn motor ty :>
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public SwerveModuleState[] getModuleStates(double vx, double vy, double radians_per_second) {
    ChassisSpeeds chassisSpeeds = new ChassisSpeeds(vx, vy, radians_per_second);
    SwerveModuleState[] moduleStates = kinematics.toSwerveModuleStates(chassisSpeeds);
    return moduleStates;
  }

  public Rotation2d getHeading(){
    return  Rotation2d.fromDegrees(-gyro.getFusedHeading());
  }
}