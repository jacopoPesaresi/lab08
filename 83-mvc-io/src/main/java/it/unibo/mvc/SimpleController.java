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


    public SimpleController(String firstString){
        myString = firstString;
        history = new ArrayList<>();
    }

    public SimpleController(){
        this("");
    }

    @Override
    public void setNextString(final String newString) throws Exception {
        if (newString !=null){
            myString = newString;
        } else throw new Exception();
        
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
        if(myString!=null){
            System.out.println(myString);
        } else {
            throw new IllegalStateException();
        }
        
    }

}
