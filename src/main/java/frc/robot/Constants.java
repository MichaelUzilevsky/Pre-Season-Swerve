// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;

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

        public static final int FRONT_LEFT_MOVE_MOTOR_ID = 2;
        public static final int FRONT_LEFT_TURN_MOTOR_ID = 1;
        public static final int FRONT_LEFT_CODER_ID = 11;

        public static final int FRONT_RIGHT_MOVE_MOTOR_ID = -1;
        public static final int FRONT_RIGHT_TURN_MOTOR_ID = -1;
        public static final int FRONT_RIGHT_CODER_ID = -1;

        public static final int BACK_LEFT_MOVE_MOTOR_ID = -1;
        public static final int BACK_LEFT_TURN_MOTOR_ID = -1;
        public static final int BACK_LEFT_CODER_ID = -1;

        public static final int BACK_RIGHT_MOVE_MOTOR_ID = -1;
        public static final int BACK_RIGHT_TURN_MOTOR_ID = -1;
        public static final int BACK_RIGHT_CODER_ID = -1;

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

        // define modules location
        public static final Translation2d FRONT_LEFT_LOCATION = new Translation2d(FRONT_LEFT_LOCATION_X,
                        FRONT_LEFT_LOCATION_Y);
        public static final Translation2d BACK_LEFT_LOCATION = new Translation2d(BACK_LEFT_LOCATION_X,
                        BACK_LEFT_LOCATION_Y);
        public static final Translation2d FRONT_RIGHT_LOCATION = new Translation2d(FRONT_RIGHT_LOCATION_X,
                        FRONT_RIGHT_LOCATION_Y);
        public static final Translation2d BACK_RIGHT_LOCATION = new Translation2d(BACK_RIGHT_LOCATION_X,
                        BACK_RIGHT_LOCATION_Y);

        public static final SwerveDriveKinematics SWERVE_KINEMATICS = new SwerveDriveKinematics(
                        Constants.FRONT_LEFT_LOCATION,
                        Constants.FRONT_RIGHT_LOCATION,
                        Constants.BACK_LEFT_LOCATION,
                        Constants.BACK_RIGHT_LOCATION);

        public static final double LEFT_RIGHT_WHEEL_DISTANCE_METER = 2;

        public static final double MAX_SPEED = 3;

        public static final double PULSES_PER_METER = -1;

        // joysticks
        public static final int SPEED_CONTROLLER_PORT = 1;
        public static final int STEER_CONTROLLER_PORT = 2;

        public static final double moveFF = -1;
        public static final double moveKs = -1;
        public static final double moveKv = 0;

        public static final double steerFF = -1;
        public static final double steerKs = -1;
        public static final double steerKv = 0;

}
