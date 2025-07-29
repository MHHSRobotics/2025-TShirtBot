package frc.robot.Subsytems;

import com.ctre.phoenix6.hardware.TalonFX;

public class PitchCatjuster {
    public class Constants{
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
    }
    //Kraken Motor Controller
    private TalonFX Cat;

    PitchCatjuster(){
        Cat = new TalonFX(Constants.id);
        
    }
}
