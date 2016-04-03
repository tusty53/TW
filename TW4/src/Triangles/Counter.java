package Triangles;

import static java.lang.Thread.sleep;




class Counter {
	int m_counter;
	Thread m_notify;
	Counter(Thread Notify) {
		m_counter=0;
		m_notify = Notify;
	}
	synchronized void inc() {
		m_counter++;		
		System.out.println("Counter:"+m_counter);
	}
	synchronized void dec() {
		if(m_counter>0)
			m_counter--;			
		System.out.println("Counter:"+m_counter);
		if(m_counter==0) {
   		    System.out.println("Counter:notify()");
			notify();
		}	
	}
	synchronized void release() {
		try {
		  System.out.println("Counter:wait");
  		  wait();
		  System.out.println("Counter:release");
                  sleep(1000);
		}
		catch(InterruptedException e){
			System.out.println("Counter:InterruptedException caught");
		}
	}
}

