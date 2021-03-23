package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {
	private float[] debits;
	private float[] credits;
	
	public SavingsCalculator(float[] debits, float[] credits) {
		super();
		this.debits = debits;
		this.credits = credits;
	}
	
	private static int remainingDaysInMonth(LocalDate date) {
		YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
		int totalDaysInMonth = yearMonth.lengthOfMonth();
		int remainingDays = totalDaysInMonth-date.getDayOfMonth();
		return remainingDays;
	}
	
	public float calculate() {
		return 0;
	}
	
	private float sumOfCredits() {
		float sum = 0.0f;
		
		for (float f : credits) {
			sum+=f;
		}
		
		return sum;
	}
	
	private float sumOfDebits() {
		float sum = 0.0f;
		
		for (float f : debits) {
			sum+=f;
		}
		
		return sum;
	}
}
