import java.util.Scanner;

/*

4
1 3
6 12
2 1
3 6


*/

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n, m, i;
		String temp;
		StringBuilder answerBuilder;
		while(t!=0) {
			n = sc.nextInt();
			m = sc.nextInt();
			answerBuilder = new StringBuilder();
			if(m<n){
				answerBuilder.append("No\n");
				// System.out.println("No");
			}
			else {
				if(n%2 != 0) {
					answerBuilder.append("Yes\n");
					// System.out.println("Yes");
					for(i=0; i<n-1; i++) answerBuilder.append("1 ");
					// for(i=0; i<n-1; i++) System.out.print("1 ");
					answerBuilder.append(Integer.toString(m-n+1)+"\n");
					// System.out.print(m-n+1);
					// System.out.println();
				} else if(m%2 == 0) {
					answerBuilder.append("Yes\n");
					// System.out.println("Yes");
					for(i=0; i<n-2; i++) answerBuilder.append("1 ");
					// for(i=0; i<n-2; i++) System.out.print("1 ");
					temp = Integer.toString((m-n+2)/2);
					answerBuilder.append(temp + " " + temp + "\n");
					// System.out.print(temp + " " + temp);
					// System.out.println();
				} else {
					answerBuilder.append("No\n");
					// System.out.println("No");
				}
			}
			System.out.println(answerBuilder.toString());
			t--;
		}
		sc.close();
	}
}
