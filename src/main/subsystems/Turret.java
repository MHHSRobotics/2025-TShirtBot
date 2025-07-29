import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;

import static edu.wpi.first.units.Units.Radians;

public class Turret {
    public static class Constants{
        public static double minTurnAngle = Units.degreestoRadians(-180.0);
        public static double maxTurnAngle = Units.degreestoRadians(180.0);
    }
    private TalonFX turretMotor;

}
