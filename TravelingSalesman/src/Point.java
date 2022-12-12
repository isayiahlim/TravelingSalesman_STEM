// ===============================================================================================
//
//                                         DO NOT MODIFY
//
// ===============================================================================================

/*************************************************************************
 *
 * Taken from Section 3.2, An Introduction to Programming (in Java) by Robert Sedgewick and Kevin
 * Wayne
 *
 * Immutable data type for 2D points with floating-point coordinates.
 *
 *************************************************************************/

public class Point
{
    // Cartesian coordinates
    private final double x;
    private final double y;

    /**
     * Creates and initialize a point with given (x, y).
     */
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the Euclidean distance between the two points.
     */
    public double distanceTo(Point that)
    {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Draws this point to standard drawing.
     */
    public void draw()
    {
        StdDraw.point(x, y);
    }

    /**
     * Draws the line segment between the two points to standard drawing.
     */
    public void drawTo(Point that)
    {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    /**
     * Returns a string representation of this point.
     */
    @Override
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }
}
