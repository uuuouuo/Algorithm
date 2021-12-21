import java.util.Scanner;

public class bj3040 {

	static int arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		arr = new int[9];
		result = new int[7];
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		
		comb(0, 0);

	}
	
	static int result[];
	private static void comb(int start, int idx) {
		if(idx == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += result[i];
			}
			
			if(sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(result[i]);
				}
				System.exit(0);
			}			
			return;
		}
		
		for (int i = start; i < 9; i++) {
			result[idx] = arr[i];
			comb(i + 1, idx + 1);
		}
		
	}

}
