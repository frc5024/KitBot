
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.DriveCommand;

public class Drive extends SubsystemBase {
  private static Drive mInstance = null;
  private WPI_TalonFX talon1 = new WPI_TalonFX(1);
  private WPI_TalonFX talon2 = new WPI_TalonFX(2);
  private WPI_TalonFX talon3 = new WPI_TalonFX(3);
  private WPI_TalonFX talon4 = new WPI_TalonFX(4);

  public static Drive getInstance() {
		if (mInstance == null) {
			mInstance = new Drive();
		}

		return mInstance;
		
	}
  public Drive() {
    super();

    // talon3.setInverted(true);
    // talon4.setInverted(true);

    talon2.follow(talon1);
    // talon1.setInverted(true);
    // talon2.setInverted(true);
    talon4.follow(talon3);

  }

  public void setSpeed(double leftSpeed, double rightSpeed){
    talon1.set(leftSpeed);
    talon3.set(rightSpeed*-1);

  }

  public void stop(){
		talon1.stopMotor();
		talon3.stopMotor();
	}


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
