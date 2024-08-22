package utils;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

// simple tool for using system buffer (just string)
public class ClipboardTools {

    // working as public static methods or as separate object (super-mega feature iq300!)
    public static String getClipboard() {
        String buffer = "";
        try {
            Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
            buffer = (String) clip.getData(DataFlavor.stringFlavor);
        } catch (IOException | UnsupportedFlavorException e) {
            // on any error - do nothing or nobody cares
        }
        return buffer;
    }

    public static void setClipboard(String input) {
        StringSelection selection = new StringSelection(input);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }

    private String buffer =  "";

    public String get() {
        refresh();
        return buffer;
    }

    public void set(String value) {
        buffer = value;
        setClipboard(buffer);
    }

    public void clear() {
        buffer = "";
    }

    public boolean isEmpty() {
        return buffer.isEmpty();
    }

    private void refresh() {
        buffer = getClipboard();
    }
}
