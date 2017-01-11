package org.usfirst.frc.team6317.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;

public class Robot extends SampleRobot {	
	RobotDrive myDrive;
	public SpeedController left, right, intake, outake;
	Joystick l, r;
	
	@Override
	public void robotInit(){
		left = new Victor(0);
		right = new Victor(1);
		intake = new Victor(2);
		outake = new Victor(3);
        l = new Joystick(0);
        r = new Joystick(1);
		myDrive = new RobotDrive(left, right);
		myDrive.setSafetyEnabled(false);
		System.out.println("Robot initialized");
	}

	public void disabled() {
		System.out.println("Disabled");
	}

	public void autonomous(){
		if (isEnabled()) System.out.println("Autonomous Enabled");
		while (isAutonomous() && isEnabled() ){
			//insert autonomous code
		}
	}

	@Override
    public void operatorControl() {
		if (isEnabled()) System.out.println("TeleOp Enabled");
        while (isOperatorControl() && isEnabled()) {
            left.set(0);
            right.set(0);
            left.set((l.getY()));
            right.set(-(r.getY()));
            Timer.delay(0.001);
        }
	}
} 