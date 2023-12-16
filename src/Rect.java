package src;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

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
        init();
    }

    public Rect(Component r, Color c) {
        this.RECT_COLOR = c;
        this.RECT_X = r.getX();
        this.RECT_Y = r.getY();
        this.RECT_HEIGHT = r.getHeight() - RECT_Y;
        this.RECT_WIDTH = r.getWidth() - RECT_X;
        init();
    }

    // Initializing location and size
    public void init() {
        this.setLocation(this.getX(), this.getY());
        Dimension size = this.getPreferredSize();
        this.setSize((int) size.width, (int) size.height);
    }

    // Drawing the rectangle on screen
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(RECT_COLOR);
        g.fillRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(RECT_WIDTH + RECT_X, RECT_HEIGHT + RECT_Y);
    }

    @Override
    public int getX() {
        return this.RECT_X;
    }

    @Override
    public int getY() {
        return this.RECT_Y;
    }

    public Color getColor() {
        return this.RECT_COLOR;
    }
}
