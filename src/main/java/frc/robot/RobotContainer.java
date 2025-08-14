package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;

import frc.robot.commands.DriveCommands;
import frc.robot.commands.PitchAdjusterCommands;
import frc.robot.commands.ShooterCommands;
import frc.robot.commands.TurretCommands;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.PitchAdjuster;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;

public class RobotContainer {
    private CommandPS5Controller controller = new CommandPS5Controller(0);

    private Drive drive;
    private PitchAdjuster pitchAdjuster;
    private Shooter shooter;
    private Turret turret;

    private DriveCommands driveCommands;
    private PitchAdjusterCommands pitchAdjusterCommands;
    private ShooterCommands shooterCommands;
    private TurretCommands turretCommands;

    public RobotContainer() {
        drive = new Drive();
        pitchAdjuster = new PitchAdjuster();
        shooter = new Shooter();
        turret = new Turret();

        driveCommands = new DriveCommands(drive);
        pitchAdjusterCommands = new PitchAdjusterCommands(pitchAdjuster);
        shooterCommands = new ShooterCommands(shooter);
        turretCommands = new TurretCommands(turret);

        configureBindings();
    }

    public void configureBindings() {
        drive.setDefaultCommand(driveCommands.drive(() -> -controller.getLeftY(), () -> -controller.getLeftX()));
        pitchAdjuster.setDefaultCommand(pitchAdjusterCommands.setSpeed(() -> (controller.getRightY())));
    }

    public Command getAutonomousCommand() {
        return new InstantCommand();
    }
}
