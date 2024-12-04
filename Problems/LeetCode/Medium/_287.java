package LeetCode.Medium;

public class _287 {

	/*
	 * Modifying the array inplace O(N) O(1)
	 */
	public int findDuplicate(int[] nums) {
		int answer = 0;
		int n = nums.length;
		int index;
		for (int i = 0; i < n; i++) {
			index = Math.abs(nums[i]);
			if (nums[index - 1] < 0) {
				answer = index;
				break;
			} else {
				nums[index - 1] = -1 * nums[index - 1];
			}
		}
		for (int i = 0; i < n; i++) {
			nums[i] = Math.abs(nums[i]);
		}
		return answer;
	}

}
