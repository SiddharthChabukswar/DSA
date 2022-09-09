package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/remove-element/

Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
                        	// It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < actualLength; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

 

Example 1:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).
 

Constraints:

0 <= nums.length <= 100
0 <= nums[i] <= 50
0 <= val <= 100

*/

public class twentyseven {

	public int removeElement(int[] nums, int val) {
		int i = 0, j = 0, maxlen = nums.length;
		// System.out.println(Arrays.toString(nums));
		// System.out.println(val);

		// Substitution technique O(n)
		for(i=0; i<maxlen; i++){
			if(nums[i] != val){
				nums[j] = nums[i];
				j++;
			}
		}

		// Swapping technique O(n)
		/*
		int temp;
		for(i=0; i<maxlen; i++){
			if(nums[j] != val) j++;
			else{
				if(nums[i] == val) continue;
				else{
					temp = nums[i];
					nums[i] = nums[j];
					nums[j++] = temp;
				}
			}
		}
		*/
		// System.out.println(Arrays.toString(nums));
		return j;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int n = sc.nextInt();
		int[] nums = new int[n];
		System.out.println("Enter the array elements one by one: ");
		for(int i=0; i<n; i++) nums[i] = sc.nextInt();
		System.out.print("Enter the number to be removed: ");
		int val = sc.nextInt();
		twentyseven objTwentyseven = new twentyseven();
		System.out.println(objTwentyseven.removeElement(nums, val));
		sc.close();
	}
	
}
