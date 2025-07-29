package frc.robot.Subsytems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.FeedbackSensorSourceValue;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.configs.Slot0Configs;

public class PitchCatjuster {
    public static class Constants{
        //Motor ID
        private static final int id = 1;
        
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
    }
    //Kraken Motor Controller
    private TalonFX Cat;
    private TalonFXConfiguration config;

    public PitchCatjuster(){
        Cat = new TalonFX(Constants.id);

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
        
        config.Feedback.FeedbackRemoteSensorID = 0;
        config.Feedback.FeedbackSensorSource = FeedbackSensorSourceValue.FusedCANcoder;
        
        Cat.getConfigurator().apply(config);
        }

    public void setMotor(double speed){
        Cat.set(speed);
    }

    public void stop(){
        Cat.stopMotor();
    }

    public double getSpeed(){
        return Cat.get();
    }

    public void setPitch(double angle){
        // Clamp the angle to the min and max values
        if(angle > PitchCatjuster.Constants.max){
            angle = PitchCatjuster.Constants.max;
        } else if(angle < PitchCatjuster.Constants.min){
            angle = PitchCatjuster.Constants.min;
        }
        // Set the motor to the desired angle
        // This is a placeholder, replace with actual control logic
        double speed = (angle - getSpeed()) * 0.1; // Simple P control
        setMotor(speed);
    }


}
