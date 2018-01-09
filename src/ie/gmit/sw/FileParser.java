package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class FileParser implements Runnable {
	private List<String> buffer = new LinkedList<>();
	private BlockingQueue <Shingle> queue;
	private String fileName;
	private int documentId;
	private int shingleSize, k;
	
	
	
	public FileParser(BlockingQueue<Shingle> queue, String filename, int shingleSize){
		this.queue = queue;
		this.fileName = fileName;
		this.shingleSize = shingleSize;
	}


public void parse() throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
	String line = null;
	while((line = br.readLine()) !=null){
		String lineLower = line.toLowerCase();
		String[] words = lineLower.split("\\s+"); //strip char + convert to lowercase
		Shingle s = getShingle(words); //the mystery getShignle method
		queue.put(s); //blocking call
		
	}
	br.close();
}
private Shingle getShingle(String[] words) {
	// TODO Auto-generated method stub
	return null;
	
}
@Override
public void run() {
	// TODO Auto-generated method stub
	
}
}

  /*Thread t1 = new Thread (new FileParser) (queue, fileName), "B"),
  t1.start();*/