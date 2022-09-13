// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import utils.Modul;
import utils.Side;

public class Chassis extends SubsystemBase {
  private Modul top_right, top_left, bottom_right, bottom_left;

  /** Creates a new Chassis. */
  public Chassis() {
    
    this.top_right = new Modul(Side.TOP_RIGHT);
    this.bottom_right = new Modul(Side.BOTTOM_RIGHT);
    this.top_left = new Modul(Side.TOP_LEFT);
    this.bottom_left = new Modul(Side.BOTTOM_LEFT);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
