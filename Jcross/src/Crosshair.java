import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Crosshair extends Frame{
    public enum shapeSelection {CIRCLE, SQUARE, CROSS_DOT, CROSS}
    public Color colorOption = Color.RED;
    public int sizeOption = 32;
    public shapeSelection selectedShape = shapeSelection.CROSS_DOT;
    public Shape shapeOption = ShapeLibrary.CrossDotted(sizeOption);

    public Crosshair(){
        super();
        configureSelf();
        setVisible(true);
    }

    void configureSelf() {
        //borderless
        setUndecorated(true);
        //set color
        Color modColor = new Color(colorOption.getRed(), colorOption.getGreen(), colorOption.getBlue(), 180);
        setBackground(modColor);
        //on top
        setAlwaysOnTop(true);
        //Make the window a circle shape
        setShape(shapeOption);
        //center the window
        center();
        //exit when user closes application from task bar
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
    }

    void center(){
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        setBounds(center.x - sizeOption / 2, center.y - sizeOption / 2, sizeOption*4, sizeOption*4);
    }

    public void setXOffset(int offset){
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        setBounds(center.x - sizeOption / 2, getY(), getWidth(), getHeight());
        setBounds(getX()+offset, getY(), getWidth(), getHeight());
        repaint();
    }

    public void setYOffset(int offset){
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        setBounds(getX(), center.y - sizeOption / 2, getWidth(), getHeight());
        setBounds(getX(), getY()+offset, getWidth(), getHeight());
        repaint();
    }

    public void setSize(int size){
        sizeOption = size;
        switch(selectedShape){
            case CROSS -> shapeOption = ShapeLibrary.CrossUnDotted(size);
            case CROSS_DOT -> shapeOption = ShapeLibrary.CrossDotted(size);
            case CIRCLE -> shapeOption = ShapeLibrary.Circle(size);
            case SQUARE -> shapeOption = ShapeLibrary.Square(size);
        }
        setBounds(getX(), getY() , sizeOption, sizeOption);
        setShape(shapeOption);
        repaint();
    }

    public void setShapeSelection(shapeSelection selectedShape){
        switch(selectedShape){
            case CROSS -> shapeOption = ShapeLibrary.CrossUnDotted(sizeOption);
            case CROSS_DOT -> shapeOption = ShapeLibrary.CrossDotted(sizeOption);
            case CIRCLE -> shapeOption = ShapeLibrary.Circle(sizeOption);
            case SQUARE -> shapeOption = ShapeLibrary.Square(sizeOption);
        }
        setBounds(getX(), getY() , sizeOption, sizeOption);
        setShape(shapeOption);
        repaint();
    }

    public void setColor(Color c){
        colorOption = c;
        //set color
        Color modColor = new Color(colorOption.getRed(), colorOption.getGreen(), colorOption.getBlue(), 180);
        setBackground(modColor);
        repaint();
    }

}
