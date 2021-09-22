package testcodes.arrays.order;

import java.util.ArrayList;
import java.util.List;

public class SampleListOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	List<Book> books = new ArrayList<>();
    	books.add( new Book(90, "The Good book"));
    	books.add( new Book(10, "Horror book"));
    	books.add( new Book(50, "Comedy book"));
    	
    	books.stream().sorted((b1, b2) -> {
    		return b2.pages > b1.pages ? -1 : b2.pages < b1.pages ? 1 : 0;
    	}).forEach(System.out::println);
	}
	
    static class Book {
    	private final int pages;
    	private final String name;
		public Book(int pages, String name) {
			super();
			this.pages = pages;
			this.name = name;
		}
		@Override
		public String toString() {
			return "Book [pages=" + pages + ", name=" + name + "]";
		}
    }

}
