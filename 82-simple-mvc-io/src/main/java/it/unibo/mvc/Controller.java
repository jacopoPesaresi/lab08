package it.unibo.mvc;

//import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.Writer;
/**
 * Application controller. Performs the I/O.
*/
public class Controller {
    private static transient String mYHOME = System.getProperty("user.home");
    private static transient String mYSEP = System.getProperty("file.separator");
    private static String dEFAULTnAMEoFoUTfILE = "output.txt";

    private File f;
    /**
     * 
     * @param f texttexttext.
     */
    public Controller(final File f) {
        this.f = f;
    }
    /**
     * 
     */
    public Controller() {
        this(new File(mYHOME + mYSEP + dEFAULTnAMEoFoUTfILE));
    }
    /**
     * 
     * @param newFile texttexttext.
     */
    public void setCurrentFile(final File newFile) {
        this.f = newFile;
    }

    /**
     * 
     * @return texttexttext.
     */
    public File getCurrentFile() {
        return f;
    }

    /**
     * 
     * @return texttexttext.
     */
    public String getPathString() {
        return f.getPath(); //toPath().toString(); //riguardami.
    }

    /**
     * 
     * @param what texttexttext.
     */
    public void writeIntoFile(final String what) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            bw.append(what);
        } catch (IOException e) {
           e.printStackTrace();  //NOPMD: è un esercizio
        }
    }

}
