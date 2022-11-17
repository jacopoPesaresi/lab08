package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * method that set the next string to print.
     * @param newString to set in the controller.
     * @throws IllegalArgumentExpression if {@param String} is null.
     */
    void setNextString(String newString);

    /**
     * method to get the next string to print.
     * @return the String setted in the controller
     */
    String getNextString();

    /**
     * get the history of the printed strings.
     * @return a List of String that is the history.
     */
    List<String> getHistory();
    /**
     * @throws IllegalStateException if the current string is unset.
     */
    void printActualString();

}
