package com.DsaProject;

import com.DsaProject.Basic.*;
import com.DsaProject.CustomDS.*;
import com.DsaProject.DataStructureModels.ListNode;
import com.DsaProject.DataStructureModels.TreeNode;
import com.DsaProject.OOPD.Penguin;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DsaProjectApplication {

	public static void main(String[] args) {
//		Penguin penguin = new Penguin();
//		penguin.showName();
		//ExecuteArrayProblem();
	}

	static void ExecuteStack(){
		CustomStack<Integer> myStack = new CustomStack<>();

		int[] asteriods = new int[]{5,10,-5};
		int[] asteriods1 = new int[]{8, -8};
		int[] asteriods2 = new int[]{10,2,-5};
		myStack.push(10);
		myStack.push(20);
		myStack.push(30);
		myStack.push(40);

		System.out.println("Top element :- "+ myStack.peek() + ", Size of stack :- " + myStack.size());
		myStack.pop();

		System.out.println("Top element :- "+ myStack.peek() + ", Size of stack :- " + myStack.size());
		myStack.pop();


		System.out.println("Top element :- "+ myStack.peek() + ", Size of stack :- " + myStack.size());
		myStack.push(40);


		System.out.println("Top element :- "+ myStack.peek() + ", Size of stack :- " + myStack.size());
	}

	static  void ExecuteCustomHashMap()
	{
		CustomHashMap<Integer, Integer> hashMap = new CustomHashMap<>();
		hashMap.put(1, 10);
		hashMap.put(2, 20);
		hashMap.put(3, 30);
		hashMap.put(4, 40);
		hashMap.put(5, 50);

		System.out.println("Element at 3 :- " + hashMap.get(3));
		hashMap.remove(3);
		System.out.println("Element at 3 :- " + hashMap.get(3));
		hashMap.put(3, 60);

		System.out.println("Element at 3 :- " + hashMap.get(3));
	}

	static void ExecuteGraphProblem()
	{
		MyGraphProblems myGraphProblems = new MyGraphProblems();
		ArrayList<ArrayList<Integer>> B = new ArrayList<>();

		B.add(new ArrayList<>(Arrays.asList(1, 2)));
		B.add(new ArrayList<>(Arrays.asList(2, 3)));
		B.add(new ArrayList<>(Arrays.asList(4, 5)));
		B.add(new ArrayList<>(Arrays.asList(5, 1)));

		//Print(myGraphProblems.PathDirectedGraph(5, B));
		Print(myGraphProblems.PossibilityOfFinishing(3, new ArrayList<>(Arrays.asList(1, 2)), new ArrayList<>(Arrays.asList(2, 3))));
	}
	static void ExecuteCustomCustomHashSet()
	{
		CustomHashSet<Integer> customHashSet = new CustomHashSet<>();
		customHashSet.add(10);
		customHashSet.add(20);
		customHashSet.add(30);
		customHashSet.add(40);
		System.out.println("Size bfr remove :- "+ customHashSet.size());
		customHashSet.remove(20);
		System.out.println("Size aftr remove :- "+ customHashSet.size());
	}

	static void ExecuteCustomQueue()
	{
		CustomQueue<Integer> queue = new CustomQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		System.out.println("Size bfr deque :- "+ queue.size());
		System.out.println("poll bfr deque :- "+ queue.poll());
		queue.dequeue();
		System.out.println("Size aftr deque :- "+ queue.size());
		System.out.println("poll aftr deque :- "+ queue.poll());
		System.out.println(queue.size());
		System.out.println(queue.poll());
	}

	static void ExecuteCustomArrayList()
	{
		CustomArrayList<Integer> arrOfInts = new CustomArrayList<>();
		arrOfInts.add(10);
		arrOfInts.add(20);
		arrOfInts.add(30);
		arrOfInts.add(40);

		System.out.println("Element at 2: " + arrOfInts.get(2));
		System.out.println("Size Of Array: " + arrOfInts.size());

		arrOfInts.remove(2);
		System.out.println("Element at 2: " + arrOfInts.get(2));
		System.out.println("Size Of Array: " + arrOfInts.size());
	}

	static void ExecuteTreeProblems()
	{
		TreePrblms treePrblms = new TreePrblms();
		TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));

		// Creating second tree
		TreeNode q = new TreeNode(1, new TreeNode(4), new TreeNode(3));

		Print(treePrblms.isSameTree(p, q));

		//Print2DArray(treePrblms.LevelOrder(root));
		//Print2DArray(treePrblms.verticalOrderTraversal(root));
		//Print(treePrblms.RightView(root));
		//printTree(treePrblms.buildTree(new ArrayList<>(Arrays.asList(6, 1, 3, 2)), new ArrayList<>(Arrays.asList(6, 3, 2, 1))), 0);
	}

	static void ExecuteQueueProblem()
	{
		MyQueueProblems myQueueProblems = new MyQueueProblems();
		Print(myQueueProblems.CpuJobs(new ArrayList<>(Arrays.asList(2, 3, 1, 5, 4)), new ArrayList<>(Arrays.asList(1, 3, 5, 4, 2))));
	}

	static void ExecuteStackProblem()
	{
		MyStack myStack = new MyStack();

		//Print(myStack.countStudents(new int[]{1,1,0,0}, new int[] {0,1,0,1}));
		Print(myStack.countStudents(new int[]{1,1,1,0,0,1}, new int[] {1,0,0,0,1,1}));
//		int[] asteriods = new int[]{5,10,-5};
//		int[] asteriods1 = new int[]{8, -8};
//		int[] asteriods2 = new int[]{10,2,-5};

//		PrintArrayList(myStack.asteroidCollision(asteriods));
	}

	static void ExecuteLinkedListPrblm()
	{
		int[][] inputArrays = {
				{1, 4, 5},
				{1, 3, 4},
				{2, 6}
		};

		ListNode[] lists = new ListNode[inputArrays.length];
		for (int i = 0; i < inputArrays.length; i++) {
			lists[i] = createLinkedList(inputArrays[i]);
		}
		LinkedList linkedList = new LinkedList();
		printLinkedList(linkedList.mergeKLists(lists));
	}

	static void ExecuteArrayProblem()
	{
		MyArray myArray = new MyArray();
		Print(myArray.LongestValidParentheses1("(()"));
	}

	static ListNode createLinkedList(int[] values) {
		if (values.length == 0) return null;

		ListNode head = new ListNode(values[0]); // Create the head node
		ListNode current = head;

		for (int i = 1; i < values.length; i++) {
			current.next = new ListNode(values[i]); // Create and link the new node
			current = current.next; // Move to the next node
		}

		return head;
	}

	public static void printTree(TreeNode root, int level) {
		if (root == null) return;

		// Print right subtree first (so it appears on top in the output)
		printTree(root.right, level + 1);

		// Print current node with indentation
		System.out.println("    ".repeat(level) + "→ " + root.val);

		// Print left subtree
		printTree(root.left, level + 1);
	}

	static void printLinkedList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " -> ");
			current = current.next;
		}
		System.out.println("NULL");
	}

	public static <T> void Print (T a)
	{
		System.out.println(a);
	}

	public static void PrintArrayList(ArrayList<Integer> A)
	{
		System.out.println(A);
	}

	public static void PrintArray(int[] A)
	{
		for(int num : A)
		{
			System.out.println(num);
		}
	}

	public static void Print2DArray(ArrayList<ArrayList<Integer>> A)
	{
		for (ArrayList<Integer> row : A) {
			System.out.println(row);
		}
	}

}
