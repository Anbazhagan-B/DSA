package com.DsaProject.IntPack;

import com.DsaProject.IntPack.curated.Employee;
import com.DsaProject.IntPack.supports.ListNode;
import com.DsaProject.IntPack.supports.TreeNode;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {
        Executor executor = new Executor();
        executor.execute();
    }

    public Map<Integer, List<String>> sort(ArrayList<String> nums)
    {
        return nums.stream().collect(Collectors.groupingBy(String::length));
    }


    public int maxWater(int arr[]) {
        int n = arr.length;

        int[] leftMax = new int[n];
        leftMax[0] = 0;
        for(int i =1; i < n ;i++)
        {
            leftMax[i] = Math.max(leftMax[i -1], i);
        }

        int[] rightMax = new int[n];
        rightMax[ n- 1] =  n -1;

        for(int i = n -2; i >= 0; i--)
        {
            rightMax[i] = Math.max(rightMax[i + 1], i);
        }

        for(int i  =0; i < n; i++)
        {
            int distance = Math.min(leftMax[i], rightMax[i]);
        }
        return 0;
    }

    static int maximumProduct(int[] nums)
    {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num : nums)
        {
            if(num > max1)
            {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if(num > max2)
            {
                max3 = max2;
                max2 = num;
            }
            else
            {
                max3 = num;
            }

            if(num < min1)
            {
                min2 = min1;
                min1 = num;
            }
            else
            {
                min2 = num;
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    static void sortEmployeeByAge()
    {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", 20, LocalDate.of(1996, 5, 10),  LocalDate.of(1988, 2, 15)),
                new Employee(2, "Jane", 24, LocalDate.of(2016, 3, 20), LocalDate.of(1990, 4, 22)),
                new Employee(3, "Alice", 25, LocalDate.of(2019, 9, 1), LocalDate.of(1995, 9, 1)),
                new Employee(4, "Alice1", 13, LocalDate.of(2019, 9, 1), LocalDate.of(1995, 9, 1))
        );

        List<Employee> sorted = employees.stream().sorted(new EmployeeAgeComparator()).toList();

        for(Employee employee : sorted)
        {
            System.out.println(employee.getName());
        }

    }

    static void employees()
    {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", 20, LocalDate.of(1996, 5, 10),  LocalDate.of(1988, 2, 15)),
                new Employee(2, "Jane", 24, LocalDate.of(2016, 3, 20), LocalDate.of(1990, 4, 22)),
                new Employee(3, "Alice", 25, LocalDate.of(2019, 9, 1), LocalDate.of(1995, 9, 1)),
                new Employee(4, "Alice1", 13, LocalDate.of(2019, 9, 1), LocalDate.of(1995, 9, 1))
        );
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/mm/yyyy");

        List<Employee> sortedEmplyee = employees.stream().sorted(Comparator.comparing(Employee::getDateOfJoining)).toList();

        Map<Integer, List<Employee>> yearGroupedEmployee = employees.stream().collect(Collectors.groupingBy(emp -> emp.getDateOfJoining().getYear()));
        List<Employee> tenYearsOldEmployees = employees.stream().filter(emp -> (LocalDate.now().getYear() == emp.getDateOfJoining().getYear()
                && emp.getDateOfJoining().getMonth() == LocalDate.now().getMonth() && LocalDate.now().getDayOfMonth() == emp.getDateOfJoining().getDayOfMonth())).toList();
        tenYearsOldEmployees.forEach(emp -> System.out.println(emp.getName()));
    }

    static ArrayList<Integer> findTargetSum(ArrayList<Integer> A, Integer B)
    {
        Map<Integer, Integer> numWithIndices = new HashMap<>();

        for (int i = 0; i < A.size(); i++)
        {
            Integer targetdiffrence = B - A.get(i);

            if(numWithIndices.containsKey(targetdiffrence))
            {
                Integer pairIndex= numWithIndices.get(targetdiffrence);
                return new ArrayList<>(List.of(pairIndex, i));
            }

            numWithIndices.put(A.get(i), i);
        }

        return new ArrayList<>(List.of(-1, -1));
    }

     final boolean isPalindrome1(String s) {

        StringBuilder stringBuilder = new StringBuilder();

        for(Character ch: s.toCharArray())
        {
            if(Character.isUpperCase(ch) || Character.isLowerCase(ch))
            {
                stringBuilder.append(Character.toLowerCase(ch));
            }
        }
        return checkPalindrome(stringBuilder.toString());
    }

    static boolean checkPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();

        while (i <= j)
        {
            if(chars[i] != chars[j])
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    static void printLinkedList(ListNode current)
    {
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
    }

    static ListNode createListNode(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    static ListNode reverseList(ListNode head) {

        ListNode next = null;
        ListNode prev = null;
        ListNode current = head;

        while (current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    static int DfsProblem(int A, ArrayList<ArrayList<Integer>> B) {
        Map<Integer, List<Integer>> vertices = new HashMap<>();
        boolean[] visited = new boolean[A + 1];
        Arrays.fill(visited, false);
        for(ArrayList<Integer> vertex : B)
        {
            int from = vertex.get(0);
            int to = vertex.get(1);

            if(!vertices.containsKey(from))
            {
                vertices.put(from, new ArrayList<>());
            }
            vertices.get(from).add(to);
        }

        DFS(1, vertices, visited);

        return visited[A] ? 1 : 0;
    }

    static void DFS(int A, Map<Integer, List<Integer>> vertices, boolean[] visited)
    {
        visited[A] = true;
        if(vertices.containsKey(A))
        {
            for(Integer vertex : vertices.get(A))
            {
                if(!visited[vertex])
                {
                    DFS(vertex, vertices, visited);
                }
            }
        }
    }

    public static ListNode[] buildLists(int[][] input) {
        ListNode[] lists = new ListNode[input.length];

        for (int i = 0; i < input.length; i++) {
            ListNode dummy = new ListNode(0);
            ListNode current = dummy;
            for (int num : input[i]) {
                current.next = new ListNode(num);
                current = current.next;
            }
            lists[i] = dummy.next;
        }

        return lists;
    }

    public static void printListNode(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(); // Move to next line after printing
    }

    static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        int[] previousInterval = intervals[0];

        for(int i = 1; i < n; i++)
        {
            int[] currentInterval = intervals[i];
            if(previousInterval[1] > currentInterval[0])
            {
                previousInterval[0] = Math.min(currentInterval[0], previousInterval[0]);
                previousInterval[1] = Math.max(currentInterval[1], previousInterval[1]);
            }
            else
            {
                result.add(previousInterval);
                previousInterval = currentInterval;
            }
        }

        if(previousInterval != null)
        {
            result.add(previousInterval);
        }

        return result.toArray(new int[result.size()][]);
    }

    static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result  = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            ArrayList<Integer> matchSequence = null;
            for(int j = i + 1; j < n; j++)
            {
                for(int k = j + 1; k < n; k++)
                {
                    if(nums[i] + nums[j] + nums[k] == 0)
                    {
                        matchSequence =  new ArrayList<>(List.of( nums[i], nums[j], nums[k]));
                        break;
                    }
                }
            }

            if(matchSequence != null)
            {
                result.add(matchSequence);
            }
        }

        return result;
    }


    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderNodes = new ArrayList<>();

        if(root == null)
        {
            return levelOrderNodes;
        }
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.add(root);
        levelOrderNodes.add(new ArrayList<>(List.of(root.val)));
        while (!treeNodeQueue.isEmpty())
        {
            List<Integer> currentLevelNodes = new ArrayList<>();
            int currentNodeSize = treeNodeQueue.size();
            while (currentNodeSize > 0)
            {
                TreeNode currentNode = treeNodeQueue.remove();
                if(currentNode != null)
                {
                    if(currentNode.left != null)
                    {
                        TreeNode leftNode = currentNode.left;
                        currentLevelNodes.add(leftNode.val);
                        treeNodeQueue.add(leftNode);
                    }

                    if(currentNode.right != null)
                    {
                        TreeNode rightNode = currentNode.right;
                        currentLevelNodes.add(rightNode.val);
                        treeNodeQueue.add(rightNode);
                    }
                    currentNodeSize--;
                }
            }
            if(!currentLevelNodes.isEmpty())
            {
                levelOrderNodes.add(currentLevelNodes);
            }
        }
        return levelOrderNodes;
    }

    static String DoubleCharacterTrouble(String A) {
        Stack<Character> characterStack = new Stack<>();
        for(char ch : A.toCharArray())
        {
            if (!characterStack.isEmpty() && characterStack.peek() == ch)
            {
                characterStack.pop();
            }
            else
            {
                characterStack.push(ch);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : characterStack)
        {
            stringBuilder.append(ch);
        }

        return stringBuilder.toString();
    }

    static int balancedParanthesis(String A) {
        Stack<Character> paranthesisStack = new Stack<>();
        char[] chars = A.toCharArray();

        for(char ch : chars) {
            if (!paranthesisStack.isEmpty() && ((ch == ')' && paranthesisStack.peek() == '(')
                    || (ch == '}' && paranthesisStack.peek() == '{')
                    || (ch == ']' && paranthesisStack.peek() == '['))) {
                paranthesisStack.pop();
            } else {
                paranthesisStack.push(ch);
            }
        }

        return paranthesisStack.isEmpty() ? 1 : 0;
    }

    static int peakElement(ArrayList<Integer> A) {
        int n = A.size(), low = 0, high = n - 1;

        if(A.size() == 2)
        {
            return Math.max(A.get(0), A.get(1));
        }

        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if(((mid -1 <= 0) || (A.get(mid- 1) < A.get(mid))) && ((mid + 1 >= n) || (A.get(mid) > A.get(mid + 1))))
            {
                return A.get(mid);
            }
            else if( mid - 1 >= 0 && A.get(mid- 1) < A.get(mid))
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return -1;
    }

    static int searchInsert(ArrayList<Integer> A, int B) {
        int n = A.size(), low = 0, high = n - 1;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(A.get(mid) == B)
            {
                return 1;
            }
            else if(B < A.get(mid))
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return 0;
    }

    public static int CheckPairSum(int A, ArrayList<Integer> B) {
        Set<Integer> set = new HashSet<>();
        for(Integer num : B)
        {
            int diff = A - num;
            if(set.contains(diff))
            {
                return 1;
            }
            set.add(num);
        }
        return 0;
    }

    public static int firstRepeating(ArrayList<Integer> A) {
        Set<Integer> frequencyOfElements = new HashSet<>();
        for(Integer num : A)
        {
            if(frequencyOfElements.contains(num))
            {
                return num;
            }
            else
            {
                frequencyOfElements.add(num);
            }
        }

        return -1;
    }

    public static int countDistinctElements(ArrayList<Integer> A) {
        var r = A.stream().distinct().toList().size();

        return r;
    }

    public static ArrayList<Integer> continuousSumQuery(int A, ArrayList<ArrayList<Integer>> B) {
        Integer[] sum = new Integer[A];
        Arrays.fill(sum, 0);

        for (ArrayList<Integer> row : B)
        {
            int start = row.get(0) - 1;
            int end = row.get(1) - 1;
            int value = row.get(2);

            sum[start] += value;
            if(end + 1 != 5)
            {
                sum[end + 1] -= value;
            }
        }

        for( int i =1; i < A; i++)
        {
            sum[i] = sum[i] + sum[i - 1];
        }

        return new ArrayList<>(Arrays.asList(sum));
    }
    public static int maxSubArray(final List<Integer> A) {
        int maxSum = Integer.MIN_VALUE, currentSum = 0;

        for(Integer num : A)
        {
            currentSum += num;
            if(currentSum > maxSum)
            {
                maxSum = currentSum;
            }

            if(currentSum < 0)
            {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    public static ArrayList<ArrayList<Integer>> MatrixTranspose(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> transposeMatrix = new ArrayList<>();
        int n = A.size();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {

            }
        }

        return transposeMatrix;
    }

    public static int diagonalSum(List<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int diagonalSum = 0;
        for (int i = 0; i<n ;i++)
        {

            for(int j =0; j < m;j++)
            {
                if(i == j)
                {
                    diagonalSum += A.get(i).get(j);
                }
            }
        }

        return diagonalSum;
    }

    public static ArrayList<Integer> columnSum(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = A.size();
        int m = A.get(0).size();

        for(int i = 0; i < m; i++)
        {
            int currentRowSum = 0;
            for(int j = 0; j < n; j++)
            {
                currentRowSum = currentRowSum + A.get(j).get(i);
            }
            res.add(currentRowSum);
        }
        return res;
    }

    public static int isPrime(int A) {
        boolean[] isPrime = new boolean[A + 1];
        Arrays.fill(isPrime, true);
        for(int i = 2; i * i <= A; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= A; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime[A] ? 1 : 0;
    }

    public static int countPrime(int A) {
        if(A > 1)
        {
            return 0;
        }
        boolean[] isPrime = new boolean[A + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i * i <= A; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= A; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int primeCount = 0;

        for (int i = 2; i <= A; i++)
        {
            if(isPrime[i])
            {
                primeCount++;
            }
        }
        return primeCount;
    }

    public int findPerfectNumbers(int A) {
        boolean[] isPrime = new boolean[A + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i * i <= A; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= A; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int perfectSum = 1;
        for( int i =2 ;i <= A; i++)
        {
        }
        return 0;
    }

    public static int linearSearch(ArrayList<Integer> A, int B) {
        int noOfOccurances = 0;
        for(int i = 0; i < A.size(); i++)
        {
            if(A.get(i) == B)
            {
                noOfOccurances++;
            }
        }
        return noOfOccurances;
    }

    public static int  TimeToEquality(ArrayList<Integer> A) {
        String st = "";

        Integer max = A.size() > 0 ? A.get(0) : 0;

        for(int i =1; i< A.size(); i++)
        {
            if(A.get(i) >= max)
            {
                max = A.get(i);
            }
        }

        int sumOfTimeNeeded = 0;
        for (Integer integer : A) {
            sumOfTimeNeeded = sumOfTimeNeeded + (max - integer);
        }
        return sumOfTimeNeeded;
    }

}