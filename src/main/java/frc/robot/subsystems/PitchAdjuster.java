package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.io.MotorIO;

// THe pitch adjuster uses a single SparkMAX controlling a Neo motor. PID is not necessary here, since we don't have an
// encoder, and precise aiming is not needed for the t-shirt bot.
public class PitchAdjuster extends SubsystemBase {
    public static class Constants {
        // Motor ID
        public static final int id = 4;

        // Whether the motor is inverted
        public static final boolean inverted = false;
    }
    // SparkMax contoller for Neo
    private MotorIO motor;

    public PitchAdjuster(MotorIO motorIO) {
        // Initialize the SparkMAX
        motor = motorIO;

        motor.setName("Turret Motor");
        motor.setPath("Turret/Motor");

        motor.setInverted(Constants.inverted);
    }

    // Sets the speed of the motor (1 is full forward, -1 is full reverse)
    public void setSpeed(double speed) {
        motor.setDutyCycle(speed);
    }

    @Override
    public void periodic() {
        motor.update();
    }
}
