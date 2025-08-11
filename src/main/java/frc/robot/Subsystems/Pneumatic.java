package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatic extends SubsystemBase {
    private final Solenoid cat;
    public Pneumatic(){
        cat = new Solenoid(PneumaticsModuleType.REVPH, 0);
    }
    public void catmand(boolean catOn){
        cat.set(catOn);
    }
}
