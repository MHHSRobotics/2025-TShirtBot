package frc.robot.io;

import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class MotorIOSpark extends MotorIO {
    private Spark motor;

    // Whether the motor is disabled
    private boolean disabled = false;

    private String controlMode = "Disabled";

    // Make a TalonFX on the given CAN bus
    public MotorIOSpark(int id) {
        motor = new Spark(id);
    }

    @Override
    public void update() {
        // Update all input values from the motor signals
        inputs.connected = motor.isAlive();

        inputs.appliedVoltage = motor.getVoltage();

        inputs.controlMode = controlMode;

        inputs.dutyCycle = motor.get();

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
