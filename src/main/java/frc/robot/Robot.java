package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;

public class Robot extends TimedRobot {

    private PWMTalonSRX left_motor_1 = new PWMTalonSRX(0);
    private PWMTalonSRX left_motor_2 = new PWMTalonSRX(1);
    private PWMTalonSRX right_motor_1 = new PWMTalonSRX(2);
    private PWMTalonSRX right_motor_2 = new PWMTalonSRX(3);

    private double start_time;

    private Joystick joy_1 = new Joystick(0);

    @Override
    public void autonomousInit() {
        start_time = Timer.getFPGATimestamp();
    }

    @Override
    public void autonomousPeriodic() {
        double time = Timer.getFPGATimestamp();

        if (time - start_time < 3) {
            left_motor_1.set(0.6);
            left_motor_2.set(0.6);
            right_motor_1.set(-0.6);
            right_motor_2.set(-0.6);
        } else {
            left_motor_1.set(0);
            left_motor_2.set(0);
            right_motor_1.set(0);
            right_motor_2.set(0);
        }
    }

    @Override
    public void teleopPeriodic() {
        double speed = -joy_1.getRawAxis(1) * 0.6;
        double turn = joy_1.getRawAxis(1) * 0.3;

        double left = speed + turn;
        double right = speed - turn;

        left_motor_1.set(left);
        left_motor_2.set(left);
        right_motor_1.set(-right);
        right_motor_2.set(-right);
    }
}