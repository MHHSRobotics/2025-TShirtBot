package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;

public class Shooter extends SubsystemBase {
    public static class Constants {
        public static final int motorId = 6;
        public static final boolean inverted = false;
    }

    private final TalonFX motor = new TalonFX(Constants.motorId);

    public Shooter() {
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.MotorOutput.Inverted =
                Constants.inverted ? InvertedValue.Clockwise_Positive : InvertedValue.CounterClockwise_Positive;

        motor.getConfigurator().apply(config);
    }

    public void setSpeed(double speed) {
        motor.set(speed);
    }
}
