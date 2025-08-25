package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

public class Pneumatics {
    public static class PneumaticsConstants{
        
    }
    private Solenoid solenoid=new Solenoid(PneumaticsModuleType.REVPH, 0);
    public Pneumatics(){

    }
}
