import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

//This class is used merely to test the individual components of DeftBlend as they are built.
public class Test {
  public static void main(String[] args) {
     try {
       File file = new File("testinput.txt");
       Scanner input = new Scanner(file);

       int index = 0;
       //String simple = input.toString();
       
       //String[] valuesArray = simple.split(" ", -1);
       //int length = valuesArray.length;
       String words[] = new String[100];
       //List<String> words = new ArrayList<String>();
       //String uniqueWords[] = new String[100];
       while (input.hasNext()) {
         words[index] = input.next().toLowerCase();
         words[index] = words[index].replaceAll("[^A-Za-z0-9]", ""); //erase non-alphanumeric characters
         System.out.println(words[index]);
         //System.out.println(valuesArray[1]);
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

       //print out the sorted array
       j = 0;
       int wordCounter = 1;
       Arrays.sort(newWords);
       while (j < index) {
         //System.out.println(newWords[j] + wordCounter);
         if (j != index - 1) {
           if (newWords[j+1].equals(newWords[j])) {
             wordCounter++;
           }  
           else {
             System.out.println(newWords[j] + " " + wordCounter);
             wordCounter=1;
           }
         }
         else {
           System.out.println(newWords[j] + " " + wordCounter);  
         }
         j++;     
       }

       

       input.close();     

     } catch (IOException e) {
       System.out.println ("File " + e.getMessage() + " does not exist.");
     }
     
  } //ends the main method
} //ends the Test class