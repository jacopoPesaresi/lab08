package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * method that set the next string to print
     * @param newString
     * @throws Exception
     */
    void setNextString(final String newString) throws Exception;

    /**
     * method to get the next string to print
     */
    String getNextString();

    /**
     * get the history of the printed strings
     * @return a List of String that is the history
     */
    List<String> getHistory();
    
    /**
     * 
     * @throws IllegalStateException if the current string is unset
     */
    void printActualString() throws IllegalStateException;

}
