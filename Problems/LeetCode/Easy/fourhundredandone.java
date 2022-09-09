package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*

https://leetcode.com/problems/binary-watch/

A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.

For example, the below binary watch reads "4:51".


Given an integer turnedOn which represents the number of LEDs that are currently on, return all possible times the watch could represent. You may return the answer in any order.

The hour must not contain a leading zero.

For example, "01:00" is not valid. It should be "1:00".
The minute must be consist of two digits and may contain a leading zero.

For example, "10:2" is not valid. It should be "10:02".
 

Example 1:

Input: turnedOn = 1
Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
Example 2:

Input: turnedOn = 9
Output: []
 

Constraints:

0 <= turnedOn <= 10

*/

public class fourhundredandone {

	HashMap<Integer, List<String>> getBinMinsMap() {
		HashMap<Integer, List<String>> bin_map = new HashMap<Integer, List<String>>();
		List<String> curr;
		int[] number_of_ones = new int[60];
		int curr_ones;
		for(int i=1; i<60; i++) number_of_ones[i] = 1 + number_of_ones[(i&(i-1))];
		String value;
		for(int i=0; i<60; i++){
			curr_ones = number_of_ones[i];
			curr = bin_map.get(curr_ones);
			if(curr == null) curr = new ArrayList<String>();
			value = String.valueOf(i);
			if(i<10) value = "0"+value;
			curr.add(value);
			bin_map.put(curr_ones, curr);
		}
		return bin_map;
	}

	HashMap<Integer, List<String>> getBinHoursMap() {
		HashMap<Integer, List<String>> bin_map = new HashMap<Integer, List<String>>();
		List<String> curr;
		int[] number_of_ones = new int[12];
		int curr_ones;
		for(int i=1; i<12; i++) number_of_ones[i] = 1 + number_of_ones[(i&(i-1))];
		for(int i=0; i<12; i++){
			curr_ones = number_of_ones[i];
			curr = bin_map.get(curr_ones);
			if(curr == null) curr = new ArrayList<String>();
			curr.add(String.valueOf(i));
			bin_map.put(curr_ones, curr);
		}
		return bin_map;
	}
	
	public List<String> readBinaryWatch(int turnedOn) {
		List<String> answer_list = new ArrayList<String>();
		if(turnedOn > 8) return answer_list;
		HashMap<Integer, List<String>> bin_hour_map = getBinHoursMap();
		HashMap<Integer, List<String>> bin_min_map = getBinMinsMap();
		List<String> hours_list, min_list;
		int hours, mins, max_hours = Math.min(3, turnedOn);
		for(hours = 0; hours<=max_hours; hours++){
			mins = turnedOn - hours;
			if(mins > 5) continue;
			hours_list = bin_hour_map.get(hours);
			min_list = bin_min_map.get(mins);
			for(String hour_string: hours_list){
				for(String min_string: min_list){
					answer_list.add(hour_string+":"+min_string);
				}
			}
		}
		return answer_list;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number turnedOn: ");
		int turnedOn = sc.nextInt();
		fourhundredandone objFourhundredandone = new fourhundredandone();
		for(String answer: objFourhundredandone.readBinaryWatch(turnedOn)){
			System.out.println(answer);
		}
		sc.close();
	}
}
