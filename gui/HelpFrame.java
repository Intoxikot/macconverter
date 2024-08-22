package gui;

import javax.swing.*;
import java.awt.*;

public class HelpFrame extends JFrame implements AutoCloseable {

    private static final String info =
        "<html><br>hello, whats ur question? <br>" +

            "<h1 align=\"center\">about:</h1>" +
        " >> dev: Nik Ladey <br>" +
        " >> contact: netoxikot@gmail.com <br>" +
        " >> app: MAC Converter version 1.0 build 20240822-0000 <br>" +

            "<h1 align=\"center\">control:</h1>" +
        " >> ENTER - update/insert (if field is empty - using clipboard) <br>" +
        " >> DELETE - clear fields <br>" +
        " >> SHIFT - switch AlwaysOnTop window mode <br>" +
        " >> RMC (right mouse click) - same as ENTER <br>" +

            "<h1 align=\"center\">for use app:</h1>" +
        " >> insert MAC address in format: XX:XX:XX:XX:XX:XX <br>" +
        " >> getting MAC address in format: XXXX.XXXX.XXXX <br>" +
        " >> autocopy to clipboard <br>" +
        " >> hf and enjoy! </html>";

    private int HEIGHT = 430;
    private int WIDTH = 465;
    private static final Font font = new Font("Courier New", Font.PLAIN, 14);
    private JLabel lblInfo = null;

    public HelpFrame() {
        initialize();
    }

    private void initialize() {
        setComponents();
        setWindowOptions();
    }

    private void setComponents() {
        lblInfo = new JLabel(info);
        lblInfo.setFont(font);
        this.add(lblInfo);
        this.pack();
    }

    private void setWindowOptions() {
        this.setTitle("Help");
        this.setSize(WIDTH, HEIGHT);
        setVisible(false);
    }

    @Override
    public void close() throws Exception {
        setVisible(false);
    }
}
