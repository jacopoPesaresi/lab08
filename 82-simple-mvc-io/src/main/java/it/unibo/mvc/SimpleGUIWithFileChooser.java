package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private final Controller controller = new Controller();
    private final JFrame frame = new JFrame();
    private static final int PROPORTION = 3;

    /**
     * 
     * @param myController that the GUI can use.
     */
    public SimpleGUIWithFileChooser(final Controller myController) {

        frame.setTitle("My little GUI (with file chooser)");

        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());

        final JPanel northG = new JPanel();
        northG.setLayout(new BorderLayout());
        final JTextField path = new JTextField();

        path.setEditable(false);
        path.setText(controller.getPathString());

        final JButton browseB = new JButton("Browse...");
        northG.add(path, BorderLayout.CENTER);
        northG.add(browseB, BorderLayout.LINE_END);
        canvas.add(northG, BorderLayout.NORTH);

        final JButton saveB = new JButton("Save");
        canvas.add(saveB, BorderLayout.SOUTH);

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        browseB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
               final JFileChooser fChooser = new JFileChooser();
               if (fChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                controller.setCurrentFile(fChooser.getSelectedFile());
                path.setText(controller.getPathString());
               } else {
                JOptionPane.showMessageDialog(frame, "Nome file non trovato", "Error", JOptionPane.ERROR_MESSAGE);
               }
            }
        });
    }


    /**
     * 
     */
    public void display() {
        /*
         * Make the frame one fifth the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected. In order to deal coherently with multimonitor
         * setups, other facilities exist (see the Java documentation about this
         * issue). It is MUCH better than manually specify the size of a window
         * in pixel: it takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        /*
         * OK, ready to push the frame onscreen
         */
        frame.setVisible(true);
    }


    /**
     * 
     * @param args
     */
    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser(new Controller()).display();
    }
}
