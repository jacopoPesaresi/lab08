package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String myString;
    private List<String> history;

   /**
    * 
    * @param firstString to set into controller
    */
    public SimpleController(final String firstString) {
        myString = firstString;
        history = new ArrayList<>();
    }

    /**
     * set a empty string if the user use this constructor.
     */
    public SimpleController() {
        this("");
    }

    @Override
    public void setNextString(final String newString) {
        if (newString != null) {
            myString = newString; // new String(newString); //NOPMD : defense copy (it is correct/necessary?)
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String getNextString() {
        return myString; //new String(myString); //NOPMD : defense copy (it is correct/necessary?)
    }

    @Override
    public List<String> getHistory() {
        return new ArrayList<String>(history);
    }

    @Override
    public void printActualString() {
        if (myString != null) {
            System.out.println(myString);  //NOPMD : it is an esercice
            history.add(getNextString());
        } else {
            throw new IllegalStateException();
        }
    }

}
