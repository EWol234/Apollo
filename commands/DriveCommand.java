// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.


package org.usfirst.frc2421.Apollo.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.Apollo.Robot;
import org.usfirst.frc2421.Apollo.subsystems.*;



/**
 *
 */
public class  DriveCommand extends Command {
    public Joystick driveStick;//Joystick that controls the drive.
    double maxMotor;//Not needed
    double leftSpeed = 0;//Left motor speed
    double rightSpeed = 0;//Right motor speed
    final double deadZone = 0.2;//Deadzone to account for the joystick beings wrongly calibrated
            
    public DriveCommand() {
        driveStick = Robot.oi.driveStick;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.drive);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        double x;
        x = -driveStick.getX() * Robot.drive.reversed;//X has a reversed value and has to be negative.
        double y;
        y = driveStick.getY() * Robot.drive.reversed;
        
        if((-deadZone < x) && (x < deadZone) && (-deadZone < y) && (y < deadZone)){//Checking if the joystick is in the deadzone.
            leftSpeed = 0;//Shouldn't move while inside deadzone.
            rightSpeed = 0;//Same as above.
        }
        else{ 
            leftSpeed = y + x;//y is speed, and x is turn. We found out that the left motor's value should be speed + turn.
            rightSpeed = y - x;//Same as above, but the right motor's value should be speed - turn.
        }
        
        if(leftSpeed > 0.5){//Limiting the speeds to between 1 and -1.
           leftSpeed = 0.5;//change all 0.5s to ones
        }
        else if(leftSpeed < -0.5){
            leftSpeed = -0.5;
        }
        
        if(rightSpeed > 0.5){
            rightSpeed = 0.5;
        }
        else if(rightSpeed < -0.5){
            rightSpeed = -0.5;
        }
        
        try {
            Robot.drive.controlMotorL(-leftSpeed);//Setting the left motor speed.
            Robot.drive.controlMotorR(rightSpeed);//Setting the right motor speed.
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
