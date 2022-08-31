package LeetCode.Easy;

/*

https://leetcode.com/problems/student-attendance-record-i/

You are given a string s representing an attendance record for a student where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:

'A': Absent.
'L': Late.
'P': Present.
The student is eligible for an attendance award if they meet both of the following criteria:

The student was absent ('A') for strictly fewer than 2 days total.
The student was never late ('L') for 3 or more consecutive days.
Return true if the student is eligible for an attendance award, or false otherwise.

 

Example 1:

Input: s = "PPALLP"
Output: true
Explanation: The student has fewer than 2 absences and was never late 3 or more consecutive days.
Example 2:

Input: s = "PPALLL"
Output: false
Explanation: The student was late 3 consecutive days in the last 3 days, so is not eligible for the award.
 

Constraints:

1 <= s.length <= 1000
s[i] is either 'A', 'L', or 'P'.

*/

import java.util.Scanner;

public class fivehundredandfiftyone {
	
	public boolean checkRecord(String s) {
		int absent_count = 0, consecutive_late_count = 0;
		for(char attendance: s.toCharArray()) {
			if(attendance == 'L') {
				consecutive_late_count++;
			} else {
				if(attendance == 'A') {
					absent_count++;
				}
				consecutive_late_count = 0;
			}
			if(absent_count == 2 || consecutive_late_count == 3) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string s:");
		String s = sc.next();
		System.out.println(new fivehundredandfiftyone().checkRecord(s));
		sc.close();
	}

}
