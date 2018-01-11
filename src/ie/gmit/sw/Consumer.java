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
	private Map<Integer, List<Integer>> map = new HashMap<>();
	private ExecutorService pool;

	public Consumer(BlockingQueue<Shingle> q, int k, int poolSize) {
		this.queue = q;
		this.k = k;
		pool = Executors.newFixedThreadPool(poolSize);
		// ThreadPoolExecutor executor = (ThreadPoolExecutor)
		// Executors.newFixedThreadPool(4); ---
		// https://howtodoinjava.com/core-java/multi-threading/java-fixed-size-thread-pool-executor-example/
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		Random random = new Random();
		minhashes = new int[k]; // k = 200 - 300
		for (int i = 0; i < minhashes.length; i++) {
			minhashes[i] = random.nextInt(0);
		}
	}

	@Override
	public void run() {
		try {
			int docCount = 2;
			while (docCount > 0) {
				Shingle s = queue.take();
				if (s instanceof Poison) {
					docCount--;
				} else {
					pool.execute(new Runnable() {
						@Override
						public void run() {
							for (int i = 0; i < minhashes.length; i++) {
								int value = s.getShingleHashCode() ^ minhashes[i]; // ^
																					// -
																					// xor(Random
																					// generated
																					// key)
								List<Integer> list = map.get(s.getDocumentId());
								if (list == null) {
									list = new ArrayList<Integer>(k);
									for (int j = 0; j < minhashes.length; j++) {
										list.add(Integer.MAX_VALUE);
										System.out.println(s.getDocumentId() + "  -----   " + value);
									}
									map.put(s.getDocumentId(), list);

								} else {
									if (list.get(i) > value) {
										list.set(i, value);

									}
								}
							}
						}
					});

				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}