package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

public class Pneumatics {
    public static class Constants{
        public static final int id=0;
    }
    private Solenoid solenoid;
    public Pneumatics(){
        solenoid=new Solenoid(PneumaticsModuleType.REVPH, Constants.id);
    }

    public void enable(){
        solenoid.set(true);
    }

    public void disable(){
        solenoid.set(false);
    }
}
