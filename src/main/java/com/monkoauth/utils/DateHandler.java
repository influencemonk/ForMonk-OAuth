package com.monkoauth.utils;

import java.time.Instant;

public class DateHandler {

	public static long getCurrentTimeStamp() {
		Instant instant = Instant.now();
		return instant.getEpochSecond();
	}
	
	public static String getCurrentUTCTime() {
		return Instant.now().toString();
	}
	
}
