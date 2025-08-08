package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Subsystems.PitchAdjuster;

public class PitchAdjusterCommands {
    PitchAdjuster pitch =  new PitchAdjuster();

    public PitchAdjusterCommands(PitchAdjuster pitcath){
        this.pitch = pitcath;
    }
    public InstantCommand setPitch(double angle){ //degree
        return new InstantCommand(()->pitch.setPitch(angle));
        };
    public InstantCommand stopPitch(){
        return new InstantCommand(()->pitch.stop());
    };
    

}
