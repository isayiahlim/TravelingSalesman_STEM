import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TourTest
{
    @Test
    public void testinsertNearestEmpty()
    {
        Point p = new Point(0,0);
        Tour test = new Tour();
    	test.insertNearest(p);
    	String temp = "(0.0, 0.0)\n";
    	System.out.print("Nearest insert into empty:\n" + test + temp);
    	System.out.println();
    	assertTrue(test.toString().equals(temp));
    }
    
    @Test
    public void testinsertNearestFirst()
    {
        Point p = new Point(0,0);
        Point p2 = new Point(10,10);
        Tour test = new Tour();
    	test.insertNearest(p);
    	test.insertNearest(p2);
    	String temp = "(0.0, 0.0)\n(10.0, 10.0)\n";
    	System.out.print("Nearest insert size 1:\n" + test + temp + "\n");
    	assertTrue(test.toString().equals(temp));
    }
    @Test
    public void testinsertNearestSame()
    {
        Point p = new Point(9,9);
        Point p2 = new Point(10,10);
        Point p3 = new Point(11,11);
        Point p4 = new Point(9.5,9.5);
        Tour test = new Tour();
    	test.insertNearest(p);
    	test.insertNearest(p2);
    	test.insertNearest(p3);
    	test.insertNearest(p4);
    	String temp = "(9.0, 9.0)\n(9.5, 9.5)\n(10.0, 10.0)\n(11.0, 11.0)\n";
    	System.out.print("Nearest same distance:\n" + test.toString() + temp + "\n");
    	assertTrue(test.toString().equals(temp));
    }
    @Test
    public void testinsertSmallestEmpty()
    {
        Point p = new Point(0,0);
        Tour test = new Tour();
    	test.insertSmallest(p);
    	String temp = "(0.0, 0.0)\n";
    	System.out.print("Smallest insert empty:\n" + test + temp);
    	System.out.println();
    	assertTrue(test.toString().equals(temp));
    }
    
    @Test
    public void testinsertSmallestFirst()
    {
        Point p = new Point(0,0);
        Point p2 = new Point(10,10);
        Tour test = new Tour();
    	test.insertSmallest(p);
    	test.insertSmallest(p2);
    	String temp = "(0.0, 0.0)\n(10.0, 10.0)\n";
    	System.out.print("Smallest insert 1:\n" + test + temp+ "\n");
    	assertTrue(test.toString().equals(temp));
    }
    
    @Test
    public void testinsertSmallestSame()
    {
        Point p = new Point(9,9);
        Point p2 = new Point(10,10);
        Point p3 = new Point(11,11);
        Point p4 = new Point(9.5,9.5);
        Tour test = new Tour();
    	test.insertSmallest(p);
    	test.insertSmallest(p2);
    	test.insertSmallest(p3);
    	test.insertSmallest(p4);
    	String temp = "(9.0, 9.0)\n(9.5, 9.5)\n(11.0, 11.0)\n(10.0, 10.0)\n";
    	System.out.print("Smallest same distance:\n" + test.toString() + temp + "\n");
    	assertTrue(test.toString().equals(temp));
    }
}
