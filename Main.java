import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Main extends Thread {
    private final static JFrame frame = new JFrame("Sorting");
    private final static JPanel main = new JPanel();
    private final static int useableWidth = 1920 - 400;
    private final static int useableHeight = 1080 - 300;
    private static JButton generateRandomBtn;

    // Main
    public static void main(String[] args) {
        Main page = new Main();
        page.start();
    }

    // Run for multi-threading
    @Override
    public void run() {
        int n = 78;

        // Creating components
        Component[] initial = generateSortedList(n);
        generateRandomBtn = new JButton("Generate random array");
        generateRandomBtn.setBounds(875, 950, 175, 50);
        generateRandomBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component[] randomList;
                try {
                    randomList = generateRandomList(n);
                } catch (InterruptedException ie) {
                    return;
                }
                addComp(randomList);
                update();
            }

        });
        // Adding all the components and initializing the screen
        addComp(initial);
        frame.add(generateRandomBtn);
        update();
        init();
    }

    // Updating canvas
    public static void update() {
        main.validate();
        main.repaint();
        frame.repaint();
    }

    // Generating a list of increasing numbers
    public static Component[] generateSortedList(int n) {
        Component[] arr = new Component[n];
        for (int i = 0; i < n; i++) {

            // Generating Rectangles
            Rect temp = new Rect(125 + useableWidth / (n * 2) * i, 400 - i * useableHeight / (2 * n), useableWidth / n,
                    useableHeight / n * (i + 1), new Color(250, 255 / n * i, 120));
            temp.setLocation(temp.getX(), temp.getY());
            Dimension size = temp.getPreferredSize();
            temp.setSize((int) size.width, (int) size.height);
            arr[i] = temp;
        }
        return arr;
    }

    // Generating a random list of numbers and creating their objects
    public static Component[] generateRandomList(int n) throws InterruptedException {
        Random r = new Random();
        Component[] curr = generateSortedList(n);
        for (int i = 0; i < 1000; i++) {
            // Generating 2 random numbers and swapping their positions
            int r1 = r.nextInt(n);
            int r2 = r.nextInt(n);
            Rect rr1 = new Rect(curr[r1], Color.GREEN);
            Rect rr2 = new Rect(curr[r2], Color.GREEN);
            addComp(new Component[] { rr1, rr2 });
            Component temp = curr[r1];
            curr[r1] = curr[r2];
            curr[r2] = temp;
            Thread.sleep(100);
        }
        return curr;
    }

    // Initializing the screen
    public static void init() {
        main.setVisible(true);
        main.setSize(1920, 1080);
        frame.getContentPane().add(main);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    // Add component short hand functions
    public static void addComp(Component[] cs) {
        for (Component c : cs) {
            main.add(c);
        }
        main.repaint();
    }
}