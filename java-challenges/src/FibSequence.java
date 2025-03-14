import java.util.ArrayList;
import java.util.Scanner;

public class FibSequence {
	
	public static void main(String[] args) {
		
		// Create variables
		int n;
		long time,completed;
		ArrayList<Integer> fibSequence = new ArrayList<Integer>();
		
		// Ask user for n value
		System.out.print("Enter number of Fibonacci terms: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		time = System.nanoTime();
				
		// Find Sequence
		findSequenceIteration(fibSequence, n);
		//findSequenceRecursion(fibSequence, n);
		
		// Print results
		System.out.print("Fibonacci Sequence: ");
		if(fibSequence.isEmpty()) {
			System.out.print("Empty!");
		}
		else {
			for(int num : fibSequence) {
				System.out.print("" + num + " ");
			}
		}
		completed = System.nanoTime() - time;
		System.out.println("\nCompleted in: " + (completed/1_000_000.0) + "ms");
		sc.close();
	}

	public static void findSequenceIteration(ArrayList<Integer> sequence, int n) {
		if(n == 0) {
			return;
		}
		if(n == 1) {
			sequence.add(0);
			return;
		}
		else {
			sequence.add(0);
			sequence.add(1);
			for(int i = 2; i < n; i++) {
				sequence.add(sequence.get(i-2) + sequence.get(i-1));
			}
		}
	}
	
	public static void findSequenceRecursion(ArrayList<Integer> sequence, int n) {
		if(n == 0) {
			return;
		}
		else if(n == 1) {
			sequence.add(0);
			return;
		}
		else if(n == 2) {
			sequence.add(0);
			sequence.add(1);
		}
		else {
			findSequenceRecursion(sequence, n-1);
			int number = sequence.get(n-2) + sequence.get(n-3);
			sequence.add(number);
		}
	}
	
}
