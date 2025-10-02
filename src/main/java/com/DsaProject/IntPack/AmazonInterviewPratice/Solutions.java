package com.DsaProject.IntPack.AmazonInterviewPratice;

import com.DsaProject.CustomDSPratice.CusHashmap;
import com.DsaProject.IntPack.supports.ListNode;

import java.util.*;

public class Solutions {
    public void execute()
    {
        String inputStr = "6 N 4 8 5 10 3 9 11 2 7 1";
        String[] inputArr = inputStr.split(" ");
        Node node1 = buildTree(inputArr);
        System.out.println(Paths(node1));
    }

    public static Node buildTree(String[] input) {
        if (input.length == 0 || input[0].equals("N")) return null;

        Node root = new Node(Integer.parseInt(input[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < input.length) {
            Node current = queue.poll();

            // Left Child
            if (i < input.length && !input[i].equals("N")) {
                current.left = new Node(Integer.parseInt(input[i]));
                queue.add(current.left);
            }
            i++;

            // Right Child
            if (i < input.length && !input[i].equals("N")) {
                current.right = new Node(Integer.parseInt(input[i]));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        PathToLeafNode(root, result, new ArrayList<>());
        return result;
    }

    void PathToLeafNode(Node root, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currentPath)
    {
        if(root == null) return;

        currentPath.add(root.data);
        if(root.left == null && root.right == null)
        {
            result.add(new ArrayList<>(currentPath));
        }
        else
        {
            PathToLeafNode(root.left, result, currentPath);
            PathToLeafNode(root.right, result, currentPath);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    public ArrayList<Integer> findSpiral(Node root) {
        ArrayList<Integer> levelOrderTraversalOfNodes = new ArrayList<>();

        Queue<Node> queueOfNodes = new LinkedList<>();
        queueOfNodes.add(root);
        levelOrderTraversalOfNodes.add(root.data);

        boolean leftToRightDirection = true;
        while (!queueOfNodes.isEmpty()) {
            int size  = queueOfNodes.size();

            List<Integer> currentLevelNodes = new ArrayList<>();
            while (size-- > 0)
            {
                Node currentNode = queueOfNodes.remove();

                if(currentNode.left != null)
                {
                    queueOfNodes.add(currentNode.left);
                    if(leftToRightDirection)
                    {
                        currentLevelNodes.add(currentNode.left.data);
                    }
                    else
                    {
                        currentLevelNodes.add(0, currentNode.left.data);
                    }
                }

                if(currentNode.right != null)
                {
                    queueOfNodes.add(currentNode.right);
                    if(leftToRightDirection)
                    {
                        currentLevelNodes.add(currentNode.right.data);
                    }
                    else
                    {
                        currentLevelNodes.add(0, currentNode.right.data);
                    }
                }
            }
            levelOrderTraversalOfNodes.addAll(currentLevelNodes);
            leftToRightDirection = !leftToRightDirection;
        }

        return levelOrderTraversalOfNodes;
    }


    void mirror(Node node) {
        if(node == null)
            return;

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        mirror(node.left);
        mirror(node.right);
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;

        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }

    int minDist(int arr[], int x, int y) {
       int n = arr.length, lastXIndex = -1, lastYIndex = -1, minDistance = Integer.MAX_VALUE;
       for(int i = 0; i < n; i++)
       {
           if(arr[i] == x)
           {
               lastXIndex = i;
               if(lastYIndex != -1)
               {
                   minDistance = Math.min(minDistance, lastXIndex - lastYIndex);
               }
           }

           if(arr[i] == y)
           {
               lastYIndex = i;
               if(lastXIndex != -1)
               {
                   minDistance = Math.min(minDistance, lastYIndex - lastXIndex);
               }
           }
       }

       return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return false;
        }

        final int MAX_VAL = 1000;

        int[] counts = new int[MAX_VAL + 1];
        for (int x : arr) {
            if (x >= 1 && x <= MAX_VAL) {
                counts[x]++;
            }
        }

        for (int a = 1; a <= MAX_VAL; a++) {
            if (counts[a] == 0) continue;

            for (int b = 1; b <= MAX_VAL; b++) {
                if (counts[b] == 0) continue;

                long cSquared = (long) a * a + (long) b * b;

                int c = (int) Math.sqrt(cSquared);

                if (c * c != cSquared || c > MAX_VAL || counts[c] == 0) {
                    continue;
                }

                if (a != b && b != c && a != c) {
                    return true;
                }
                else if (a == b && a != c) {
                    if (counts[a] >= 2) {
                        return true;
                    }
                }
                else if (c == a && c != b) {
                    if (counts[a] >= 2) {
                        return true;
                    }
                }
                else if (c == b && c != a) {
                    if (counts[b] >= 2) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    boolean isIdentical(Node r1, Node r2) {
        if(r1 == null && r2 == null)
        {
            return true;
        }

        boolean leftSubtreeIndentical = isIdentical(r1.left, r2.left);
        boolean rightSubtreeIndentical = isIdentical(r1.right, r2.right);

        return  leftSubtreeIndentical && rightSubtreeIndentical && r1.data == r2.data;
    }
    public int firstRepeated(int[] arr) {
        Map<Integer, Integer> numWithIndex = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length ; i++)
        {
            if(numWithIndex.containsKey(arr[i]))
            {
                if(minIndex > numWithIndex.get(arr[i]))
                {
                    minIndex = numWithIndex.get(arr[i]);
                }
            }
            else
            {
                numWithIndex.put(arr[i], i);
            }
        }
        return minIndex != Integer.MAX_VALUE ? minIndex + 1 : -1;
    }

    void mergeSort(int arr[], int l, int r) {
       if(l < r)
       {
           int mid = l + (r - l) / 2;
           mergeSort(arr, l, mid);
           mergeSort(arr, mid + 1, r);
           mergeSortHelper(arr, l, r, mid);
       }
    }

    void mergeSortHelper(int arr[], int l, int r, int mid)
    {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        int i = 0, j = 0;
        for(i = 0; i < n1; i++)
        {
            leftArray[i] = arr[i + l];
        }

        for(j = 0; j < n2; j++)
        {
            rightArray[j] = arr[j + mid + 1];
        }

        i = 0; j = 0; int k = l;

        while (i < n1 && j < n2)
        {
            if(leftArray[i] <= rightArray[j])
            {
                arr[k++] = leftArray[i++];
            }
            else
            {
                arr[k++] = rightArray[j++];
            }
        }

        while(i < n1)
        {
            arr[k++] = leftArray[i++];
        }

        while(j < n2)
        {
            arr[k++] = rightArray[j++];
        }
    }

    int longestPalindromeSubseq(String s1) {

        int n = s1.length();
        int[][] dp = new int[n+1][n + 1];
        StringBuilder stringBuilder = new StringBuilder(s1);
        stringBuilder.reverse();
        String s1Reversed = stringBuilder.toString();

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(s1.charAt(i -1) == s1Reversed.charAt(j - 1))
                {
                    stringBuilder.append(s1.charAt(i -1));
                    dp[i][j] = dp[i -1][j -1] + 1;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j -1]);
                }
            }
        }

        return dp[n][n];
    }

    public int coinchange2(int[] A, int B) {
        int MOD = 1000007;
        int[] dp = new int[B + 1];
        dp[0] = 1; // Base case: one way to make sum 0

        for (int coin : A) {
            for (int i = coin; i <= B; i++) {
                int reducingIndex = i - coin;
                dp[i] = (dp[i] + dp[i - coin]) % MOD;
            }
        }

        return dp[B];
    }

    public int cuttingRod(int[] A) {
        int n = A.length;
        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i++)
        {
            int maxValue = Integer.MIN_VALUE;
            for(int j = 0; j < i; j++)
            {
                maxValue = Math.max( maxValue, A[j] + dp[i - j - 1]);
            }
            dp[i] = maxValue;
        }

        return dp[n];
    }

     int lcs(String s1, String s2) {

        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m + 1];
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                if(s1.charAt(i -1) == s2.charAt(j - 1))
                {
                    stringBuilder.append(s1.charAt(i -1));
                    dp[i][j] = dp[i -1][j -1] + 1;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j -1]);
                }
            }
        }

        return dp[n][m];
    }

    String lcs1(String s1, String s2) {

        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m + 1];
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                if(s1.charAt(i -1) == s2.charAt(j - 1))
                {
                    stringBuilder.append(s1.charAt(i -1));
                    dp[i][j] = dp[i -1][j -1] + 1;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j -1]);
                }
            }
        }

        return stringBuilder.toString();
    }

    public int smallestDivisor(int[] arr, int k) {

       int left = 0 , mid = 0, right = Arrays.stream(arr).max().getAsInt(), smallestDivisorPossible  = right;

       while(left <= right)
       {
           mid = left + (right - left) /2;

           if(isValid(arr, k, mid))
           {
               smallestDivisorPossible = mid;
               right = mid - 1;
           }
           else
           {
               left = mid + 1;
           }
       }
        return smallestDivisorPossible;
    }


    boolean isValid(int[] arr, int k, int divisor)
    {
        int sum = 0;

        for(int num : arr)
        {
            sum = sum + (num + divisor - 1)/divisor;
        }

        return sum <= k;
    }

    private int[][] memo;
    private int[] values; // Array to store item values (A)
    private int[] weights; // Array to store item weights (B)

    public int unboundedKnapsack(int A, int[] B, int[] C) {
        int[] dp = new int[A + 1];

        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int currentWeight = 1; currentWeight <= A; currentWeight++) {
            for (int i = 0; i < B.length; i++) {
                int itemValue = B[i];
                int itemWeight = C[i];
                if (currentWeight >= itemWeight && dp[currentWeight - itemWeight] != -1) {
                    int potentialValue = dp[currentWeight - itemWeight] + itemValue;
                    if (dp[currentWeight] == -1 || potentialValue > dp[currentWeight]) {
                        dp[currentWeight] = potentialValue;
                    }
                }
            }
        }

        return Math.max(0, dp[A]);
    }

    public int knapsack(int[] A, int[] B, int C) {
        // Initialize instance variables for easier access in the recursive helper function.
        this.values = A;
        this.weights = B;

        memo = new int[A.length + 1][C + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return knapsackRecursive(0, C);
    }

    private int knapsackRecursive(int index, int currentCapacity) {
        if (currentCapacity <= 0 || index >= values.length) {
            return 0;
        }

        if (memo[index][currentCapacity] != -1) {
            return memo[index][currentCapacity];
        }

        int valueExcludingCurrent = knapsackRecursive(index + 1, currentCapacity);

        int valueIncludingCurrent = 0;
        if (weights[index] <= currentCapacity) {
            valueIncludingCurrent = values[index] + knapsackRecursive(index + 1, currentCapacity - weights[index]);
        }

        memo[index][currentCapacity] = Math.max(valueExcludingCurrent, valueIncludingCurrent);

        return memo[index][currentCapacity];
    }

    public int knapsack1(int[] A, int[] B, int C) {
        int n = A.length;
        int[][] memo = new int[n+1][C + 1];

        for(int[] row :memo)
        {
            Arrays.fill(row, -1);
        }
        return knapsackHelper1(A, B, 0, C, memo);
    }

    int knapsackHelper1(int[] values , int[] weights, int index, int currentCapacity, int[][] memo)
    {
        if(index >= values.length || currentCapacity <= 0)
        {
            return 0;
        }

        if(memo[index][currentCapacity] != -1)
            return memo[index][currentCapacity];

        int excludedWeight = knapsackHelper1(values, weights, index + 1, currentCapacity, memo);

        int includedWeight = 0;

        if(weights[index] <= currentCapacity)
        {
            includedWeight =  values[index] + knapsackHelper1(values, weights, index + 1, currentCapacity - weights[index], memo);
        }

        memo[index][currentCapacity] = Math.max(includedWeight, excludedWeight);

        return memo[index][currentCapacity];
    }

    public int longestkSubstr(String s, int k) {
       char[] chars = s.toCharArray();
       int n = s.length(), start = 0, length = 0;
       Map<Character, Integer> charWithFrequency = new TreeMap<>();

       for (int i = 0; i < n; i++)
       {
           char currentChar = chars[i];
           charWithFrequency.put(currentChar, charWithFrequency.getOrDefault(currentChar, 0) + 1);

           if(charWithFrequency.size() > k)
           {
               char lastStart = s.charAt(start);
               charWithFrequency.put(lastStart, charWithFrequency.getOrDefault(lastStart, 0) - 1);
               if(charWithFrequency.get(lastStart) == 0)
               {
                   charWithFrequency.remove(lastStart);
               }
               start++;
           }
            if(charWithFrequency.size() == k)
            {
                length = Math.max(length, i - start + 1);
            }
       }

       return length;
    }

    int countFreq(int[] arr, int target) {
       int leftMostIndex = countFreqHelper(arr, target, true);
       int rightMostIndex = countFreqHelper(arr, target, false);

       return leftMostIndex  != -1 && rightMostIndex != -1 ?  rightMostIndex - leftMostIndex + 1 : -1;
    }

    int countFreqHelper(int[] arr, int target, boolean isLeftMost)
    {
        int n = arr.length;
        int left = 0, mid = 0, right = n - 1;
        int indexfound = -1;
        while(left <= right)
        {
            mid = left + (right - left) / 2;
            if(arr[mid] == target)
            {
                if(isLeftMost)
                {
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
                indexfound = mid;
            }
            else if(arr[mid] < target)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        return indexfound;
    }

    public ArrayList<Integer> topKFrequent(int[] arr, int k) {
        ArrayList<Integer> topKFrequent = new ArrayList<>();
        Map<Integer, Integer> elementWithFrequencies = new HashMap<>();

        for(Integer num : arr)
        {
            elementWithFrequencies.put(num, elementWithFrequencies.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> elementWithFrequencies.get(b).equals(elementWithFrequencies.get(a)) ?
                Integer.compare(b, a) :
                Integer.compare(elementWithFrequencies.get(b), elementWithFrequencies.get(a)));

        priorityQueue.addAll(elementWithFrequencies.keySet());

        for(int i = 0; i < k; i++)
        {
            if(!priorityQueue.isEmpty())
            {
                topKFrequent.add(priorityQueue.poll());
            }
        }

        return topKFrequent;
    }

    void sortOfIntegers(ArrayList<Integer> A)
    {
        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2)
                    return 1;
                else if(o2 < o1)
                    return -1;
                return 0;
            }
        });
    }

    class Meeting
    {
        int start;
        int end;
        int position;

        public Meeting(int start, int end, int position)
        {
            this.start = start;
            this.end = end;
            this.position = position;
        }
    }

    public int maxMeetings(int start[], int end[]) {
        // add your code here
        int n = start.length;
       List<Meeting> meetings = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            meetings.add(new Meeting(start[i], end[i], i));
        }

        Collections.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if(o1 != o2)
                {
                    return Integer.compare(o1.end, o2.end);
                }

                return Integer.compare(o1.position, o2.position);
            }
        });

        int possibleMeetingCount = 0;
        int lastActiveMeeting = -1;
        for(Meeting meeting: meetings)
        {
            if(meeting.start >= lastActiveMeeting)
            {
                possibleMeetingCount++;
                lastActiveMeeting = meeting.end;
            }
        }
        return possibleMeetingCount;
    }

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n = adj.size();
        ArrayList<Integer> dfsOfNodes = new ArrayList<>();
        boolean[] visited = new boolean[n];
        dfsHelper(0, adj, visited, dfsOfNodes);

        return dfsOfNodes;
    }

    void dfsHelper(Integer node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfsOfNodes)
    {
        visited[node] = true;
        dfsOfNodes.add(node);

        for(Integer neighbour: adj.get(node))
        {
            if(!visited[neighbour])
            {
                dfsHelper(neighbour, adj, visited, dfsOfNodes);
            }
        }
    }



    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();

        ArrayList<Integer> bfsOfNodes = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int currentElement = queue.remove();
            bfsOfNodes.add(currentElement);
            for (Integer element : adj.get(currentElement)) {
                if (!visited[element]) {
                    visited[element] = true;
                    queue.add(element);
                }
            }
        }

        return bfsOfNodes;
    }

    public List<Integer> frequencyCount(int[] arr) {
        int n = arr.length;
        List<Integer> frequencyOfArrayElements = new ArrayList<>(n);

        for(int element: arr)
        {
            frequencyOfArrayElements.set(element - 1, frequencyOfArrayElements.get(element - 1) + 1);
        }

        return frequencyOfArrayElements;
    }

    void printListNode(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    int getKthFromLast(ListNode head, int k) {
        head = reverseListNode(head);
        int i = 1;
        while (head != null)
        {
            if(i == k)
            {
                return head.val;
            }
            head = head.next;
            i++;
        }
        return -1;
    }

    ListNode reverseListNode(ListNode head)
    {
        ListNode traversedNode = head, prev = null, next = null;

        while (traversedNode != null)
        {
            next = traversedNode.next;
            traversedNode.next = prev;
            prev = traversedNode;
            traversedNode = next;
        }

        return prev;
    }

    public int missingNumber(int[] arr) {
        int n = arr.length;

        for(int i = 0; i < n; ++i)
        {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i])
            {
                int correctIndex = arr[i] - 1;
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
        }
        int i = 0;
        for(i = 0; i < n; i++)
        {
            if(arr[i] != i + 1)
            {
                return i + 1;
            }
        }
        return n + 1;
    }

    int maxProduct(int[] arr) {
        int n = arr.length;

        int maxProduct = arr[0];

        int currentProduct = 1;

        for(int i = 0; i < n; i++)
        {
            currentProduct = currentProduct * arr[i];

            maxProduct = Math.max(maxProduct, currentProduct);

            if(currentProduct == 0)
            {
                currentProduct = 1;
            }
        }

        currentProduct = 1;
        for(int i = n - 1; i >= 0; i--)
        {
            currentProduct = currentProduct * arr[i];

            maxProduct = Math.max(maxProduct, currentProduct);

            if(currentProduct == 0)
            {
                currentProduct = 1;
            }
        }

        return maxProduct;
    }

    // -2, 6, -3, -10, 0, 2
    int maxProduct1(int[] arr) {
        // code here
        int n = arr.length;
        long maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
        {
            long currentProductOfSubArray = 1;
            for(int j = i; j < n; j++)
            {
                currentProductOfSubArray = currentProductOfSubArray * arr[j];
                maxProduct = Math.max(currentProductOfSubArray, maxProduct);
            }

        }
        return (int)maxProduct;
    }

    public int maxWater(int arr[]) {
        int n = arr.length;
        int[] rightMax = new int[n];
        int[] leftMax = new int[n];
        leftMax[0] = arr[0];

        for(int i = 1; i < n; i++)
        {
            leftMax[i] = Math.max(leftMax[i- 1], arr[i]);
        }

        rightMax[n -1] = arr[n -1];
        for(int i = n - 2; i >= 0; i--)
        {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }
        int waterFilled = 0;
        for (int i = 0; i < n; i++)
        {
            int wallLevel = Math.min(leftMax[i], rightMax[i]);
            waterFilled = waterFilled + (wallLevel - arr[i]);
        }
        return waterFilled;
    }

    int majorityElement(int arr[]) {
        int majorElement = arr[0], majorityElementCount = 1;

        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] == majorElement)
            {
                majorityElementCount++;
            }
            else
            {
                majorityElementCount--;
                if(majorityElementCount == 0)
                {
                    majorElement = arr[i];
                    majorityElementCount = 1;
                }
            }
        }

        majorityElementCount = 0;
        for(int element: arr)
        {

            if(majorElement == element)
            {
                majorityElementCount++;
            }
        }

        if(majorityElementCount > arr.length/2)
        {
            return majorElement;
        }

        return -1;
    }

    public int MaximumSumValue(int[] A, int B, int C, int D) {

        int n = A.length, maxSumPossible = Integer.MIN_VALUE;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        leftSum[0] = A[0] * B;
        for(int i = 1; i < n; i++)
        {
            leftSum[i] = Math.max(leftSum[i-1], A[i] * B);
        }

        rightSum[n-1] = A[n-1] * D;
        for(int i = n-2; i >= 0; i--)
        {
            rightSum[i] = Math.max(rightSum[i+1], A[i] * D);
        }

        for(int i = 0; i < n; i++)
        {
            maxSumPossible = Math.max( maxSumPossible, leftSum[i] + (A[i] * C) + rightSum[i]);
        }
        return maxSumPossible;
    }

    public int MaximumSumValue1(int[] A, int B, int C, int D) {

        int n = A.length, maxSumPossible = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++)
        {
            for (int j = i;  j < n; j++)
            {
                for(int k = j; k < n; k++)
                {
                    maxSumPossible = Math.max( maxSumPossible, (A[i] * B) + (A[j] * C) + (A[k] * D));
                }
            }
        }
        return maxSumPossible;
    }

    public int adjacent(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int maxAdjacentSum = 0;
        if(m == 1)
        {
            maxAdjacentSum = Math.max(A[0][0], A[1][0]);
        }
        int[][] dp = new int[n][m];

        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                maxAdjacentSum = Math.max(maxAdjacentSum, A[i][j]);
                dp[i][j] = A[i][j];
            }
        }
        for(int i = 0; i < n; i++)
        {
            for(int j = 2; j < m; j++)
            {
                 dp[i][j] = Math.max(dp[i][j - 1], dp[i][j - 2] + A[i][j]);
                 maxAdjacentSum = Math.max(maxAdjacentSum, dp[i][j]);
            }
        }

        return maxAdjacentSum;
    }

    public int countInversions()
    {
        //int[] nums = new int[]{4, 5, 2, 1, 8};
        int[] nums = new int[]{2, 4, 1, 3, 5};
        return merge(nums, 0, 4);
    }

    int merge(int[] nums, int left, int right)
    {
        int inversionCount = 0;
        if(left < right)
        {
            int mid = left + (right - left) / 2;
            inversionCount += merge(nums, left, mid);
            inversionCount += merge(nums, mid + 1, right);
            inversionCount += merger(nums, left, mid, right);
        }
        return inversionCount;
    }

    int merger(int[] nums, int left, int mid, int right){
        int inversionSort = 0;
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftSubArray = new int[n1];
        int[] rightSubArray = new int[n2];

        for(int i = 0; i < n1; i++)
        {
            leftSubArray[i] = nums[left + i];
        }

        for(int i = 0; i < n2; i++)
        {
            rightSubArray[i] = nums[mid + i + 1];
        }
        int i = 0, j = 0, k = left;

        while(i < n1 && j < n2)
        {
            if(leftSubArray[i] <= rightSubArray[j])
            {
                nums[k++] = leftSubArray[i++];
            }
            else
            {
                nums[k++] = rightSubArray[j++];
                inversionSort = inversionSort + (n1 - i);
            }
        }

        while(i < n1)
        {
            nums[k++] = leftSubArray[i++];
        }

        while(j < n2)
        {
            nums[k++] = rightSubArray[j++];
        }
        return inversionSort;
    }
}
