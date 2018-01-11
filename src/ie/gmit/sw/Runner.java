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
		//t3 for consumer
		//Thread t3 = new Thread(new Consumer(queue,200,10), "T3");
		t1.start();
		t2.start();
		
		
	}


}

/*Thread t1 = new Thread (new FileParser) (queue, fileName), "B"),
t1.start();*/