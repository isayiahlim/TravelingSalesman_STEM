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
    
    //purely for testing purposes
    public Tour(Point p)
    {
    	home = new Node(p);
    	size = 1;
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
        //runs through the entire list & back to the first, adding the distance between points
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
        //null pointer
    	if(size == 0) 
        	return null;
        Node temp = home.next;
        //call each node's toString, then adds each string to the list
    	StringBuilder returnStr = new StringBuilder(home.data + "\n");
    	for(int i = 1; i < size; i ++)
    	{
    		returnStr.append(temp.data + "\n");
    		temp = temp.next;
    	}
    	return returnStr.toString();
    }

    /**
     * Draws this tour to standard drawing.
     */
    public void draw()
    {
    	Node temp = home;
    	//null conditionals
    	if(size == 0)
    		return;
    	if(size == 1)
    	{
    		temp.data.draw();
    		return;
    	}
    	if(size > 10000)
    	{
    		StdDraw.enableDoubleBuffering();
    	}
    	//draws every point and a line connecting to the next point
    	for(int i = 0; i < size+1; i ++)
    	{
    		temp.data.draw();
    		temp.data.drawTo(temp.next.data);
    		temp = temp.next;
    	}
    	StdDraw.show();
    }

    /**
     * Inserts p into the tour using the nearest neighbor heuristic.
     */
    public void insertNearest(Point p)
    {
    	//stores the index to iterate to on the second run through
    	int storedIndex = 0;
    	Node temp = home;
    	//null conditionals, sets either the first or the second nodes
    	if(size == 0)
    	{
    		home = new Node(p);
    		size++;
    		return;
    	}
    	if(size == 1)
    	{
    		home.next = new Node(p);
    		home.next.next = home;
    		size++;
    		return;
    	}
    	//the smallest distance
    	double min = p.distanceTo(temp.data);
    	temp = temp.next;
    	for(int i = 1; i < size; i ++)
    	{
    		double tempDistance = p.distanceTo(temp.data);
    		//if there is a smaller distance, it replaces the node and stores its index
    		if(tempDistance < min)
    		{
    			storedIndex = i;
    			min = tempDistance;
    		}
    		temp = temp.next;
    	}
    	//iterates to the location of the stored node then inserts and pushes everything over
    	Node temp2 = home;
    	for(int i = 0; i < storedIndex; i++)
    	{
    		temp2 = temp2.next;
    	}
    	Node insert = new Node(p);
    	insert.next = temp2.next;
    	temp2.next = insert;
    	size ++;
    }

    /**
     * Inserts p into the tour using the smallest increase heuristic.
     */
    public void insertSmallest(Point p)
    {
    	//stores index of the smallest overall change
    	int storedIndex = 0;
    	Node temp = home;
    	//null conditional, adds either 1st or 2nd node
    	if(size == 0)
    	{	
    		home = new Node(p);
    		size ++;
    		return;
    	}
    	if(size == 1)
    	{
    		home.next = new Node(p);
    		home.next.next = home;
    		size ++;
    		return;
    	}
    	//calculates the smallest change caused by an insertion
    	double original = temp.data.distanceTo(temp.next.data);
    	double newDistance = temp.data.distanceTo(p) + p.distanceTo(temp.next.data);
    	double smallestChange = newDistance - original;
    	temp = temp.next;
    	for(int i = 1; i < size; i ++)
    	{
    		original = temp.data.distanceTo(temp.next.data);
    		newDistance = temp.data.distanceTo(p) + p.distanceTo(temp.next.data);
    		//stores the index of it to iterate to
    		if(newDistance - original < smallestChange)
    		{
    			storedIndex = i;
    			smallestChange = newDistance - original;
    		}
    		temp = temp.next;
       	}
    	//iterates to the location of the stored node then inserts and pushes everything over
    	Node temp2 = home;
    	for(int i = 0; i < storedIndex; i++)
    	{
    		temp2 = temp2.next;
    	}
    	Node insert = new Node(p);
    	insert.next = temp2.next;
    	temp2.next = insert;
    	size ++;
    }
}
