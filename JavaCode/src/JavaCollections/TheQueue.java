package JavaCollections;

import java.util.Arrays;

public class TheQueue {

	private String[] queueArray;

	private int queueSize;

	private int front, rear, numberOfItems = 0;

	TheQueue(int size) {
		queueSize = size;
		queueArray = new String[size];
		Arrays.fill(queueArray, "-1");
	}

	public void insert(String input) {
		if (numberOfItems + 1 <= queueSize) {
			queueArray[rear++] = input;
			numberOfItems++;
			System.out.println("INSERT" + input + "was added to the queue\n");
		} else {
			System.out.println("Sorry but the Queue is full\n");
		}
	}

	public void remove() {
		if (numberOfItems > 0) {
			System.out.println("REMOVE" + queueArray[front] + "was removed");
			queueArray[front++] = "-1";
			numberOfItems--;
		} else {
			System.out.println("Sorry but the queue is empty");
		}
	}

	public void peek() {
		System.out.println("The First element is" + queueArray[front]);
	}


	public void displayTheQueue() {

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < queueSize; n++) {

			System.out.format("| %2s " + " ", n);

		}

		System.out.println("|");

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < queueSize; n++) {

			if (queueArray[n].equals("-1"))
				System.out.print("|     ");

			else
				System.out.print(String.format("| %2s " + " ", queueArray[n]));

		}

		System.out.println("|");

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

		// Number of spaces to put before the F

		int spacesBeforeFront = 3 * (2 * (front + 1) - 1);

		for (int k = 1; k < spacesBeforeFront; k++)
			System.out.print(" ");

		System.out.print("F");

		// Number of spaces to put before the R

		int spacesBeforeRear = (2 * (3 * rear) - 1) - (spacesBeforeFront);

		for (int l = 0; l < spacesBeforeRear; l++)
			System.out.print(" ");

		System.out.print("R");

		System.out.println("\n");

	}

	public static void main(String[] args) {
		TheQueue theQueue = new TheQueue(10);

		theQueue.insert("10");
		theQueue.insert("11");
		theQueue.insert("15");

		theQueue.displayTheQueue();

		theQueue.remove();

		theQueue.displayTheQueue();
		
		theQueue.insert("20");
		
		theQueue.displayTheQueue();
		
		theQueue.remove();

		theQueue.displayTheQueue();
		
		theQueue.insert("21");
		
		theQueue.displayTheQueue();
	}

}
