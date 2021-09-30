package project.excercises.code.concurrency;

public class CreateThread01 {

	public static void main(String[] args) {
		
		class Multi3 implements Runnable{  
			public void run(){  
				System.out.println("thread is running...");  
			}  
		}
		
		Thread runThread = new Thread(new Multi3());
		runThread.start();
		
		class Multi4 extends Thread{  
			public void run(){  
				System.out.println("thread is running...");  
			}  
		}
		
		Thread runThread2 = new Multi4();
		runThread2.start();
		
	}
}
