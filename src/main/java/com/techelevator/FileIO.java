package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * handle all the input and output for the vending machine
 * 1) importing inventory
 * 2) logging sales log after each item sold
 * 3) compiling sales report when requested (from sales log)
 * 4) (optional) rewriting inventory file(.csv) when machine closes
 * 5) (optional) make maintenance sub-menu, for making sales report, shut down machine, //
 * 				 restock machine 
 *
 */
public class FileIO {

	private static BufferedReader buffReader = null;
	private static File reportFile = null;
	private static FileOutputStream reportOutputStream = null; 
	private static PrintWriter writer = null;
	private static Date date = null;
	private static NumberFormat fmt = NumberFormat.getCurrencyInstance();
	
	/**
	 * Import inventory file from file system, to construct machine inventory
	 * @param fileName
	 * @return
	 */
	public static List<Snack> importInventory(String fileName) {
		
		List<Snack> machineInventory = new ArrayList<Snack>();
		
		try {
			File inputFile = new File(fileName);
			FileReader reader = new FileReader(inputFile); 
			buffReader = new BufferedReader(reader);
			
			String line = buffReader.readLine();
			
			while (line != null) {
				String[] splitUpItems = line.split("\\|");
				Snack snack = new Snack(splitUpItems[0], splitUpItems[1], splitUpItems[2], splitUpItems[3]);
				machineInventory.add(snack);
				line = buffReader.readLine();
			}  	
		}
		catch (FileNotFoundException e) {
			System.err.println("File not found");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.err.println("Problem with buffReader");
			e.printStackTrace();
		}
		return machineInventory;
	}
	/**
	 * takes in snack purchased, logs sales data to transactionlog.txt file
	 * @param snack
	 * @param moneyPutIn
	 */
	public static void logSales(Snack snack, double moneyPutIn) {
		writer = turnOnThePrinter("transactionlog.txt");
		DateFormat salesLogFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		date = new Date();
		
		writer.println(salesLogFormat.format(date) + "\t" + snack.getSnackName() + " " + snack.getItemKey() + "\t" + fmt.format(moneyPutIn) + "\t" + (moneyPutIn - snack.getCost()));
		writer.flush();
	}
		
	/**
	 * create sales log file from current machien information
	 * @param snackMachine
	 */
	public static void salesReport(Inventory snackMachine) {
		date = new Date();
		DateFormat salesReportFormat = new SimpleDateFormat("dd:MM:yyyy-HH:mm:ss");
		String reportFileName = "VendoTron-4000-Sales-" + salesReportFormat.format(date) + ".csv";
		writer = turnOnThePrinter(reportFileName);		
		double totalGrossSales = 0.0;
		
		for (Snack snack : snackMachine.getMachineInventory()) {
			writer.println(snack.getTotalSold() + " " + snack.getSnackName());
			totalGrossSales += snack.getTotalSold() * snack.getCost();
			snack.resetTotalSold();
		}
		
		writer.println("\nTotal Sales: " + fmt.format(totalGrossSales));
		writer.flush();
	}

	public static void rewriteMachineInventoryToFile() {
		
	}
	
	
	/**
	 * create the printwriter used by other methods in this class	
	 * @param fileName
	 * @return
	 */
	private static PrintWriter turnOnThePrinter(String fileName) {
		reportFile = new File(fileName);
		try { 
			reportOutputStream = new FileOutputStream(reportFile, true);
		} 
		catch (FileNotFoundException e) {
			System.err.println("File not found");
			e.printStackTrace();
		}
		return new PrintWriter(reportOutputStream);
	}
}
