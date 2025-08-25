package frc.robot;

import edu.wpi.first.math.MathUtil;
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
    // The controller. CommandPS5Controller should always be used rather than PS5Controller, since the former can be
    // bound to commands.
    private CommandPS5Controller controller = new CommandPS5Controller(0);

    // The subsystem fields
    private Drive drive;
    private PitchAdjuster pitchAdjuster;
    private Shooter shooter;
    private Turret turret;

    // The subsystem command fields
    private DriveCommands driveCommands;
    private PitchAdjusterCommands pitchAdjusterCommands;
    private ShooterCommands shooterCommands;
    private TurretCommands turretCommands;

    public RobotContainer() {
        // Initialize the subsystems
        drive = new Drive();
        pitchAdjuster = new PitchAdjuster();
        shooter = new Shooter();
        turret = new Turret();

        // Initialize the subsystem commands
        driveCommands = new DriveCommands(drive);
        pitchAdjusterCommands = new PitchAdjusterCommands(pitchAdjuster);
        shooterCommands = new ShooterCommands(shooter);
        turretCommands = new TurretCommands(turret);

        // Bind controls to commands
        configureBindings();
    }

    public void configureBindings() {
        drive.setDefaultCommand(driveCommands.drive(() -> -MathUtil.applyDeadband(controller.getLeftY(),0.1), () -> -MathUtil.applyDeadband(controller.getLeftX(),0.1)));
        pitchAdjuster.setDefaultCommand(pitchAdjusterCommands.setSpeed(() -> MathUtil.applyDeadband(controller.getRightY(),0.1)/10));
        turret.setDefaultCommand(turretCommands.setSpeed(()->MathUtil.applyDeadband(controller.getRightX(), 0.1)/10));
        controller.R2().onTrue(shooterCommands.setSpeed(()->0.3)).onFalse(shooterCommands.stop());
    }

    // Gets the next auto command. Since this is t-shirt bot it just returns a no-op.
    public Command getAutonomousCommand() {
        return new InstantCommand();
    }
}
