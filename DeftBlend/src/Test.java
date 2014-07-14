import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

//This class is used merely to test the individual components of DeftBlend as they are built.
public class Test {
  public static void main(String[] args) {
    String words[][];
    words = getWordCount();
    orderWordsByCount(words);

  } //ends the main method

  public static String[][] getWordCount() {
     //create an array of words and occurences to return
     String wordsToReturn[][] =  new String[29][2];

     try {
       File file = new File("testinput.txt");
       Scanner input = new Scanner(file);

       int index = 0;
       String words[] = new String[100];
       while (input.hasNext()) {
         words[index] = input.next().toLowerCase();
         words[index] = words[index].replaceAll("[^A-Za-z0-9]", ""); //erase non-alphanumeric characters
         System.out.println(words[index]);
         index++;
       }

       //wouldn't need this copy if I set the array size correctly in the beginning so that Arrays.sort
       //doesn't choke on NullPointerException later on
       String newWords[] = new String[index]; 
       int j = 0;
       while (j < index) {
         newWords[j] = words[j];
         j++;
       }

       j = 0;
       int k = 1;
       int wordCounter = 1;
       Arrays.sort(newWords);
       System.out.println("array sorted");
       while (j < index) {
         if (j != index - 1) {
           if (newWords[j+1].equals(newWords[j])) {
             wordCounter++;
           }  
           else {
             System.out.println(newWords[j] + " " + wordCounter);
             wordsToReturn[k][0] = newWords[j];
             wordsToReturn[k][1] = Integer.toString(wordCounter);
             wordCounter=1;
             k++;
           }
         }
         else {
           System.out.println(newWords[j] + " " + wordCounter);  
           wordsToReturn[k][0] = newWords[j];
           wordsToReturn[k][1] = Integer.toString(wordCounter);
           k++;
         }
         j++;     
       }

       input.close();     
               
     } catch (IOException e) {
       System.out.println (e.getMessage());
     }
     
       return wordsToReturn;
 
  }//ends the getWordCount method

  
  public static String[][] orderWordsByCount (String[][] words) {
   /*  Arrays.sort(words, new Comparator<String[]>() {
      @Override
      public int compare(final String[] entry1, final String[] entry2) {
        final String time1 = entry1[0];
        final String time2 = entry2[0];
        return time1.compareTo(time2);
      }
    });
*/
    for (final String[] s : words) {
        //System.out.println ("null value found");
        System.out.println(s[0] + " " + s[1]);
    }    
    
    return words;  
 
  } //ends the orderWordsByCount method
} //ends the Test class