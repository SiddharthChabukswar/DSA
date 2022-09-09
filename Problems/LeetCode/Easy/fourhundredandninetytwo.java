package LeetCode.Easy;

import java.util.Arrays;
import java.util.Scanner;

/*

https://leetcode.com/problems/construct-the-rectangle/

A web developer needs to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:

The area of the rectangular web page you designed must equal to the given target area.
The width W should not be larger than the length L, which means L >= W.
The difference between length L and width W should be as small as possible.
Return an array [L, W] where L and W are the length and width of the web page you designed in sequence.

 

Example 1:

Input: area = 4
Output: [2,2]
Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1]. 
But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.
Example 2:

Input: area = 37
Output: [37,1]
Example 3:

Input: area = 122122
Output: [427,286]
 

Constraints:

1 <= area <= 107

*/

public class fourhundredandninetytwo {

	public int[] constructRectangle(int area) {
		int[] ans = {1, 1};
        if(area == 1) return ans;
		long sqrt, left = 0, right = area/2, sqr;
		while(left <= right){
			sqrt = (right - left)/2 + left;
			sqr = sqrt*sqrt;
			// System.out.printf("sqrt: %d, sqr: %d\n", sqrt, sqr);
			if(sqr > area) right = sqrt - 1;
			else left = sqrt + 1;
		}
		// System.out.println(right);
		while(right > 0){
			if(area%right == 0){
				ans[0] = area/(int)right;
				ans[1] = (int)right;
				break;
			}
			right--;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter area: ");
		int area = sc.nextInt();
		fourhundredandninetytwo objFourhundredandninetytwo = new fourhundredandninetytwo();
		System.out.println(Arrays.toString(objFourhundredandninetytwo.constructRectangle(area)));
		sc.close();
	}
}
