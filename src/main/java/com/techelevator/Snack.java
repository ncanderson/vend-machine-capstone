package com.techelevator;

public class Snack {

	private String itemKey;
	private String snackName;
	private double cost;
	private int count;
	private int totalSold;
	
	public Snack (String itemKey, String snackName, String cost, String count) {
		this.itemKey = itemKey;
		this.snackName = snackName;
		this.cost = Double.parseDouble(cost);
		this.count = Integer.parseInt(count);
		this.totalSold = 0;
		
	}

	public String getItemKey() {
		return itemKey;
	}

	public String getSnackName() {
		return snackName;
	}

	public double getCost() {
		return cost;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void resetTotalSold() {
		totalSold = 0;
	}
	public int getTotalSold() {
		return totalSold;
	}
	
	public void addToTotalSold() {
		totalSold ++;
	}
	
}
