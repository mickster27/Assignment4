import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlotTestStudent 
{
	private Plot plot1, plot2, plot3, plot4, plot5;

	@Before
	public void setUp() throws Exception
	{
		plot1 = new Plot(3, 3, 7, 7);
		plot2 = new Plot(4, 5, 5, 4);
		plot3 = new Plot(5, 6, 2, 2);
        plot4 = new Plot(2, 2, 8, 8);
        plot5 = new Plot(3, 4, 2, 2);
	}

	@After
	public void tearDown() throws Exception
	{
		plot1 = plot2 = plot3 = null;
	}

	@Test
	public void testOverlaps() 
	{
		assertTrue(plot1.overlaps(plot2)); 
	}
	
	@Test
    public void testEncompasses() 
	{
        assertTrue(plot4.encompasses(plot5));
    }
	
	@Test
	public void testToString()
	{
		assertEquals("4,5,5,4",plot2.toString());	
	}
}
