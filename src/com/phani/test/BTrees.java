package com.phani.test;

import java.util.LinkedList;
import java.util.Stack;

public class BTrees {

	private Node root;

	public BTrees(int key) {
		root = new Node(key);
	}

	class Node {
		int key;
		Node left = null;
		Node right = null;

		Node(int k) {
			key = k;
		}
	}

	public Node getRoot() {
		return root;
	}

	public void insert(Node temp, int key) {

		LinkedList<Node> q = new LinkedList<Node>();
		q.add(temp);
		while (!q.isEmpty()) {
			temp = q.remove();
			if (temp.left == null) {
				temp.left = new Node(key);
				break;
			} else
				q.add(temp.left);

			if (temp.right == null) {
				temp.right = new Node(key);
				break;
			} else
				q.add(temp.right);
		}
	}

	public void levelOrder(Node temp) {
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(temp);
		while (!q.isEmpty()) {
			temp = q.remove();
			System.out.print(temp.key + " ");
			if (temp.left != null)
				q.add(temp.left);

			if (temp.right != null)
				q.add(temp.right);
		}
		System.out.println();
	}

	public void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.key + " ");
		inOrder(node.right);
	}

	public void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.key + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.key + " ");
	}

	public void deleteNode() {

	}

	public void findElementInorder(Node node, int key) {
		if (node == null) {
			return;
		}
		if (node.key == key) {
			System.out.println("Key " + key + " present");
			return;
		} else {
			findElementInorder(node.left, key);
			findElementInorder(node.right, key);
		}
	}

	public void findElementBFS(Node node, int key) {
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(node);
		while (!q.isEmpty()) {
			Node temp = q.remove();
			System.out.print(temp.key + " ");
			if (temp.key == key) {
				System.out.println("key is present!");
				break;
			}
			if (temp.left != null) {
				q.add(temp.left);
			}
			if (temp.right != null) {
				q.add(temp.right);
			}
		}
	}

	public void findElementDFS(Node node, int key) {
		Stack<Node> s = new Stack<Node>();
		s.push(node);
		while (!s.isEmpty()) {
			Node temp = s.pop();
			System.out.print(temp.key + " ");
			if (temp.key == key) {
				System.out.print("Key is present!");
				break;
			}
			if (temp.right != null)
				s.push(temp.right);
			if (temp.left != null) {
				s.push(temp.left);
			}
		}
	}

	public static void main(String[] args) {
		BTrees tree = new BTrees(1);

		tree.insert(tree.getRoot(), 2);
		tree.insert(tree.getRoot(), 3);
		tree.insert(tree.getRoot(), 4);
		tree.insert(tree.getRoot(), 5);

		System.out.println("Inorder");
		tree.inOrder(tree.getRoot());
		System.out.println();
		System.out.println("Preorder");
		tree.preOrder(tree.getRoot());
		System.out.println();
		System.out.println("Postorder");
		tree.postOrder(tree.getRoot());
		System.out.println();
		System.out.println("LevelOrder");
		tree.levelOrder(tree.getRoot());

		System.out.println("Inorder search");
		tree.findElementInorder(tree.getRoot(), 5);
		System.out.println();
		System.out.println("Breadth first search");
		tree.findElementBFS(tree.getRoot(), 3);
		System.out.println();
		System.out.println("Depth first search");
		tree.findElementDFS(tree.getRoot(), 3);
		System.out.println();
	}

}
