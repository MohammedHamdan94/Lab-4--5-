import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    System.out.println("Unsorted Array ---------------------------------------------------");
    ArrayList<Integer> integerList = Lab4.getList();
    Lab4.outputList(integerList);

    System.out.println("\n\nBubble sort results ----------------------------------------------");
    ArrayList<Integer> bubbleSortedList = new ArrayList<>(integerList); // Create a copy of the list
    long bubbleStartTime = System.nanoTime();
    Lab4.bubbleSort(bubbleSortedList);
    long bubbleEndTime = System.nanoTime();
    Lab4.outputList(bubbleSortedList);
    System.out.println("\nBubble sort took " + ((bubbleEndTime - bubbleStartTime) / 1_000_000) + " milliseconds.");

    System.out.println("\n\nInsertion sort results -------------------------------------------");
    ArrayList<Integer> insertionSortedList = new ArrayList<>(integerList); // Create a copy of the list
    long insertionStartTime = System.nanoTime();
    Lab4.insertionSort(insertionSortedList);
    long insertionEndTime = System.nanoTime();
    Lab4.outputList(insertionSortedList);
    System.out
        .println("\nInsertion sort took " + ((insertionEndTime - insertionStartTime) / 1_000_000) + " milliseconds.");
  }
}

class Lab4 {
  public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
    // Step 1 - Implement insertion sort algorithm here
    for (int i = 1; i < integerList.size(); i++) {
      int key = integerList.get(i);
      int j = i - 1;

      // Move elements of integerList[0..i-1], that are greater than key,
      // to one position ahead of their current position
      while (j >= 0 && integerList.get(j) > key) {
        integerList.set(j + 1, integerList.get(j));
        j = j - 1;
      }
      integerList.set(j + 1, key);
    }

    return integerList;
  }

  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
    // Step 2 - Implement the bubble sort algorithm here
    int n = integerList.size();
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (integerList.get(j) > integerList.get(j + 1)) {
          // swap integerList[j] and integerList[j+1]
          int temp = integerList.get(j);
          integerList.set(j, integerList.get(j + 1));
          integerList.set(j + 1, temp);
        }
      }
    }

    return integerList;
  }

  public static ArrayList<Integer> getList() {
    ArrayList<Integer> integerList = new ArrayList<>();
    String line;
    try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
      while ((line = br.readLine()) != null) {
        integerList.add(Integer.parseInt(line));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return integerList;
  }

  public static void outputList(ArrayList<Integer> integerList) {
    for (int i = 0; i < integerList.size(); i++) {
      System.out.print(integerList.get(i) + " ");
    }
  }
}