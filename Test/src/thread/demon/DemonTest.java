package thread.demon;

public class DemonTest extends Thread{
	
	@Override
	public void run() {
		
		  if(Thread.currentThread().isDaemon()){
			  //checking for daemon thread  
			   System.out.println("daemon thread work");  
			  }  
			  else{  
			  System.out.println("user thread work");  
			 } 
		
	for(int i=0;i<=50;i++)
	{
		try {
			Thread.sleep(100);
			

		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+"::"+i);
	}
		
	
	}
	

}
