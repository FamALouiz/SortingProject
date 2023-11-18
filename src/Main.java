package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import sortingAlgorithms.BubbleSort;
import sortingAlgorithms.BubbleSortMachine;

public class Main {
    private final static JFrame frame = new JFrame("Sorting");
    private static JButton closeBtn;
    private static JButton generateRandomBtn;
    private static JButton bubbleSortBtn;
    private static JButton countSortBtn;
    private final static JPanel main = new JPanel();
    private final static GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
    private final static GraphicsDevice device = graphics.getDefaultScreenDevice();
    public final static int useableWidth = 1920 - 400;
    public final static int useableHeight = 1080 - 300;
    public static Component[] rects;
    public static int[] heights;

    // Main
    public static void main(String[] args) {
        Main page = new Main();
        page.Start();
    }

    public void Start() {
        int n = 78;

        // Creating components
        rects = generateSortedList(n);
        Main.heights = generateHeights(n);
        closeBtn = new JButton("Exit");
        closeBtn.setBounds(10, 10, 100, 50);
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exiting");
                System.exit(Main.frame.getDefaultCloseOperation());
            }
        });
        generateRandomBtn = new JButton("Generate random array");
        generateRandomBtn.setBounds(875, 950, 175, 50);
        generateRandomBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GenerateRandomList randomList = new GenerateRandomList(78);
                Thread t1 = new Thread(randomList);
                t1.start();
                update();
                Main.heights = generateHeights(n);
            }

        });
        bubbleSortBtn = new JButton("Bubble Sort");
        bubbleSortBtn.setBounds(10, 110, 100, 50);
        bubbleSortBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked bubble");
                BubbleSortMachine bubbleSort = new BubbleSortMachine();
                Thread t1 = new Thread(bubbleSort);
                t1.start();
            }
        });

        countSortBtn = new JButton("Count Sort");
        countSortBtn.setBounds(10, 210, 100, 50);
        bubbleSortBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked Count");
            }
        });

        // Adding all the components and initializing the screen
        addComp(rects);
        frame.add(closeBtn);
        frame.add(generateRandomBtn);
        frame.add(countSortBtn);
        frame.add(bubbleSortBtn);
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
            Rect temp = new Rect(125 + Main.useableWidth / (n * 2) * i, 400 - i * Main.useableHeight / (2 * n),
                    Main.useableWidth / n,
                    Main.useableHeight / n * (i + 1), new Color(250, 255 / n * i, 120));
            arr[i] = temp;
        }
        return arr;
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
        device.setFullScreenWindow(frame);
    }

    // Add component short hand functions
    public static void addComp(Component[] cs) {
        main.validate();
        for (Component c : cs) {
            main.add(c);
        }
        update();
    }

    // Returns Main panel
    public static JPanel getMainPanel() {
        return Main.main;
    }

    // Removes a certain rectangle
    public static Component removeRect(int r) {
        Component temp = Main.rects[r];
        try {
            Main.main.remove(Main.rects[r]);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
        return temp;
    }

    // Removes all rectangles
    public static void removeAllRects() {
        for (int i = 0; i < 78; i++) {
            Main.removeRect(i);
        }
    }

    // Removes a certain component from the main frame
    public static void removeComp(Component c) {
        Main.main.remove(c);
    }

    public static int[] generateHeights(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = Main.rects[i].getHeight();
        }
        return res;
    }
}
