/*
 *  This program intends to read in and scan the last stanza of Martin Luther King Jr.'s speech
 *"I Have A Dream", and accurately print out how words are in the last paragraph. This program runs 
 *and compiles with no issue, and prints the correct amount of words in the last paragraph of the speech being 82 words. 
 */
package words;

//import classes we will need, such as the Scanner class bc we will read in a text file
import java.util.Scanner;

import java.io.File;
//import File class bc we will need an object of the file class

public class Words {
    
    public static void main(String[] args) throws Exception {
        //Instiantiate scanner o bject
        Scanner sc = new Scanner(new File("Dream.txt"));
        
        //Intialize variables
        String line  = "";
        
        //Intialize count 
        int count = 0;
        
        //Line to let the user know what is happening 
        System.out.println("Reading String from File. Processsing.... ");
        
        //While loop will run until everything is read from the file 
        while (sc.hasNextLine()) {
            //line variable is assigned the value of the next line scanned in the document
            line = sc.nextLine();
            
            String[] wordArray = line.trim().split(" ");
            //Holding lines in the array
            //Trim method takes away the excess whitespace
            //Split seperates the line into words
            
            count += wordArray.length;
            //As lines are scanned, they are put in the array, seperated into words, and then the length of the array is added to count 
        }
        
        System.out.println(count);
        //Simply print the count out
    
    } //End of the main method
}
// End of the class

