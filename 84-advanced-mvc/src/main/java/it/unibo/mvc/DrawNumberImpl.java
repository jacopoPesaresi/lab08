package it.unibo.mvc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//import java.nio.file.Paths;
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

    private static final String SEP = System.getProperty("file.separator");
    private static final String PRG_PATH = System.getProperty("user.dir");
    private static final String RES_PATH =  SEP  + "src" + SEP + "main" + SEP + "resources" + SEP; 
    private static final String CONFIG_PATH = PRG_PATH + RES_PATH;
    /**
     * 
     * @param min text
     * @param max text
     * @param attempts text
     * @throws IllegalStateException if the configuration is not consistent
     */
    public DrawNumberImpl(final int min, final int max, final int attempts) {
        this.min = min;
        this.max = max;
        this.attempts = attempts;
        this.reset();
    }

    /*
     * fuction that help the read of the config file
     */
    private int readValue(final BufferedReader br) {
        String tmp = "";
        try {
            tmp = br.readLine();
        } catch (IOException e) {
            e.printStackTrace(); //NOPMD: is an esercice
        }
        return Integer.parseInt(tmp.split(": ")[1]);
    }
    /**
     * @param fileConfigName
     */
    public DrawNumberImpl(final String fileConfigName) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(CONFIG_PATH + fileConfigName)));
        } catch (IOException e) {
            e.printStackTrace(); //NOPMD: is an esercice
        }

        min = readValue(br);
        max = readValue(br);
        attempts = readValue(br); 
        this.reset();
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
