package ie.gmit.sw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import ie.gmit.sw.UI;
import ie.gmit.sw.FileParser;

public class Runner {
	public static void main(String[] args) throws InterruptedException {
		UI ui = new UI(); // create new user interface
		ui.show(); // 
		
		BlockingQueue<Shingle> q1 = new LinkedBlockingQueue<>();
		BlockingQueue<Shingle> q2 = new LinkedBlockingQueue<>();
		
		
		Map <Integer,List<Integer>> m1 = new HashMap<>();
		Map <Integer,List<Integer>> m2 = new HashMap<>();
		
		int k = 0;
		Thread t1 = new Thread(new FileParser(q1, ui.getFile1(),k, ui.getShingleSize()),"T1");
		Thread t2 = new Thread(new FileParser(q2, ui.getFile2(),k, ui.getShingleSize()),"T2");
		
		t1.start();
		t2.start();
		
		//t3/t4 for consumer
		/*Thread t3 = new Thread(new Consumer(q1,m1,k), "T3");
		Thread t4 = new Thread(new Consumer(q2,m2,k), "T4");
		
		t3.start();
		t4.start();
		
		t1.join();
		t2.join();
		//t3.join();
		
		t3.join();
		t3.join();*/
		
		//outprint final results
		System.out.println("---------------------------------");
		System.out.println("Documents are " + "" + "% Similar");
		System.out.println("---------------------------------");
		
	}


}

/*Thread t1 = new Thread (new FileParser) (queue, fileName), "B"),
t1.start();*/