package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import utils.ClipboardTools;
import static utils.MacConverterLogic.MacToDot;

public class MacConverterFrame extends JFrame {

    private int HEIGHT = 100;
    private int WIDTH = 300;

    private ClipboardTools clipboard = new ClipboardTools();
    private JTextField txtInput = null;
    private JTextField txtDotNotation = null;
    private JFrame helpWindow = new HelpFrame();
    private boolean isAlwaysOnTop = true;

    public MacConverterFrame() {
        initialize();
    }

    private void initialize() {
        setComponents();
        addActions();
        setWindowOptions();
    }

    private void setComponents() {
        txtInput = new JTextField();
        txtDotNotation = new JTextField();
        txtDotNotation.setEditable(false);

        JPanel pnlMain = new JPanel();
        pnlMain.setLayout(new GridLayout(2, 1));
        pnlMain.add(txtInput);
        pnlMain.add(txtDotNotation);
        this.add(pnlMain);
    }

    public void refresh() {
        String input = txtInput.getText();
        String result = "";
        if (input.isEmpty()) {
            input = clipboard.get();
            txtInput.setText(input);
        }
        if (input.contains("?")) {
            helpWindow.setVisible(true);
            return;
        }
        result = MacToDot(input);
        txtDotNotation.setText(result);
        if (!result.isEmpty()) clipboard.set(result);
    }

    public void clear() {
        txtInput.setText("");
        txtDotNotation.setText("");
    }

    public void switchAlwaysOnTop() {
        isAlwaysOnTop = !isAlwaysOnTop;
        setAlwaysOnTop(isAlwaysOnTop);
    }

    private void addActions() {

        txtInput.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e))
                    refresh();
                super.mousePressed(e);
            }
        });

        txtInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    refresh();
                else if (e.getKeyCode() == KeyEvent.VK_DELETE)
                    clear();
                else if (e.getKeyCode() == KeyEvent.VK_SHIFT)
                    switchAlwaysOnTop();
                else
                    super.keyReleased(e);
            }
        });
    }

    private void setWindowOptions() {
        this.setTitle("MAC Converter 1.0");
        this.setSize(WIDTH, HEIGHT);
        this.setAlwaysOnTop(isAlwaysOnTop);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        gui.MacConverterFrame macConverterFrame = new MacConverterFrame();
    }
}
