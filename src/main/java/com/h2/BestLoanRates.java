package com.h2;

import java.util.Map;
import java.util.Scanner;

public class BestLoanRates {
	
	public static final Map<Integer, Float> BESTRATES = Map.of(1, 5.50f, 2, 3.45f, 3, 2.67f);
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name");
		String name = scanner.nextLine();
		System.out.println(String.format("Hello %s", name));
		System.out.println("Enter the loan term (in years)");
		int loanTermInYears = scanner.nextInt();
		float bestRate = getRates(loanTermInYears);
		if(bestRate==0.0f) System.out.println(String.format("No available rates for term: %d years", loanTermInYears));
		else System.out.println(String.format("Best Available Rate: %.2f%", getRates(loanTermInYears)));
		scanner.close();
	}
	
	public static float getRates(int loanTermInYears) {
		return BESTRATES.containsKey(loanTermInYears) ? BESTRATES.get(loanTermInYears) : 0.0f;
	}
}
