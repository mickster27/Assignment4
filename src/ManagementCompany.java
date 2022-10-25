public class ManagementCompany 
{
	static final int MAX_PROPERTY = 5;
	static final int MGMT_WIDTH = 10;
	static final int MGMT_DEPTH = 10;
	private String name;
	private String taxID;
	private double mgmFeePer;
	private Plot plot;
	private Property[] properties;
	private int numberOfProperties;
	
	public ManagementCompany()
	{
		this.name = "";
		this.taxID = "";
		this.plot = new Plot();
		this.properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID, double mgmFeePer)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		plot = new Plot(x, y, width, depth);
		this.properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(ManagementCompany otherCompany)
	{
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = otherCompany.plot;
		this.properties = otherCompany.properties;
	}
	
	public int addProperty(String name, String city, double rent, String owner) 
	{
		if (numberOfProperties == 5) 
		{
			return -1;
		}
		properties[numberOfProperties] = new Property(name,city,rent,owner);
		if (properties[numberOfProperties] == null)
		{
			return -2;
		}
		if (!plot.encompasses(properties[numberOfProperties].getPlot())) 
		{
			return -3;
		}
		for (int z = 0; z < numberOfProperties; z++) 
		{
			if (properties[z].getPlot().overlaps(properties[numberOfProperties].getPlot())) 
			{
				return -4;
			}
		}
		return numberOfProperties++;
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) 
	{
		if (numberOfProperties == 5) 
		{
			return -1;
		}
		properties[numberOfProperties] = new Property(name,city,rent,owner,x,y,width,depth);
		if (properties[numberOfProperties] == null) 
		{
			return -2;
		}
		if (!plot.encompasses(properties[numberOfProperties].getPlot())) 
		{
			return -3;
		}
		for (int z = 0; z < numberOfProperties; z++) 
		{
			if (properties[z].getPlot().overlaps(properties[numberOfProperties].getPlot())) 
			{
				return -4;
			}
		}
		return numberOfProperties++;
	}
	
	public int addProperty(Property property) 
	{
		if (numberOfProperties == 5) 
		{
			return -1;
		}
		properties[numberOfProperties] = new Property(property);
		if (properties[numberOfProperties] == null) 
		{
			return -2;
		}
		if (!plot.encompasses(properties[numberOfProperties].getPlot())) 
		{
			return -3;
		}
		for (int z = 0; z < numberOfProperties; z++) 
		{
			if (properties[z].getPlot().overlaps(properties[numberOfProperties].getPlot())) 
			{
				return -4;
			}
		}
		return numberOfProperties++;
	}
	
	public void removeLastProperty()
	{
		properties[(numberOfProperties - 1)] = null;
		numberOfProperties--;
	}
	
	public boolean isPropertiesFull()
	{
		return (numberOfProperties == 5);
	}
	
	public int getPropertiesCount()
	{
		int propertyCount = 0;
		for (int x = 0; x < MAX_PROPERTY; x++)
		{
			if (properties[x] != null)
			{
				propertyCount++;
			}
		}
		return propertyCount;
	}
	
	public double getTotalRent()
	{
		double totalRent = 0;
		for (int x = 0; x < properties.length; x++) 
		{
			if (properties[x] == null)
				break;
			totalRent += properties[x].getRentAmount();
		}
		return totalRent;
	}
	
	public Property getHighestRentPropperty()
	{
		int highestRent = 0;
		for (int x = 1; x < properties.length; x++) 
		{
			if (properties[x] == null)
				break;
			if (properties[highestRent].getRentAmount() < properties[x].getRentAmount()) 
			{
				highestRent = x;
			}
		}
		return properties[highestRent];
	}
	
	public boolean isMangementFeeValid()
	{
		return (mgmFeePer >= 0 && mgmFeePer <= 100);
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getTaxID()
	{
		return taxID;
	}
	
	public Property[] getProperties()
	{
		return properties;
	}
	
	public int getMAX_PROPERTY() 
	{
		return MAX_PROPERTY;
	}
	
	public double getMgmFeePer()
	{
		return mgmFeePer;
	}
	
	public Plot getPlot()
	{
		return new Plot(plot);
	}
	
	public String toString()
	{
		String propertyList = "";
		for (int x = 0; x < MAX_PROPERTY; x++) 
		{
			if (properties[x] == null) 
			{
				break;
			}
			propertyList += properties[x] + "\n";
		}
		return "List of the properties for " + name + ", taxID: " + taxID + "\n____________________________\n"
				+ propertyList + "____________________________" + "\ntotal management Fee: "
				+ (getTotalRent() * mgmFeePer / 100);
	}
}
