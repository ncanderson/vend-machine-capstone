package com.techelevator;

import java.text.NumberFormat;
import java.util.List;

public class Inventory {

	private List<Snack> machineInventory; 
	
	public Inventory(String fileName) {
		machineInventory = FileIO.importInventory(fileName);
	}
	
	public List<Snack> getMachineInventory() {
		return this.machineInventory;
	}
	
	public void display() {
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		System.out.println();
		for (Snack snack : machineInventory) {
			if (snack.getCount() == 0) {
				System.out.println(snack.getItemKey() + " " + snack.getSnackName() + " SOLD OUT");
			}
			else {
				System.out.println(snack.getItemKey() + " " + snack.getSnackName() + " " + fmt.format(snack.getCost()) + " " + snack.getCount());
			}
		} 
	}
	
	public static void restockMachine() {
		
	}
}
