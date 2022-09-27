// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  
    public static final int GYRO = -1;

    public static final int TOP_LEFT_MOVE = -1; 
    public static final int TOP_LEFT_TURN = -1;
    public static final int TOP_LEFT_CODER = -1;

    public static final int FRONT_LEFT_MOVE = -1;
    public static final int FRONT_LEFT_TURN = -1;
    public static final int FRONT_LEFT_CODER = -1;

    public static final int FRONT_RIGHT_MOVE = -1;
    public static final int FRONT_RIGHT_TURN = -1;
    public static final int FRONT_RIGHT_CODER = -1;

    public static final int BACK_LEFT_MOVE = -1;
    public static final int BACK_LEFT_TURN = -1;
    public static final int BACK_LEFT_CODER = -1;

    public static final int BACK_RIGHT_MOVE = -1;
    public static final int BACK_RIGHT_TURN = -1;
    public static final int BACK_RIGHT_CODER = -1;

    public static final double STARTING_POSITION_X = 0;
    public static final double STARTING_POSITION_Y = 0;
    public static final double STARTING_ANGLE = 0;
    
    // Locations for the swerve drive modules relative to the robot center.
    public static final double FRONT_RIGHT_LOCATION_X = 0;
    public static final double FRONT_RIGHT_LOCATION_Y = 0;
    public static final double FRONT_LEFT_LOCATION_X = 0;
    public static final double FRONT_LEFT_LOCATION_Y = 0;
    public static final double BACK_LEFT_LOCATION_X = 0;
    public static final double BACK_LEFT_LOCATION_Y = 0;
    public static final double BACK_RIGHT_LOCATION_X = 0;
    public static final double BACK_RIGHT_LOCATION_Y = 0;

    //define modules location
    public static final Translation2d FRONT_LEFT_LOCATION  = new Translation2d(FRONT_LEFT_LOCATION_X, FRONT_LEFT_LOCATION_Y);
    public static final Translation2d BACK_LEFT_LOCATION  = new Translation2d(BACK_LEFT_LOCATION_X, BACK_LEFT_LOCATION_Y);
    public static final Translation2d FRONT_RIGHT_LOCATION  = new Translation2d(FRONT_RIGHT_LOCATION_X, FRONT_RIGHT_LOCATION_Y);
    public static final Translation2d BACK_RIGHT_LOCATION  = new Translation2d(BACK_RIGHT_LOCATION_X, BACK_RIGHT_LOCATION_Y);

    public static final double PULSES_PER_METER = -1;

}
