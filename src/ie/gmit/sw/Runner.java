package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import ie.gmit.sw.UI;
import ie.gmit.sw.FileParser;

public class Runner {
	public static void main(String[] args) throws InterruptedException {
		UI ui = new UI(); // create new user interface
		ui.show(); // 
		
		BlockingQueue<Shingle> queue = new LinkedBlockingQueue<>();
		
		Thread t1 = new Thread(new FileParser(queue, ui.getFile1(), ui.getShingleSize()),"T1");
		Thread t2 = new Thread(new FileParser(queue, ui.getFile2(), ui.getShingleSize()),"T2");
		//t3 for consumer
		//Thread t3 = new Thread(new Consumer(queue,200,10), "T3");
		t1.start();
		t2.start();
		//t3.start();
		
		t1.join();
		t2.join();
		//t3.join();
	}


}

/*Thread t1 = new Thread (new FileParser) (queue, fileName), "B"),
t1.start();*/