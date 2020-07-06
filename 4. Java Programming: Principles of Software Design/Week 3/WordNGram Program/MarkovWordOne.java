
/**
 * MarkovWordOne class is used to create randomly generated text based on the original text. 
 * It uses string arrays and getFollows() method to collect the words that follow a specified 
 * key and then to create a randomly generated text with getRandomText() method. It uses one
 * word as a key to predict the next one.
 * 
 * 
 * @ Konstantin Krumin  
 * @ Version: 1.0 (January 21, 2020)
 */

import java.util.*;

public class MarkovWordOne implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    
    public MarkovWordOne() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        myText = text.split("\\s+");
    }
    
    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-1);  // random word to start with
        String key = myText[index];
        sb.append(key);
        sb.append(" ");
        for(int k=0; k < numWords-1; k++){
            ArrayList<String> follows = getFollows(key);
            
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key = next;
        }
        
        return sb.toString().trim();
    }
    
    private int indexOf(String[] words, String target, int start) {
        for (int k=start; k < words.length; k++) {
            if (words[k].equals(target)) {
                return k;
            }
        }
        
        return -1;
    }
    
    private ArrayList<String> getFollows(String key) {
        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        while (pos < myText.length) {
            int start = indexOf(myText, key, pos);
            if (start == -1) {
                break;
            }
            if (start >= myText.length - 1) {
                break;
            }
            String next = myText[start+1];
            follows.add(next);
            pos = start + 1;
        }
        
        return follows;
    }
}
