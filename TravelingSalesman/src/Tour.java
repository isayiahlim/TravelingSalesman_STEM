/**
 * <pre>
 * Name:  Isayiah Lim
 * Mrs. Kankelborg
 * Period 1
 * Project 1 Traveling Salesman
 * Last Revised on:  12/12/2022
 * </pre>
 */
public class Tour
{
    /** 
    * Internal Node class - you may add constructors
    */
    private class Node
    {
        private Point data;
        private Node next;
        public Node()
        {
        	data = null;
        	next = null;
        }
        public Node(Point p)
        {
        	data = p;
        	next = null;
        }
    }
    
    /**
    * Required fields
    */
    private Node home;
    private int size;
    
    /**
     * Creates an empty tour.
     */
    public Tour()
    {
    	home = null;
    	size = 0;
    }

    /**
     * Returns the number of points in this tour.
     */
    public int size()
    {
        return size;
    }

    /**
     * Returns the length of this tour.
     */
    public double length()
    {
        double returnLen = 0;
        Node temp = home;
        if(size <= 1) 
        	return 0;
        //runs through the entire list & back to the first
        for(int i = 0; i < size; i++)
        {
        	returnLen += temp.data.distanceTo(temp.next.data);
        	temp = temp.next;
        }
    	return returnLen;
    }

    /**
     * Returns a string representation of this tour.
     */
    public String toString()
    {
        if(size == 0) 
        	return "";
        Node temp = home.next;
    	StringBuilder returnStr = new StringBuilder("(" + home.toString() + ")\n");
    	for(int i = 1; i < size; i ++)
    	{
    		returnStr.append("(" + temp.toString() + ")\n");
    		temp = temp.next;
    	}
    	return returnStr.toString();
    }

    /**
     * Draws this tour to standard drawing.
     */
    public void draw()
    {
    	StdDraw.setPenColor(StdDraw.BLACK);
    	Node temp = home;
    	for(int i = 0; i < size+1; i ++)
    	{
    		temp.data.draw();
    		temp.data.drawTo(temp.next.data);
    	}
    }

    /**
     * Inserts p into the tour using the nearest neighbor heuristic.
     */
    public void insertNearest(Point p)
    {
    	int iterIndex = 0;
    	int storedIndex = 0;
    	Node temp = home;
    	double min = p.distanceTo(temp.data);
    	temp = temp.next;
    	for(int i = 1; i < size; i ++)
    	{
    		double tempDistance = p.distanceTo(temp.data);
    		if(tempDistance < min)
    		{
    			storedIndex = iterIndex;
    			min = tempDistance;
    		}
    		temp = temp.next;
    		iterIndex ++;
    	}
    	Node temp2 = home;
    	for(int i = 0; i < storedIndex+1; i++)
    	{
    		temp2 = temp2.next;
    	}
    	Node insert = new Node(p);
    	insert.next = temp2.next;
    	temp2.next = insert;
    }

    /**
     * Inserts p into the tour using the smallest increase heuristic.
     */
    public void insertSmallest(Point p)
    {
    	int iterIndex = 0;
    	int storedIndex = 0;
    	Node temp = home;
    	if(size == 0)
    	{	
    		home = new Node(p);
    		return;
    	}
    	if(size == 1)
    	{
    		home.next = new Node(p);
    		return;
    	}
    	double difference = temp.data.distanceTo(temp.next.data);
    	double newDistance = temp.data.distanceTo(p) + p.distanceTo(temp.next.data);
    	double smallestChange = newDistance - difference;
    	temp = temp.next;
    	for(int i = 1; i < size-1; i ++)
    	{
    		difference = temp.data.distanceTo(temp.next.data);
    		newDistance = temp.data.distanceTo(p) + p.distanceTo(temp.next.data);
    		if(newDistance - difference < smallestChange)
    		{
    			storedIndex = iterIndex;
    			smallestChange = newDistance - difference;
    		}
    		iterIndex ++;
    	}
    	
    	Node temp2 = home;
    	for(int i = 0; i < storedIndex+1; i++)
    	{
    		temp2 = temp2.next;
    	}
    	Node insert = new Node();
    	insert.data = p;
    	insert.next = temp2.next;
    	temp2.next = insert;
    }
}
