package LeetCode.Hard;

public class _25_2 {

	private ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode curr = head, next = head.next;
		while (next != null) {
			curr.next = next.next;
			next.next = head;
			head = next;
			next = curr.next;
		}
		return head;
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k==1) return head;
		ListNode anchor = null;
		ListNode currHead = head, currTail = head, nextHead = head, prevHead = null , prevTail = null;
		while (true) {
			for (int i=0; i<k; i++) {
				if (nextHead == null) {
					if (anchor == null) return head;
					else return anchor;
				}
				currTail = nextHead;
				nextHead = nextHead.next;
			}
			prevHead = currHead;
			currTail.next = null;
			currHead = reverseList(currHead);
			if (anchor == null) anchor = currHead;
			else prevTail.next = currHead;
			prevHead.next = nextHead;
			prevTail = prevHead;
			currHead = nextHead;
		}
	}

}
