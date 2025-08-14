package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.subsystems.Shooter;

public class ShooterCommands {
    private Shooter shooter;

    public ShooterCommands(Shooter shooter) {
        this.shooter = shooter;
    }

    public Command setSpeed(DoubleSupplier speed) {
        return new InstantCommand(() -> shooter.setSpeed(speed.getAsDouble()), shooter);
    }

    public Command stop() {
        return setSpeed(() -> 0);
    }
}
