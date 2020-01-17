package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePanel extends BasePanel{

    private final String TITLE = "AlgorithmVisualization";
    private Font font;
    JButton startBtn;
    public HomePanel() {
        setLayout(new FlowLayout());
        setBackground(Color.WHITE);
        font = new Font("Serrif", Font.BOLD, 50);
        setUpBtn();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(font);
        g2d.drawString(TITLE,(getWidth() / 2) - g2d.getFontMetrics().stringWidth(TITLE) / 2, 120 );

    }

    private void setUpBtn(){
        startBtn = new JButton();
        startBtn.addActionListener(e -> {

        });

        add(startBtn);

    }


}
