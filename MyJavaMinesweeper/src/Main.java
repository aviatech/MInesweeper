

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {
    private final JFrame frame = new JFrame();
    private int COLS = 9;
    private int ROWS = 9;
    private int IMAGE_SIZE = 40;

    public static void main(String[] args) {
        new Main();
    }
    private void initFrame() {
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setMinimumSize(new Dimension(300, 300));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setIconImage(getImage("icon_Minesweeper"));
        frame.setTitle("Minesweeper");
    }

    private void initPanel() {
        JPanel panelGameBoard = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(getImage("boom"), 0, 0, this);
                g.drawImage(getImage("bomb"), IMAGE_SIZE, 0, this);
                g.drawImage(getImage("flag"), 0, IMAGE_SIZE, this);
                g.drawImage(getImage("boom"), IMAGE_SIZE, IMAGE_SIZE, this);
            }
        };

        panelGameBoard.setPreferredSize(new Dimension(COLS * IMAGE_SIZE, ROWS * IMAGE_SIZE));
        Border border = BorderFactory.createEtchedBorder();
        panelGameBoard.setBorder(border);
        frame.add(panelGameBoard, BorderLayout.CENTER);


    }


    private Main() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initPanel();
                initFrame();

            }
        });
    }

    public Image getImage(String name) {
        String fileName = "images/" + name + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(fileName));
        return icon.getImage();
    }


}