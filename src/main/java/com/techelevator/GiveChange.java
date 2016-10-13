package com.techelevator;

import java.util.HashMap;


public class GiveChange { 
	
	
	
	public static HashMap<String, Integer> giveChange(double moneyPutIn) {
		HashMap<String, Integer> coinsReturned = new HashMap<String, Integer>();
		int moneyInCents = (int)(moneyPutIn * 100);
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		
		while (moneyInCents >= 25) {
			quarters += 1;
			moneyInCents -= 25;
		}
		while (moneyInCents >= 10) {
			dimes += 1;
			moneyInCents -= 10;
		}
		while (moneyInCents >= 5) {
			nickels += 1;
			moneyInCents -= 5;
		}
		
		coinsReturned.put("quarters", quarters);
		coinsReturned.put("dimes", dimes);
		coinsReturned.put("nickels", nickels);
		
		return coinsReturned;
	}
	
	public static void displayChange (HashMap<String, Integer> coinsToReturn) {
		System.out.println();
		System.out.println("Your change is as follows: ");
		System.out.println("quarters: " + coinsToReturn.get("quarters"));
		System.out.println("dimes: " + coinsToReturn.get("dimes"));
		System.out.println("nickels: " + coinsToReturn.get("nickels"));
		System.out.println("Thank you for shopping with us today!");
		System.out.println();
	}
}
