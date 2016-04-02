


class Executor_2 extends Thread {
	public synchronized void run() {

	  	Counter counter = new Counter(this);
		//axiom
		Vertex S = new Vertex(null,null,"S");

		//p1 
		P1 p1 = new P1(S,counter);
		p1.start();
		
		counter.release();
		
		//p2,p3
		P2 p21 = new P2(p1.m_vertex,counter);
		P5 p5b = new P5(p1.m_vertex.m_right,counter);
		p21.start();
		p5b.start();

		counter.release();
		
		//p5^2,p6^2
		P2 p22 = new P2(p21.m_vertex,counter);
		P4 p41 = new P4(p21.m_vertex.m_right,counter);
		p22.start();
		p41.start();

		counter.release();
		
                P5 p5a = new P5(p22.m_vertex,counter);
		P4 p42 = new P4(p22.m_vertex.m_right,counter);
		P6 p61 = new P6(p41.m_vertex,counter);
		P6 p62 = new P6(p41.m_vertex.m_right,counter);
		p5a.start();
		p42.start();
                p61.start();
		p62.start();
                
                counter.release();
                
                P6 p63 = new P6(p42.m_vertex,counter);
		P6 p64 = new P6(p42.m_vertex.m_right,counter);
                p63.start();
		p64.start();
                
                counter.release();
		//done
		System.out.println("done");
		GraphDrawer drawer = new GraphDrawer();
		drawer.draw(p64.m_vertex);

	}
}
