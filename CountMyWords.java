
package ManyWords;

/*
 * Was using to man of the libraries to Read in text from the console and output to the output.txt document. 
 * I have commented out the libraries that are no longer being used.
import java.io.BufferedReader;
*/
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @author mendes parker
 * HEB Assessment
 */
public class CountMyWords {

	/**
	 *String and Map created. The Map contains both a string and an integer that will keep count of the key and values. 
	 */
	static void countWords(String fileName, Map<String, Integer> words) throws FileNotFoundException {
	Scanner scan = new Scanner(new File(fileName));
	while (scan.hasNext())
	{
		
	//Take out extra punctuation from each line that is read in.
		String word = scan.next();
		Integer count = words.get(word);
		word = word.replaceAll("\\,", "");
		word = word.replaceAll("\\.", "");
		word = word.replaceAll("\\?", "");
		word = word.replaceAll("\\!", "");
		
	// counts the words as long as there are words left to count.	
		if (count != null)
			count++;
		else
			count = 1;
		words.put(word, count);
	}
	scan.close();
	}
	
	/* Sort the values in descending order using compare method, then returns the values. 
	 * This is meant to organize and sort the values of the output in descending order. 
	*/
	static <K,V extends Comparable<? super V>>
	List<Entry<K, V>> entriesSortedByValues(Map<K,V> map) 
	{
		List<Entry<K,V>> sortedEntries = new ArrayList<Entry<K,V>>(map.entrySet());
		
		Collections.sort(sortedEntries, new Comparator<Entry<K,V>>() 
		{
			@Override
			public int compare(Entry<K,V> e1, Entry<K,V> e2) 
			{
				return e2.getValue().compareTo(e1.getValue());
			}
		  }
		);
	
	return sortedEntries;
	}
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
	  // The TreeMap is being used here to contain and order the keys and values of the words that were read in.
		TreeMap<String, Integer> words = new TreeMap<String, Integer>();
		countWords("C:\\Users\\mendes.parker\\input.txt", words);
		
		 /* Display content using Iterator*/
	      Set s = words.entrySet();
	      Iterator iterator = s.iterator();
	      while(iterator.hasNext()) 
	      {
	         Map.Entry mapentry = (Map.Entry)iterator.next();
	        // Prints out the keys and adds a pipe. Plan to have the pipe delimiter be the middle of the sort.	         
	         System.out.print(mapentry.getKey() + "|") ;
	        /* Unfortunately I was not able to have the "=" print equally as the word values incremented, but 
	         * that is the effort below. 
	         */
	         for (int eq = 0; eq <= 3 ; eq++)
	         System.out.print("=");
	         System.out.println( "(" + mapentry.getValue() + ")");
	        }
	      
	      try{	
	    	  /*Reassigns the standard console data to output and places it in the correct location. 
	    	   * The file is being created, but the console output is not writting to the file. 
	    	  */
	    	     PrintStream out = new PrintStream(new FileOutputStream("C:\\Users\\mendes.parker\\output.txt"));
		         System.setOut(out);
		         out.close();	
	         }
	      /*If there is a problem with the output being created. The user will receive an error message.
	       * There are more checks to do to avoid confusion later. i.e. NullPointerException, ParseException and 
	       * FileNotFoundException. Make sure no other file already exist with that name. Prevent that file from being overwritten.
	      */
	      catch(IOException e)
	      {
	    	  e.printStackTrace();
	    	  System.out.println("There is an error with creating and saving output.txt.");
	      }
	      
         }
     }
