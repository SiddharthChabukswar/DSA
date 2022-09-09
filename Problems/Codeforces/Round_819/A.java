import java.util.Scanner;

/*

5
6
1 3 9 11 5 7
1
20
3
9 99 999
4
2 1 8 1
3
2 1 5 4

*/

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n, i, max;
		while(t!=0) {
			n = sc.nextInt();
			int[] arr = new int[n];
			for(i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			max = 0;
			for(i=0; i<n; i++) {
				max = Math.max(max, arr[n-1] - arr[i]);
				max = Math.max(max, arr[i] - arr[0]);
				max = Math.max(max, arr[i] - arr[(i+1)%n]);
			}
			System.out.println(max);
			t--;
		}
		sc.close();
	}

}