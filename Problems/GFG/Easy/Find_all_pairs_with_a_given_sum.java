package GFG.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*

https://practice.geeksforgeeks.org/problems/find-all-pairs-whose-sum-is-x5808/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-all-pairs-whose-sum-is-x

Given two unsorted arrays A of size N and B of size M of distinct elements, the task is to find all pairs from both arrays whose sum is equal to X.

 

Example 1:

Input:
A[] = {1, 2, 4, 5, 7}
B[] = {5, 6, 3, 4, 8} 
X = 9 
Output: 
1 8
4 5 
5 4
Explanation:
(1, 8), (4, 5), (5, 4) are the
pairs which sum to 9.
Example 2:
Input:
A[] = {-1, -2, 4, -6, 5, 7}
B[] = {6, 3, 4, 0} 
X = 8 
Output:
4 4 
5 3

Your Task:  
You don't need to read input or print anything. Your task is to complete the function allPairs() which takes the array A[], B[], its size N and M respectively and an integer X as inputs and returns the sorted vector pair values of all the pairs u,v where u belongs to array A and v belongs to array B. If no such pair exist return empty vector pair.
Note : All pairs should be printed in increasing order of u. For eg. for two pairs (u1,v1) and (u2,v2), if u1<u2 then
(u1,v1) should be printed first else second.


Expected Time Complexity: O(NLog(N))
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N, M ≤ 106
-106 ≤ X, A[i], B[i] ≤ 106


*/

class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

public class Find_all_pairs_with_a_given_sum {

	public pair[] allPairs( long A[], long B[], long N, long M, long X) {
		List<pair> pairList = new ArrayList<pair>();
		Set<Long> bSet = new HashSet<Long>();
		pair newPair;
		for(Long b: B) bSet.add(b);
		Arrays.sort(A);
		for(Long a: A) {
			if(bSet.contains(X-a) == true){
				newPair = new pair(a, X-a);
				pairList.add(newPair);
			}
		}
		pair[] pairArray = new pair[pairList.size()];
		for(int i=0; i<pairArray.length; i++) pairArray[i] = pairList.get(i);
		return pairArray;
	}

}