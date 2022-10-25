public class Plot 
{
	private int x;
	private int y;
	private int width;
	private int depth;
	
	public Plot()
	{
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	public Plot(int x, int y, int width, int depth)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	public Plot(Plot otherPlot)
	{
		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
	}
	
	public boolean overlaps(Plot plot)
	{ 
	    int xCoordinateTRight = x + width; 
	    int yCoordinateTRight = y + depth;
	    int xCoordainteBLeft = x;
	    int yCoordinateBLeft = y;
	    int xCoordinatePlotTRight = plot.getX() + plot.getWidth(); 
	    int yCoordinatePlotTRight = plot.getY() + plot.getDepth();
	    int xCoordinatePlotBLeft = plot.getX();
	    int yCoordinatePlotBLeft = plot.getY();

	        if((xCoordinatePlotBLeft < xCoordinateTRight) && (xCoordainteBLeft < xCoordinatePlotTRight) && (yCoordinatePlotBLeft < yCoordinateTRight) && (yCoordinateBLeft < yCoordinatePlotTRight))
	        	return true;
	        else 
	        	return false;
	}
	
	public boolean encompasses(Plot plot)
	{ 
	        int xCoordinateTRight = x + width;
	        int yCoordinateTRight = y + depth;
	        int xCoordainteBLeft = x;
	        int yCoordinateBLeft = y; 
	        int xCoordinatePlotTRight = plot.getX() + plot.getWidth();
	        int yCoordinatePlotTRight = plot.getY() + plot.getDepth();
	        int xCoordinatePlotBLeft = plot.getX();
	        int yCoordinatePlotBLeft = plot.getY(); 
	        
	        if((xCoordainteBLeft <= xCoordinatePlotBLeft) && (xCoordinateTRight >= xCoordinatePlotTRight) && (yCoordinateBLeft <= yCoordinatePlotBLeft) && (yCoordinateTRight >= yCoordinatePlotTRight))
	            return true;
	        else
	            return false;
	}
	
	public void setX(int x) 
	{
		this.x = x;
	}
	
	public void setY(int y) 
	{
		this.y = y;
	}
	
	public void setWidth(int width) 
	{
		this.width = width;
	}
	
	public void setDepth(int depth) 
	{
		this.depth = depth;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getDepth()
	{
		return depth;
	}
	
	public String toString()
	{
		return "Upper left: " + x + "," + y + " Width: " + width + " Depth: " + depth;
	}
	
}
