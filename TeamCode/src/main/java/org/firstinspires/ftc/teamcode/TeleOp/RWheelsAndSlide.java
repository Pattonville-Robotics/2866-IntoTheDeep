package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp
public class RWheelsAndSlide extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {
        //Wheels: 0fL, 1bL, 2fR, 3bR
        DcMotor motorBackRight = hardwareMap.dcMotor.get("backRight");
        DcMotor motorFrontRight = hardwareMap.dcMotor.get("frontRight");
        DcMotor motorBackLeft = hardwareMap.dcMotor.get("backLeft");
        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("frontLeft");

        // Slides:
        DcMotor motorLinSlideLEFT = hardwareMap.dcMotor.get("lSlideLEFT");
        DcMotor motorLinSlideRIGHT = hardwareMap.dcMotor.get("lSlideRIGHT");

        DcMotor motorBoomArm = hardwareMap.dcMotor.get("boomArm");

        motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);
        motorBackLeft.setDirection(DcMotor.Direction.REVERSE);
        waitForStart();
        while (opModeIsActive()) {
            double y = gamepad1.left_stick_y; // Remember, this is reversed!
            double x = -gamepad1.left_stick_x;
            double rx = gamepad1.right_stick_x;
            double speed;
            double linearSlidePower = 0;
            double boomArmPower = 0;

            if (gamepad1.right_trigger>0) {
                speed = 0.8;
            } else if (gamepad1.left_trigger>0){
                speed = 0.2;
            } else {
                speed = 0.4;
            }



            if (gamepad2.left_bumper) {
                linearSlidePower = 0.5;
            } else if (gamepad2.right_bumper) {
                linearSlidePower = -0.5;
            } else {
                linearSlidePower = 0;
            }

            if (gamepad2.dpad_up) {
                boomArmPower = 0.2;
            } else if (gamepad2.dpad_down) {
                boomArmPower = -0.2;
            } else {
                boomArmPower = 0;
            }



            double den = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (Math.pow((y + x + rx),3) * speed) / den;
            double backLeftPower = (Math.pow((y - x + rx),3) * speed) / den;
            double frontRightPower = (Math.pow((y - x - rx),3) * speed) / den;
            double backRightPower = -(Math.pow((y + x - rx),3) * speed) / den;

            motorFrontLeft.setPower(frontLeftPower);
            motorBackLeft.setPower(backLeftPower);
            motorFrontRight.setPower(frontRightPower);
            motorBackRight.setPower(backRightPower);

            motorLinSlideLEFT.setPower(linearSlidePower);
            motorLinSlideRIGHT.setPower(linearSlidePower);

            motorBoomArm.setPower(boomArmPower);
        }
    }
}
