package com.techelevator;

import java.text.NumberFormat;

public class Menus {
	
	public static void mainMenu() {
		System.out.println();
		System.out.println("************************************");
		System.out.println("** Welcome to the VendoTron 4000! **");
		System.out.println("************************************");
		System.out.println();
		System.out.println("(1) Display Vending Machine Items");
		System.out.println("(2) Purchase");
		System.out.print(">>> ");
	}
	
	public static void purchaseMenu(double moneyPutIn) {
		
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		System.out.println();
		System.out.println("************************************");
		System.out.println("**  All Your $ Are Belong To Us   **");
		System.out.println("************************************");
		System.out.println();
		System.out.println("(1) Feed Money");
		System.out.println("(2) Select Product");
		System.out.println("(3) Finish Transaction");
		System.out.println("Current money provided: " + fmt.format(moneyPutIn));
		System.out.print(">>> ");
	}
	
}
