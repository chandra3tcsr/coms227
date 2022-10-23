package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class TownTest {

	Town town_test;
	@Before
	public void initialize() throws FileNotFoundException
	{
		town_test = new Town(2, 2);
		town_test.randomInit(5);
	}

    
    @Test
    void testLength()
    {
    	assertEquals(2, town_test.getLength());
    }
    
    @Test
    void testWidth()
    {
    	assertEquals(2, town_test.getWidth());
    }
    

}