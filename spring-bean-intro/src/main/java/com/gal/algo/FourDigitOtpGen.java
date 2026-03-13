package com.gal.algo;

import java.util.Random;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(value="fourDigitOtpGenerator")
//@Primary
public class FourDigitOtpGen implements OtpGenerator {
	public String getOtp() {
		return "" + new Random().nextInt(10000);
	}
}
