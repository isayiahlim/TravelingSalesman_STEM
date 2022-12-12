import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Test driver for the Tour class that reads in sample input files, outputs basic metrics such as
 * length and size (number of points), and draws the resulting tour.
 */
public class TourDriver
{
    public static void main(String[] args)
    {
        Tour test = new Tour();
        try
        {
            String filename = "./input/tsp1000.txt"; // Try out different sample input files!
            BufferedReader bf = new BufferedReader(new FileReader(new File(filename)));
            String scale = bf.readLine();
            String[] points = scale.split(" ");
            StdDraw.setXscale(0, Double.parseDouble(points[0]));
            StdDraw.setYscale(0, Double.parseDouble(points[1]));
            String nextLine = bf.readLine();
            while (nextLine != null && !nextLine.equals(""))
            {
                // Add your code here to parse each line of the input.
                nextLine = bf.readLine();
            }
            bf.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println(test);
        System.out.println("Tour length = " + test.length());
        System.out.println("Number of points = " + test.size());

        test.draw();
    }
}
