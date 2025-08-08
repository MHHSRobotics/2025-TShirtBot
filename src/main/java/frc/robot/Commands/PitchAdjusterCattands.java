package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Subsystems.PitchCatjuster;

public class PitchAdjusterCattands {
    PitchCatjuster pitchCatjuste =  new PitchCatjuster();

    public PitchAdjusterCattands(PitchCatjuster pitchCatjuste){
        this.pitchCatjuste = pitchCatjuste;
    }
    public InstantCommand setPitch(double angle){ //degree
        return new InstantCommand(()->pitchCatjuste.setPitch(angle));
            // pitchCatjuster.setPosition(angle);
        };
    public InstantCommand stopPitch(){
        return new InstantCommand(()->pitchCatjuste.stop());
    };
    

}
