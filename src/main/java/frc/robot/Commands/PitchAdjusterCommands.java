package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Subsystems.PitchAdjuster;

public class PitchAdjusterCommands {
    PitchAdjuster pitcat =  new PitchAdjuster();

    public PitchAdjusterCommands(PitchAdjuster pitch){
        this.pitcat = pitch;
    }
    public InstantCommand setPitch(double angle){ //degree
        return new InstantCommand(()->pitcat.setPitch(angle));
            // pitchCatjuster.setPosition(angle);
        };
    public InstantCommand stopPitch(){
        return new InstantCommand(()->pitcat.stop());
    };
    

}
