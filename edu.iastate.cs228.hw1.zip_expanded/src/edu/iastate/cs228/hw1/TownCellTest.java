package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class TownCellTest {
    Town town_test;
	
	@Before
	public void initialize() throws FileNotFoundException
	{
		town_test = new Town("ISP4x4.txt");
	}
	
	@Test
	public void testCensus() 
	{
		String str = town_test.grid[1][1].next(town_test).who().toString();
		assertEquals("", State.EMPTY.toString(), str); 
	}
}
