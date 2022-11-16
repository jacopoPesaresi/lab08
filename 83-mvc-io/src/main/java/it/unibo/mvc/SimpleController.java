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
     * @param firstString texttexttext
     */
    public SimpleController(final String firstString) {
        myString = firstString;
        history = new ArrayList<>();
    }

    /**
     * 
     */
    public SimpleController() {
        this("");
    }

    @Override
    public void setNextString(final String newString) throws Exception {
        if (newString != null) {
            myString = new String(newString);
        } else {
            throw new Exception();
        }
    }

    @Override
    public String getNextString() {
        return new String(myString);
    }

    @Override
    public List<String> getHistory() {
        return new ArrayList<String>(history);
    }

    @Override
    public void printActualString() throws IllegalStateException {
        if (myString != null) {
            System.out.println(myString);  //NOPMD
            history.add(getNextString());
        } else {
            throw new IllegalStateException();
        }
    }

}
