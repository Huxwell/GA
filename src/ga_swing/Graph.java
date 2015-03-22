package ga_swing;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 *
 * @author Orley
 */
public class Graph extends JFrame {
    public Graph() {
        initUI();
    }
    private void initUI() {
        setTitle("Lines");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new Surface());
        setSize(550, main.genNo * 20 + 1000);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Graph lines = new Graph();
                lines.setVisible(true);
            }
        });
    }
}