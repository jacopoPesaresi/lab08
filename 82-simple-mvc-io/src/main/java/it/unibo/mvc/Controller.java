package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Application controller. Performs the I/O.
*/
public class Controller {
    private static final transient String MYHOME = System.getProperty("user.home");
    private static final transient String MYSEP = System.getProperty("file.separator");
    private static final String DEFAULTNAMEOFOUTFILE = "output.txt";

    private File f;
    /**
     * 
     * @param f the file that the controller will manage.
     */
    public Controller(final File f) {
        this.f = f;
    }
    /**
     * the controller will manage a default file
     */
    public Controller() {
        this(new File(MYHOME + MYSEP + DEFAULTNAMEOFOUTFILE));
    }
    /**
     * 
     * @param newFile the new file that the controller will manage.
     */
    public void setCurrentFile(final File newFile) {
        this.f = newFile;
    }

    /**
     * 
     * @return the actual file that the controller is managing.
     */
    public File getCurrentFile() {
        return f;
    }

    /**
     * 
     * @return the path of the file that the controller is managing.
     */
    public String getPathString() {
        return this.getCurrentFile().getPath(); //toPath().toString(); //riguardami.
    }

    /**
     * 
     * @param what the string that will be printed into the file that the controller is managing.
     */
    public void writeIntoFile(final String what) {
        try (PrintStream bw = new PrintStream(f)) {
            bw.print(what);
        } catch (IOException e) {
           e.printStackTrace();  //NOPMD: è un esercizio
        }
    }

}
