package it.unibo.mvc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;

/**
 *
 */
public final class DrawNumberImpl implements DrawNumber {

    private int choice;
    private final int min;
    private final int max;
    private final int attempts;
    private int remainingAttempts;
    private final Random random = new Random();

    private final static String PACKAGE_PATH = Paths.get(System.getProperty("user.dir")).getParent().toString();
    private final static String SEP = System.getProperty("file.separator");
    private final static String SRC_PATH = SEP + "84-advanced-mvc" + SEP + "src" + SEP + "main";
    private final String RES_PATH =  SEP  + "resources" + SEP; 
    private final String CONFIG_PATH = PACKAGE_PATH + SRC_PATH + RES_PATH;
    
    /**
     * @throws IllegalStateException if the configuration is not consistent
     */
    public DrawNumberImpl(final int min, final int max, final int attempts) {
        this.min = min;
        this.max = max;
        this.attempts = attempts;
        this.reset();
    }

    /*
     * 
     */
    private int catchValue(final BufferedReader br) {
        String tmp="";
        try {
            tmp = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(tmp.split(":")[1]);
    }
    /**
     * @param fileConfigName
     */
    public DrawNumberImpl(final String fileConfigName) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(CONFIG_PATH + fileConfigName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        min = catchValue(br);
        max = catchValue(br);
        attempts = catchValue(br);
        
    }

    @Override
    public void reset() {
        this.remainingAttempts = this.attempts;
        this.choice = this.min + random.nextInt(this.max - this.min + 1);
    }

    @Override
    public DrawResult attempt(final int n) {
        if (this.remainingAttempts <= 0) {
            return DrawResult.YOU_LOST;
        }
        if (n < this.min || n > this.max) {
            throw new IllegalArgumentException("The number is outside boundaries");
        }
        remainingAttempts--;
        if (n > this.choice) {
            return DrawResult.YOURS_HIGH;
        }
        if (n < this.choice) {
            return DrawResult.YOURS_LOW;
        }
        return DrawResult.YOU_WON;
    }

}
