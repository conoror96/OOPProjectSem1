package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import ie.gmit.sw.UI;
import ie.gmit.sw.FileParser;

public class Runner {
	public static void main(String[] args) {
		UI ui = new UI(); // create new user interface
		ui.show(); //
		int shingleSize = 100; 
		
		BlockingQueue<Shingle> queue = new LinkedBlockingQueue<>();
		
		Thread t1 = new Thread(new FileParser(queue, ui.getFile1(), shingleSize()),"A");
		Thread t2 = new Thread(new FileParser(queue, ui.getFile2(), shingleSize()),"B");
		
		t1.start();
		t2.start();
	}

	private static int shingleSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}

/*Thread t1 = new Thread (new FileParser) (queue, fileName), "B"),
t1.start();*/