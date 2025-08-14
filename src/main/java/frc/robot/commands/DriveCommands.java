package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

import frc.robot.subsystems.Drive;

public class DriveCommands {
    private Drive drive;

    public DriveCommands(Drive drive) {
        this.drive = drive;
    }

    public Command drive(DoubleSupplier speed, DoubleSupplier angle) {
        return Commands.run(() -> drive.setSpeed(speed.getAsDouble(), angle.getAsDouble()), drive);
    }
}
