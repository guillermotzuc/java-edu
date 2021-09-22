package testcodes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Salution {

	// Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

    	char[] array = s.toCharArray();
    	long r =  n/(long)array.length;
    	
    	//s.
    	
        if(!s.contains("a"))
        	return 0;
        
        if(s.length() == 1 )
            return n;
        
       
        long count = 0;
        long countAletters = 0;
        while(count != n){
        	for(char c : array) {
        		if(c == 'a'){
        			countAletters++;
        		}
        		
        		count++;
        		if(count == n)
        			break;
        		
        	}
        	try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        return countAletters;
    }

   // private static final Scanner scanner = new Scanner(System.in);
    


    public static void main(String[] args) throws IOException {
    	
    	
    	
   // long v = repeatedString("aab", 882787);
    	
//    	long v = repeatedString("kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm",
//    			736778906400L);
    	//System.out.println(v);
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = scanner.nextLine();
//
//        long n = scanner.nextLong();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        long result = repeatedString(s, n);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
