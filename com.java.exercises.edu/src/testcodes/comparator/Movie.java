package testcodes.comparator;

public class Movie implements Comparable<Movie>  {

	private double rating; 
    private String name; 
    private int year; 
  
    // Used to sort movies by year 
    @Override
    public int compareTo(Movie m) 
    { 
        return this.year - m.year; 
    } 
  
    // Constructor 
    public Movie(String nm, double rt, int yr) 
    { 
        this.name = nm; 
        this.rating = rt; 
        this.year = yr; 
    } 
  
    // Getter methods for accessing private data 
    public double getRating() { return rating; } 
    public String getName()   {  return name; } 
    public int getYear()      {  return year;  }

}
