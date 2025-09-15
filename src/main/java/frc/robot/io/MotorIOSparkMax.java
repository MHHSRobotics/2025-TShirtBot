package frc.robot.io;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

public class MotorIOSparkMax extends MotorIO {
    private SparkMax motor;

    // Whether the motor is disabled
    private boolean disabled = false;

    private String controlMode = "Disabled";

    // Make a TalonFX on the given CAN bus
    public MotorIOSparkMax(int id, MotorType motorType) {
        motor = new SparkMax(id, motorType);
    }

    @Override
    public void update() {
        // Update all input values from the motor signals
        inputs.connected = true;

        inputs.appliedVoltage = motor.getAppliedOutput() * 12;

        inputs.controlMode = controlMode;

        inputs.dutyCycle = motor.getAppliedOutput();

        // Update alerts using the base class method (this checks all fault conditions and updates dashboard alerts)
        super.update();
    }

    // Tell the motor how fast to spin (percent, -1 = full reverse, 1 = full forward)
    @Override
    public void setDutyCycle(double value) {
        if (disabled) return;
        motor.set(value);
        controlMode = "DutyCycle";
    }

    // Tell the motor what voltage to apply (volts). Similar to setSpeed but in volts.
    @Override
    public void setVoltage(double volts) {
        if (disabled) return;
        motor.setVoltage(volts);
        controlMode = "Voltage";
    }

    // Tell the motor which direction is forward (true = invert)
    @Override
    public void setInverted(boolean inverted) {
        motor.setInverted(inverted);
    }

    @Override
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
        if (disabled) {
            motor.stopMotor();
            controlMode = "Disabled";
        }
    }
}
