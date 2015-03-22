package ga_swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class Surface extends JPanel {

    private int offsetX = 15;
    private int offsetY = 15;

    private void doDrawing(Graphics gr) {
        Graphics2D g2d = (Graphics2D) gr;
        drawAxes(g2d);
        g2d.setColor(Color.red);
        for (int g = 0; g < main.genNo; g++) {
            for (int p = 0; p < main.popNo; p++) {
                g2d.drawLine(offsetX + (int) ((main.points[g][p] + 10) * 25), offsetY + g * 20 + 5, (int) (offsetX + (main.points[g][p] + 10) * 25), offsetY + g * 20 - 5);
                //g2d.drawString(""+(int)main.points2[g][p],offsetX + (int) ((main.points2[g][p] + 10) * 25), offsetY + g * 20 + 5);
            }
        }

        g2d.setColor(Color.blue);
        for (int g = 0; g < main.genNo; g++) {
            for (int p = 0; p < main.popNo; p++) {
                g2d.drawLine(offsetX + (int) ((main.points2[g][p] + 10) * 25), offsetY + g * 20 + 5, (int) (offsetX + (main.points2[g][p] + 10) * 25), offsetY + g * 20 - 5);

            }
        }
    }

    private void drawAxes(Graphics2D g2d) {
        for (int g = 0; g < main.genNo; g++) {
            g2d.drawLine(offsetX + 0, offsetY + g * 20, offsetX + 500, offsetY + g * 20);
            for (int i = 0; i < 21; i++) {
                g2d.drawLine(offsetX + i * 25, offsetY + (g * 20) - 2, offsetX + i * 25, offsetY + (g * 20) + 2);
                if (g == 0) {
                    g2d.drawString("" + (i - 10), offsetX + i * 25, offsetY + main.genNo * 20);
                }
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
