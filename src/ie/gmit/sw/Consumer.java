package ie.gmit.sw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Consumer implements Runnable {
	private BlockingQueue<Shingle> queue;
	private int k;
	private int[] minhashes; // The random stuff
	private Map<Integer, List<Integer>> map; // = new HashMap<>()
	// private ExecutorService pool;

	public Consumer(BlockingQueue<Shingle> q, int k, int[] hashes) {
		this.queue = q;
		this.k = k;
		this.map = map;
		this.minhashes = hashes;
		// pool = Executors.newFixedThreadPool(poolSize);
		// ThreadPoolExecutor executor = (ThreadPoolExecutor)
		// Executors.newFixedThreadPool(4); ---
		// https://howtodoinjava.com/core-java/multi-threading/java-fixed-size-thread-pool-executor-example/
		// init();
	}

	/*
	 * private void init() { // TODO Auto-generated method stub Random random =
	 * new Random(); minhashes = new int[k]; // k = 200 - 300 for (int i = 0; i
	 * < minhashes.length; i++) { minhashes[i] = random.nextInt(0); } }
	 */

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int docCount = 1;
		int max = Integer.MAX_VALUE;
		int value = 0;

		while (docCount > 0) {
			try {
				Shingle s = queue.take();

				if (s.getShingleHashCode() == 0) {
					docCount--;
					continue;
				}

				List<Integer> list = map.get(s.getDocumentId());

				if (list == null) {
					list = new ArrayList<Integer>(k);

					for (int j = 0; j < k; j++) {
						list.add(j, max);
					}
					map.put(s.getDocumentId(), list);
				}
				for (int i = 0; i < minhashes.length; i++) {
					value = s.getShingleHashCode() ^ minhashes[i];

					if (list.get(i) > value) {
						list.set(i, value);
					}
				}
			}

			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		} // while
	} // run method
} //consumer class
