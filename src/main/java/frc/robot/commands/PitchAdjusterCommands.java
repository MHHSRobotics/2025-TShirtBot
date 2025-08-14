package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.subsystems.PitchAdjuster;

public class PitchAdjusterCommands {
    private PitchAdjuster pitchAdjuster;

    public PitchAdjusterCommands(PitchAdjuster pitchAdjuster) {
        this.pitchAdjuster = pitchAdjuster;
    }

    public Command setSpeed(DoubleSupplier speed) {
        return new InstantCommand(() -> pitchAdjuster.setSpeed(speed.getAsDouble()), pitchAdjuster);
    }

    public Command stop() {
        return setSpeed(() -> 0);
    }

    public Command setPitch(DoubleSupplier pitch) {
        return new InstantCommand(() -> pitchAdjuster.setPitch(pitch.getAsDouble()), pitchAdjuster);
    }
}
