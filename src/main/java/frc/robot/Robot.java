// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Robot extends TimedRobot {
    private final PWMSparkMax left_drive = new PWMSparkMax(0);
    private final PWMSparkMax right_drive = new PWMSparkMax(1);
    private final DifferentialDrive robot_drive = new DifferentialDrive(left_drive::set, right_drive::set);
    private final XboxController controller = new XboxController(0);
    private final Timer timer = new Timer();

    @Override
    public void robotInit() {
    }

    @Override
    public void robotPeriodic() {
    }

    @Override
    public void autonomousInit() {
        timer.reset();
    }

    @Override
    public void autonomousPeriodic() {
        if (timer.get() < 2.0) {
            robot_drive.arcadeDrive(0.5, 0.0, false);

        } else {
            robot_drive.stopMotor();
        }
    }

    @Override
    public void teleopPeriodic() {
        robot_drive.arcadeDrive(controller.getLeftY(), controller.getRightY(), true);
    }
}
