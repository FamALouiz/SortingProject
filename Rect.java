import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;

public class Rect extends JPanel {

    private int RECT_X;
    private int RECT_Y;
    private int RECT_WIDTH;
    private int RECT_HEIGHT;
    private Color RECT_COLOR;

    public Rect(int x, int y, int w, int h, Color c) {
        this.RECT_X = x;
        this.RECT_Y = y;
        this.RECT_WIDTH = w;
        this.RECT_HEIGHT = h;
        this.RECT_COLOR = c;
    }

    public Rect(Component r, Color c) {
        this.RECT_COLOR = c;
        this.RECT_HEIGHT = r.getHeight();
        this.RECT_WIDTH = r.getWidth();
        this.RECT_X = r.getX();
        this.RECT_Y = r.getY();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(RECT_COLOR);
        g.fillRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
    }

    @Override
    public Dimension getPreferredSize() {
        // so that our GUI is big enough
        return new Dimension(RECT_WIDTH + 1 * RECT_X, RECT_HEIGHT + 1 * RECT_Y);
    }

    public int getX() {
        return this.RECT_X;
    }

    public int getY() {
        return this.RECT_Y;
    }
}
