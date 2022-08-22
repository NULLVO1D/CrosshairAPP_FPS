import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ShapeLibrary {

    public static Shape Circle(int size){
        return new Ellipse2D.Double(0,0, size, size);
    }

    public static Shape Square(int size){
        return new Rectangle(0,0, size, size);
    }

    public static Shape CrossDotted(int size){
        int texel = size/9;
        int t = texel;

        int[] xPoints = {4*t,5*t,5*t,4*t,//center Dot
        4*t,4*t,4*t, 5*t, 5*t, 4*t,//top line
        4*t,4*t,4*t, 5*t, 5*t, 4*t,//bottom line
        4*t,3*t,0*t, 0*t,3*t, 3*t,//left line
        4*t,6*t,9*t, 9*t,6*t, 6*t};//right line

        int[] yPoints = {4*t,4*t,5*t,5*t,//center dot
        4*t,3*t,0*t, 0*t,3*t, 3*t,//top line
        4*t,6*t,9*t, 9*t,6*t, 6*t,//bottom line
        4*t,4*t,4*t, 5*t, 5*t, 4*t,//left line
        4*t,4*t,4*t, 5*t, 5*t, 4*t};//right line

        Polygon crossHairDotted = new Polygon();
        for (int p =0; p < xPoints.length; p++){
            crossHairDotted.addPoint(xPoints[p], yPoints[p]);
        }

        return crossHairDotted;
    }

    public static Shape CrossUnDotted(int size){
        int texel = size/9;
        int t = texel;

        int[] xPoints = {
                4*t,4*t,4*t, 5*t, 5*t, 4*t,//top line
                4*t,4*t,4*t, 5*t, 5*t, 4*t,//bottom line
                4*t,3*t,0*t, 0*t,3*t, 3*t,//left line
                4*t,6*t,9*t, 9*t,6*t, 6*t};//right line

        int[] yPoints = {
                4*t,3*t,0*t, 0*t,3*t, 3*t,//top line
                4*t,6*t,9*t, 9*t,6*t, 6*t,//bottom line
                4*t,4*t,4*t, 5*t, 5*t, 4*t,//left line
                4*t,4*t,4*t, 5*t, 5*t, 4*t};//right line

        Polygon crossHairDotted = new Polygon();
        for (int p =0; p < xPoints.length; p++){
            crossHairDotted.addPoint(xPoints[p], yPoints[p]);
        }

        return crossHairDotted;
    }

    public static Shape CircleLine(int size){
        return null;
    }

    public static Shape boxCorners(int size){
        return null;
    }

    public static Shape triCrossDotted(int size){
        return null;
    }
    public static Shape triCrossUnDotted(int size){
        return null;
    }
}
