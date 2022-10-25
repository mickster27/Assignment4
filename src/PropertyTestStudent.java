import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropertyTestStudent 
{
	Property firstProperty;

	@BeforeEach
	void setUp() throws Exception
	{
		firstProperty = new Property("Property Zed", "Shinganshina", 3000.00, "Crypto Arena", 1, 1, 2, 2);
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		firstProperty = null;
	}

	@Test
	void testGetPropertyName() 
	{
		assertEquals("Property ABC", firstProperty.getPropertyName());
	}

	@Test
	void testGetRentAmount() 
	{
		assertEquals(2450.00, firstProperty.getRentAmount());
	}

	@Test
	void testGetPlot() 
	{
		assertEquals(1, firstProperty.getPlot().getX());
		assertEquals(1, firstProperty.getPlot().getY());
		assertEquals(2, firstProperty.getPlot().getWidth());
		assertEquals(2, firstProperty.getPlot().getDepth());
	}

	@Test
	void testToString() 
	{
		assertEquals("Property Zed,Shinganshina,Crypto Arena,3000.0",firstProperty.toString());	
	}
}
