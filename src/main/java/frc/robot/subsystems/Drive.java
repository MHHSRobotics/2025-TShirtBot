package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
    public static class Constants {
        public static final int leftMotor1Id = 0;
        public static final int leftMotor2Id = 1;
        public static final int rightMotor1Id = 2;
        public static final int rightMotor2Id = 3;

        public static final boolean leftMotor1Inverted = false;
        public static final boolean leftMotor2Inverted = false;
        public static final boolean rightMotor1Inverted = true;
        public static final boolean rightMotor2Inverted = true;
    }

    private Spark leftMotor1;
    private Spark leftMotor2;
    private Spark rightMotor1;
    private Spark rightMotor2;
    private DifferentialDrive drive;

    public Drive() {
        leftMotor1 = new Spark(Constants.leftMotor1Id);
        leftMotor2 = new Spark(Constants.leftMotor2Id);
        rightMotor1 = new Spark(Constants.rightMotor1Id);
        rightMotor2 = new Spark(Constants.rightMotor2Id);

        leftMotor1.setInverted(Constants.leftMotor1Inverted);
        leftMotor2.setInverted(Constants.leftMotor2Inverted);
        rightMotor1.setInverted(Constants.rightMotor1Inverted);
        rightMotor2.setInverted(Constants.rightMotor2Inverted);

        drive = new DifferentialDrive(
                (s) -> {
                    leftMotor1.set(s);
                    leftMotor2.set(s);
                },
                (s) -> {
                    rightMotor1.set(s);
                    rightMotor2.set(s);
                });
    }

    public void setSpeed(double speed, double angle) {
        drive.arcadeDrive(speed, angle);
    }
}
