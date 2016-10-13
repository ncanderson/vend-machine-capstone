package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SnackTest {

	private Snack snack;
	 
	@Before
	public void setUp() {
		snack = new Snack("A1", "Anything", "3", "5");
	}
	
	@Test
	public void snack_init_test() {
		Snack snack = new Snack("A1", "Anything", "3", "5");
		Assert.assertEquals(snack.getItemKey(), "A1");
		Assert.assertEquals(snack.getSnackName(), "Anything");
		Assert.assertEquals(snack.getCost(), 3.0, 0.0);
		Assert.assertEquals(snack.getCount(), 5);
		Assert.assertEquals(snack.getTotalSold(), 0);
	}

	@Test
	public void snack_set_count() {
		snack.setCount(500);
		Assert.assertEquals(snack.getCount(), 500);
	}
	
	@Test
	public void add_to_total_sold() {
		snack.addToTotalSold();
		Assert.assertEquals(snack.getTotalSold(), 1);
	}
	
	@Test
	public void reset_total_sold() {
		snack.addToTotalSold();
		snack.resetTotalSold();
		Assert.assertEquals(snack.getTotalSold(), 0);
	}
	
}
