package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
    public static class Constants {
        public static final int id = 0;
    }

    private Solenoid solenoid;

    public Pneumatics() {
        solenoid = new Solenoid(PneumaticsModuleType.REVPH, Constants.id);
    }

    public void enable() {
        solenoid.set(true);
    }

    public void disable() {
        solenoid.set(false);
    }
}
