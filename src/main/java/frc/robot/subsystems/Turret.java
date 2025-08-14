package frc.robot.subsystems;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;

public class Turret extends SubsystemBase {

    public static class Constants {
        public static final double minAngle = Units.degreesToRadians(-180.0);
        public static final double maxAngle = Units.degreesToRadians(180.0);
        public static final boolean motorInverted = true;
        // public static final boolean encoderInverted = true;
    }

    private TalonFX turretMotor;
    // private CANcoder turretEncoder;

    private TalonFXConfiguration motorConfig = new TalonFXConfiguration();
    // private CANcoderConfiguration encoderConfig = new CANcoderConfiguration();

    public Turret() {
        motorConfig.MotorOutput.Inverted =
                Constants.motorInverted ? InvertedValue.Clockwise_Positive : InvertedValue.CounterClockwise_Positive;

        // encoderConfig.MagnetSensor.SensorDirection = Constants.encoderInverted ?
        // SensorDirectionValue.Clockwise_Positive: SensorDirectionValue.CounterClockwise_Positive;

        turretMotor.getConfigurator().apply(motorConfig);
        // turretEncoder.getConfigurator().apply(encoderConfig);
    }

    public void setSpeed(double speed) {
        turretMotor.set(speed);
    }

    public void stop(double speed) {
        turretMotor.set(0.0);
    }
}
