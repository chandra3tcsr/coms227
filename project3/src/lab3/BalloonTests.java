package lab3;

import balloon4.Balloon;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class BalloonTests 
{
	private Balloon b;
	
	@Before
	public void balloonsetup()
	{
		b = new Balloon(10);
	}
	
	@Test //1
	public void inflate()
	{
		b.pop();
		b.blow(1);
		assertEquals(0, b.getRadius());
	}
	
	@Test //2
	public void checkRadius()
	{
		b.blow(5);
		assertEquals(5,b.getRadius());
		
	}
	
	@Test //3
	public void inflateTwice()
	{
		b.blow(5);
		b.blow(5);
		assertEquals(10,b.getRadius());
	}
	
	@Test //4
	public void pop()
	{
		b.deflate();
		assertEquals(false,b.isPopped());
	}
	
	@Test //5
	public void beyondCapacity()
	{
		b.blow(20);
		assertEquals(true,b.isPopped());
	}

}