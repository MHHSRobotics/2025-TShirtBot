package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Subsystems.PitchCatjuster;

public class PitchAdjusterCattands {
    PitchCatjuster pitchCatjuste =  new PitchCatjuster();

    InstantCommand adjustPitch(double angle){
        return new InstantCommand(()->pitchCatjuste.setPitch(angle));
            // pitchCatjuster.setPosition(angle);
        };
    InstantCommand stopPitch(){
        return new InstantCommand(()->pitchCatjuste.stop());
    };
    

}
