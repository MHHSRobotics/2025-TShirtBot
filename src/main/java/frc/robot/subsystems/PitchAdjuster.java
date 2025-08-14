package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

public class PitchAdjuster extends SubsystemBase {
    public static class Constants {
        // Motor ID
        private static final int id = 1; // port

        // Motor constants

        private static final boolean inverted = false;
    }
    // SparkMax contoller for Neo
    private SparkMax motor;
    private SparkMaxConfig config;

    public PitchAdjuster() {
        motor = new SparkMax(Constants.id, MotorType.kBrushless);
        config = new SparkMaxConfig();
        config.inverted(Constants.inverted);
        motor.configure(config, null, null);
    }

    public void setSpeed(double speed) {
        motor.set(speed);
    }

    public void stop() {
        motor.stopMotor();
    }
}
