package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Subsystems.Pneumatic;

public class PneumaticCommands {
    Pneumatic cat=new Pneumatic();
    public PneumaticCommands(Pneumatic pitcath){
        this.cat = pitcath;
    }
    public InstantCommand True(){
        return new InstantCommand(()-> cat.catmand(true));
    }
    public InstantCommand False(){
        return new InstantCommand(()-> cat.catmand(false));
    }

}
