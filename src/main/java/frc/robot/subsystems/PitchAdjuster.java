package frc.robot.subsystems;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.FeedbackSensorSourceValue;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.InvertedValue;

public class PitchAdjuster extends SubsystemBase {
    public static class Constants {
        // Motor ID
        private static final int id = 1;

        // Motor constants
        private static final double max = Units.degreesToRadians(85);
        private static final double min = 0;

        // PID constants
        private static final double kP = 0.1;
        private static final double kI = 0.0;
        private static final double kD = 0.0;

        // Feedword constants
        private static final double kG = 0.0;
        private static final double kS = 0.0;
        private static final double kV = 0.0;
        private static final double kA = 0.0;
        private static final boolean inverted = false;
    }
    // TalonFX motor controller for the Kraken x60
    private TalonFX motor;
    private TalonFXConfiguration config;

    private DutyCycleOut setSpeed = new DutyCycleOut(0);
    private PositionVoltage setPos = new PositionVoltage(0);

    public PitchAdjuster() {
        motor = new TalonFX(Constants.id);

        config = new TalonFXConfiguration();
        config.MotorOutput.Inverted =
                Constants.inverted ? InvertedValue.Clockwise_Positive : InvertedValue.CounterClockwise_Positive;

        config.Slot0.kA = Constants.kA;
        config.Slot0.kG = Constants.kG;
        config.Slot0.kP = Constants.kP;
        config.Slot0.kI = Constants.kI;
        config.Slot0.kD = Constants.kD;
        config.Slot0.kS = Constants.kS;
        config.Slot0.kV = Constants.kV;
        config.Slot0.GravityType = GravityTypeValue.Elevator_Static;

        config.Feedback.FeedbackRemoteSensorID = 0;
        config.Feedback.FeedbackSensorSource = FeedbackSensorSourceValue.FusedCANcoder;

        motor.getConfigurator().apply(config);
    }

    public void setSpeed(double speed) {
        motor.setControl(setSpeed.withOutput(speed));
    }

    public void stop() {
        motor.stopMotor();
    }

    public void setPitch(double angle) {
        double clamped = MathUtil.clamp(angle, Constants.min, Constants.max);
        motor.setControl(setPos.withPosition(Units.radiansToRotations(clamped)));
    }
}
