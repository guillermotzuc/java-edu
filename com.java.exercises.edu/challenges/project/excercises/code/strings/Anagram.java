package project.excercises.code.strings;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.kafka.streams.StreamsBuilder;

import avro.shaded.com.google.common.collect.Lists;

public class Anagram {

	/* function to check whether two strings are
    anagram of each other */
    static boolean areAnagram(char[] str1, char[] str2)
    {
        // Get lenghts of both strings
        int n1 = str1.length;
        int n2 = str2.length;
 
        // If length of both strings is not same,
        // then they cannot be anagram
        if (n1 != n2)
            return false;
 
        // Sort both strings
        Arrays.sort(str1);
        Arrays.sort(str2);
 
        // Compare sorted strings
        for (int i = 0; i < n1; i++)
            if (str1[i] != str2[i])
                return false;
 
        return true;
    }
    
    /**
     * - Why a LinkedList?
     * - 
     * @param str1
     * @param str2
     * @return
     */
    static boolean areAnagram2(char[] str1, char[] str2){
        if(str1.length != str2.length)
            return false;
        
        LinkedList<Character> list1 = new LinkedList<Character>(); 
        for(char c : str1){
            list1.add(c);
        }

        for (int i =0; i< str2.length; i++){
            if(list1.contains(str2[i])){
                list1.remove((Character)str2[i]);
            }
            else return false;
        }
        return true;
    }
 
    /* Driver Code*/
    public static void main(String args[])
    {
        String[] one = {"restful", "funeral", "adultery", "fortyfive", "Santa"};
        String[] two = {"fluster", "realfun", "truelady", "overfifty", "Satan"};
      
        for(int i=0; i< one.length; i++) {
        	
        	 // Function Call
            if (areAnagram2(one[i].toCharArray(), two[i].toCharArray()))
                System.out.println("The two strings are"
                                   + " anagram of each other");
            else
                System.out.println("The two strings are not"
                                   + " anagram of each other");
        }
       
    }
}
