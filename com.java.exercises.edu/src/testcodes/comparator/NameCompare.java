package testcodes.comparator;

import java.util.Comparator;

public class NameCompare implements Comparator<Movie>  {

    public int compare(Movie m1, Movie m2) 
    { 
        return m1.getName().compareTo(m2.getName()); 
    }
}
