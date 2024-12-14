package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.SwitchableLight;



@Autonomous(name="Auto", group="Robot")
public class RRightForward extends LinearOpMode {


    @Override
    public void runOpMode() {

        /* Declare OpMode members. */
        // Initialize the drive system variables.
        DcMotor motorFrontRight = hardwareMap.dcMotor.get("frontRight"); //
        DcMotor motorBackRight = hardwareMap.dcMotor.get("backRight");   //
        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("frontLeft"); //
        DcMotor motorBackLeft = hardwareMap.dcMotor.get("backLeft");   //
        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // When run, this OpMode should start both motors driving forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);
        motorBackLeft.setDirection(DcMotor.Direction.REVERSE);

        // If there are encoders connected, switch to RUN_USING_ENCODER mode for greater accuracy
        motorFrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorFrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        // Wait for driver to press START)
        waitForStart();
        motorFrontRight.setPower(0.5);
        motorBackRight.setPower(0.5);
        motorFrontLeft.setPower(0.5);
        motorBackLeft.setPower(0.5);

        sleep(1000);
        motorFrontRight.setPower(0);
        motorBackRight.setPower(0);
        motorFrontLeft.setPower(0);
        motorBackLeft.setPower(0);
    }
}