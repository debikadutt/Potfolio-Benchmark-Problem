

import java.text.*;
import java.io.*;
import java.math.*;
import java.util.*;


	public class try3 {
	    
	    public static final String SEPARATOR = "@";
	    public static final String COLON = ":";
	    /*
	     * Complete the function below.
	     *
	 	 * Note: The questions in this test build upon each other. We recommend you
		 * copy your solutions to your text editor of choice before proceeding to
		 * the next question as you will not be able to revisit previous questions.
		 */
	 

	    static String printHoldings(String portfolioString) {
	    	if(portfolioString == null || portfolioString.length() == 0) {
	    		return "";
	    	}
	    	// split the input string when encountering ":" into benchmark holding
	    	String[] inputArray=portfolioString.split(COLON);
	    	String[] benchmarkArray = inputArray[1].split(SEPARATOR);   	
	    	Arrays.sort(benchmarkArray, new Comparator<String>() {
	    	
	    		@Override
	    		// ordering the holdings
	    		public int compare(String s1, String s2) {
	    			return (s1).compareTo(s2);
	    		}
	    	});
	    	
	    	StringBuilder result = new StringBuilder("");
	    	
	    	for(String benchmarkholding : benchmarkArray) {
	    		// create a temporary stringbuilder for each portfolio holding
	    		StringBuilder tempStr = new StringBuilder("");
	    		// split each portfolioholding string array to the target string
	    		String[] tempArr = benchmarkholding.split(",");
	    		tempStr.append("[");
	    		for(String attr : tempArr) {
	    			tempStr.append(attr);
	    			
	    			// if it is not the last attribute of this holding
	    			if(!attr.equals(tempArr[tempArr.length - 1])) {
	    				tempStr.append(", ");
	    			}
	    		}
	    		// else complete one holding
	    		tempStr.append("]");
	    		// if it is not the last portfolioholding of this holding array
	    		if(!benchmarkholding.equals(benchmarkArray[benchmarkArray.length - 1])) {
	    			tempStr.append(", ");
	    		}
	    		// appending each formatted holding string into a result stringbuilder
	    		result.append(tempStr.toString());
	    	}
	    	return result.toString();
	    	
	    }

	    public static void main(String[] args) throws IOException{
	        Scanner in = new Scanner(System.in);
	        String res;
	        String _input;
	        try {
	            _input = in.nextLine();
	        } catch (Exception e) {
	            _input = null;
	        }
	        res = printHoldings(_input);
	        System.out.println(res);
	    }
	}


