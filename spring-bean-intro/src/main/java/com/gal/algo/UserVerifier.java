package com.gal.algo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//if we make one class primary then everyone make that type of otpgenerator
//if no one is primary and the value of component has been set then it will match the name.
//above is true

@Component
public class UserVerifier {
//	@Autowired
//	OtpGenerator otpGenerator;
	@Autowired
	OtpGenerator fourDigitOtpGenerator;
	@Autowired
	OtpGenerator sixDigitOtpGenerator;
//	@Autowired
//	public UserVerifier(OtpGenerator otpGenerator) {
//		super();
//		this.otpGenerator = otpGenerator;
//	}
//	@Autowired
//	public OtpGenerator getOtpGenerator() {
//		return otpGenerator;
//	}
	@Autowired
//	public void setOtpGenerator(OtpGenerator otpGenerator) {
//		this.otpGenerator = otpGenerator;
//	}

	public void verifyUser() {
//		String otp = otpGenerator.getOtp();
		String otp2 = fourDigitOtpGenerator.getOtp();
		String otp3 = sixDigitOtpGenerator.getOtp();
		if (true) {
			System.out.println("user verified");
//			System.out.println(otp);
			System.out.println(otp2);
			System.out.println(otp3);
		}
			
		else
			System.out.println("verification failed");
	}
	
}
