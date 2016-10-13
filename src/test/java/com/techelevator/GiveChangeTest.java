package com.techelevator;

import org.junit.Assert;

import java.util.HashMap;

import org.junit.Test;

public class GiveChangeTest {
	
	@Test
	public void give_change_returns_expected_amount() {
		HashMap<String, Integer> coinsReturned = new HashMap<String, Integer>();
		coinsReturned.put("nickels", 0);
		coinsReturned.put("quarters", 4);
		coinsReturned.put("dimes", 0);
		HashMap<String, Integer> testMap = GiveChange.giveChange(1.00);
		Assert.assertEquals(testMap, coinsReturned);
	}
	
	@Test
	public void testing_all_coin_amounts() {
		HashMap<String, Integer> coinsReturned = new HashMap<String, Integer>();
		coinsReturned.put("nickels", 1);
		coinsReturned.put("quarters", 2);
		coinsReturned.put("dimes", 1);
		HashMap<String, Integer> testMap = GiveChange.giveChange(.65);
		Assert.assertEquals(testMap, coinsReturned);
	}
}
