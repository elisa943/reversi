import static java.lang.Math.*;
import java.util.Arrays;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*; 

public class Draw {
    private int x;
    private int y;
    private Graphics g;
    static final int DISK_RADIUS = 45;

    public Draw(int x, int y, Graphics g) {
        this.x = x;
        this.y = y;
        this.g = g;
    }

    public void display_disk() {
        g.setColor(Color.BLACK);
        g.drawOval(x, y, DISK_RADIUS, DISK_RADIUS);
    }

}