package testcodes;

import java.util.Iterator;
import java.util.LinkedList;

public class Sample2 {

	public static void main(String[] args) {
		/// Creating object of class linked list 
        LinkedList<String> object = new LinkedList<String>(); 
        
        // Adding elements to the linked list 
        object.add("A"); 
        object.add("B"); 
        object.addLast("C"); 
        object.addFirst("D"); 
        object.add(2, "E"); 
        object.add("F"); 
        object.add("G"); 
        System.out.println("Linked list : " + object); 
  
        Iterator<String> elements = object.iterator();
        while(elements.hasNext()) {
        	System.out.println(elements.next());
        }
        
        // Removing elements from the linked list 
        object.remove("B"); 
        object.remove(3); 
        object.removeFirst(); 
        object.removeLast(); 
        
	}

}
