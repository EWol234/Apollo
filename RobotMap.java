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
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType; 
/*import edu.wpi.first.wpilibj.Encoder.PIDSourceParameter;*/
import edu.wpi.first.wpilibj.can.*;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import java.util.Vector;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANJaguar catapultcatMotor1;
    public static CANJaguar catapultcatMotor2;
    public static CANJaguar catapultcatMotor3;
    public static DigitalInput catapultupperLimit;
    public static DigitalInput catapultlowerLimit;
    public static Encoder catAngle;
    public static CANJaguar driveleftrive;
    public static CANJaguar driverightDrive;
    public static Encoder leftWheelEncoder;
    public static Encoder rightWheelEncoder;
    public static AnalogChannel ultrasonicRangeFinder;
    public static DigitalInput drivephotoSensor;
    public static CANJaguar ballIntakeintakeMotor;
    public static Victor ballIntakeballEjector;
    public static DigitalInput eject;
    public static DigitalInput reseted;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        try { 
            catapultcatMotor1 = new CANJaguar(2);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
	
        
        try { 
            catapultcatMotor2 = new CANJaguar(5);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
	
        
        try { 
            catapultcatMotor3 = new CANJaguar(7);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
	
        
        catapultupperLimit = new DigitalInput(5);
	LiveWindow.addSensor("Catapult", "upperLimit", catapultupperLimit);
        
        catapultlowerLimit = new DigitalInput(6);
	LiveWindow.addSensor("Catapult", "lowerLimit", catapultlowerLimit);
        
        catAngle = new Encoder(1, 9, 1, 10, false, EncodingType.k4X);
	LiveWindow.addSensor("Catapult", "catAngle", catAngle);
        catAngle.setDistancePerPulse(1.0);
//        catAngle.setPIDSourceParameter(PIDSourceParameter.kRate);
        catAngle.start();
        try { 
            driveleftrive = new CANJaguar(10);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
	
        
        try { 
            driverightDrive = new CANJaguar(6);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
	
        
        leftWheelEncoder = new Encoder(1, 1, 1, 2, false, EncodingType.k4X);
	LiveWindow.addSensor("Drive", "leftQuadEncoder", leftWheelEncoder);
        leftWheelEncoder.setDistancePerPulse(1.0);
//        leftWheelEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        leftWheelEncoder.start();
        rightWheelEncoder = new Encoder(1, 3, 1, 4, false, EncodingType.k4X);
	LiveWindow.addSensor("Drive", "rightQuadEncoder", rightWheelEncoder);
        rightWheelEncoder.setDistancePerPulse(1.0);
//        rightWheelEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        rightWheelEncoder.start();
        ultrasonicRangeFinder = new AnalogChannel(2);
	LiveWindow.addSensor("Drive", "distanceSensor", ultrasonicRangeFinder);
        
//        drivephotoSensor = new DigitalInput(1, 3);
//	LiveWindow.addSensor("Drive", "photoSensor", drivephotoSensor);
        
        try { 
            ballIntakeintakeMotor = new CANJaguar(3);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
	
        
//        try { 
//            ballIntakeballEjector = new CANJaguar(8);
//        } catch (CANTimeoutException ex) {
//            ex.printStackTrace();
//        }
	
        
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
