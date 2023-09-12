package com.jerry.test.link;

public class NodeTest {

	static class MyNode {

		private final int val;
		private MyNode nextNode;
		private MyNode preNode;

		public MyNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {

		MyNode node1 = new MyNode(1);
		MyNode node2 = new MyNode(2);
		MyNode node3 = new MyNode(3);
		MyNode node4 = new MyNode(4);
		node1.nextNode = node2;
		node2.nextNode = node3;
		node3.nextNode = node4;
		node4.nextNode = node2;

		MyNode fast = node1;
		MyNode slow = node1;

		boolean boo = false;
		while (fast != null) {
			fast = fast.nextNode.nextNode;
			slow = slow.nextNode;
			if (fast == null || slow == null) {
				break;
			}
			if (fast == slow) {
				System.out.println(fast.val);
				boo = true;
				break;
			}
		}
		System.out.println(boo);
		System.out.println(boo);

	}

}
