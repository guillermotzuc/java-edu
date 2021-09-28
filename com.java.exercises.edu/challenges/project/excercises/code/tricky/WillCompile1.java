package project.excercises.code.tricky;

import java.io.IOException;
import java.sql.SQLException;

public class WillCompile1 {

	/**
	 * It comes from specific to general
	 * @param args
	 */
	public static void main(String[] args) {

		try {

		} 
		catch(RuntimeException ex) {


		} catch(Exception ex) {

		}
		
		try {

		} 
		catch(Exception ex) {


		} catch(Throwable ex) {

		}
		
		try {

		    // execute code that may throw 1 of the 3 exceptions below.
			if(10<10)
				throw new IOException();
			else
				throw new RuntimeException(); 
			
		} catch(IOException | RuntimeException e) {

		} catch(Exception e) {
		}
	}

}
