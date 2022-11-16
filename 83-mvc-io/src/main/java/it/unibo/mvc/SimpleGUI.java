/*
package it.unibo.mvc;

import javax.swing.JFrame;


 * A very simple program using a graphical interface.
 * 

public final class SimpleGUI {

    private final JFrame frame = new JFrame();

}
*/
package it.unibo.mvc;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private static final int PROPORTION = 3;

    /**
     * 
     * @param myCon texttexttext
     */
    public SimpleGUI(final Controller myCon) {
        frame.setTitle("My little GUI");

        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());

        //final JTextArea text = new JTextArea("dummy");
        //final JButton saveB = new JButton("Save");

        final JTextField tField = new JTextField();
        final JTextArea tArea = new JTextArea();
        final JButton bPrint = new JButton("Print");
        final JButton bShowHist = new JButton("Show history");

        tArea.setEditable(false);

        final JPanel tmpPanel = new JPanel();
        tmpPanel.setLayout(new BoxLayout(tmpPanel, BoxLayout.LINE_AXIS));
        tmpPanel.add(bPrint);
        tmpPanel.add(bShowHist);

        canvas.add(tField, BorderLayout.NORTH);
        canvas.add(tArea, BorderLayout.CENTER);
        canvas.add(tmpPanel, BorderLayout.SOUTH);
        //canvas.add(bShowHist, BorderLayout.SOUTH);
        //canvas.add(bPrint, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bPrint.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                final String actualString = tField.getText();
                try {
                    myCon.setNextString(actualString);
                    myCon.printActualString();
                } catch (Exception e) {
                    e.printStackTrace(); //NOPMD
                }
                //new Controller().writeIntoFile(text.getUIClassID()); 
                //TODO: non so cosa stampare, vorrei stampare la testArea ma non mi viene.
            }
        });

        bShowHist.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                tArea.setText(myCon.getHistory().toString());
            } });
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

        //frame.pack(); 

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
        final SimpleGUI g = new SimpleGUI(new SimpleController());
        g.display();
    }

}

