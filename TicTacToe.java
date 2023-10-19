import com.sun.security.jgss.GSSUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TicTacToe {
    public static void main() {

        SwingUtilities.invokeLater(() -> createAndShowPopup());
    }

    public static void createAndShowPopup() {
        JFrame frame = new JFrame("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800); // Set the size of the window

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(3, 3, 50, 50)); // 3x3 grid with spacing
        gridPanel.setBackground(Color.WHITE);
        for (int i = 0; i < 9; i++) {
            JPanel square = createSquare();
            gridPanel.add(square);
        }

        mainPanel.add(gridPanel, BorderLayout.CENTER); // Center the grid within the window
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); // Add spacing around the grid

        frame.add(mainPanel);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
static int tempx = 0;
    public static JPanel createSquare() {
        JPanel square = new JPanel();
        square.setBackground(Color.BLACK);
        square.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tempx +=1;
                if (tempx % 2 == 0){
                    square.setBackground(Color.RED);
                }
                if (tempx % 2 == 1){
                    square.setBackground(Color.GREEN);
                }

            }
        });
        return square;
    }
}
