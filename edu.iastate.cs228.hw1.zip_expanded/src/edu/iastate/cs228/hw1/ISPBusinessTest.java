package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;




import org.junit.jupiter.api.Test;

class ISPBusinessTest {
    

	
	@Test
	public void testCensus() 
	{
		Town town_test = new Town(2,2);
		town_test.grid[0][0] = new Empty(town_test,0,0);
		town_test.grid[0][1] = new Empty(town_test,0,1);
		town_test.grid[1][0] = new Casual(town_test,1,0);
		town_test.grid[1][1] = new Casual(town_test,1,1);
        
		assertEquals(2, ISPBusiness.getProfit(town_test));
	}
}
