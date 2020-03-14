import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

//add your name and matric number
//name: Zhiwei Wang; matric number: 2431032w

//do NOT include a package statement in your final submission

//add any import statements you need here


public class AssEx1 {
    
	
	/** read strings from file 
     * and add them to an array. Assume that in the file there is one string
     * per line.
     * @param filename
     * return array
	 * @throws FileNotFoundException 
     */
	public static String[] readFromFile(String fileName) throws FileNotFoundException{
		int count = 1;
		File file = new File(fileName);
		FileInputStream ffs = new FileInputStream(file);
		FileInputStream ffs2 = new FileInputStream(file);
		Scanner s = new Scanner(ffs);
		while(s.hasNextLine()) {
			s.nextLine();
			count++;
		}
		
		s = new Scanner(ffs2);
		String[] fileString = new String[count];
		for(int i=0; i<fileString.length-1; i++) {
			fileString[i] = s.nextLine();
		}
		return fileString;
			
	}
	
	
	/**
	 * Add all of the elements of an array of Strings
	 * to a set of strings - note repeats will disappear
	 * your set should be instantiated as a TreeSet (see lecture 1)
	 */
	public static Set<String> arrayToSet(String[] myArray){
		Set<String> stringSet = new TreeSet<String>();
		for(int i=0; i<myArray.length-1;i++) {
			stringSet.add(myArray[i]); 
		}
		return stringSet;
	}
	
	
	/** randomly re-order an array
	 * 
	 * @param origArray
	 */
	public static void jumbleArray(String[] origArray){
		ArrayList<String> jumbleList = new ArrayList<String>();
		for(int i=0; i<origArray.length-1;i++) {
			jumbleList.add(origArray[i]);
		}
		Collections.shuffle(jumbleList);
		for(int n=0; n<jumbleList.size();n++) {
			origArray[n] = jumbleList.get(n);
		}

	}
	
	/** create a string consisting all of the elements in an array,
	 * one element per row.
	 * Use a for--each loop to return them in the order in which they 
	 * are stored
	 */
	public static String arrayToString(String[] stringArray){
		String result="";
		for(String s: stringArray) {
			result += s + "\n";
		}
		return result;
	}
	
	/** create a string consisting of all of the elements in a set,
	 * one element per row.
	 * Use a for--each loop to return them in the order in which they 
	 * are stored
	 */
	public static String setToString(Set<String> stringSet){
		String result = "";
		for(String s: stringSet) {
			result += s + "\n";
		}
		return result;
		
	}
	
	
	
	/**
	 * main method - do not edit this
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException{
		String fileName = args[0];
		String[] originalArray = readFromFile(fileName);
		System.out.println("the array has length " + originalArray.length + "\n");
		String[] newArray1 = originalArray.clone();
		String[] newArray2 = originalArray.clone();
		
		jumbleArray(newArray1);
		jumbleArray(newArray2);
		
		System.out.print("The original array is:\n");
		System.out.print(arrayToString(originalArray) + "\n");
		
		System.out.print("The frst jumbled array is:\n");
		System.out.print(arrayToString(newArray1) + "\n");
		System.out.print("The corresponding set is:\n");
		System.out.print(setToString(arrayToSet(newArray1))+"\n");
		
		System.out.print("The second jumbled array is:\n");
		System.out.print(arrayToString(newArray2) + "\n");
		System.out.print("The corresponding set is:\n");
		System.out.print(setToString(arrayToSet(newArray2)) + "\n");
		
		
		
		}
	
}
