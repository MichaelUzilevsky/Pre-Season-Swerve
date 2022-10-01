package utils;

import edu.wpi.first.math.geometry.Rotation2d;

public class SwerveModuleState {
    private double speedMetersPerSecond;
    private Rotation2d angle;

    public SwerveModuleState(double speedMetersPerSecond, Rotation2d angle) {
        this.speedMetersPerSecond = speedMetersPerSecond;
        this.angle = angle;
    }
}
 