/**
 * 
 */
package ManyWords;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @author mendes.parker
 *
 */
public class CountMyWords {

	/**
	 * @param args
	 * String eq = "|";
	 * int [] a;
	 */		
	static <K,V extends Comparable<? super V>> 
    List<Entry<K, V>> entriesSortedByValues(Map<K,V> map) {

List<Entry<K,V>> sortedEntries = new ArrayList<Entry<K,V>>(map.entrySet());

Collections.sort(sortedEntries, 
    new Comparator<Entry<K,V>>() {
        @Override
        public int compare(Entry<K,V> e1, Entry<K,V> e2) {
            return e2.getValue().compareTo(e1.getValue());
        }
    }
);

return sortedEntries;
}
	
	static void countWords(String fileName, Map<String, Integer> words) throws FileNotFoundException {
	Scanner scan = new Scanner(new File(fileName));
	while (scan.hasNext())
	{
		String word = scan.next();
		Integer count = words.get(word);
		word = word.replaceAll("\\,", "");
		word = word.replaceAll("\\.", "");
		word = word.replaceAll("\\?", "");
		word = word.replaceAll("\\!", "");
		// (" ,!?.", "")
		
		if (count != null)
			count++;
		else
			count = 1;
		words.put(word, count);
	}
	scan.close();
	}
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		 
		
		TreeMap<String, Integer> words = new TreeMap<String, Integer>();
		countWords("C:\\Users\\mendes.parker\\sample.txt", words);
		
		 /* Display content using Iterator*/
	      Set s = words.entrySet();
	      Iterator iterator = s.iterator();
	      while(iterator.hasNext()) 
	      {
	         Map.Entry mapentry = (Map.Entry)iterator.next();
	         //int j = mapentry; 
	         
	         System.out.print(mapentry.getKey() + "|") ;
	         for (int eq = 0; eq <= 3 ; eq++)
	         System.out.print("=");
	         //System.out.println(" = " + "(" + mapentry.getValue() + ")");
	         System.out.println( "(" + mapentry.getValue() + ")");
	        

	 		/*while( s!= mapentry) {
	 			System.out.print("=");
	 		} */
	 			
	      }
	           
	        
	      try{	
	    	  //Reassigns the standard output
	    	     PrintStream out = new PrintStream(new FileOutputStream("C:\\Users\\mendes.parker\\output.txt"));
		         System.setOut(out);
		         out.close();		       
		         
		       /*Used to connect to the console. read lines of output from the console.
		        * 
		        */
		         
		       //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		       
		       /*Used to read lines of output from the console.
		        * 
		        */
		       //String lines = br.readLine();
		       
		       //Used to write to a file.
		       //PrintWriter outp = new PrintWriter(new FileWriter("C:\\Users\\mendes.parker\\output.txt"));
		       //File f1 = new File("C:\\Users\\mendes.parker\\output.txt");
		       //if(!f1.exists()){
		    	 //  f1.createNewFile();
		       //}
		       //new
		       /*
		       FileWriter fw = new FileWriter (f1.getName(),true);
		       BufferedWriter bw = new BufferedWriter(fw);
		       bw.write(lines);
		       bw.close();
		       
		       outp.println(lines);
		       
		       */
		       //PrintStream out = new PrintStream(new FileOutputStream("C:\\Users\\mendes.parker\\output.txt"));
		       //System.setOut(out);
		       //out.close();
		       
		       //Close File
		       //outp.close();
		       		       
	      }
	      //If there is a problem with the output being created. The user will receive an error message.
	      catch(IOException e)
	      {
	    	  e.printStackTrace();
	    	  System.out.println("There is an error with creating and saving output.txt.");
	      }
	      }
		}
    
