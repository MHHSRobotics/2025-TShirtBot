package frc.robot.Subsystems;

import java.security.PrivateKey;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.Spark;


public class Shooter extends SubsystemBase {

    public static final int maxSupplyCurrent = 40;

    private final Spark lowerMotor = new Spark(8);
    private final Spark upperMotor = new Spark(7);

    private final Encoder lowerEncoder = new Encoder(0, 1);
    private final Encoder upperEncoder = new Encoder(2, 3);

    public Shooter(){

        lowerMotor.setInverted(true);
    //      lowerMotor.setSmartCurrentLimit(maxSupplyCurrent);
    //    upperMotor.setSmartCurrentLimit(maxSupplyCurrent);


    }
    public void shoot(double speed) {
        lowerMotor.set(speed);
        upperMotor.set(speed);
    }

    public void stop() {
        lowerMotor.set(0);
        upperMotor.set(0);
    }

    public boolean atSpeed() {
        return Math.abs(upperEncoder.getRate()) > 5000 && Math.abs(lowerEncoder.getRate()) > 5000;
    }
}
