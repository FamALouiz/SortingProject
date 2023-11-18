package src;

import java.util.Random;

public class GenerateRandomList extends Thread {

    int n;

    public GenerateRandomList(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        try {
            GenerateRandomList.generateRandomList(n);
        } catch (InterruptedException e) {
            return;
        }
    }

    public static void generateRandomList(int n) throws InterruptedException {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            // Generating 2 random numbers and swapping their positions
            int rr1 = r.nextInt(n);
            int rr2 = r.nextInt(n);
            int r1 = Math.min(rr1, rr2);
            int r2 = Math.max(rr1, rr2);

            // Getting all dimension of random components
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
                continue;
            }
            // Creating new ones in their place
            Rect temp1 = new Rect(r1x, r2y, r1w, r2h, ((Rect) Main.rects[r2]).getColor());
            Rect temp2 = new Rect(r2x, r1y, r2w, r1h, ((Rect) Main.rects[r1]).getColor());

            Main.removeRect(r1);
            Main.removeRect(r2);

            Main.rects[r1] = temp1;
            Main.rects[r2] = temp2;

            int temp = Main.heights[r1];
            Main.heights[r1] = Main.heights[r2];
            Main.heights[r2] = temp;
        }
        Main.removeAllRects();
        Main.addComp(Main.rects);
    }
}
