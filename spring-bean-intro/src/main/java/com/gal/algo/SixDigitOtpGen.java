package com.gal.algo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component(value="sixDigitOtpGenerator")
public class SixDigitOtpGen implements OtpGenerator {
	public String getOtp() {
		return "" + new Random().nextInt(1000000);
	}
}
