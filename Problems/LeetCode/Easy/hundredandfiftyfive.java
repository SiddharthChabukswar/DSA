package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();	// return 0
minStack.getMin(); // return -2
 

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.

*/

// Brute force Pop: O(n)
/*
class MinStack {

	List<Integer> stack;
	int size;
	int min_ele;

	MinStack() {
		stack = new ArrayList<Integer>();
		size = 0;
		min_ele = Integer.MAX_VALUE;
	}
	
	public void push(int val) {
		stack.add(size, val);
		if(val < min_ele) min_ele = val;
		size++;
	}
	
	public void pop() {
		if(stack.get(size-1) == min_ele){
			min_ele = Integer.MAX_VALUE;
			for(int i=0; i<size-1; i++) if(stack.get(i) < min_ele) min_ele = stack.get(i);
		}
		size--;
	}
	
	public int top() {
		return stack.get(size-1);
	}
	
	public int getMin() {
		return min_ele;
	}

}
*/


// Optimal solution O(1) all operations

class MinStack{

	List<Integer> stack;
	List<Integer> curr_min;
	int size;

	MinStack() {
		stack = new ArrayList<Integer>();
		curr_min = new ArrayList<Integer>();
		size = 0;
	}
	
	public void push(int val) {
		if(size == 0) curr_min.add(0, val);
		else curr_min.add(size, Math.min(curr_min.get(size-1), val));
		stack.add(size, val);
		size++;
	}
	
	public void pop() {
		size--;
	}
	
	public int top() {
		return stack.get(size-1);
	}
	
	public int getMin() {
		return curr_min.get(size-1);
	}
}


public class hundredandfiftyfive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MinStack objMinStack = new MinStack();
		int val = 10;
		objMinStack.push(val);
		objMinStack.pop();
		System.out.println(objMinStack.top());
		System.out.println(objMinStack.getMin());
		sc.close();
	}
	
}
