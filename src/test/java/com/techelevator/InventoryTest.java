package com.techelevator;

import org.junit.Assert;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.After;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class InventoryTest {

	private Inventory testInv;
	
	@Before
	public void setUp() {
		testInv = new Inventory("vendingmachine.csv");
	}
	
	@Test
	public void inventory_contains_a_list_of_values() {
		List<Snack> inventoryList = testInv.getMachineInventory();
		Snack item = inventoryList.get(0);
		Assert.assertEquals(item.getItemKey(), "A1");
	}
	
	@Test
	public void inventory_contains_a_list_of_snacks_last_one() {
		List<Snack> inventoryList = testInv.getMachineInventory();
		Snack item = inventoryList.get(inventoryList.size() - 1);
		Assert.assertEquals(item.getItemKey(), "D4");
	}
	 
	@Test
	public void inventory_costs_are_the_same_as_in_the_csv_file() {
		List<Snack> inventoryList = testInv.getMachineInventory();
		Snack item = inventoryList.get(0);
		boolean rightCost = item.getCost() == 3.25; 
		Assert.assertTrue(rightCost);
	}
	
	@Test
	public void inventory_costs_are_not_different_that_the_csv_file() {
		List<Snack> inventoryList = testInv.getMachineInventory();
		Snack item = inventoryList.get(0);
		boolean wrongCost = item.getCost() == 500000; 
		Assert.assertFalse(wrongCost);
	}
	
	@Test
	public void test_exception_handling_for_bad_filename() {
		Inventory badFileName = new Inventory("badName");
		Assert.assertNotNull(badFileName);
	}
}
