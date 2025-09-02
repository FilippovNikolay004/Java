package first_project;

public class Program {
	private static int[] sort(int[] arr) {
	    for (int i = 0; i < arr.length; i++) {
	        for (int j = 0; j < arr.length - 1; j++) {
	            if (arr[j] > arr[j + 1]) {
	                int temp = arr[j];
	                arr[j] = arr[j + 1];
	                arr[j + 1] = temp;
	            }
	        }
	    }
	    return arr;
	}
	private static void print(String label, int[] arr) {
		System.out.print(label);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(arr.length - 1 != i ? ", " : "");
		}

		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] a = {6, 4, 2, 1, 7};
		
		print("before: ", a);
		print("after: ", sort(a));
	}
}