package frc.robot.subsystems;
import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.MotorOutputConfigs;

import static edu.wpi.first.units.Units.Radians;
public class Turret{

    public static class Constants{
        public static final double minTurnAngle = Units.degreestoRadians(-180.0);
        public static final double maxTurnAngle = Units.degreestoRadians(180.0);
        public static final boolean motorInverted = true;
        
    }

    public Turret(){
        TalonFXConfiguration turretMotor = new TalonFXConfiguration();
        turretMotor.MotorOutputConfigs.Inverted = Constants.motorInverted ? InvertedValue.Clockwise_Positive : InvertedValue.CounterClockwise_Positive;
        
        CANcoderConfiguration turretEncoder = new CANcoderConfiguration();
        
    }
    
}
