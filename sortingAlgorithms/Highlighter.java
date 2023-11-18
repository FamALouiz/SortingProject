package sortingAlgorithms;

import src.Main;
import src.Rect;
import java.awt.Color;

public class Highlighter {
    private static final Color HIGHLIGHT_COLOR = Color.GREEN;

    public void highlight(int r) {
        Rect temp = ((Rect) (Main.rects[r]));

        // Getting all dimension of random components
        int r1x, r1y, r1w, r1h;
        try {
            r1x = temp.getX();
            r1y = temp.getY();
            r1w = temp.getWidth() - r1x;
            r1h = temp.getHeight() - r1y;
        } catch (Exception e) {
            return;
        }

        // Creating new Highlighted rectangles
        Rect highlighted = new Rect(r1x, r1y, r1w, r1h, HIGHLIGHT_COLOR);
        Main.removeRect(r);
        Main.rects[r] = highlighted;
        Main.removeAllRects();
        Main.addComp(Main.rects);

    }

    public void swapRects(int r1, int r2) {
        int r1x, r1y, r1w, r1h, r2x, r2y, r2w, r2h;
        try {
            r1x = Main.rects[r1].getX();
            r1y = Main.rects[r1].getY();
            r1w = Main.rects[r1].getWidth() - r1x;
            r1h = Main.rects[r1].getHeight() - r1y;

            r2x = Main.rects[r2].getX();
            r2y = Main.rects[r2].getY();
            r2w = Main.rects[r2].getWidth() - r2x;
            r2h = Main.rects[r2].getHeight() - r2y;
        } catch (Exception e) {
            return;
        }

        // Creating new ones in their place
        Rect temp1 = new Rect(r1x, r2y, r1w, r2h, ((Rect) Main.rects[r2]).getColor());
        Rect temp2 = new Rect(r2x, r1y, r2w, r1h, ((Rect) Main.rects[r1]).getColor());

        Main.removeRect(r1);
        Main.removeRect(r2);

        Main.rects[r1] = temp1;
        Main.rects[r2] = temp2;
    }
}
