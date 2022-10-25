import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent 
{
	Property testProperty;
	ManagementCompany mangementCompany ; 
	
	@Before
	public void setUp() throws Exception 
	{
		mangementCompany= new ManagementCompany("Romeo", "777777",6);
	}

	@After
	public void tearDown() throws Exception 
	{
		mangementCompany=null;
	}

	@Test
	public void testAddProperty() 
	{
		testProperty = new Property ("Exquisite", "Drogba", 3456, "Mickey Mouse",3,6,3,3);		 
		assertEquals(mangementCompany.addProperty(testProperty),1,1);	
	}
	
	@Test
	public void testGetPropertiesCount() 
	{
		testProperty = new Property ("Exquisite", "Drogba", 3456, "Mickey Mouse",3,6,3,3);		 
		assertEquals(mangementCompany.addProperty(testProperty),1,1);	
		assertEquals(mangementCompany.getPropertiesCount(), 2);
	}

	@Test
	public void testToString() 
	{
		assertEquals("12,12,6,6", mangementCompany.toString());
	}
}
