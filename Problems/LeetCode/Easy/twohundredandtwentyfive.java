package LeetCode.Easy;

import java.util.LinkedList;
import java.util.Queue;

/*

https://leetcode.com/problems/implement-stack-using-queues/

Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:

You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 

Example 1:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False
 

Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, top, and empty.
All the calls to pop and top are valid.
 

Follow-up: Can you implement the stack using only one queue?

*/

// Two queue method
/*
class MyStack {

	Queue<Integer> queue1;
	Queue<Integer> queue2;

	public MyStack() {
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}
	
	public void push(int x) {
		queue2.add(x);
		while(!queue1.isEmpty()){
			queue2.add(queue1.poll());
		}
		queue1 = new LinkedList<Integer>(queue2);
		queue2.clear();
	}
	
	public int pop() {
		return queue1.poll();
	}
	
	public int top() {
		return queue1.peek();
	}
	
	public boolean empty() {
		return queue1.isEmpty();
	}
}
*/


// Single Queue method
class MyStack {

	Queue<Integer> queue1;

	public MyStack() {
		queue1 = new LinkedList<Integer>();
	}
	
	public void push(int x) {
		int curr_queue_size = queue1.size();
		int curr_queue_element = 0;
		queue1.add(x);
		while(curr_queue_size!=0){
			curr_queue_element = queue1.poll();
			queue1.add(curr_queue_element);
			curr_queue_size--;
		}
	}
	
	public int pop() {
		return queue1.poll();
	}
	
	public int top() {
		return queue1.peek();
	}
	
	public boolean empty() {
		return queue1.isEmpty();
	}
}

public class twohundredandtwentyfive {

	public static void main(String[] args) {
		MyStack obj = new MyStack();
		System.out.println("Program started: ");
		obj.push(10);
		obj.push(20);
		obj.push(30);
		obj.push(40);
		System.out.println(obj.pop());
		System.out.println(obj.top());
		System.out.println(obj.empty());
	}

}
