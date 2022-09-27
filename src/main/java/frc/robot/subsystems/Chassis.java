
package frc.robot.subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import utils.Module;
import utils.Side;

public class Chassis extends SubsystemBase {

  private final Module front_right, back_right, front_left, back_left;
  private final SwerveDriveKinematics kinematics;
  private final PigeonIMU gyro;

  public Chassis() {

    this.gyro = new PigeonIMU(Constants.GYRO);

    //define moduls
    this.front_right = new Module(Side.FRONT_RIGHT);
    this.back_right = new Module(Side.BACK_RIGHT);
    this.front_left = new Module(Side.FRONT_LEFT);
    this.back_left = new Module(Side.BACK_LEFT);

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