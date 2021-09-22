package testcodes.algorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class PageCount {
	 /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
    	int total = n/2;
        int right = p/2;
        int left = total - right;
        if(right < left){
            return right;
        }
        else {
            return left;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	
    	System.out.println(pageCount(5, 4));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
//
//        int p = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
//
//        int result = pageCount(n, p);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
    
    static class  Book {
    	
    	int page1;
    	int page2;
    }
}
