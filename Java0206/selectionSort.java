public static void selectionSort (Comparable[] list){
	int minIndex;
	Comparable temp;

	for (int unsortedIndex = 0; unsortedIndex < list.length - 1; unsortedIndex++){
		minIndex = unsortedIndex;
		for (int currentIndex = unsortedIndex + 1; currentIndex < list.length; currentIndex++){
			if (list[currentIndex].compareTo(list[minIndex]) < 0){
				minIndex = currentIndex;
			}
		}

		if (minIndex != unsortedIndex){
			temp = list[minIndex];
			list[minIndex] = list[unsortedIndex];
			list[unsortedIndex] = temp;
		}
	}
}

public static void insertionSort(int[] inputList){
	for (int unsortedStart = 1; unsortedStart < inputList.length; unsortedStart++){
		int temp = list[unsortedStart]; // leftmost unsorted index
		int currentSortedIndex = unsortedStart - 1; // rightmost sorted index

		while (currentSortedIndex >= 0 && list[currentSortedIndex] > temp){
			list[currentSortedIndex+1] = list[currentSortedIndex];
			currentSortedIndex--;//these 2 lines indicates we are moving each element of number 1 index behind as long as the latter is larger than the former
		}

		list[currentSortedIndex+1] = temp;//if the while condition completed, it means all elements are properly moved till the element that is smaller than the moving one
		// thus moving the
	}
}

public static void binarySearch(Comparable[] inputList, Comparable target){
	int start = 0, end = inputList.length - 1, mid = 0;

	while (start <= end){
		mid = (start + end) / 2;
		if (list[mid].compareTo(target) == 0){
			return mid;
		} else if (list[mid].compareTo(target) < 0){
			start = mid + 1;
		} else {
			end = mid - 1;
		}
	}
	return -1;
}