package com.DsaProject.IntPack;
import com.DsaProject.IntPack.FunctionalInterface.Calculator;
import com.DsaProject.IntPack.supports.*;
import com.DsaProject.Prods.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Executor {
    private static final Logger log = LoggerFactory.getLogger(Executor.class);
    Graph graph = new Graph();


    public void execute() {
        System.out.println(CheckPairSum(8,  new ArrayList<>(Arrays.asList(3, 5, 1, 2, 1, 2))));
    }

    public int CheckPairSum(int A, ArrayList<Integer> B) {
        Set<Integer> sumNumbers = new HashSet<>();
        for(Integer num : B)
        {
            int targetDifferencePossible = A - num;
            if(sumNumbers.contains(targetDifferencePossible))
            {
                return 1;
            }
            sumNumbers.add(num);
        }
        return 0;
    }

    Map<Character, Long> characterWithCount(String input)
    {
       return input.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }

    private boolean customFilter(Integer number, Predicate<Integer> conditionsToSatisfy)
    {
        try
        {
            //return conditionsToSatisfy.test(number);
            CountDownLatch count = new CountDownLatch(3);
            for (int i = 0; i < 3; i++)
            {
                int finalI = i;
                new Thread(() -> {
                    System.out.println("Thread" + finalI);
                    count.countDown();
                }).start();
            }
            count.await();
        }
        catch (Exception e)
        {

        }
        return true;
    }

    static List<Employee> sortEmployee(List<Employee> employees)
    {
        return employees.stream().
                sorted(Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Employee::getSalary)
                        .thenComparing(Employee::getName))
                .toList();
    }

    // abcdd
    ///  Find duplicate char

    static String findDuplicateChars(String input)
    {
        StringBuilder duplicateChrs = new StringBuilder();
        HashSet<Character> characters = new HashSet<>();
        for(char chr : input.toCharArray())
        {
            if(characters.contains(chr))
            {
                duplicateChrs.append(chr);
            }
            else
            {
                characters.add(chr);
            }
        }

        return duplicateChrs.toString();

    }

    int countTriplet(int arr[]) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        int count = 0;

        for (int k = n - 1; k >= 0; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (arr[i] + arr[j] == arr[k]) {
                    count++;
                    i++;
                    j--;
                } else if (arr[i] + arr[j] < arr[k]) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        return count;
    }

    public static int firstRepeated(int[] arr) {
        // code here
        Map<Integer, Integer> numSet  = new HashMap<>();

        for(int num : arr)
        {
            numSet.put(num, numSet.getOrDefault(num, 0) + 1);
        }

        for(int i = 0; i < arr.length; i++)
        {
            int num = arr[i];
            if(numSet.get(num) > 1)
            {
                return  i + 1;
            }
        }

        return -1;
    }

    public int findExtra(int a[], int b[]) {
        Set<Integer> set = new HashSet<>();
        for(Integer num : b)
        {
            set.add(num);
        }

        for(int i = 0; i < a.length; i++)
        {
            if(!set.contains(a[i]))
            {
                return i;
            }
        }
        return -1;
    }

    public int maxVal(List<Integer> arr) {
        int n = arr.size(), minValue = arr.get(0), maxValue = arr.get(0);

        for(int i = 0; i < n; i++)
        {
            int transformValue = arr.get(i) - i;
            minValue = Math.min(transformValue, minValue);
            maxValue = Math.max(transformValue, maxValue);
        }

        return maxValue - minValue;
    }

    int maxNtype(int arr[]) {
        int n = arr.length;
        boolean isAsc = true, isDesc = true;
        int ascBreak = 0, descBreak = 0;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1])
                descBreak++;
            if (arr[i] > arr[i + 1])
                ascBreak++;
            if (arr[i] > arr[i + 1])
                isAsc = false;
            if (arr[i] < arr[i + 1])
                isDesc = false;
        }

        if (arr[n - 1] > arr[0])
            descBreak++;
        if (arr[n - 1] < arr[0])
            ascBreak++;

        if (isAsc)
            return 1;
        else if (isDesc)
            return 2;
        else if (descBreak == 1)
            return 3;
        else
            return 4;
    }

    void praticeFunctionalInterface()
    {
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;
        Calculator divide = (a, b) -> a / b;
        Calculator subtract = (a, b) -> a - b;

        System.out.println("Add :- " + add.operate(5, 6));
        System.out.println("Multiply :- " + multiply.operate(5, 6));
        System.out.println("Divide :- " + divide.operate(36, 6));
        System.out.println("Subtract :- " + subtract.operate(5, 6));
    }

    private static boolean areElementsContiguous(int arr[]) {
        int max = Arrays.stream(arr).max().getAsInt();

        int min = Arrays.stream(arr).min().getAsInt();

        int[] frequencyOfNumbers = new int[max + 1];

        for(int num: arr)
        {
            frequencyOfNumbers[num]++;
        }


        for(int element = min + 1; element <= max + 1; element++)
        {
            if ( frequencyOfNumbers[element - 1] == 0)
            {
                return false;
            }
        }

        return true;
    }

    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Map<Integer, Integer> pairsWithCount = new HashMap<>();

        for(int v : arr)
        {
           pairsWithCount.put(v, pairsWithCount.getOrDefault(v, 0) + 1);
        }

        for(int a : pairsWithCount.keySet())
        {
            if(a > 0 && pairsWithCount.containsKey(-a))
            {
                result.add(new ArrayList<>(List.of(a, -a)));
            }
        }

        if(pairsWithCount.getOrDefault(0, 0) >= 2)
        {
            result.add(new ArrayList<>(List.of(0, 0)));
        }

        result.sort((a, b) -> {
            if (!a.get(0).equals(b.get(0))) return Integer.compare(a.get(0), b.get(0));
            return Integer.compare(a.get(1), b.get(1));
        });

        return result;
    }

    public Map<Integer, List<String>> sort(List<String> nums)
    {
        //return nums.stream().collect(Collectors.groupingBy(String::length));
        return nums.stream().collect(Collectors.groupingBy(String::length));
    }

    public int minEnergy(int a[]) {
        int minEnergy = 0,  totalEnergy = 0;

        for(int num : a)
        {
            totalEnergy += num;

            if(totalEnergy < minEnergy)
            {
                minEnergy = totalEnergy;
            }
        }

        return Math.abs(minEnergy) + 1;
    }

    boolean check_elements(int arr[], int n, int A, int B)
    {
        int max = Math.max(B, Arrays.stream(arr).max().getAsInt());

        int[] frequency = new int[max + 1];

        for(int i =0; i < n; i++)
        {
            frequency[arr[i]]++;
        }

        while(A <= B)
        {
            if(frequency[A] < 1)
            {
                return false;
            }
            A++;
        }

        return true;
    }

    int mthHalf(int N, int M) {
        // code here
        int num = N, n = M -1;

        while( n > 0)
        {
            num = num / 2;
            n--;
        }

        return num;
    }

    public ArrayList<Integer> reverseSubArray(ArrayList<Integer> arr, int l,  int r) {
        // code here
        reverse(arr, l- 1, r - 1);
        return arr;
    }

    public void reverse(ArrayList<Integer> arr, int l,  int r)
    {
        int left = l, right = r;

        while (left >= 0 && right < arr.size() && left < right)
        {
            int temp = arr.get(right);
            arr.set(right , arr.get(left));
            arr.set(left , temp);
            right--;
            left++;
        }
    }

    String uncommonChars(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(char ch : s1.toCharArray())
        {
            freq1[ch - 'a'] = 1;
        }

        for(char ch : s2.toCharArray())
        {
            freq2[ch - 'a'] = 1;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < 26; i++)
        {
            if(freq2[i] + freq1[i] == 1)
            {
                stringBuilder.append((char)(i + 'a'));
            }
        }

        return stringBuilder.toString();
    }

    int[] countElements1(int a[], int b[], int n, int query[], int q)
    {
        int[] counts = new int[q]; int i = 0;
        for(int index : query)
        {
            if(index < n)
            {
                int elementToValidate = a[index];
                int countOfNumLessThen = 0;
                for(int intInB : b){
                    if(intInB <= elementToValidate)
                    {
                        countOfNumLessThen++;
                    }
                }

                if(countOfNumLessThen > 0)
                {
                    counts[i] = countOfNumLessThen;
                    i++;
                }

            }
        }
        return counts;
    }

    int firstOccurance(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();

        for(int i = 0; i < n; i++)
        {
            int j = 0;
            while(j < m && txt.charAt(i + j) == pat.charAt(j))
            {
                j++;
            }

            if(j == m)
            {
                return  i;
            }
        }

        return -1;
    }

    int thirdLargest(int arr[]) {
        int firstLargest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE, thirdLargest = Integer.MIN_VALUE;

        for (int currentElement : arr) {
            if (currentElement >= firstLargest) {
                thirdLargest = secondLargest;
                secondLargest = firstLargest;
                firstLargest = currentElement;
            } else if (currentElement >= secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = currentElement;
            } else if (currentElement >= thirdLargest) {
                thirdLargest = currentElement;
            }
        }

        return thirdLargest;
    }

    public int findKRotation(int arr[]) {
        int n = arr.length, peakElementIndex = 0, left = 0, right = n - 1, mid = 0;
        if(arr[0] < arr[n - 1])
        {
            return 0;
        }
        while (left < right)
        {
            mid = left  + (right - left) / 2;

            if(arr[mid] > arr[right])
            {
                left = mid + 1;
            }
            else
            {
                right = mid;
            }
        }

        return peakElementIndex + 1;
    }

    public ArrayList<Integer> preorder(Node root) {
        ArrayList<Integer> preorderNodes = new ArrayList<>();
        preOrderNode(root, preorderNodes);
        return preorderNodes;
    }

    void preOrderNode(Node root, ArrayList<Integer> preorderNodes)
    {
        if(root == null) return;

        preorderNodes.add(root.data);
        preOrderNode(root.left, preorderNodes);
        preOrderNode(root.right, preorderNodes);
    }

    int sumOfDigitsq(int n)
    {
        int sumOfDigits = 0;
        while(n > 1)
        {
            sumOfDigits += n % 10;
            n = n /10;
        }
        return sumOfDigits;
    }

    int minDepth(Node root) {
        if(root == null)
            return 0;

        if(root.left == null)
            return 1 + minDepth(root.right);

        if(root.right == null)
            return 1 + minDepth(root.left);

       return  1 + Math.min(minDepth(root.left) , minDepth(root.right));
    }

    int height(Node root)
    {
        if(root == null)
            return 0;

        return 1 + height(root.left) + height(root.right);
    }

    public int lenOfLongIncSubArr(List<Integer> arr) {
        int n = arr.size(), low = 0,high = n - 1,  mid = low + (high - low)/2, maxWindowLength = Integer.MIN_VALUE;


        while (low >= 0 && high < n){



            if(arr.get(low) < arr.get(mid))
            {
                low--;
            }
            else
            {
                high++;
            }
        }

        return maxWindowLength;
    }

    int sumExceptFirstLast(int[] arr) {
        // your code here
        int n = arr.length, i = 1, sum = 0;
        while (i < n- 1)
        {
            sum = sum + arr[i];
            i++;
        }

        return sum;
    }

//    Input: arr[] = [16, 17, 4, 3, 5, 2]
//    Output: [17, 5, 5, 5, 2, -1]
    ArrayList<Integer> nextGreatest(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

        int i = n - 2, lastGreaterNum = arr[n - 1];
        result.add(-1);

        while (i >= 0)
        {
            if(arr[i] > lastGreaterNum)
            {
                lastGreaterNum = arr[i];
            }

            result.add(lastGreaterNum);
            i--;
        }
        Collections.reverse(result);
        return result;
    }

    String encryptString(String s) {
        StringBuilder charWithCount = new StringBuilder();


        int n = s.length();
        char[] characters = s.toCharArray();
        int i = 0;
        while(i < n)
        {
            char currentChar = characters[i];
            int currentCharCount = 0;
            while(i < n && currentChar == characters[i])
            {
                currentCharCount++;
                i++;
            }

            charWithCount.append(currentChar);
            charWithCount.append(currentCharCount);
        }

        charWithCount.reverse();
        return charWithCount.toString();
    }


    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        ArrayList<Integer> combinedNums = new ArrayList<>();

        int i = 0, j = 0, n = arr1.length;

        while (i < n && j < n)
        {
            if(arr1[i] <= arr2[j])
            {
                combinedNums.add(arr1[i++]);
            }
            else
            {
                combinedNums.add(arr2[j++]);
            }
        }

        while (i < n)
        {
            combinedNums.add(arr1[i++]);
        }

        while (j < n)
        {
            combinedNums.add(arr2[j++]);
        }

        int mid  = (n + n) / 2;

        return combinedNums.get(mid) + combinedNums.get(mid - 1);
    }


    public static String PartyType(int arr[]) {
        Map<Integer, Integer> numWithCount = new HashMap<>();

        for(int num : arr){

            if(numWithCount.containsKey(num))
                return "true";

            numWithCount.put(num, numWithCount.getOrDefault(num, 0) + 1);
        }

        return "false";
    }

    ArrayList<Integer> downwardDiagonal(int N, int A[][]) {
        ArrayList<Integer> diagonalElements = new ArrayList<>();
        for(int i = 0; i < N; i++)
        {
            printDiagonal(A, 0, i, N, diagonalElements);
        }

        for(int i = 1; i < N; i++)
        {
            printDiagonal(A, i, N - 1, N, diagonalElements);
        }

        return diagonalElements;
    }

    void printDiagonal(int A[][], int i, int j, int n, ArrayList<Integer> diagonalElements)
    {
        while(i < n && j >= 0)
        {
            diagonalElements.add(A[i][j]);
            j--;
            i++;
        }
    }

    public boolean checkDuplicatesWithinK(int[] arr, int k) {
        Map<Integer, Integer> numWithLastIndex = new HashMap<>();

        for(int i = 0; i < arr.length; i++)
        {
            if(numWithLastIndex.containsKey(arr[i]) && i - numWithLastIndex.get(arr[i]) <= k)
            {
                return true;
            }
            numWithLastIndex.put(arr[i], i);
        }

        return false;
    }

    public int countBuildings(int[] height) {
        // code here
        if(height == null || height.length == 0) return 0;

        int maxHeigtBuilding = height[0], buildingCount = 1;

        for(int i = 1; i < height.length; i++)
        {
            if(height[i] > maxHeigtBuilding)
            {
                maxHeigtBuilding = height[i];
                buildingCount++;
            }
        }

        return buildingCount;
    }

    public int binarySearch(int[] arr, int k) {
        int left = 0, right = arr.length, mid  =0;

        while(left <= right)
        {
            mid = left + (right - left) / 2;

            if(arr[mid] == k)
            {
                return arr[mid];
            }
            else if(arr[mid] <= k)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
       return 0;
    }

    static boolean isBalanced(String s) {
        Stack<Character> stackChars = new Stack<>();

        for(char chr : s.toCharArray())
        {
            if(chr == '{' || chr == '[' || chr == '(')
            {
                stackChars.push(chr);
            }
            else
            {
                if(stackChars.isEmpty())
                {
                    return false;
                }

                if ((chr == '}' && stackChars.peek() != '{') || (chr == ')' && stackChars.peek() != '(') || (chr == ']' && stackChars.peek() != '['))
                {

                    return false;
                }

            }
        }

        return stackChars.isEmpty();
    }

    // 1, 2, 1, 3, 4, 2, 3
    ArrayList<Integer> countDistinct(int arr[], int k) {
        Map<Integer, Integer> numWithFrequency = new HashMap<>();
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < k; i++)
        {
            numWithFrequency.put(arr[i], numWithFrequency.getOrDefault(arr[i], 0) + 1);
        }

        result.add(numWithFrequency.size());
        int left = 0;

        for(int i = k; i < n; i++)
        {
            numWithFrequency.put(arr[left], numWithFrequency.getOrDefault(arr[left], 0) - 1);
            if(numWithFrequency.get(arr[left]) <= 0)
            {
                numWithFrequency.remove(arr[left]);
            }

            numWithFrequency.put(arr[i], numWithFrequency.getOrDefault(arr[i], 0) + 1);

            result.add(numWithFrequency.size());
            left++;
        }

        return result;
    }

    public int solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int[][] DIRS = { new int[] { 0, -1 }, new int[] { 0, 1 }, new int[] { -1, 0 }, new int[] { 1, 0 } };

        int n = A.size();
        if (n == 0)
            return -1;

        int m = A.get(0).size();
        if (m == 0)
            return -1;

        int[][] distance = new int[n][ m];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        distance[B.get(0)][B.get(1)] = 0;

        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.add(B);

        while (!queue.isEmpty())
        {
            List<Integer> position = queue.remove();
            int x = position.get(0);
            int y = position.get(1);

            for (int[] dir : DIRS)
            {
                int newX = x;
                int newY = y;
                int count = 0;

                while (newX >= 0 && newY >= 0 && newX < n && newY < m && A.get(newX).get(newY) == 0)
                {
                    newX += dir[0];
                    newY += dir[1];
                    count++;
                }

                newX -= dir[0];
                newY -= dir[1];
                count--;

                if (distance[x][ y] + count < distance[newX][ newY])
                {
                    distance[newX][ newY] = distance[x][ y] + count;
                    queue.add(List.of(newX, newY ));
                }
            }
        }

        return distance[C.get(0)][ C.get(1)] == Integer.MAX_VALUE ? -1 : distance[C.get(0)][ C.get(1)];
    }

    public int LongestSubArrayZeroSum(ArrayList<Integer> A) {
        int n = A.size(), maxLength = 0, sum = 0;
        Map<Integer, Integer> sumWithIndex = new HashMap<>();

        for(int i = 0; i < n; i++)
        {
            sum += A.get(i);

            if(sum == 0)
            {
                maxLength = i + 1;
            }

            if(sumWithIndex.containsKey(sum))
            {
                int currentSumLength = i - sumWithIndex.get(sum);
                if(currentSumLength > maxLength)
                {
                    maxLength = currentSumLength;
                }
            }

            sumWithIndex.put(sum, i);
        }
        return maxLength;
    }

    public int squareBlock(int A) {
        int height = 0;
        int blockUsed = 0;

        while(blockUsed <= A)
        {
            height++;
            blockUsed += height;
        }

        return height - 1;
    }

    public int sqrt(int A) {
        int left = 0, right = A, mid;long sqrt = 1;
        while (left <= right)
        {
            mid = left + (right - left)/2;

            if(mid * mid <= A)
            {
                sqrt = mid;
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        return (int)sqrt;
    }

    public ArrayList<Integer> findPairs(int arr[], int n) {
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> nums = new HashSet<>();
        for(int num : arr)
        {
            if(num < 0)
           nums.add(num);
        }

        for(Integer num : arr)
        {
            if(nums.contains(-num))
            {
                result.add(num);
            }
        }

        return result;
    }

    int getSingle(int arr[]) {
        int singleNum = 0;
        HashMap<Integer, Integer> numWithFrequency = new HashMap<>();

        for(Integer num : arr)
        {
            numWithFrequency.put(num, numWithFrequency.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : numWithFrequency.entrySet())
        {
            if(entry.getValue() % 2 != 0)
            {
                singleNum = entry.getKey();
                break;
            }
        }
        return singleNum;
    }

    public ArrayList<Integer> findDuplicates(int[] arr) {
        HashMap<Integer, Integer> numWithFrequency = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(Integer num : arr)
        {
            numWithFrequency.put(num, numWithFrequency.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : numWithFrequency.entrySet())
        {
            if(entry.getValue() == 2)
            {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public int rowWithMax1s(int arr[][]) {
        int maxOneRow = -1, maxOneCount = 0;
        int n = arr.length, m = arr[0].length;

        for(int i = 0; i < n; i++)
        {
            int currentRowOneCount = 0;
            for(int j = 0; j < m; j++)
            {
                if(arr[i][j] == 1)
                {
                    currentRowOneCount++;
                }
            }

            if(currentRowOneCount > maxOneCount)
            {
                maxOneCount = currentRowOneCount;
                 maxOneRow = i;
            }
        }
        return maxOneRow;
    }

    public int numberOfElementsInIntersection(int a[], int b[]) {
        HashSet<Integer> numOfASet = new HashSet<>();
        for(int numOfA : a)
        {
            numOfASet.add(numOfA);
        }

        int intersectionNumCount = 0;

        for(int numOfB : b)
        {
            if(numOfASet.contains(numOfB))
            {
                intersectionNumCount++;
            }
        }
        return intersectionNumCount;
    }

    public int maxRepeating(int k, int[] arr) {
        int maxRepeatedCount = 0, maxRepeatedNum = 0;
        int[] frequency = new int[k];

        for(int num: arr)
        {
            frequency[num]++;
        }

        for(int i = 0; i < k; i++)
        {
            if(frequency[i] > maxRepeatedCount)
            {
                maxRepeatedCount = frequency[i];
                maxRepeatedNum = i;
            }
        }

        return maxRepeatedNum;
    }

    public int findMaximum(int[] arr) {
       int n =  arr.length , mid = 0, left = 0, right = n -1;

       while (left <= right)
       {
           mid = left + (right - left) / 2;

           if( (mid - 1 < 0 || arr[mid -1] < arr[mid]) && (mid + 1 >= n || arr[mid + 1] < arr[mid]))
           {
               return arr[mid];
           }
           else if (mid - 1 > 0 && arr[mid -1] < arr[mid])
           {
               left = mid + 1;
           }
           else
           {
               right = mid - 1;
           }
       }

       return arr[mid];
    }

    int maxProduct(int[] arr) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for(int num : arr)
        {
            if(num >= max1)
            {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if(num >= max2)
            {
                max3 = max2;
                max2 = num;
            }
            else if(num >= max3)
            {
                max3 = num;
            }

            if(num <= min1)
            {
                min2 = min1;
                min1 = num;
            }
            else if(num <= min2)
            {
                min2 = num;
            }
        }

       return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    void rearrange(ArrayList<Integer> arr) {
        Queue<Integer> positiveNos = new LinkedList<>(),  negativeNos = new LinkedList<>();
        for (int i : arr)
        {
            if( i >= 0)
            {
                positiveNos.add(i);
            }
            else
            {
                negativeNos.add(i);
            }
        }

        int i = 0, n = arr.size();

        while (i < n && !positiveNos.isEmpty() && !negativeNos.isEmpty())
        {
            if(i % 2 == 0)
            {
                arr.set(i, positiveNos.poll());
            }
            else
            {
                arr.set(i, negativeNos.poll());
            }
            i++;
        }

        while (!positiveNos.isEmpty())
        {
            arr.set(i++, positiveNos.poll());
        }

        while (!negativeNos.isEmpty())
        {
            arr.set(i++, negativeNos.poll());
        }
    }

    int countZeroes(int[] arr) {
        int n = arr.length, left = 0, right = n - 1, mid = 0;

        while(left <= right)
        {
            mid = left + (right - left) / 2;
            if(arr[mid] == 0)
            {
                right = mid - 1;
            }
            else if(arr[mid] == 1)
            {
                left = mid + 1;
            }
        }

        return n - right - 1;
    }

    public int knapsack(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int N = A.size();
        int[][] dp = new int[N + 1][C + 1];

        for (int i = 1; i <= N; i++) {
            int value = A.get(i - 1);
            int weight = B.get(i - 1);

            for (int w = 0; w <= C; w++) {
                if (weight > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], value + dp[i - 1][w - weight]);
                }
            }
        }

        return dp[N][C];
    }

    public int countOccurrence(int[] arr, int k) {
        int maxCount,  n = arr.length;
        Map<Integer, Integer> numWithFrequency = new HashMap<>();

        for (int j : arr) {
            numWithFrequency.put(j, numWithFrequency.getOrDefault(j, 0) + 1);
        }

        maxCount = 0;
        for (int j : numWithFrequency.values())
        {
            if (j > n / k) {
                maxCount++;
            }
        }

        return maxCount;
    }

    static ArrayList<Integer> getStar(int[] arr) {
        int n = arr.length;
        int maxRightSideNumber = 0;
        ArrayList<Integer> rightSideGreaterNumbers = new ArrayList<>();
        for(int i = n - 1; i >= 0; i--)
        {
            if(arr[i] > maxRightSideNumber)
            {
                maxRightSideNumber = arr[i];
                rightSideGreaterNumbers.add(maxRightSideNumber);
            }
        }
        Collections.reverse(rightSideGreaterNumbers);
        return rightSideGreaterNumbers;
    }

    public int[] countElements(int a[], int b[], int n, int query[], int q)
    {
        int[] indexes = new int[q];
        int outIndex = 0;
        for(int index: query)
        {
            int checkNumber = a[index], countOfNumGreaterThenIndex = 0;

            for(int bNum: b)
            {
                if(checkNumber >= bNum)
                {
                    countOfNumGreaterThenIndex++;
                }
            }
            indexes[outIndex] = countOfNumGreaterThenIndex;
            outIndex++;
        }
        return indexes;
    }

    public ArrayList<Integer> findGreater(int[] arr) {
        ArrayList<Integer> resultOfRightGreater = new ArrayList<>();
        int n = arr.length;
        Map<Integer, Integer> numWithFrequency = new HashMap<>();

        for (int num : arr) {
            numWithFrequency.put(num, numWithFrequency.getOrDefault(num, 0) + 1);
        }
        Stack<Integer> numberFrequencyOrder = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {

            while (!numberFrequencyOrder.isEmpty() && numWithFrequency.get(numberFrequencyOrder.peek()) <= numWithFrequency.get(arr[i]))
            {
                numberFrequencyOrder.pop();
            }

            if (numberFrequencyOrder.isEmpty()) {
                resultOfRightGreater.add(-1);
            } else {
                resultOfRightGreater.add(numberFrequencyOrder.pop());
            }

            numberFrequencyOrder.add(arr[i]);
        }
        Collections.reverse(resultOfRightGreater);
        return resultOfRightGreater;
    }

    public int findEquilibrium(int arr[]) {
        int n = arr.length;
        int totalSum = 0, leftSum = 0;

        for(int i = 0; i < n; i++)
        {
            totalSum += arr[i];
        }

        for(int i = 0; i < n; i++)
        {
            int currentSum = totalSum - leftSum - arr[i];

            if(leftSum == currentSum)
            {
                return i;
            }

            leftSum += arr[i];
        }

        return -1;
    }

    public void immediateSmaller(int arr[]) {
        Stack<Integer> smallerElementStack = new Stack<>();
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--)
        {
            while (!smallerElementStack.isEmpty() && smallerElementStack.peek() >= arr[i])
            {
                smallerElementStack.pop();
            }
            int currentNumber = arr[i];

            if(smallerElementStack.isEmpty())
            {
                arr[i] = -1;
            }
            else
            {
                arr[i] = smallerElementStack.pop();
            }
            smallerElementStack.add(currentNumber);
        }
    }

    public static void printLevelOrder(ArrayList<ArrayList<Integer>> result) {
        for (ArrayList<Integer> level : result) {
            System.out.println(level);
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> levelOrderNodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);

        while (!queue.isEmpty())
        {
            int currentLevelSize = queue.size();
            ArrayList<Integer> currentLevelNodes = new ArrayList<>();
            while (currentLevelSize-- > 0)
            {
                TreeNode currentNode = queue.poll();
                if(currentNode != null)
                {
                    currentLevelNodes.add(currentNode.val);
                    if(currentNode.left != null)
                    {
                        queue.add(currentNode.left);
                    }

                    if(currentNode.right != null)
                    {
                        queue.add(currentNode.right);
                    }
                }
            }
            levelOrderNodes.add(currentLevelNodes);
        }
        return levelOrderNodes;
    }

    public int solve(List<Integer> A, int B) {
        int n = A.size();
        int nosLessThanB = 0;

        // Count how many elements are ≤ B
        for (int i = 0; i < n; i++) {
            if (A.get(i) <= B) {
                nosLessThanB++;
            }
        }

        // Count unwanted elements ( > B ) in the first window
        int unwantedElements = 0;
        for (int i = 0; i < nosLessThanB; i++) {
            if (A.get(i) > B) {
                unwantedElements++;
            }
        }

        int minSwaps = unwantedElements;

        // Slide the window across the array
        for (int i = 0, j = nosLessThanB; j < n; i++, j++) {
            if (A.get(i) > B) {
                unwantedElements--;          // element leaving window
            }
            if (A.get(j) > B) {
                unwantedElements++;          // element entering window
            }
            minSwaps = Math.min(minSwaps, unwantedElements);
        }

        return minSwaps;
    }

    public String longestCommonPrefix(ArrayList<String> A) {

        int n = A.size();
        if( n < 1)
        {
            return "";
        }
        String previous = A.get(0);
        String commonPrefix = "";
        for(int i = 1; i < n; i++)
        {
            String current = A.get(i);
            int j = 0;
            while(j < previous.length() && j < current.length() && previous.charAt(j) == current.charAt(j))
            {
                j++;
            }
            commonPrefix = current.substring(0, j);
            previous = current;
        }

        return commonPrefix;
    }

    String ToggleCase(String str)
    {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = str.toCharArray();
        for(char ch : chars)
        {
            if(ch >= 'a' && ch <= 'z')
            {
                stringBuilder.append(Character.toUpperCase(ch));
            }
            else
            {
                stringBuilder.append(Character.toLowerCase(ch));
            }
        }
        return  stringBuilder.toString();
    }


    int peakElement(int[] arr) {
        int left = 0, n = arr.length - 1, mid = 0, right = n;

        while (left <= right)
        {
            mid = left + (right - left) / 2;

            if((mid - 1 < 0 || arr[mid] > arr[mid - 1]) && (mid + 1 >= n || arr[mid] > arr[mid + 1]))
            {
                return mid;
            }

            if(mid > 0 &&  arr[mid] > arr[mid - 1])
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }

        }

        return -1;
    }
    public int countWords(String list[], int n) {
        // code here
        Map<String, Integer> stringWithFrequencyCount = new HashMap<>();

        for (String str :list)
        {
            stringWithFrequencyCount.put(str, stringWithFrequencyCount.getOrDefault(str, 0) + 1);
        }
        return (int)stringWithFrequencyCount.entrySet().stream().filter(str1 -> str1.getValue() == 2).count();
    }

    public static boolean isFrequencyUnique(int n, int[] arr) {
        // code here

        Map<Integer, Integer> mapWithFrequency = new HashMap<>();
        for(int num : arr) {
            mapWithFrequency.put(num, mapWithFrequency.getOrDefault(num, 0) + 1);
        }

        HashSet<Integer> frequencies = new HashSet<>();

        for(Integer frequency: mapWithFrequency.values())
        {
            if(frequencies.contains(frequency))
            {
                return false;
            }
            else
            {
                frequencies.add(frequency);
            }
        }

        return true;
    }

    int KthMissingElement(int arr[], int k)
    {
        for (int i = 0; i < arr.length - 1; i++) {
            int missingBetween = arr[i + 1] - arr[i] - 1;
            if (missingBetween >= k) {
                return arr[i] + k;
            }
            k -= missingBetween;
        }

        return arr[arr.length - 1] + k;
    }

    int KthMissingElement1(int arr[], int k) {
        // Complete the function
        int max  = java.util.Arrays.stream(arr).max().getAsInt(), n = arr.length;

        int[] frequencyArray = new int[max+1];

        for(int i = 0; i < n; i++)
        {
            frequencyArray[arr[i]]++;
        }

        int j = 0, missingKthNumber = 1;

        for(int i = 1; i <= max; i++)
        {
            if(frequencyArray[i] == 0)
            {
                j++;
            }

            if(j == k)
            {
                missingKthNumber = i;
                break;
            }
        }

        return missingKthNumber;
    }

    String firstRepChar(String s) {
        // code here
        Set<Character> characters = new HashSet<>();
        for(Character ch: s.toCharArray())
        {
            if(characters.contains(ch))
            {
                return ch.toString();
            }
            else
            {
                characters.add(ch);
            }
        }

        return "-1";
    }

    public boolean findPairs(int arr[]) {
        int n = arr.length;
        Map<Integer, int[]> pairSum =new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int currentSum = arr[i] + arr[j];
                if(pairSum.containsKey(currentSum))
                {
                    int[] pair = pairSum.get(currentSum);
                    if(pair[0] != i && pair[0] != j && pair[1] != i && pair[1] != j)
                    {
                        return true;
                    }
                }
                else
                {
                    pairSum.put(currentSum, new int[]{i , j});
                }
            }
        }

        return false;
    }

    int equalSum(int[] arr) {
        int n = arr.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        leftSum[0] = arr[0];
        for(int i = 1; i < n; i++)
        {
            leftSum[i] = leftSum[i - 1] + arr[i];
        }

        rightSum[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--)
        {
            rightSum[i] = rightSum[i + 1] + arr[i];
        }

        for(int i = 0; i < n; i++)
        {
            if(leftSum[i] == rightSum[i])
            {
                return i;
            }
        }

        return -1;
    }

    public pair indexes(long v[], long x) {

        int leftMostIndex = findDirectedIndex(v, x, true);
        int rightMostIndex = findDirectedIndex(v, x, false);
        if(leftMostIndex >= 0 && leftMostIndex < v.length && rightMostIndex >= 0 && rightMostIndex < v.length && v[leftMostIndex] == x && v[rightMostIndex] == x)
        {
            return new pair(leftMostIndex, rightMostIndex);
        }
        return new pair(-1, -1);
    }

    int findDirectedIndex(long[] v, long x, boolean isLeftMost)
    {
        int left = 0, n = v.length, right = n - 1, mid  = 0;

        while(left <= right)
        {
            mid  = left + (right - left) / 2;
            if(v[mid] == x)
            {
                if(isLeftMost)
                {
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }
            else if(x < v[mid])
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }

        return isLeftMost ? left : right;
    }



    public static void convertToWave(int[] arr) {

       for(int i = 0; i < arr.length; i+=2)
       {
           int j = i + 1;
           if(j < arr.length)
           {
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
           }
       }
    }

    boolean isSumTree(Node root) {

        if(root == null || isLeaf(root)) return true;

        if(isSumTree(root.left) && isSumTree(root.right))
        {
            int leftSum = treeSum(root.left);
            int rightSum = treeSum(root.right);
            return leftSum + rightSum  == root.data;
        }
        return false;
    }

    int treeSum(Node node)
    {
        if(node == null)
            return 0;
        if(isLeaf(node))
            return node.data;

        int leftSum = treeSum(node.left);
        int rightSum = treeSum(node.right);

        return node.data + leftSum + rightSum;
    }

    boolean isLeaf(Node node)
    {
        return node != null && node.left == null && node.right == null;
    }

    ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> leftViewOfElement = new ArrayList<>();
        Queue<Node> queueOfNode = new LinkedList<>();
        queueOfNode.add(root);

        while (!queueOfNode.isEmpty())
        {
            int lengthOfCurrentLevel = queueOfNode.size();
            leftViewOfElement.add(queueOfNode.peek().data);
            while (lengthOfCurrentLevel-- > 0)
            {
                Node currentNode = queueOfNode.poll();
                if(currentNode.left != null)
                {
                    queueOfNode.add(currentNode.left);
                }

                if(currentNode.right != null)
                {
                    queueOfNode.add(currentNode.right);
                }
            }
        }
        return leftViewOfElement;
    }


    ArrayList<Integer> boundaryTraversal(Node node) {
        if(node == null) return null;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(node.data);
        if(node.left == null && node.right == null)
        {
            return result;
        }
        addLeftMostNode(node.left, result);
        addLeaves(node, result);
        addRightMostNode(node.right, result);
        return result;
    }

    void addLeftMostNode(Node node, ArrayList<Integer> result)
    {
        if(node == null)
            return;
        if(node.left != null || node.right != null)
        {
            result.add(node.data);
        }

        if(node.left != null)
        {
            addLeftMostNode(node.left, result);
        }
        else if(node.right != null)
        {
            addLeftMostNode(node.right, result);
        }
    }

    void addLeaves(Node node, ArrayList<Integer> result)
    {
        if(node == null)
            return;
        if(node.left == null && node.right == null)
            result.add(node.data);

            addLeaves(node.left, result);
            addLeaves(node.right, result);
    }

    void addRightMostNode(Node node, ArrayList<Integer> result)
    {
        Stack<Integer> stack = new Stack<>();

        while(node != null)
        {

            if(node.left != null || node.right != null)
            {
                stack.add(node.data);
            }

            if(node.right != null)
            {
                node = node.right;
            }
            else
            {
                node = node.left;
            }
        }

        while (!stack.isEmpty())
        {
            result.add(stack.pop());
        }
    }

    void boundaryTraversalHelper(Node node, ArrayList<Integer> result, boolean leftmost, boolean rightmost)
    {

        if(node == null) return;

        if ((node.left == null && node.right == null) || leftmost)
            result.add(node.data);

        if(node.left != null)
        {
            boundaryTraversalHelper(node.left, result, leftmost, false);
        }

        if(node.right != null)
        {
            boundaryTraversalHelper(node.right, result, false, rightmost);
            if(rightmost)
            {
                result.add(node.data);
            }
        }
    }

    public static int kthSmallest(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k -1];
    }

    int missingNum1(int[] arr) {
        int n = arr.length + 1;
        long expectedSum = n * (n + 1)/ 2;
        long actualSum = 0;
        for(int inputNumber: arr)
        {
            actualSum = (actualSum + inputNumber) % 1000000009;
        }

        return (int)(expectedSum - actualSum);
    }

//    Input: arr[] = [1, 2, 3, 5]
//    Output: 4
//    Input: arr[] = [8, 2, 4, 5, 3, 7, 1]
//    Output: 6
    int missingNum(int[] arr) {
        int max = java.util.Arrays.stream(arr).max().getAsInt();
        int i;
        int[] countOfOrder = new int[max+1];
        for(int num : arr)
        {
            countOfOrder[num]++;
        }

        for(i = 1; i <= max; i++)
        {
            if(countOfOrder[i] == 0)
            {
                break;
            }
        }

        return i;
    }



    // arr[] = [1, 2, 3, 7, 5], target = 12
    // arr[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], target = 15
    ArrayList<Integer> subarraySum(int[] arr, int target) {
        int left = 0, n = arr.length, totalSum = 0;

        for(int i = 0; i < n; i++)
        {
            totalSum += arr[i];

            if(totalSum > target)
            {
                totalSum -= arr[left];
                left++;
            }

            if(totalSum == target)
            {
                return new ArrayList<>(List.of(left+ 1, i+1));
            }
        }

        return new ArrayList<>(List.of(-1));
    }

    public boolean isSymmetric1(TreeNode root) {
        return isMirror(root, root);
    }

    boolean isMirror(TreeNode root1, TreeNode root2)
    {
        if(root1 != null && root2 != null)
            return true;

        if(root1 != null || root2 != null)
            return false;

        return root1.val == root2.val && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i < n; i++)
        {
            prefixSum[i] = nums[i] + prefixSum[i - 1];
        }

        int left = 0, mid = 0, right = n -1, start = -1;

        while(left <= right)
        {
            mid = left + (right - left) / 2;

            if(prefixSum[n-1] - prefixSum[mid] >= target)
            {
                left = mid + 1;
                start = left;
            }
            else
            {
                right = mid - 1;
            }
        }

        return start != -1 ? n - start : 0;
    }

    public int searchInsert(int[] nums, int target) {
        int mid = 0, left = 0, n = nums.length, right = n - 1;
        while(left <= right)
        {
            mid = left + (right - left) / 2;

            if(nums[mid] == target)
            {
                return mid;
            }
            else if(nums[mid] < target)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        return left;
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }


        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public boolean isPalindrome(int x) {

        if(x < 0 || ( x % 10 == 0 && x == 0))
            return false;

        int reversed = 0;
        while (x > reversed)
        {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return reversed == x || reversed/10 == x;
    }

    public String convert(String s, int numRows) {
        StringBuilder[] rows = new StringBuilder[numRows];

        for(int i = 0; i < numRows; i++)
        {
            rows[i] = new StringBuilder();
        }

        int currentLevel = 0;
        boolean downwardTraversal = false;

        for(char c : s.toCharArray())
        {
            rows[currentLevel].append(c);
            if(currentLevel == 0 || currentLevel == numRows - 1)
            {
                downwardTraversal = !downwardTraversal;
            }

            currentLevel = downwardTraversal ? currentLevel + 1 : currentLevel - 1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row: rows)
        {
            result.append(row);
        }

        return result.toString();
    }

    //1, 2, 1, 3, 4, 3
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> frequencyOfElements = new HashMap<>();
        ArrayList<Integer> result  = new ArrayList<>();
        int i = 0, j = B;
        for(i = 0; i < B; i++)
        {
            frequencyOfElements.put(A.get(i), frequencyOfElements.getOrDefault(A.get(i), 0) + 1);
        }

        result.add(frequencyOfElements.size());
        i = 0;
        while(j < A.size()) {
            int ithElement = A.get(i);
            frequencyOfElements.put(ithElement, frequencyOfElements.getOrDefault(ithElement, 0) - 1);
            if (frequencyOfElements.get(ithElement) == 0) {
                frequencyOfElements.remove(ithElement);
            }

            int jthElement = A.get(j);
            frequencyOfElements.put(jthElement, frequencyOfElements.getOrDefault(jthElement, 0) + 1);

            result.add(frequencyOfElements.size());
            i++;
            j++;
        }

        return result;
    }

    int previousSum = 0;
    public int addDigits(int num) {
        if(num <= 9)
        {
            return num;
        }
        int sumOfDigit = sumOfDigits(num);

        return addDigits(sumOfDigit);
    }

    public int sumOfDigits(int num) {
        if(num <= 9)
            return num;
        return  num % 10 + sumOfDigits(num / 10);
    }

//    Example 1:
//    Input: nums = [1,2,3,4]
//    Output: [24,12,8,6]
//    Example 2:
//    Input: nums = [-1,1,0,-3,3]
//    Output: [0,0,9,0,0]
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProduct = new int[n];
        prefixProduct[0] = 1;

        for(int i = 1; i < nums.length; i++)
        {
            prefixProduct[i] =  nums[i - 1] * prefixProduct[i - 1];
        }

        int suffix = 1;
        for(int i = n - 1; i >= 0; i--)
        {
            prefixProduct[i] = prefixProduct[i] * suffix;
            suffix *= nums[i];
        }

        return prefixProduct;
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numsSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++)
        {
            if(numsSet.contains(nums[i]))
            {
                return true;
            }
            else
            {
                numsSet.add(nums[i]);
            }
        }
        return false;
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> charStack = new Stack<>();
        for(int i = 0; i < s.length(); i++)
        {
            if(!charStack.isEmpty() && ((chars[i] == ')' && charStack.peek() == '(') || (chars[i] == '}' && charStack.peek() == '{')|| (chars[i] == ']' && charStack.peek() == '[')))
            {
                charStack.pop();
            }
            else
            {
                charStack.push(chars[i]);
            }
        }
        return charStack.isEmpty();
    }

    public int majorityElement1(int[] nums) {

        int majorityElement = nums[0], countOfMajorityElement = 1;

        for(int i = 1; i < nums.length; i++)
        {
            if(countOfMajorityElement == 0)
            {
                majorityElement = nums[i];
                countOfMajorityElement++;
            }
            else
            if(majorityElement == nums[i])
            {
                countOfMajorityElement++;
            }
            else
            {
                countOfMajorityElement--;
            }
        }

        countOfMajorityElement = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == majorityElement)
            {
                countOfMajorityElement++;
            }
        }

        if(countOfMajorityElement >= nums.length / 2)
        {
            return majorityElement;
        }

        return 0;
    }

     int climbStairs1(int n) {
        int a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }

//    TreeNode root = new TreeNode(1);
//
//    root.left = new TreeNode(2);
//    root.right = new TreeNode(2);
//
//    root.left.left = new TreeNode(3);
//    root.left.right = new TreeNode(4);
//
//    root.right.left = new TreeNode(3);
//    root.right.right = new TreeNode(4);
    public boolean isSymmetric(TreeNode root) {
        if(root == null || root.left == null && root.right == null)
            return  true;

        if(root.left == null || root.right == null)
            return false;

        return root.left.val == root.right.val && isSymmetric(root.left) && isSymmetric(root.right);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> coursesWithMappings = new HashMap<>();

        for(int i = 0; i < prerequisites.length; i++)
        {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];

            if(!coursesWithMappings.containsKey(from))
            {
                coursesWithMappings.put(from, new ArrayList<>());
            }

            coursesWithMappings.get(from).add(to);
        }

        boolean[] visited = new boolean[numCourses];
        DFS(0, coursesWithMappings, visited);
        return visited[numCourses - 1];
    }

    void DFS(int num, Map<Integer, ArrayList<Integer>> coursesWithMappings, boolean[] visited)
    {
        visited[num] = true;
        if(coursesWithMappings.containsKey(num))
        {
            for (int neighbour : coursesWithMappings.get(num))
            {
                DFS(neighbour, coursesWithMappings, visited);
            }
        }
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        int[][] uniquePaths = new int[m][n];

        for (int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] != 1)
                uniquePaths[i][0] = 1;
            else
                break;
        }

        for (int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] != 1)
                uniquePaths[0][i] = 1;
            else
                break;
        }

        if(n == 1 && m == 1)
        {
            return obstacleGrid[0][0] == 0 ? 1 : 0;
        }
        else
        if(m == 1)
            return uniquePaths[0][n-1];
        else
        if(n == 1)
            return uniquePaths[m-1][0];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] != 1)
                {
                    uniquePaths[i][j] = uniquePaths[i - 1][j] + uniquePaths[i][j - 1];
                }
            }
        }

        return uniquePaths[m-1][n - 1];
    }

    public int uniquePaths(int m, int n) {
        int[][] uniquePaths = new int[m][n];

        for (int i = 0; i < m; i++) {
            uniquePaths[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            uniquePaths[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                uniquePaths[i][j] = uniquePaths[i - 1][j] + uniquePaths[i][j - 1];
            }
        }

        return uniquePaths[m-1][n - 1];
    }


    public long minimizeSystemCost(int k, List<Integer> machines) {
        int n = machines.size();

        if (n - k <= 1) {
            return 0;
        }

        long[] prefix_cost = new long[n];
        prefix_cost[0] = 0;
        for (int i = 1; i < n; i++) {
            prefix_cost[i] = prefix_cost[i-1] + Math.abs((long)machines.get(i) - machines.get(i-1));
        }

        long min_cost = Long.MAX_VALUE;

        for (int start_index = 0; start_index <= n - k; start_index++) {
            long current_remaining_cost = 0;

            if (start_index > 0) {
                current_remaining_cost += prefix_cost[start_index - 1];
            }

            if (start_index + k < n) {
                current_remaining_cost += (prefix_cost[n-1] - prefix_cost[start_index + k]);
            }

            if (start_index > 0 && start_index + k < n) {
                current_remaining_cost += Math.abs((long)machines.get(start_index + k) - machines.get(start_index - 1));
            }

            min_cost = Math.min(min_cost, current_remaining_cost);
        }

        return min_cost;
    }

    int findTime5(String genome, char mutation)
    {
        if(genome == null || genome.isEmpty())
        {
            return 0;
        }
        char[] genomeCharArray = genome.toCharArray();
        int time = 0;
        Queue<MutatedCharWithIndices> mutatedCharWithIndices = new LinkedList<>();

        for(int i = 0; i < genome.length(); i++)
        {
            char character = genomeCharArray[i];
            if(character == mutation)
            {
                mutatedCharWithIndices.add(new MutatedCharWithIndices(character, i));
            }
        }

        while (!mutatedCharWithIndices.isEmpty())
        {
            int sizeOfMutatedSize = mutatedCharWithIndices.size();

            while (sizeOfMutatedSize-- > 0)
            {
                MutatedCharWithIndices mutatedCharWithIndices1 = mutatedCharWithIndices.poll();

                mutatedCharWithIndices.add(new MutatedCharWithIndices(mutatedCharWithIndices1.getCharacter(), mutatedCharWithIndices1.getIndex()));
            }

            time--;
        }

        return time;
    }

    public static int findTime4(String genome, char mutation) {
        if (genome == null || genome.isEmpty()) {
            return 0;
        }

        ArrayList<Character> genomeList = new ArrayList<>();
        for (char c : genome.toCharArray()) {
            genomeList.add(c);
        }

        int time = 0;

        while (true) {
            Set<Integer> indicesToRemove = new HashSet<>();
            boolean removalsMadeInThisTurn = false;
            for (int i = 0; i < genomeList.size(); i++) {
                if (genomeList.get(i) == mutation) {
                    if (i > 0) {
                        indicesToRemove.add(i - 1);
                        removalsMadeInThisTurn = true;
                    }
                }
            }

            if (!removalsMadeInThisTurn) {
                break;
            }
            time++;

            ArrayList<Character> newGenomeList = new ArrayList<>();
            for (int i = 0; i < genomeList.size(); i++) {
                if (!indicesToRemove.contains(i)) {
                    newGenomeList.add(genomeList.get(i));
                }
            }
            genomeList = newGenomeList;
        }

        return time;
    }

    public static int findTime(String genome, char mutation) {
        int time = 0;

        while (true) {
            Deque<Character> stack = new ArrayDeque<>();
            boolean changed = false;

            for (int i = 0; i < genome.length(); i++) {
                char current = genome.charAt(i);

                if (current == mutation && !stack.isEmpty()) {
                    stack.pollLast(); // Remove left neighbor
                    changed = true;
                } else {
                    stack.addLast(current);
                }
            }

            if (!changed) break;

            // Build genome for next round
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            genome = sb.toString();
            time++;
        }

        return time;
    }

    public static int findTime3(String genome, char mutation) {
        if (genome == null || genome.isEmpty()) {
            return 0;
        }

        char[] currentGenomeChars = genome.toCharArray();
        int currentLength = currentGenomeChars.length;

        int time = 0;

        while (true) {
            Set<Integer> indicesToRemove = new HashSet<>();
            boolean removalsMadeInThisTurn = false;

            for (int i = 0; i < currentLength; i++) {
                if (currentGenomeChars[i] == mutation) {
                    if (i > 0) {
                        indicesToRemove.add(i - 1);
                        removalsMadeInThisTurn = true;
                    }
                }
            }

            if (!removalsMadeInThisTurn) {
                break;
            }

            time++;


            char[] nextGenomeChars = new char[currentLength];
            int nextLength = 0;

            for (int i = 0; i < currentLength; i++) {
                if (!indicesToRemove.contains(i)) {
                    nextGenomeChars[nextLength++] = currentGenomeChars[i];
                }
            }

            currentGenomeChars = nextGenomeChars;
            currentLength = nextLength;
        }

        return time;
    }

    public static int findTime1(String genome, char mutation) {
        if (genome == null || genome.isEmpty()) {
            return 0;
        }

        char[] currentGenomeChars = genome.toCharArray();
        int currentLength = currentGenomeChars.length;

        int time = 0;

        while (true) {
            Set<Integer> indicesToRemove = new HashSet<>();
            boolean removalsMadeInThisTurn = false;

            for (int i = 0; i < currentLength; i++) {
                if (currentGenomeChars[i] == mutation) {
                    if (i > 0) {
                        indicesToRemove.add(i - 1);
                        removalsMadeInThisTurn = true;
                    }
                }
            }

            if (!removalsMadeInThisTurn) {
                break;
            }

            time++;
            char[] nextGenomeChars = new char[currentLength];
            int nextLength = 0;

            for (int i = 0; i < currentLength; i++) {
                if (!indicesToRemove.contains(i)) {
                    nextGenomeChars[nextLength++] = currentGenomeChars[i];
                }
            }

            currentGenomeChars = nextGenomeChars;
            currentLength = nextLength;
        }

        return time;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null || p == root || q == root){
                return root;
            }

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p , q);

            if(left == null)
                return right;
            else if(right == null)
                return left;
            else
                return root;
    }

    public int[] AsteroidCollision(int[] asteroids) {

        Stack<Integer> asteroidStack = new Stack<>();

        asteroidStack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            int currentAsteroid = asteroids[i];

            if (currentAsteroid > 0) {
                asteroidStack.push(currentAsteroid);
            }
            else
            {
                while (!asteroidStack.isEmpty() && asteroidStack.peek() > 0 && currentAsteroid < 0 && asteroidStack.peek() < Math.abs(currentAsteroid)) {
                    asteroidStack.pop();
                }

                if(!asteroidStack.isEmpty() && asteroidStack.peek() == Math.abs(currentAsteroid))
                {
                    asteroidStack.pop();
                }
                else if(asteroidStack.isEmpty() || asteroidStack.peek() < 0)
                {
                    asteroidStack.push(currentAsteroid);
                }
            }
        }

        return asteroidStack.stream().mapToInt(Integer::intValue).toArray();
    }

//    Example 1:
//
//    Input: nums = [10,9,2,5,3,7,101,18]
//    Output: 4
//    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
//    Example 2:
//
//    Input: nums = [0,1,0,3,2,3]
//    Output: 4
//    Example 3:
//
//    Input: nums = [7,7,7,7,7,7,7]
//    Output: 1
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, maxlength = 0, start = 0, end = 1;

        while (start < end && start < n && end < n)
        {
            if(nums[start] > nums[end])
            {
                maxlength = Math.max(0 , maxlength - 1);
                start++;
            }
            else
            if(nums[start] < nums[end]) {
                if(nums[end - 1] < nums[end])
                {
                    maxlength = maxlength + 1;
                }
                else
                {
                    start = end;
                }
            }
            end++;
        }
        return maxlength + 1;
    }

    public int maxProfit(int[] prices) {

        int n = prices.length, maxProfit = 0;

        int[] minDp = new int[n];

        minDp[0] = prices[0];

        for(int i = 1; i < n; i++)
        {
            int minNum = Math.min(minDp[i -1], prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minNum);
            minDp[i] = minNum;
        }
//        for(int i = 0; i < n; i++)
//        {
//            int distance = Integer.MIN_VALUE;
//            for(int j = i + 1; j < n; j++)
//            {
//                distance = prices[j] - prices[i];
//                maxProfit = Math.max(maxProfit, distance);
//            }
//        }



        return maxProfit;
    }

    public int solve(String A) {
        return palindromeHelper(A.toCharArray(), 0, A.length() - 1) ? 1 : 0;
    }

    boolean palindromeHelper(char[] inputChar, int start, int end)
    {
        if(start >= end )
        {
            return true;
        }

        if(inputChar[start] == inputChar[end] && palindromeHelper(inputChar, start + 1, end - 1))
        {
            return true;
        }

        return false;
    }

    public int sumOfItDigits(int A) {
        if(A <= 0)
            return 0;

        return A%10 + sumOfItDigits(A/10);
    }

    public int majorityElement(int[] A) {
        int majorityElement = A[0], majorityNumCount = 1;

        for(int i = 1; i < A.length; i++)
        {
            if(A[i] == majorityElement)
            {
                majorityNumCount++;
            }
            else
            {
                if(majorityNumCount == 0)
                {
                    majorityElement = A[i];
                }
                else
                {
                    majorityNumCount--;
                }
            }
        }

        return majorityElement;
    }

    public ArrayList<Integer> leaders(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = A.size(), rightMostGreaterElement = A.get(n - 1);
        result.add(rightMostGreaterElement);

        for(int i = n -2; i >= 0; i--)
        {
            int currentElement = A.get(i);
            if(currentElement > rightMostGreaterElement)
            {
                rightMostGreaterElement = currentElement;
                result.add(currentElement);
            }
        }

        return result;
    }

    public int maxProfit(final List<Integer> A) {
        int maxProfit = 0, minPrice = A.get(0);

        for(int i = 1; i < A.size(); i++)
        {
            minPrice = Math.min(minPrice, A.get(i));

            maxProfit = Math.max(maxProfit, A.get(i) - minPrice);
        }

        return maxProfit;
    }

    public int closeMinMax(ArrayList<Integer> A) {
        int n = A.size(), min = Integer.MAX_VALUE, max = Integer.MIN_VALUE,
        lastMinIndex = -1, lastMaxIndex = -1, closeMinMaxLength = Integer.MAX_VALUE;

        for (Integer integer : A) {
            if (integer < min)
                min = integer;

            if (integer > max)
                max = integer;
        }

        for(int i = 0; i < n; i++)
        {
            int currentElement = A.get(i);

            if(currentElement == min)
            {
                lastMinIndex = i;
                if(lastMaxIndex != -1)
                {
                    closeMinMaxLength = Math.min(closeMinMaxLength, i - lastMaxIndex + 1);
                }
            }

            if(currentElement == max)
            {
                lastMaxIndex = i;
                if(lastMinIndex != -1)
                {
                    closeMinMaxLength = Math.min(closeMinMaxLength, i - lastMinIndex + 1);
                }
            }
        }

        return closeMinMaxLength;
    }

    public String convert1(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> inOrderTraversalNodes = new ArrayList<>();
        inorderHelper(root, inOrderTraversalNodes);
        return inOrderTraversalNodes;
    }

    void inorderHelper(TreeNode root, ArrayList<Integer> inOrderTraversalNodes)
    {
        if(root == null)
        {
            return;
        }

        inorderHelper(root.left, inOrderTraversalNodes);
        inOrderTraversalNodes.add(root.val);
        inorderHelper(root.right, inOrderTraversalNodes);
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> charWithCount = new LinkedHashMap<>();

        for (Character character: s.toCharArray())
        {
            charWithCount.put(character, charWithCount.getOrDefault(character, 0) + 1);
        }

        return charWithCount.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().get().getKey();
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;

        while (i < m && j < n && k < m)
        {
            if(nums1[i] <= nums2[j])
            {
                nums1[k++] = nums1[i++];
            }
            else
            {
                nums1[k++] = nums2[j++];
            }
        }

        while (i < m && k < m + n)
        {
            nums1[k++] = nums1[i++];
        }

        while (j < n && k < n + m)
        {
            nums1[k++] = nums2[j++];
        }

    }

    ListNode deleteDuplicates(ListNode head) {
        ListNode withoutDuplicates = new ListNode(-1);
        ListNode traversalNode = withoutDuplicates;

        while (head != null)
        {
            while (head.next != null && head.val == head.next.val)
            {
                head = head.next;
            }

            traversalNode.next = new ListNode(head.val);
            traversalNode = traversalNode.next;
            head = head.next;
        }

        return withoutDuplicates.next;
    }

    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(); // for newline after printing list
    }

    public void bitwise()
    {
        BitSet bitSet = new BitSet();

        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(3);
        bitSet.flip(2);
    }
    public int hasPathSum(TreeNode A, int B) {
        return hasSumHelper(A, B) ? 1 : 0;
    }

    boolean hasSumHelper(TreeNode A, int B)
    {
        if(A == null)
            return false;

        if(A.left == null && A.right == null)
            return A.val == B;

        boolean hasLeftSum = hasSumHelper(A.left, B - A.val);
        boolean hasRightSum = hasSumHelper(A.right, B - A.val);

        return hasLeftSum || hasRightSum;
    }

    public int isValidBST(TreeNode A) {
        return validBSTHelper(A) ? 1 : 0;
    }
    int prev = Integer.MIN_VALUE;
    boolean validBSTHelper(TreeNode A)
    {
        if(A == null)
            return true;
        if(!validBSTHelper(A.left))
            return false;

        if(A.val <= prev)
            return false;

        prev = A.val;

        return validBSTHelper(A.right);
    }

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer, Integer> inOrderElementWithIndex = new HashMap<>();
        for(int i = 0; i < A.size(); i++)
        {
            inOrderElementWithIndex.put(A.get(i), i);
        }
        return buildTreeHelpher(A, B, 0,  0, B.size() - 1,  inOrderElementWithIndex);
    }

    public TreeNode buildTreeHelpher(ArrayList<Integer> A, ArrayList<Integer> B, Integer inStart, Integer preStart, Integer preEnd, Map<Integer, Integer> inOrderElementWithIndex)
    {
        if(preStart > preEnd)
            return null;

        Integer rootElement = B.get(preStart);
        TreeNode root = new TreeNode(rootElement);
        Integer rootIndex = inOrderElementWithIndex.get(rootElement);
        Integer leftSubTreeCount = rootIndex - inStart;

        root.left = buildTreeHelpher(A, B, inStart,  preStart + 1, preStart + leftSubTreeCount, inOrderElementWithIndex);
        root.right = buildTreeHelpher(A, B, rootIndex + 1,  preStart + leftSubTreeCount + 1, preEnd, inOrderElementWithIndex);

        return root;
    }

    public TreeNode buildTree1(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer, Integer> inOrderElementWithIndex = new HashMap<>();
        for(int i = 0; i < A.size(); i++)
        {
            inOrderElementWithIndex.put(A.get(i), i);
        }
        return null;
        //return buildTreeHelpher(A, B, 0, A.size() -1, 0, B.size() - 1, inOrderElementWithIndex);
    }

//    public TreeNode buildTreeHelpher1(ArrayList<Integer> A, ArrayList<Integer> B, Integer inStart, Integer inEnd, Integer postStart, Integer postEnd, Map<Integer, Integer> inOrderElementWithIndex)
//    {
//        if(inStart > inEnd || postStart > postEnd)
//            return null;
//
//        Integer rootElement = B.get(postEnd);
//        TreeNode root = new TreeNode(rootElement);
//        Integer rootIndex = inOrderElementWithIndex.get(rootElement);
//        Integer leftSubTreeCount = rootIndex - inStart;
//
//        root.left = buildTreeHelpher(A, B, inStart, rootIndex - 1, postStart, postStart + leftSubTreeCount - 1, inOrderElementWithIndex);
//        root.right = buildTreeHelpher(A, B, rootIndex + 1, inEnd,  postStart + leftSubTreeCount, postEnd - 1, inOrderElementWithIndex);
//
//        return root;
//    }

    public ArrayList<Integer> nIntegers(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int num = 1;
        queue.add(num);
        result.add(num);
        if(num == A)
            return result;
        num++;

        queue.add(num);
        result.add(num);
        if(num == A)
            return result;
        num++;

        queue.add(num);
        result.add(num);
        if(num == A)
            return result;

        int count = 4;
        while(count <= A)
        {
            num = queue.poll();

            queue.add(num * 10 + 1);
            result.add(num  * 10 + 1);
            if(count == A)
                return result;
            count++;

            queue.add(num  * 10 + 2);
            result.add(num  * 10 + 2);
            if(count == A)
                return result;
            count++;

            queue.add(num  * 10 + 3);
            result.add(num  * 10 + 3);
            if(count == A)
                return result;
            count++;
        }

        return result;
    }

    String perfectNumbers(int A) {
        Queue<String> queue = new LinkedList<>();
        int i = 0;
        queue.add("1");
        queue.add("2");
        while (i <= A) {
            String  num1 = queue.remove();
            i++;

            if(i == A)
                return num1 + new StringBuilder(num1).reverse();

            queue.add(num1 + "1");
            queue.add(num1 + "2");
        }

        return "";
    }

    String reverse(String A)
    {
        StringBuilder stringBuilder = new StringBuilder();
        int n = A.length();
        char[] inputs = A.toCharArray();
        for(int i = n -1; i >= 0; i--)
        {
            stringBuilder.append(inputs[i]);
        }
        return stringBuilder.toString();
    }

    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        Stack<Integer> numStack = new Stack<>();
        ArrayList<Integer> numList = new ArrayList<>();
        for(int i= A.size() - 1; i >= 0; i--)
        {
            Integer num = A.get(i);
            while (!numStack.isEmpty() && num >= numStack.peek())
            {
                numStack.pop();
            }

            if(numStack.isEmpty())
            {
                numList.add(-1);
            }
            else
            {
                numList.add(numStack.peek());
            }

            numStack.push(num);
        }
        ArrayList<Integer> reversed = new ArrayList<>();
        for(int i = numList.size() - 1; i >= 0; i--)
        {
            reversed.add(numList.get(i));
        }
        return numList;
    }

    public synchronized int majorityElement(final List<Integer> a) {
        int n = a.size();
        int majorElement1 = 0, majorElement2 = 0;
        int countOfMajorElement1 = 0, countOfMajorElement2 = 0;
        List<String> names = List.of("Alice", "Bob");

        names.forEach((var name) -> System.out.println(name.toUpperCase()));
        for(Integer num : a)
        {
            synchronized (num) {
                if (majorElement1 == num) {
                    countOfMajorElement1++;
                } else if (majorElement2 == num) {
                    countOfMajorElement2++;
                } else if (countOfMajorElement1 == 0) {
                    majorElement1 = num;
                    countOfMajorElement1++;
                } else if (countOfMajorElement2 == 0) {
                    majorElement2 = num;
                    countOfMajorElement2++;
                } else {
                    countOfMajorElement1--;
                    countOfMajorElement2--;
                }
            }
        }
        countOfMajorElement2 = 0;countOfMajorElement1= 0;
        for(int i = 0; i < n; i++)
        {
            if(a.get(i) == majorElement2){
                countOfMajorElement2++;
            }
            else if (a.get(i) == majorElement1)
            {
                countOfMajorElement1++;
            }
        }

        if(countOfMajorElement1 > (n/3)) return majorElement1;
        if(countOfMajorElement2 > (n/3)) return majorElement2;

        return -1;
    }

    public int lengthOfLongestSubstring(String A) {
        int  start = 0, maxLength = 1;
        HashSet<Character> chars = new HashSet<>();
        for(int i = 0; i < A.length(); i++)
        {
            Character ch = A.charAt(i);
            if(chars.contains(ch))
            {
                chars.remove(A.charAt(start));
                start++;
            }

            chars.add(ch);

            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }

    public ArrayList<Integer>  sortArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer, Integer> numWithCount = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(Integer num : A)
        {
            numWithCount.put(num, numWithCount.getOrDefault(num, 0) + 1);
        }

        for(Integer num : B)
        {
            if(numWithCount.containsKey(num))
            {
                for(int i = 0; i <= numWithCount.get(num); i++)
                {
                    numWithCount.put(num, numWithCount.getOrDefault(num, 0) - 1);
                    result.add(num);
                }
            }
        }

        for(Map.Entry<Integer, Integer> entry : numWithCount.entrySet().stream().filter(map -> map.getValue() > 0).toList())
        {
            if(numWithCount.containsKey(entry.getKey()))
            {
                for(int i = 0; i < numWithCount.get(entry.getKey()); i++)
                {
                    numWithCount.put(entry.getKey(), numWithCount.getOrDefault(entry.getKey(), 0) - 1);
                    result.add(entry.getKey());
                }
            }
        }

        return result;
    }

    public int  shaggyAndDistances(ArrayList<Integer> A) {
        Map<Integer, Integer> numWithIndex = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        for(int i = 0; i < A.size(); i++)
        {
            int currentNum = A.get(i);

            if(numWithIndex.containsKey(currentNum))
            {
                minDistance = Math.min(minDistance, i - numWithIndex.get(currentNum));
            }
            numWithIndex.put(currentNum, i);
        }
        return minDistance == Integer.MAX_VALUE ? 0 : minDistance;
    }

    public int longestSubArraySum(ArrayList<Integer> A) {
       Map<Integer, Integer> sumWithIndex = new HashMap();
       Integer sum = 0, maxLength = 0;

       for (int i = 0; i < A.size(); i++)
       {
           sum += A.get(i);

           if(sum == 0)
           {
               maxLength = i + 1;
           }
           else
           {
               if(sumWithIndex.containsKey(sum))
               {
                   maxLength = Math.max(maxLength, i -sumWithIndex.get(sum));
               }
               else
               {
                   sumWithIndex.put(sum, i);
               }
           }
       }

       return maxLength;
    }

    public int PathDirectedGraph(int A, ArrayList<ArrayList<Integer>> B) {
        Map<Integer, List<Integer>> withVertices = new HashMap<>();

        for(List<Integer> row : B)
        {
            int from = row.get(0);
            int to = row.get(1);

            if(!withVertices.containsKey(from))
            {
                withVertices.put(from, new ArrayList<>());
            }

            withVertices.get(from).add(to);
        }

        int[] visited = new int[A+1];
        Arrays.fill(visited, 0);

        for(Map.Entry<Integer, List<Integer>> row : withVertices.entrySet())
        {
            if(visited[row.getKey()] == 1 && DFS(row.getKey(), withVertices, visited))
            {
                return 1;
            }
        }

        return 0;
    }

    boolean DFS(Integer A, Map<Integer, List<Integer>> withVertices, int[] visited)
    {
        if(visited[A] == 1)
        {
            return true;
        }
        visited[A] = 1;
        if(withVertices.containsKey(A))
        {
            for(Integer vertices : withVertices.get(A))
            {
                if(visited[vertices] != 2 && DFS(vertices, withVertices, visited))
                {
                    return true;
                }
                else
                {
                    visited[vertices] = 2;
                }
            }
        }

        return false;
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int n = A.size();
        int[][] dp = new int[n + 1][C + 1];

        for (int i = 1; i <= n; i++) {
            int value = A.get(i - 1);
            int weight = B.get(i - 1);
            for (int w = 0; w <= C; w++) {
                if (weight <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], value + dp[i - 1][w - weight]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][C];
    }

    public int  LetsParty(int A) {
        int[] dp = new int[A+1];
        dp[1] = 1; dp[0] = 1;

        for(int i = 2; i <= A; i++)
        {
            dp[i] = (dp[i -1] + ((i - 1) * dp[i -2]) % 10003) % 10003;
        }

        return dp[A];
    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int[][] dp = new int[n][m];

        dp[n-1][m -1] = Math.max(1, 1 - A.get(n -1).get(m - 1));

        for(int i = n - 2; i >= 0; i--)
        {
            dp[i][m - 1] = Math.max(1, dp[i + 1][m - 1] - A.get(i).get(m - 1));
        }

        for(int j = m - 2; j >= 0; j--)
        {
            dp[n - 1][j] =  Math.max(1, dp[n - 1][j + 1] - A.get(n - 1).get(j));
        }

        for(int i = n - 2; i >= 0; i--)
        {
            for(int j = m - 2; j >= 0; j--) {
                int minExit = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, minExit - A.get(i).get(j));
            }
        }

        return dp[0][0];
    }


    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {
        int n = A.size(), m = A.get(0).size();
        int[][] dp = new int[n + 1][m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n-1][m -1] = Math.min(1, 1 - A.get(n- 1).get(m - 1));


        for(int i = n - 1; i >= 0; i--)
        {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i -1][j], dp[i][j - 1]) + A.get(i).get(j);
            }
        }

        return dp[n-1][m-1];
    }

    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        int n = A.size(), m = A.get(0).size();
        int[][] dp = new int[n][m];

        dp[0][0] = A.get(0).get(0);
        for(int i = 1 ; i < n; i++)
        {
            dp[i][0] = A.get(i).get(0) + dp[i-1][0];
        }

        for(int i = 1 ; i < m; i++)
        {
            dp[0][i] = A.get(0).get(i) + dp[0][i-1];
        }

        for(int i = 1; i < n; i++)
        {
            for(int j = 1; j < m; j++)
            {
                dp[i][j] = Math.min(dp[i -1][j], dp[i][j -1]) + A.get(i).get(j);
            }
        }

        return dp[n-1][m-1];
    }

    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int n = A.size(), m = A.get(0).size();
        int[][] dp = new int[n][m];
//        if( n== 1 && m==1 && A.get(0).get(0) == 1)
//            return 0;
//        if(n == 1 || m == 1)
//            return 0;

        for(int i = 0; i < n; i++)
        {
            if(A.get(i).get(0) == 0)
            {
                dp[i][0] = 1;
            }
            else
            {
                break;
            }

        }

        for(int i = 0; i < m; i++)
        {
            if(A.get(0).get(i) == 0)
            {
                dp[0][i] = 1;
            }
            else
            {
                break;
            }

        }

        for(int i = 1; i < n; i++)
        {
            for(int j = 1; j < m; j++)
            {
                if(A.get(i).get(j) == 0)
                {
                    dp[i][j] = dp[i - 1][j] + dp[i][j -1];
                }
            }
        }
        return dp[n-1][m-1];
    }
    public int adjacent(ArrayList<ArrayList<Integer>> A) {

        int n =A.get(0).size();

        int[] maxSum = new int[n];

        for(int i =0; i < n; i++)
        {
            maxSum[i] = Math.max(A.get(0).get(i), A.get(1).get(i));
        }
        if(n == 1) return maxSum[0];
        int[] dp = new int[n];
        dp[0] = maxSum[0]; dp[1] = Math.max(maxSum[0], maxSum[1]);

        for(int i =2; i < n; i++)
        {
            dp[i] = Math.max(dp[i -1], maxSum[i] + dp[i -2]);
        }

        return dp[n - 1];
    }
    public int adjacent12(ArrayList<Integer> A) {
        int maxSum = Integer.MIN_VALUE;
        int[] dp = new int[A.size()];
        dp[0] = A.get(0); dp[1] = A.get(1);

        for (int i = 2; i < A.size(); i++)
        {
            maxSum = Math.max(dp[i -1], A.get(i) + dp[ i -2]);
        }

        return maxSum;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode templist = lists[0];

        for(int i = 1; i < lists.length; i++)
        {
            templist = mergeList(templist, lists[i]);
        }
        return templist;
    }

    public int countMinSquares(int A) {
        int[] dp = new int[A + 1];
        for(int i = 1; i <= A; i++)
        {
            int ans = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++)
            {
                ans = Math.min(ans, dp[i - j* j] + 1);
            }
            dp[i] = ans;
        }

        return dp[A];
    }

    public int climbStairs(int A) {
        if(A == 0 || A == 1) return A;
        int a = 0, b= 1, c = 0, i = 2;
        while (i <= A + 1)
        {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
            i++;
        }

        return c;
    }

    public ArrayList<Integer> spellingChecker(ArrayList<String> A, ArrayList<String> B) {
        ArrayList<Integer> result = new ArrayList<>();

        for(String word: B)
        {
            result.add(A.contains(word) ? 1 : 0);
        }

        return result;
    }

    int majorElement(ArrayList<Integer> A)
    {
        Map<Integer, Integer> numWithCount = new HashMap<>();

        for(Integer num : A)
        {
            numWithCount.put(num, numWithCount.getOrDefault(num, 0) + 1);
        }

        Integer majorelement = numWithCount.entrySet().stream().sorted((a,b) -> b.getValue().compareTo(a.getValue())).findFirst().get().getKey();

        return majorelement;
    }

    ListNode mergeList(ListNode list1, ListNode list2)
    {
        String str  =" fg";
        str.substring(0, 2);

        ListNode result = new ListNode(-1);
        ListNode headOfResult = result;
        while (list1 != null && list2 != null)
        {
            if(list1.val <= list2.val)
            {
                result.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            else
            {
                result.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            result = result.next;
        }

        while(list1 != null)
        {
            result.next = new ListNode(list1.val);
            list1 = list1.next;
            result = result.next;
        }

        while(list2 != null)
        {
            result.next = new ListNode(list2.val);
            list2 = list2.next;
            result = result.next;
        }

        return headOfResult.next;
    }
}


