import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SettingsWindow extends Frame{
    public Crosshair crossHair;

    public SettingsWindow(){
        super();
        crossHair = new Crosshair();

        configureSelf();
        setVisible(true);
    }

    void configureSelf(){
        //auto layout
        setLayout(null);
        //fixed size
        setResizable(false);
        //window size
        int width = 320;
        int height = 420;
        //center/right the window
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        setBounds(center.x + width / 2, center.y - height / 2, width, height);

        addOffsetControls();
        addSizeControls();
        addColorControls();
        addStyleControls();


        //exit when user closes application from task bar
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });

    }

    private void addSizeControls() {
        //layout container
        Panel container = new Panel(new GridLayout(1,2,0,8));
        container.setBounds(10,120,300,40);

        //configure X offset control
        Label x = new Label("Size");
        Scrollbar scroll = new Scrollbar(Scrollbar.HORIZONTAL, 16,16 ,0, 128);
        //add events
        scroll.addAdjustmentListener(e -> crossHair.setSize(scroll.getValue()));
        //add to main UI
        container.add(x);
        container.add(scroll);

        add(container);
    }

    private void addStyleControls() {
        //layout container
        Panel container = new Panel(new GridLayout(3,2,2,2));
        container.setBounds(160,170,140,150);

        Label description = new Label("Style");

        Button circleButton = new Button(" · ");
        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                crossHair.setShapeSelection(Crosshair.shapeSelection.CIRCLE);
            }
        });
        Button squareButton = new Button(" ▪ ");
        squareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                crossHair.setShapeSelection(Crosshair.shapeSelection.SQUARE);
            }
        });
        Button crossButton = new Button(" ☩ ");
        crossButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                crossHair.setShapeSelection(Crosshair.shapeSelection.CROSS);
            }
        });
        Button crossDotButton = new Button( " ✜ ");
        crossDotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crossHair.setShapeSelection(Crosshair.shapeSelection.CROSS_DOT);
            }
        });

        container.add(description);
        container.add(new Container());
        container.add(circleButton);
        container.add(squareButton);
        container.add(crossButton);
        container.add(crossDotButton);
        add(container);

    }

    private void addColorControls() {
        //layout container
        Panel container = new Panel(new GridLayout(4,3,2,2));
        container.setBounds(10,170,150,150);

        Label description = new Label("Color");

        Button redButton = new Button("");
        redButton.setBackground(Color.RED);
        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crossHair.setColor(Color.RED);
            }
        });

        Button greenButton = new Button("");
        greenButton.setBackground(Color.GREEN);
        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crossHair.setColor(Color.GREEN);
            }
        });

        Button blueButton = new Button("");
        blueButton.setBackground(Color.BLUE);
        blueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crossHair.setColor(Color.BLUE);
            }
        });

        Button cyanButton = new Button("");
        cyanButton.setBackground(Color.CYAN);
        cyanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crossHair.setColor(Color.CYAN);
            }
        });

        Button yellowButton = new Button("");
        yellowButton.setBackground(Color.YELLOW);
        yellowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crossHair.setColor(Color.YELLOW);
            }
        });

        Button magentaButton = new Button("");
        magentaButton.setBackground(Color.MAGENTA);
        magentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crossHair.setColor(Color.MAGENTA);
            }
        });

        Button orangeButton = new Button("");
        orangeButton.setBackground(Color.ORANGE);
        orangeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crossHair.setColor(Color.ORANGE);
            }
        });

        Button blackButton = new Button("");
        blackButton.setBackground(Color.BLACK);
        blackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crossHair.setColor(Color.BLACK);
            }
        });

        Button whiteButton = new Button("");
        whiteButton.setBackground(Color.WHITE);
        whiteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crossHair.setColor(Color.WHITE);
            }
        });

        //Row
        container.add(description);
        container.add(new Container());
        container.add(new Container());
        //Row
        container.add(redButton);
        container.add(greenButton);
        container.add(blueButton);
        //Row
        container.add(cyanButton);
        container.add(yellowButton);
        container.add(magentaButton);
        //Row
        container.add(orangeButton);
        container.add(blackButton);
        container.add(whiteButton);

        add(container);
    }

    private void addOffsetControls() {
        //layout container
        Panel container = new Panel(new GridLayout(2,2,0,8));
        container.setBounds(10,40,300,80);

        //configure X offset control
        Label x = new Label("X offset");
        Scrollbar xScroll = new Scrollbar(Scrollbar.HORIZONTAL, 0,16 ,-128, 128);
        //add events
        xScroll.addAdjustmentListener(e -> crossHair.setXOffset(xScroll.getValue()));
        //add to main UI
        container.add(x);
        container.add(xScroll);

        //configure Y offset control
        Label y = new Label("Y offset");
        Scrollbar yScroll = new Scrollbar(Scrollbar.HORIZONTAL, 0, 16 ,-128, 128);
        //add events
        yScroll.addAdjustmentListener(e -> crossHair.setYOffset(yScroll.getValue()));
        //add to main UI
        container.add(y);
        container.add(yScroll);

        add(container);
    }
}
