package frc.robot.Subsystems;

import java.security.PrivateKey;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenic6.configs.LoggedTalonFX;

public class Shooter extends SubsystemBase {

    public static final int lowerMoterId = 21;
    private LoggedTalonFX lowerMotor;
    public static final int upperMoterId = 22;
    private LoggedTalonFX upperMotor;
    private CANcoderIO encoderIO;

    public Shooter(){
        
    }
    public void shoot(double speed) {
        lowerMotor.set(speed);
    }

    public void stop() {
        
    }

    public void atSpeed() {
        
    }
    public void periodic(){
        SmartDashboard.putNumber(" upper RPM",upperEncoder.getVelocity());
                SmartDashboard.putNumber(" lower RPM",lowerEncoder.getVelocity());

    }
}
