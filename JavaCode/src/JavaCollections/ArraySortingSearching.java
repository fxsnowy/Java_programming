package JavaCollections;

public class ArraySortingSearching {

	private int[] theArray = new int[50];

	private int arraySize = 10;

	public void generateRandomArray() {
		for (int i = 0; i < arraySize; i++) {

			theArray[i] = (int) (Math.random() * 10) + 10;
		}
	}

	public void printArray() {
		System.out.println("---------");
		for (int i = 0; i < arraySize; i++) {

			System.out.print("| " + i + " |");
			System.out.println(theArray[i] + " |");

			System.out.println("---------");
		}
	}

	public int getValueAtIndex(int index) {
		if (index < arraySize) {
			return theArray[index];
		}
		return 0;
	}

	public boolean doesArrayContainThisValue(int searchValue) {
		boolean valueInArray = false;
		for (int i = 0; i < arraySize; i++) {
			if (theArray[i] == searchValue) {
				valueInArray = true;
				break;
			}
		}
		return valueInArray;
	}

	public void deleteIndex(int index) {
		if (index < arraySize) {
			for (int i = index; i < (arraySize - 1); i++) {
				theArray[i] = theArray[i + 1];
			}
		}
		arraySize--;
	}

	public void insertValue(int value) {
		if (arraySize < 50) {
			theArray[arraySize++] = value;
		}
	}

	public String linearSearchForValue(int value) {
		boolean valueInArray = false;
		String indexsWithValue = "";
		System.out.print("The value was found in the following: ");

		for (int i = 0; i < arraySize; i++) {
			if (theArray[i] == value) {
				indexsWithValue += i + " ";
			}
		}

		if (indexsWithValue == "") {
			return "None";
		}
		return indexsWithValue;
	}

	public void printHorzArray(int i, int j) {

		for (int n = 0; n < 51; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < arraySize; n++) {

			System.out.print("| " + n + "  ");

		}

		System.out.println("|");

		for (int n = 0; n < 51; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < arraySize; n++) {

			System.out.print("| " + theArray[n] + " ");

		}

		System.out.println("|");

		for (int n = 0; n < 51; n++)
			System.out.print("-");

		System.out.println();

		// END OF FIRST PART

		// ADDED FOR BUBBLE SORT

		if (j != -1) {

			// ADD THE +2 TO FIX SPACING

			for (int k = 0; k < ((j * 5) + 2); k++)
				System.out.print(" ");

			System.out.print(j);

		}

		// THEN ADD THIS CODE

		if (i != -1) {

			// ADD THE -1 TO FIX SPACING

			for (int l = 0; l < (5 * (i - j) - 1); l++)
				System.out.print(" ");

			System.out.print(i);

		}

		System.out.println();

	}

	/*
	 * 1) Computation that performs for every m*n becomes crucial operation,
	 * when the input size goes larger.
	 * 
	 * 2) Random input(entropy is high): For large inputs, Selection sort should
	 * work better than Bubble sort because 'minimumValueIndex = j;' is less
	 * costlier than 'swapValues()' for every m*n. I would not care about 'int
	 * minimumValueIndex = i;' and 'swapValues(i, minimumValueIndex);' in
	 * selection sort.
	 * 
	 * 3) Nearly sorted input: For small/large inputs, Bubble sort(BS)
	 * performance improvement is better than Selection sort, because BS avoids
	 * 'swapValues(j, j + 1);' computation which is more costlier than
	 * 'minimumValueIndex = j;' for every m*n.
	 * 
	 * 4) Reversed Input: For small/large inputs, Bubble sort(BS) looks too
	 * worse than selection sort, because BS cannot avoid 'swapValues(j, j +
	 * 1);' computation which is more costlier than 'minimumValueIndex = j;' for
	 * every m*n.
	 * 
	 * 5) At any instance of time, part of the array is sorted using BS and SS.
	 */
	public void bubbleSort() { // ascending order
		for (int i = arraySize - 1; i > 1; i--) {

			for (int j = 0; j < i; j++) {
				if (theArray[j] > theArray[j + 1]) { // Use < for descending
														// order

					swapValues(j, j + 1); // takes 3 computations - relatively
					printHorzArray(i, j);
				}
				printHorzArray(i, j);

			}

		}
	}

	public void selectionSort() {
		for (int i = 0; i < arraySize; i++) {

			int minimumValueIndex = i; // takes 1 computation - relatively
			for (int j = i + 1; j < arraySize; j++) {

				if (theArray[minimumValueIndex] > theArray[j]) {
					minimumValueIndex = j; // takes 1 computation - relatively
				}

			}
			swapValues(i, minimumValueIndex); // takes 3 computations
			printHorzArray(i, -1);

		}
	}

	/*
	 * Insertion sort is like sorting deck of cards, by considering the 
	 * first card which is already sorted.
	 */
	public void insertionSort() {

		/*for (int i = 1; i < arraySize; i++) {
			int j = i;
			int toInsert = theArray[i];
			while ((j > 0) && (theArray[j - 1] > toInsert)) {
				theArray[j] = theArray[j - 1];
				j--;

				printHorzArray(i, j);

			}
			theArray[j] = toInsert;

			printHorzArray(i, j);

			System.out.println("\nArray[i] = " + theArray[i] + " Array[j] = "
					+ theArray[j] + " toInsert = " + toInsert + "\n");

		}*/
		
		for (int i = 1; i < arraySize; i++){
			int j = i-1;
			int key = theArray[i];
			while ((j > 0) && (theArray[j] > key)){ //these are sorted
				theArray[j+1] = theArray[j];
				j--;
			}
			theArray[j] = key;
		}

	}

	private void swapValues(int indexOne, int indexTwo) {
		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;
	}

	public static void main(String[] args) {

		ArraySortingSearching newArray = new ArraySortingSearching();

		newArray.generateRandomArray();

		newArray.selectionSort();

		/*
		 * newArray.printArray();
		 * 
		 * System.out.println(newArray.getValueAtIndex(3));
		 * 
		 * System.out.println(newArray.doesArrayContainThisValue(13));
		 * 
		 * newArray.deleteIndex(4);
		 * 
		 * newArray.printArray();
		 * 
		 * newArray.insertValue(50);
		 * 
		 * newArray.printArray();
		 * 
		 * System.out.println(newArray.linearSearchForValue(18));
		 */

	}

}
