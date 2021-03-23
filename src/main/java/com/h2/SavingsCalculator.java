package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {
	private float[] debits;
	private float[] credits;
	
	public SavingsCalculator(float[] debits, float[] credits) {
		this.debits = debits;
		this.credits = credits;
	}
	
	public static void main(String[] args) {
		String[] creditsAsString = args[0].split(",");
		String[] debitsAsStrings = args[1].split(",");
		
		float[] credits = new float[creditsAsString.length];
		float[] debits = new float[debitsAsStrings.length];
		
		for (int i = 0; i < creditsAsString.length; i++) {
			credits[i]=Float.parseFloat(creditsAsString[i]);
		}
		
		for (int i = 0; i < debitsAsStrings.length; i++) {
			debits[i]=Float.parseFloat(debitsAsStrings[i]);
		}
		
		SavingsCalculator calculator = new SavingsCalculator(debits, credits);
		float netSavings = calculator.calculate();
		
		System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
		
	}
	
	private static int remainingDaysInMonth(LocalDate date) {
		YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
		int totalDaysInMonth = yearMonth.lengthOfMonth();
		int remainingDays = totalDaysInMonth-date.getDayOfMonth();
		return remainingDays;
	}
	
	public float calculate() {
		return sumOfCredits()-sumOfDebits();
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
