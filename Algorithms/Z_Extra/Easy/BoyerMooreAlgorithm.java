package Algorithms.Z_Extra.Easy;

/*

Purpose: Find the element occurring more than size/2 time in an array
Time complexity: O(n)

Approach:

1. Set a counter and max_element to 0
2. traverse the array and check if count == 0
3. if count == 0 set max_element to curr_ele
4. if curr_ele == max_element  increment count
5. else decrement count

[2, 2, 1, 1, 1, 2, 2]


*/

public class BoyerMooreAlgorithm {
	
	public static int getMajorityElement(int[] nums) {
		int count = 0, majority_element = 0, n = nums.length;
		for(int i=0; i<n; i++){
			if(count == 0) majority_element = nums[i];
			if(majority_element == nums[i]) count++;
			else count--;
		}
		return majority_element;
	}

	public static void main(String[] args) {
		int[] array = new int[]{ 2, 2, 1, 1, 1, 2, 2 };
		System.out.print("Given array: ");
		for(int element: array) System.out.print(element + ", ");
		System.out.println();
		int majority_element = getMajorityElement(array);
		System.out.print("Majority element in the array: " + majority_element);
		System.out.println();
	}

}
