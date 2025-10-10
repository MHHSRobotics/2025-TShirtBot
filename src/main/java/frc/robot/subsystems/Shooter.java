package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.io.MotorIO;

// The shooter subsystem uses a single TalonFX controlling a Falcon 500 motor, which powers a pair of flywheels. No PID
// is required since flywheels don't need to have a precise velocity.
public class Shooter extends SubsystemBase {
    public static class Constants {
        // ID of the TalonFX
        public static final int motorId = 5;

        // Whether the motor should be inverted
        public static final boolean inverted = false;
    }

    // The motor controller
    private final MotorIO motor;

    public Shooter(MotorIO motorIO) {
        // Initialize the TalonFX
        motor = motorIO;

        motor.setName("Shooter Motor");
        motor.setPath("Shooter/Motor");

        motor.setInverted(Constants.inverted);
    }

    // Sets the speed of the Falcon motor
    public void setSpeed(double speed) {
        motor.setDutyCycle(speed);
    }

    @Override
    public void periodic() {
        motor.update();
    }
}
