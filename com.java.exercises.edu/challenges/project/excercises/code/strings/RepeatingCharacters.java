package project.excercises.code.strings;

/*
 * 
 * Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

 */
public class RepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int lengthOfLongestSubstring(String s) {
	        
	        if(s.length() == 0)
	            return 0;
	        
	        String biggerString = "";
	       	StringBuilder builder = new StringBuilder();
	        char[] charArray = s.toCharArray();
	        for(int i=0; i<s.length();i++){
	            
	            Character currentChar = charArray[i]; 
	           if(builder.toString().contains(currentChar.toString())) {
	              
	               builder = new StringBuilder();
	           }
	               
	           builder.append(currentChar) ; 
	           
	            
	            if(biggerString.length() <builder.toString().length()){
	                
	                biggerString = builder.toString();
	            }   
	        }
	        
	        return biggerString.length();
	    }

}
