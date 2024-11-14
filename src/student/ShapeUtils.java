package student;

public class ShapeUtils {
    /**
     * @param p1 point1
     * @param p2 point2
     * @return the distance between them
     */
    public static double distance(Point p1, Point p2) {
        double tempNum1 = Math.pow(p1.getX() - p2.getX(), 2);
        double tempNum2 = Math.pow(p1.getY() - p2.getY(), 2);
        return Math.sqrt(tempNum1 + tempNum2);
    }

    /**
     * @param points all the points in the point array
     * @return the point that represent the center of all points
     */
    public static Point getCenter(Point[] points) {
        if (points.length == 0) {
            return new Point(0, 0);
        } else {
            double sumOfX = 0;
            double sumOfY = 0;
            for (int i = 0; i < points.length; i++) {
                sumOfX += points[i].getX();
                sumOfY += points[i].getY();
            }
            return new Point((sumOfX / points.length), (sumOfY / points.length));
        }
    }

    /**
     * @param c the name of a ring
     * @return the area of this ring
     */
    public static double getArea(Ring c) {
        double outerArea;
        double innerArea;
        double innerRadius;
        double outerRadius;
        innerRadius = c.getInnerCircle().getRadius();
        innerArea = Math.pow(innerRadius, 2) * Math.PI;
        outerRadius = c.getInnerCircle().getRadius() + c.getThickness();
        outerArea = Math.pow(outerRadius, 2) * Math.PI;
        return outerArea - innerArea;
    }

    /**
     * @param c the circle's name
     * @return the area of this circle
     */
    public static double getArea(Circle c) {
        return Math.PI * Math.pow(c.getRadius(), 2);
    }

    /**
     * @param c the name of the circle.
     * @param p the point
     * @return if the point in this circle, return true.
     */
    public static boolean isIn(Circle c, Point p) {
        double x = c.getCenter().getX() - p.getX();
        double y = c.getCenter().getY() - p.getY();
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) <= c.getRadius();
    }
}
