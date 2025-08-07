package frc.robot.subsystems;

import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.MotorOutputConfigs;

import com.ctre.phoenix6.hardware.TalonFX;

import static edu.wpi.first.units.Units.Radians;

public class Turret{

    public static class Constants{
        public static final double minTurnAngle = Units.degreestoRadians(-180.0);
        public static final double maxTurnAngle = Units.degreestoRadians(180.0);
        public static final double startAngle = Units.degreestoRadians(90.0);
        public static final boolean motorInverted = true;

        public static final double statorCurrentLimit = 5.0;
        public static final double supplyCurrentLimit = 5.0;
        public static final double supplyCurrentLowerLimit = 5.0;
        public static final double supplyCurrentLowerTime = 5.0;
    }

    public Turret(){
        TalonFX turretMotor;
        TalonFXConfiguration motorConfig = new TalonFXConfiguration();

        motorConfig.MotorOutputConfigs.Inverted = Constants.motorInverted ? InvertedValue.Clockwise_Positive : InvertedValue.CounterClockwise_Positive;

        motorConfig.CurrentLimits.StatorCurrentLimit = Constants.statorCurrentLimit;

        motorConfig.CurrentLimits.SupplyCurrentLimit = Constants.supplyCurrentLimit;
        motorConfig.CurrentLimits.SupplyCurrentLowerLimit = Constants.supplyCurrentLowerLimit;
        motorConfig.CurrentLimits.SupplyCurrentLowerTime = Constants.supplyCurrentLowerTime;

        
        CANcoderConfiguration turretEncoder = new CANcoderConfiguration();

        encoderConfig.MagnetSensor.SensorDirection = Constants.encoderInverted ? SensorDirectionValue.Clockwise_Positive: SensorDirectionValue.CounterClockwise_Positive;
    }

    public void setSpeed(double speed){
        turretMotor.set(speed);
    }

    public void stop(double speed){
        turretMotor.set(0.0);
    }

    public void setPose(Angle angle){
        turretMotor.setPosition(angle);
    }

    @Override
    public void applyConfig(TalonFXConfiguration config) {
        turretMotor.getConfigurator().apply(config);
    }
    
}
