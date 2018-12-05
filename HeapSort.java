import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {
	private static Scanner sc;

	public static void main(String args[]) {
		sc = new Scanner(System.in);

		System.out.println("Digite o número termos");
		int n = sc.nextInt();

		System.out.println("Digite os termos");
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		System.out.println("\nArray não organizado:\t\t"+Arrays.toString(arr)+"\n");

		heap(arr);

		System.out.println("\nArray organizado:\t\t"+Arrays.toString(arr)+"\n");
		System.out.println("\nFIM");
	}

	static void heapify(int a[], int n, int i) {
		int max, child;
		child = 2 * i + 1;
		max = i;
		if (child < n)
			if (a[child] > a[max])
				max = child;
		if (child + 1 < n)
			if (a[child + 1] > a[max])
				max = child + 1;
		if (max != i) {
			int temp = a[i];
			a[i] = a[max];
			a[max] = temp;
			heapify(a, n, max);
		}
	}

	static void buildheap(int a[]) {
		for (int i = a.length / 2 - 1; i >= 0; i--)
			heapify(a, a.length, i);
	}

	static void heap(int a[]) {
		buildheap(a);
		int cont = 1;
		for (int i = a.length - 1; i >= 1; i--) {	
			
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			heapify(a, i, 0);
			System.out.println("Array Parcial Estapa["+cont+"]:\t"+Arrays.toString(a));
			cont++;		
		}
	}
}