package com.techelevator;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {

	public static void main(String[] args) {
	
		Inventory snackMachine = new Inventory("vendingmachine.csv");
		double moneyPutIn = 0.0;
		double purchaseMoney = 0.0;
		Scanner scanner = new Scanner(System.in);
		Scanner subScanner = null;
			
		boolean purchasing = true;
		boolean main = true;
		boolean shutdown = false;
		 
		while (!shutdown) {			
			scanner = new Scanner(System.in);
			
			while (main) {
				Menus.mainMenu();
				String mainMenuChoice = scanner.next();
				
				if (mainMenuChoice.equals("0")) {
					FileIO.salesReport(snackMachine);
					System.out.println();
					System.out.println("Sales report created");
					break;
				}
				else if (mainMenuChoice.equals("1")) {
					snackMachine.display();
					System.out.println();
					System.out.println("Enter 'exit' to go back");
					System.out.print(">>> ");
					subScanner = new Scanner(System.in);
					String subMenu = subScanner.next();
				} 
				else if (mainMenuChoice.equals("2")) {
					main = false;
					purchasing = true;
				}
				else if (mainMenuChoice.equals("3")) {
					main = false;
					shutdown = true;
					System.out.println("Powering down");
				}
				else {
					System.out.println("Invalid input, please try again");
				}
			} 
			
			while (purchasing) {
				
				Menus.purchaseMenu(moneyPutIn);
				
				String purchaseMenuChoice = scanner.next(); 
				
				if (purchaseMenuChoice.equals("1")) {
					System.out.println();
					System.out.println("How much money would you like to add?");
					System.out.print(">>> ");
					purchaseMoney = (double)scanner.nextInt();
					moneyPutIn += purchaseMoney;
				}
				else if (purchaseMenuChoice.equals("2")) {
					System.out.println();
					System.out.println("Select a snack to purchase");
					System.out.print(">>> ");
					String productChoice = scanner.next();
					
					List<Snack> inventory = snackMachine.getMachineInventory();
					
					boolean snackFound = false;
					for (Snack snack : inventory) {
						if (productChoice.equalsIgnoreCase(snack.getItemKey())) {
							snackFound = true;
							
							if (snack.getCount() == 0) {
								System.out.println();
								System.out.println("Selected item is sold out");
								break;
							}
							
							if (moneyPutIn < snack.getCost()) {
								System.out.println();
								System.out.println("Please insert more money");
								break;
							}
		
							FileIO.logSales(snack, moneyPutIn);
							System.out.println();
							System.out.println("Enjoy your " + snack.getSnackName() + "!");
							snack.setCount(snack.getCount() - 1);
							snack.addToTotalSold();
							moneyPutIn -= snack.getCost();
						}
					}
					
					if (snackFound == false) {
						System.out.println();
						System.out.println("Invalid item please choose again");
					}
				}
				else if (purchaseMenuChoice.equals("3")) {
					HashMap<String, Integer> change = GiveChange.giveChange(moneyPutIn);
					GiveChange.displayChange(change);
					moneyPutIn = 0;
					purchasing = false;
					main = true;
				}
				else {
					System.out.println();
					System.out.println("Invalid option, please try again");
				}
			}
		}
		scanner.close();
		subScanner.close();
	}
}
