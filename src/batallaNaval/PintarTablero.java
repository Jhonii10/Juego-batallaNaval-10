package batallaNaval;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used to draw the decoration of the boards
 */

public class PintarTablero extends JPanel {
    private int encabezado;

    /**
     * Constructor of PintarTablero class
     */

    public PintarTablero(){
        setBackground(Color.pink);
        setPreferredSize(new Dimension(506, 506));
        setLayout(new GridLayout(11,11));
    }

    /**
     * This function inserts the decoration
     */

    public void decoradoDelTablero(){
        encabezado = 1;
        repaint();
    }

    /**
     * Here the decoration is drawn and placed on the board
     * @param g
     */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (encabezado){
            case 1:
                //encabezado horizontal
                g.setColor(Color.white);
                g.fillRect(46, 0, 46, 46);
                g.setColor(Color.BLACK);
                g.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 26));
                g.drawString("A", 59, 30);
                g.setColor(Color.BLACK);
                g.drawRect(46, 0, 46, 46);

                g.setColor(Color.white);
                g.fillRect(92, 0, 46, 46);
                g.setColor(Color.BLACK);
                g.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 26));
                g.drawString("B", 105, 30);
                g.setColor(Color.BLACK);
                g.drawRect(92, 0, 46, 46);

                g.setColor(Color.white);
                g.fillRect(138, 0, 46, 46);
                g.setColor(Color.BLACK);
                g.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 26));
                g.drawString("C", 151, 30);
                g.setColor(Color.BLACK);
                g.drawRect(138, 0, 46, 46);

                g.setColor(Color.white);
                g.fillRect(184, 0, 46, 46);
                g.setColor(Color.BLACK);
                g.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 26));
                g.drawString("D", 197, 30);
                g.setColor(Color.BLACK);
                g.drawRect(184, 0, 46, 46);

                g.setColor(Color.white);
                g.fillRect(230, 0, 46, 46);
                g.setColor(Color.BLACK);
                g.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 26));
                g.drawString("E", 243, 30);
                g.setColor(Color.BLACK);
                g.drawRect(230, 0, 46, 46);

                g.setColor(Color.white);
                g.fillRect(276, 0, 46, 46);
                g.setColor(Color.BLACK);
                g.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 26));
                g.drawString("F", 289, 30);
                g.setColor(Color.BLACK);
                g.drawRect(276, 0, 46, 46);

                g.setColor(Color.white);
                g.fillRect(322, 0, 46, 46);
                g.setColor(Color.BLACK);
                g.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 26));
                g.drawString("G", 335, 30);
                g.setColor(Color.BLACK);
                g.drawRect(322, 0, 46, 46);

                g.setColor(Color.white);
                g.fillRect(368, 0, 46, 46);
                g.setColor(Color.BLACK);
                g.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 26));
                g.drawString("H", 381, 30);
                g.setColor(Color.BLACK);
                g.drawRect(368, 0, 46, 46);

                g.setColor(Color.white);
                g.fillRect(414, 0, 46, 46);
                g.setColor(Color.BLACK);
                g.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 26));
                g.drawString("I", 434, 30);
                g.setColor(Color.BLACK);
                g.drawRect(414, 0, 46, 46);

                g.setColor(Color.white);
                g.fillRect(460, 0, 46, 46);
                g.setColor(Color.BLACK);
                g.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 26));
                g.drawString("J", 473, 30);
                g.setColor(Color.BLACK);
                g.drawRect(460, 0, 46, 46);

                //encabezado vertical

                g.setColor(Color.white);
                g.fillRect(0, 0, 46, 46);
                g.setColor(Color.BLACK);
                g.drawRect(0, 0, 46, 46);

                g.setColor(Color.white);
                g.fillRect(0, 46, 46, 46);
                g.setColor(Color.BLACK);
                g.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 26));
                g.drawString("1", 16, 78);
                g.setColor(Color.BLACK);
                g.drawRect(0, 46, 46, 46);

                g.setColor(Color.white);
                g.fillRect(0, 92, 46, 46);
                g.setColor(Color.BLACK);
                g.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 26));
                g.drawString("2", 16, 124);
                g.setColor(Color.BLACK);
                g.drawRect(0, 92, 46, 46);

                g.setColor(Color.white);
                g.fillRect(0, 138, 46, 46);
                g.setColor(Color.BLACK);
                g.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 26));
                g.drawString("3", 16, 170);
                g.setColor(Color.BLACK);
                g.drawRect(0, 138, 46, 46);

                g.setColor(Color.white);
                g.fillRect(0, 184, 46, 46);
                g.setColor(Color.BLACK);
                g.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 26));
                g.drawString("4", 16, 216);
                g.setColor(Color.BLACK);
                g.drawRect(0, 184, 46, 46);

                g.setColor(Color.white);
                g.fillRect(0, 230, 46, 46);
                g.setColor(Color.BLACK);
                g.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 26));
                g.drawString("5", 16, 262);
                g.setColor(Color.BLACK);
                g.drawRect(0, 230, 46, 46);

                g.setColor(Color.white);
                g.fillRect(0, 276, 46, 46);
                g.setColor(Color.BLACK);
                g.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 26));
                g.drawString("6", 16, 308);
                g.setColor(Color.BLACK);
                g.drawRect(0, 276, 46, 46);

                g.setColor(Color.white);
                g.fillRect(0, 322, 46, 46);
                g.setColor(Color.BLACK);
                g.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 26));
                g.drawString("7", 16, 354);
                g.setColor(Color.BLACK);
                g.drawRect(0, 322, 46, 46);

                g.setColor(Color.white);
                g.fillRect(0, 368, 46, 46);
                g.setColor(Color.BLACK);
                g.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 26));
                g.drawString("8", 16, 400);
                g.setColor(Color.BLACK);
                g.drawRect(0, 368, 46, 46);

                g.setColor(Color.white);
                g.fillRect(0, 414, 46, 46);
                g.setColor(Color.BLACK);
                g.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 26));
                g.drawString("9", 16, 446);
                g.setColor(Color.BLACK);
                g.drawRect(0, 414, 46, 46);

                g.setColor(Color.white);
                g.fillRect(0, 460, 46, 46);
                g.setColor(Color.BLACK);
                g.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 26));
                g.drawString("10", 10, 492);
                g.setColor(Color.BLACK);
                g.drawRect(0, 460, 46, 46);
        }
    }
}