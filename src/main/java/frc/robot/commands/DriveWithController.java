// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Chassis;

public class DriveWithController extends CommandBase {
  private Joystick speed_controller;
  private Joystick steer_controller;
  private Chassis chassis;
  private int motor_id;
  public DriveWithController(Chassis chassis, Joystick speed_controller,Joystick steer_controller, int motor_id) {
    this.chassis = chassis;
    this.speed_controller = speed_controller;
    this.steer_controller = steer_controller;
    this.motor_id = motor_id;
    addRequirements(chassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double power_test = speed_controller.getY();

    if (power_test > -0.1 && power_test < 0.1) {
      power_test = 0;
    } 

    chassis.set_power(power_test);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
