package LeetCode.Easy;

import java.util.Scanner;
import java.util.Stack;

/*

https://leetcode.com/problems/implement-queue-using-stacks/

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 

Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
 

Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, peek, and empty.
All the calls to pop and peek are valid.
 

Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.

*/


// Using single stack push: O(n)
/*
class MyQueue {

	Stack<Integer> stack;

	public MyQueue() {
		stack = new Stack<Integer>();
	}
	
	public void push(int x) {
		Stack<Integer> temp = new Stack<Integer>();
		while(!stack.isEmpty()) temp.add(stack.pop());
		stack.add(x);
		while(!temp.isEmpty()) stack.add(temp.pop());
	}
	
	public int pop() {
		return stack.pop();
	}
	
	public int peek() {
		return stack.peek();
	}
	
	public boolean empty() {
		return stack.isEmpty();
	}
}
*/


// Using two stack Amortized O(1)
class MyQueue {

	Stack<Integer> stack;
	Stack<Integer> stack2;

	public MyQueue() {
		stack = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	
	public void push(int x) {
		stack.add(x);
	}
	
	public int pop() {
		refillOutputStack();
		return stack2.pop();
	}
	
	public int peek() {
		refillOutputStack();
		return stack2.peek();
	}
	
	public boolean empty() {
		return stack.isEmpty() && stack2.isEmpty();
	}

	// transfer all elements from 1st stack to output stack only when output stack is empty
	public void refillOutputStack(){
		if(stack2.isEmpty()) while(!stack.isEmpty()) stack2.add(stack.pop());
	}
}

public class twohundredandthirtytwo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyQueue objMyQueue = new MyQueue();
		objMyQueue.push(10);
		objMyQueue.push(20);
		objMyQueue.push(30);
		objMyQueue.push(40);
		System.out.println(objMyQueue.peek());
		System.out.println(objMyQueue.pop());
		System.out.println(objMyQueue.pop());
		System.out.println(objMyQueue.empty());
		System.out.println(objMyQueue.pop());
		System.out.println(objMyQueue.pop());
		System.out.println(objMyQueue.empty());
		sc.close();
	}

}
