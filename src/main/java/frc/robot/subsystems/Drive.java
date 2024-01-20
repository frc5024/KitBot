
package frc.robot.subsystems;


import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.DriveCommand;

public class Drive extends SubsystemBase {
  private static Drive mInstance = null;
  
  private TalonFX rightMaster;
  private TalonFX rightFollower;
  private TalonFX leftMaster;
  private TalonFX leftFollower;


  //Set Singleton
  public static Drive getInstance() {
		if (mInstance == null) {
			mInstance = new Drive();
		}

		return mInstance;
		
	}
  public Drive() {
    super();
    //
    rightMaster = new TalonFX(1);
    rightFollower = new TalonFX(2);
    leftMaster = new TalonFX(3);
    leftFollower = new TalonFX(4);

    //leftFollower.follow(leftMaster);
    //rightFollower.follow(rightMaster);

  }
  //Tells motors to go forwards/backwards
  public void setSpeed(double leftSpeed, double rightSpeed){
    leftMaster.set(-leftSpeed);
    rightMaster.set(rightSpeed);
  }
  //Tells motors to stop
  public void stop(){
		leftMaster.stopMotor();
		rightMaster.stopMotor();
	}


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  
}
