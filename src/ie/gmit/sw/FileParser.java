package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class FileParser implements Runnable {
	private List<String> buffer = new LinkedList<>();
	private BlockingQueue<Shingle> queue;
	private String fileName;
	private int documentId;
	private int shingleSize, k;

	public FileParser(BlockingQueue<Shingle> queue, String filename, int shingleSize) {
		super();
		this.documentId = documentId;
		this.queue = queue;
		this.fileName = fileName;
		this.shingleSize = shingleSize;
		this.k = k;
	}

	public void parse() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		String line = null;
		while ((line = br.readLine()) != null) {
			if (line.length() > 0) { // skip over blank lines
				String lineLower = line.toLowerCase();
				String[] words = lineLower.split("\\s+"); // strip char +
															// convert to
															// lowercase
				Shingle s = getNextShingle(); // the mystery getShignle method
				queue.put(s); // blocking call
			}
		}
		flushbuffer();
		br.close();
	}

	// add words to buffer
	private void addWordsTobuffer(String[] words) {
		for (String s : words) {
			buffer.add(s);
		}
	}

	private Shingle getNextShingle() {
		StringBuffer sb = new StringBuffer();
		int counter = 0;
		while (counter < shingleSize) {
			if (((LinkedList<String>) buffer).peek() != null) {
				sb.append(((LinkedList<String>) buffer).poll());
				counter++;
			}
		}
		if (sb.length() > 0) {
			return (new Shingle(documentId, sb.toString().hashCode()));
		} else {
			return (null);
		}
	}// next shingle

	private void flushbuffer() throws InterruptedException {
		while (buffer.size() > 0) {
			Shingle s = getNextShingle();
			if (s != null) {
				queue.put(s);
			} else {
				queue.put(new Poison(documentId, 0));
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
