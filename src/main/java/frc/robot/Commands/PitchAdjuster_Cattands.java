package frc.robot.Commands;

import java.time.Instant;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Subsytems.PitchCatjuster;

public class PitchAdjuster_Cattands {
    PitchCatjuster pitchCatjuste =  new PitchCatjuster();

    InstantCommand adjustPitch(double angle){
        return new InstantCommand(()->pitchCatjuste.setPitch(angle));
            // pitchCatjuster.setPosition(angle);
        };
    InstantCommand stopPitch(){
        return new InstantCommand(()->pitchCatjuste.stop());
    };
    

}
