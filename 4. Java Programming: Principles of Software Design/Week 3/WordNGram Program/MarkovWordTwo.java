
/**
 * MarkovWordTwo class is used to create randomly generated text based on the original text. 
 * It uses string arrays and getFollows() method to collect the words that follow a specified 
 * key and then to create a randomly generated text with getRandomText() method. It uses two
 * words as a key to predict the next one.
 * 
 * @ Konstantin Krumin
 * @ Version: 1.0 (January 21, 2020)
 */

import java.util.*;

public class MarkovWordTwo implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    
    public MarkovWordTwo() {
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
        int index = myRandom.nextInt(myText.length-2);  // random word to start with
        String key1 = myText[index];
        sb.append(key1);
        sb.append(" ");
        String key2 = myText[index+1];
        sb.append(key2);
        sb.append(" ");
        for(int k=0; k < numWords-2; k++){
            ArrayList<String> follows = getFollows(key1, key2);
            
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key1 = key2;
            key2 = next;
        }
        
        return sb.toString().trim();
    }
    
    private int indexOf(String[] words, String target1, String target2, int start) {
        for (int k=start; k < words.length-1; k++) {
            if (words[k].equals(target1) && words[k+1].equals(target2)) {
                return k;
            }
        }
        return -1;
    }
    
    private ArrayList<String> getFollows(String key1, String key2) {
        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        while (pos < myText.length) {
            int start = indexOf(myText, key1, key2, pos);
            if (start == -1) {
                break;
            }
            if (start >= myText.length - 2) {
                break;
            }
            
            String next = myText[start+2];
            follows.add(next);
            pos = start + 1;
        }
        return follows;
    }
}
