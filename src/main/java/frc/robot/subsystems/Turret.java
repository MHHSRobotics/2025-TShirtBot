package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.io.EncoderIO;
import frc.robot.io.MotorIO;

// The turret subsystem uses a single TalonFX controlling a Falcon 500 motor.
public class Turret extends SubsystemBase {
    public static class Constants {
        // The ID of the TalonFX
        public static final int motorId = 6;

        public static final int encoderId = 9;

        // Whether the motor should be inverted
        public static final boolean motorInverted = true;

        public static final double motorToSensorRatio = 9;
        // gear ratio is 20:7
    }

    // The motor controller
    private MotorIO motor;
    private EncoderIO encoder;

    public Turret(MotorIO motorIO, EncoderIO encoderIO) {
        // Initialize the TalonFX
        motor = motorIO;
        encoder = encoderIO;

        motor.setName("Turret Motor");
        motor.setPath("Turret/Motor");

        encoder.setName("Turret Encoder");
        encoder.setPath("Turret/Encoder");

        motor.setInverted(Constants.motorInverted);
        motor.setBraking(true);
        motor.connectEncoder(encoder, Constants.motorToSensorRatio);
    }

    public double getPosition() {
        return motor.getInputs().position;
    }
    // Sets the speed of the Falcon motor
    public void setSpeed(double speed) {
        if (getPosition() < 0 && speed > 0) {
            speed = 0;
        }
        if (getPosition() > 16 && speed < 0) {
            speed = 0;
        }
        motor.setDutyCycle(speed);
    }

    @Override
    public void periodic() {
        System.out.println(motor.getInputs().position);
        motor.update();
        encoder.update();
    }
}
