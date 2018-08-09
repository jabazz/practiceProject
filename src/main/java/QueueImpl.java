package main.java;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueImpl {

	public static void main(String[] args) {
		Queue<Integer> q = new ArrayBlockingQueue<>(3);
		q.add(10);
		q.add(20);
		q.add(30);
		System.out.println(q.hashCode());
		
	}

}
