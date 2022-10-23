package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CasualTest {

    @Test
    void testA() {
        Town town_test1 = new Town(2,2);
        town_test1.grid[0][0] = new Casual( town_test1,0,0);
        town_test1.grid[0][1] = new Streamer( town_test1,0,1);
        town_test1.grid[1][0] = new Casual( town_test1,1,0);
        town_test1.grid[1][1] = new Casual( town_test1,1,1);
        assertEquals(State.RESELLER,  town_test1.grid[0][0].next(town_test1).who());
    }

    @Test
    void testB() {
        Town  town_test1 = new Town(2,2);
        town_test1.grid[0][0] = new Casual(town_test1,0,0);
        town_test1.grid[0][1] = new Casual( town_test1,0,1);
        town_test1.grid[1][0] = new Casual( town_test1,1,0);
        town_test1.grid[1][1] = new Casual( town_test1,1,1);
        assertEquals(State.RESELLER,  town_test1.grid[0][0].next( town_test1).who());
        
        Town town_test2 = new Town(2,2);
        
        for(int i = 0; i < town_test2.getLength();i++) {
        	for(int j = 0; j < town_test2.getWidth(); j++) {
        		town_test2.grid[i][j]= new Casual(town_test2, i, j);
        	}
        }
        town_test2.toString();
        assertEquals(4, ISPBusiness.getProfit(town_test2));
        
    }

}