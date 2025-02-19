package GFG.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*

https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

Rat in a Maze Problem - I
Difficulty: MediumAccuracy: 35.75%Submissions: 319K+Points: 4Average Time: 25m
Consider a rat placed at position (0, 0) in an n x n square matrix mat. The rat's goal is to reach the destination at position (n-1, n-1). The rat can move in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).

The matrix contains only two possible values:

0: A blocked cell through which the rat cannot travel.
1: A free cell that the rat can pass through.
Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell. In case of no path, return an empty list.+

The task is to find all possible paths the rat can take to reach the destination, starting from (0, 0) and ending at (n-1, n-1), under the condition that the rat cannot revisit any cell along the same path. Furthermore, the rat can only move to adjacent cells that are within the bounds of the matrix and not blocked.

Return the final result vector in lexicographically smallest order.

Examples:

Input: mat[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
Output: ["DDRDRR", "DRDDRR"]
Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.
Input: mat[][] = [[1, 0], [1, 0]]
Output: []
Explanation: No path exists and the destination cell is blocked.
Input: mat = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
Output: ["DDRR", "RRDD"]
Explanation: The rat has two possible paths to reach the destination: 1. "DDRR" 2. "RRDD", These are returned in lexicographically sorted order.
Constraints:
2 ≤ mat.size() ≤ 5
0 ≤ mat[i][j] ≤ 1
*/
public class Rat_in_a_Maze_Problem__I {

	// Backtracking solution.
	private void findPathsWithBacktracking(final int row, final int col, final ArrayList<ArrayList<Integer>> mat, final String currPath, final ArrayList<String> paths) {
		final int n = mat.size();
		if (row == n-1 && col == n-1) {
			paths.add(currPath);
			return;
		}
		StringBuilder stringBuilder = new StringBuilder(currPath);

		mat.get(row).set(col, 0);
		// Move up;
		if (row-1>=0 && mat.get(row-1).get(col)==1) {
			stringBuilder.append("U");
			findPathsWithBacktracking(row-1, col, mat, stringBuilder.toString(), paths);
			stringBuilder.deleteCharAt(stringBuilder.length()-1);
		}
		// Move down;
		if (row+1<n && mat.get(row+1).get(col)==1) {
			stringBuilder.append("D");
			findPathsWithBacktracking(row+1, col, mat, stringBuilder.toString(), paths);
			stringBuilder.deleteCharAt(stringBuilder.length()-1);
		}
		// Move left;
		if (col-1>=0 && mat.get(row).get(col-1)==1) {
			stringBuilder.append("L");
			findPathsWithBacktracking(row, col-1, mat, stringBuilder.toString(), paths);
			stringBuilder.deleteCharAt(stringBuilder.length()-1);
		}
		// Move right;
		if (col+1<n && mat.get(row).get(col+1)==1) {
			stringBuilder.append("R");
			findPathsWithBacktracking(row, col+1, mat, stringBuilder.toString(), paths);
			stringBuilder.deleteCharAt(stringBuilder.length()-1);
		}
		mat.get(row).set(col, 1);
	}

	// Function to find all possible paths
	public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
		int n = mat.size();
		if (mat.get(n-1).get(n-1) == 0) return null;
		ArrayList<String> paths = new ArrayList<>();
		findPathsWithBacktracking(0, 0, mat, new String(), paths);
		Collections.sort(paths);
		return paths;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
		int currVal;
		System.out.println("Enter elements: ");
		for (int i=0; i<n; i++) {
			mat.add(new ArrayList<>());
			for (int j=0; j<n; j++) {
				currVal = sc.nextInt();
				mat.get(i).add(currVal);
			}
		}
		Rat_in_a_Maze_Problem__I rat_in_a_Maze_Problem__I = new Rat_in_a_Maze_Problem__I();
		System.out.println(rat_in_a_Maze_Problem__I.findPath(mat));
		sc.close();
	}
}