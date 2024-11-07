package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;

public class Robot extends TimedRobot {

  private PWMTalonSRX leftMotor1 = new PWMTalonSRX(0);
  private PWMTalonSRX leftMotor2 = new PWMTalonSRX(1);
  private PWMTalonSRX rightMotor1 = new PWMTalonSRX(2);
  private PWMTalonSRX rightMotor2 = new PWMTalonSRX(3);

  private Joystick joy1 = new Joystick(0);

  private double startTime;

  @Override
  public void robotInit() {

  }

  @Override
  public void robotPeriodic() {

  }

  @Override
  public void autonomousInit() {
    startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void autonomousPeriodic() {
    double time = Timer.getFPGATimestamp();
    System.out.println(time - startTime);

    if (time - startTime < 3) {
      leftMotor1.set(0.6);
      leftMotor2.set(0.6);
      rightMotor1.set(-0.6);
      rightMotor2.set(-0.6);
    } 
    else {
      leftMotor1.set(0);
      leftMotor2.set(0);
      rightMotor1.set(0);
      rightMotor2.set(0);
    }
  }

  @Override
  public void teleopInit() {

  }

  @Override
  public void teleopPeriodic() {
    double speed = -joy1.getRawAxis(1) * 0.6;
    double turn = joy1.getRawAxis(4) * 0.3;

    double left = speed + turn;
    double right = speed - turn;

    leftMotor1.set(left);
    leftMotor2.set(left);
    rightMotor1.set(-right);
    rightMotor2.set(-right);
  }

  @Override
  public void disabledInit() {

  }

  @Override
  public void disabledPeriodic() {

  }

  @Override
  public void testInit() {

  }

  @Override
  public void testPeriodic() {

  }

  @Override
  public void simulationInit() {

  }

  @Override
  public void simulationPeriodic() {

  }
}
