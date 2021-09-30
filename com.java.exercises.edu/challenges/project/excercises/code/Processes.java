package project.excercises.code;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Processes {

	/**
	 * The java.lang.Process is a subclass of Object class and it can describe the processes 
	 * that are started by the exec() 
	 * method of Runtime class. A Process object controls the process and gets information about it.
	 *  The Process class is an abstract class, therefore, it cannot be instantiated. 
	 *  The important method s of the Process class are 
	 *  	destroy(), 
	 *  	exitValue(), 
	 *  	getErrorStream(), 
	 *  	waitFor(), 
	 *  	getInputStream() 
	 *  	getOutputStream()
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, InterruptedException {

		Runtime runtime = Runtime.getRuntime();
		System.out.println("Launching of Notepad Application");
		Process process = runtime.exec("Notepad.exe"); // Launch a Notepad application

		System.out.println("Wait for 5 seconds");
		process.waitFor(5, TimeUnit.SECONDS);
		System.out.println("Exit of Notepad Application");
		process.destroy(); // destroy the application
	}

}
