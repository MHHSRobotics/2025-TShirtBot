package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.io.MotorIO;

// The drive subsystem uses a total of 4 PWM Spark motor controllers, 2 for each side of the differential drive. Each
// pair of motors controls three wheels.
public class Drive extends SubsystemBase {
    public static class Constants {
        // The IDs for each of the motor controllers
        public static final int leftMotor1Id = 0;
        public static final int leftMotor2Id = 1;
        public static final int rightMotor1Id = 2;
        public static final int rightMotor2Id = 3;

        // Whether each motor is inverted
        public static final boolean leftMotor1Inverted = false;
        public static final boolean leftMotor2Inverted = false;
        public static final boolean rightMotor1Inverted = true;
        public static final boolean rightMotor2Inverted = true;
    }

    // The motors
    private MotorIO leftMotor1;
    private MotorIO leftMotor2;
    private MotorIO rightMotor1;
    private MotorIO rightMotor2;

    // DifferentialDrive class to control the motors based on controller input
    private DifferentialDrive drive;

    public Drive(MotorIO leftMotor1, MotorIO leftMotor2, MotorIO rightMotor1, MotorIO rightMotor2) {
        // Initialize the motors
        this.leftMotor1 = leftMotor1;
        this.leftMotor2 = leftMotor2;
        this.rightMotor1 = rightMotor1;
        this.rightMotor2 = rightMotor2;

        // Invert them if necessary
        leftMotor1.setInverted(Constants.leftMotor1Inverted);
        leftMotor2.setInverted(Constants.leftMotor2Inverted);
        rightMotor1.setInverted(Constants.rightMotor1Inverted);
        rightMotor2.setInverted(Constants.rightMotor2Inverted);

        // Initialize the differential drive. This takes in two lambdas: one to set the speed of the left side, and one
        // for the right side. The DifferentialDrive class uses these to control the bot.
        drive = new DifferentialDrive(
                (s) -> {
                    leftMotor1.setDutyCycle(s);
                    leftMotor2.setDutyCycle(s);
                },
                (s) -> {
                    rightMotor1.setDutyCycle(s);
                    rightMotor2.setDutyCycle(s);
                });
    }

    // Sets the forward speed and rotation for the bot. drive.arcadeDrive converts these values into speeds for the left
    // and right sides.
    public void setSpeed(double speed, double rotation) {
        drive.arcadeDrive(speed, rotation);
    }
}
