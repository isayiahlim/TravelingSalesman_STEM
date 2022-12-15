import static org.junit.Assert.assertEquals;
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
    	Tour temp = new Tour(p);
    	System.out.print("Test one:\n" + test + temp);
    	System.out.println();
    	assertEquals(test.size(), temp.size());
    }
    
    @Test
    public void testinsertNearestFirst()
    {
        Point p = new Point(0,0);
        Point p2 = new Point(10,10);
        Tour test = new Tour();
    	test.insertNearest(p);
    	test.insertNearest(p2);
    	Tour temp = new Tour(p);
    	temp.insertNearest(p2);
    	System.out.print("Test two:\n" + test +"\n"+ temp);
    	assertEquals(test.size(), temp.size());
    }
}
