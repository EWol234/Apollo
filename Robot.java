// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.


package org.usfirst.frc2421.Apollo;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc2421.Apollo.commands.*;
import org.usfirst.frc2421.Apollo.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Catapult catapult;
    public static Drive drive;
    public static BallIntake ballIntake;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
	RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        catapult = new Catapult();//HI TRES
        drive = new Drive();
        ballIntake = new BallIntake();
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
	
        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        autonomousCommand = new AutonomousCommand();
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        try {
            SmartDashboard.putNumber("LEFT DRIVE", RobotMap.driveleftrive.getX());
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        try {
            SmartDashboard.putNumber("RIGHT DRIVE", RobotMap.driverightDrive.getX());
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        try {
            SmartDashboard.putNumber("CAT MOTOR 1", RobotMap.catapultcatMotor1.getX());
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        try {
            SmartDashboard.putNumber("CAT MOTOR 2", RobotMap.catapultcatMotor2.getX());
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        try {
            SmartDashboard.putNumber("CAT MOTOR 3", RobotMap.catapultcatMotor3.getX());
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        SmartDashboard.putNumber("CATAPULT ENCODER", RobotMap.catAngle.getRaw());
        SmartDashboard.putNumber("INTAKE EJECTOR", RobotMap.ballIntakeballEjector.get());
        try {
            SmartDashboard.putNumber("INTAKE MOTOR", RobotMap.ballIntakeintakeMotor.getX()
            );
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        SmartDashboard.putNumber("LEFT DRIVE ENCODER", RobotMap.leftWheelEncoder.getRaw());
        SmartDashboard.putNumber("RIGHT DRIVE ENCODER", RobotMap.rightWheelEncoder.getRaw());
    }

    /**
     * This function called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
