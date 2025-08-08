package frc.robot.Subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.ControlModeValue;
import com.ctre.phoenix6.signals.FeedbackSensorSourceValue;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.configs.Slot0Configs;

public class PitchCatjuster extends SubsystemBase{
    public static class Constants{
        //Motor ID
        private static final int id = 1;
        private static final int encoderId = 0;
        
        //Motor constants
        private static final double max = 85;
        private static final double min = 0;

        //PID constants
        private static final double kP = 0.1;
        private static final double kI = 0.0;
        private static final double kD = 0.0;

        //Feedword constants
        private static final double kG = 0.0;
        private static final double kS = 0.0;
        private static final double kV = 0.0;
        private static final double kA = 0.0;
        private static final boolean inverted = false;

        private static final double RotorToSensorRatio = 1.0; // Adjust as needed
        private static final double SensorToMechanismRatio = 1.0; // Adjust as needed

        private static final double encoderOffset = 0.0; // Encoder offset, adjust as needed
    }
    //Kraken Motor Controller
    private TalonFX cat;
    private TalonFXConfiguration config;
    private CANcoder encoder;
    private PositionVoltage controller = new PositionVoltage(0);

    public PitchCatjuster(){
        cat = new TalonFX(Constants.id);
        encoder = new CANcoder(Constants.encoderId);

        config = new TalonFXConfiguration();
        config.MotorOutput.Inverted = Constants.inverted? InvertedValue.Clockwise_Positive : InvertedValue.CounterClockwise_Positive;
        
        config.Slot0.kA = Constants.kA;
        config.Slot0.kG = Constants.kG;
        config.Slot0.kP = Constants.kP;
        config.Slot0.kI = Constants.kI;
        config.Slot0.kD = Constants.kD;
        config.Slot0.kS = Constants.kS;
        config.Slot0.kV = Constants.kV;
        config.Slot0.GravityType = GravityTypeValue.Elevator_Static;

        config.Feedback.RotorToSensorRatio = Constants.RotorToSensorRatio;
        config.Feedback.SensorToMechanismRatio = Constants.SensorToMechanismRatio;
        
        config.Feedback.FeedbackRemoteSensorID = encoder.getDeviceID();
        config.Feedback.FeedbackSensorSource = FeedbackSensorSourceValue.FusedCANcoder;
        
        cat.getConfigurator().apply(config);
        }

    public void setPosition(double angle){
        cat.setControl(controller.withPosition(angle));
    }

    public void stop(){
        cat.stopMotor();
    }

    public double getSpeed(){
        return cat.get();
    }

    public double getAngle(){
        // Assuming the encoder returns a value between 0 and 1 representing the position
        double position = cat.getPosition().getValueAsDouble();
        // Map this to the angle range
        return position * (Constants.max - Constants.min) + Constants.min;
    }

    public void setPitch(double angle){
        // Clamp the angle to the min and max values
        angle = MathUtil.clamp(angle, PitchCatjuster.Constants.min, PitchCatjuster.Constants.max);
    
        setPosition(angle);
    }


}
