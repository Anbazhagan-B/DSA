package com.DsaProject.Basic;

import javax.swing.text.html.parser.Entity;
import java.lang.annotation.Inherited;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyArray {

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int n = A.size(), remainder = 1;
        ArrayList<Integer> results = new ArrayList<>();
        for(int i = n -1; i >= 0; i--)
        {
            int addedValue = remainder + A.get(i);
            remainder = addedValue / 10;
            results.add(addedValue % 10);
        }

        if (remainder%10 > 0)
        {
            results.add(remainder % 10);
        }

        ArrayList<Integer> reversedResults = new ArrayList<>();

        for (int i = results.size() -1; i >= 0; i--)
        {
            reversedResults.add(results.get(i));
        }
        return reversedResults;
    }

    public int trap(final List<Integer> A) {
        int n = A.size();
        int[] leftMax = new int[n], rightMax = new int[n];

        leftMax[0] = A.get(0);
        for(int i = 1; i < n; i++)
        {
            leftMax[i] = Math.max(A.get(i), leftMax[i -1]);
        }

        rightMax[n-1] = A.get(n -1);
        for(int i = n-2; i >= 0; i--)
        {
            rightMax[i] = Math.max(rightMax[i + 1], A.get(i));
        }

        int waterTrapped = 0;

        for(int i = 1; i < n; i++)
        {
            waterTrapped += (Math.min(leftMax[i], rightMax[i]) - A.get(i));
        }

        return waterTrapped;
    }

    public static int factorsCount(int A) {
        int factorsCount = 0;

        for (int i = 1; i * i <= A; i++) {
            if (A % i == 0) {
                if (A % i == i) {
                    factorsCount += 1;
                } else {
                    factorsCount += 2;
                }
            }
        }
        return factorsCount;
    }

    public static int goodPair(ArrayList<Integer> A, int B) {
        for(int i = 0; i < A.size();i++)
        {
            for(int j = 0; j < A.size(); j++)
            {
                if(i != j && A.get(i) + A.get(j) == B)
                {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static int sumOfMinMax(ArrayList<Integer> A) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(Integer num : A)
        {
            if(num < min)
            {
                min = num;
            }
            if(num > max)
            {
                max = num;
            }
        }

        return min + max;
    }

    private static void reverseBetweenRange(ArrayList<Integer> A, int B, int C) {
        int left = B, right = C - 1;

        while(left < right)
        {
            int temp = A.get(right);
            A.set(right, A.get(left));
            A.set(left, temp);
            right--;
            left++;
        }
    }

    public static ArrayList<Integer> arrayRotation(ArrayList<Integer> A, int B) {
        if(B > A.size())
        {
            B = B%A.size();
        }
        reverseBetweenRange(A, 0, A.size() - 1);
        reverseBetweenRange(A, 0,B);
        reverseBetweenRange(A, B, A.size() - 1);
        return A;
    }

    public static ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Long> rangeSums = new ArrayList<>();
        ArrayList<Long> prefixSum = new ArrayList<>();

        prefixSum.add(0, Long.valueOf(A.get(0)));
        for(int i = 1; i < A.size(); i++)
        {
            prefixSum.add(i, prefixSum.get(i-1) + A.get(i));
        }

        for (ArrayList<Integer> range : B)
        {
            int from = range.get(0);
            int to = range.get(1);

            if(from == 0)
            {
                rangeSums.add(prefixSum.get(to));
            }
            else
            {
                rangeSums.add(prefixSum.get(to) - prefixSum.get(from - 1));
            }
        }

        return rangeSums;
    }



    public static int specialIndex(ArrayList<Integer> A) {
        ArrayList<Long> evenSums = new ArrayList<>();
        ArrayList<Long> oddSums = new ArrayList<>();

        evenSums.add(Long.valueOf(A.get(0)));
        for(int i = 1; i < A.size(); i++)
        {
            if(i%2==0)
            {
                evenSums.add(evenSums.get(i-1) + A.get(i));
            }
            else
            {
                evenSums.add(evenSums.get(i -1));
            }
        }

        oddSums.add(Long.valueOf(0));
        for(int i = 1; i < A.size(); i++)
        {
            if(i%2!=0)
            {
                oddSums.add(oddSums.get(i-1) + A.get(i));
            }
            else
            {
                oddSums.add(oddSums.get(i -1));
            }
        }

        int specialIndexCount = 0;

        for(int i = 0; i < A.size(); i++)
        {
            Long evenSum = getSum(evenSums,0, i -1) + getSum(oddSums, i + 1, A.size() -1);
            Long oddSum = getSum(oddSums,0, i -1) + getSum(evenSums, i + 1, A.size() -1);

            if(evenSum == oddSum)
            {
                specialIndexCount++;
            }
        }

        return specialIndexCount;
    }

    static Long getSum(ArrayList<Long> prefixArray, int start, int end)
    {
        if(start < 0 || end < 0 ) return 0L;
        if(start == 0) return prefixArray.get(end);
        return  prefixArray.get(end) - prefixArray.get(start - 1);
    }

    public static int ClosestMinMax(ArrayList<Integer> A) {

        if(A == null || A.isEmpty()) return 0;
        int max = Collections.max(A);
        int min = Collections.min(A);

        if(max == min) return 1;

        int lastIdxOfMin = -1;
        int lastIdxOfMax = -1;

        int closestCount = Integer.MAX_VALUE;

        for(int i = 0; i < A.size(); i++)
        {
            if(A.get(i) == min)
            {
                lastIdxOfMin = i;
                if(lastIdxOfMax != -1)
                {
                    closestCount = Math.min(closestCount, lastIdxOfMin - lastIdxOfMax + 1);
                }
            }

            if(A.get(i) == max)
            {
                lastIdxOfMax = i;
                if(lastIdxOfMin != -1)
                {
                    closestCount = Math.min(closestCount, lastIdxOfMax - lastIdxOfMin + 1);
                }
            }
        }

        return closestCount;
    }

    public ArrayList<Integer> subarrayRange(ArrayList<Integer> A, int B, int C) {
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = B; i<= C;i++)
        {
            results.add(A.get(i));
        }
        return results;
    }

    public static ArrayList<ArrayList<Integer>> generateAllSubarrays(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<ArrayList<Integer>> subArrays = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j <= i; j++)
            {
                ArrayList<Integer> row = new ArrayList<>();
                for(int z =j; z <= i; z++)
                {
                    var element = A.get(z);
                    row.add(element);
                }
                subArrays.add(row);
            }
        }
        return subArrays;
    }
    public Long subarraySum(ArrayList<Integer> A) {
        long result = 0;
        int n = A.size();

        for(int i = 0 ; i < n; i++)
        {
            var currentContribution = A.get(i) * (i + 1) * (n - i);
            result = result + currentContribution;
        }
        return result;
    }

    public static int solve(ArrayList<Integer> A, int B, int C) {
        int n = A.size(), sum = 0;

        for(int i = 0; i < B; i++)
        {
            sum += A.get(i);
        }

        if(sum == C)
        {
            return 1;
        }

        for(int i = B; i < n; i++)
        {
            sum -= A.get(i - B);
            sum += A.get(i);
            if(sum == C)
            {
                return 1;
            }
        }

        return 0;
    }

    public int maxSubarray(int A, int B, ArrayList<Integer> C) {
        int result  = 0, sum = 0, start = 0;
        for(int i = 0; i < C.size(); i++)
        {
            sum += C.get(i);

            while (sum > B)
            {
                sum -= C.get(start);
                start++;
            }

            result = Math.max(result, sum);
        }
        return result;
    }

    public static  void main1(String[] args)
    {
        for(ArrayList<Integer> row : generateAllSubarrays(new ArrayList<>(List.of(1, 2, 3))))
        {
            for (Integer elements : row)
            {
                System.out.println( elements);
            }
        }
        System.out.println("elements :" + "\n");
    }

    public int maxSubArray(final List<Integer> A) {

        int n = A.size(),maxSum = Integer.MIN_VALUE, sum = 0;
        for(int i =0; i < n; i++)
        {
            sum += A.get(i);

            if(maxSum < sum)
            {
                maxSum = sum;
            }

            if(sum < 0)
            {
                sum = 0;
            }
        }

        return maxSum;
    }

    public ArrayList<Integer> ContinuousSumQuery(int A, ArrayList<ArrayList<Integer>> B) {
        int[] result = new int[A];
        for(ArrayList<Integer> query : B)
        {
            Integer from = query.get(0) - 1;
            Integer to = query.get(1) - 1;
            result[from] += query.get(2);
            if(to + 1 < A)
            {
                result[to + 1] -= query.get(2);
            }
        }

        for(int i =1; i < A; i++)
        {
            result[i] = result[i -1] + result[i];
        }

        return Arrays.stream(result).boxed().collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<Integer> ColumnSum(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        ArrayList<Integer> columnSums = new ArrayList<>();
        int m = A.get(0).size();

        for (int i = 0; i < m; i++)
        {
            int columnSum = 0;
            for(int j = 0; j < n; j++)
            {
                columnSum += A.get(i).get(j);
            }
            columnSums.add(columnSum);
        }

        return columnSums;
    }

//    public static void main(String[] agrs)
//    {
//        System.out.println(solve(new ArrayList<Integer>(List.of(6,3,3,6,7,8,7,3,7)), 2, 10));
//    }

    public static Long AGCount(String A) {

        int n = A.length(); Long aCount = 0L, agCount = 0L;

        for(int i = 0; i < n; i++)
        {
            if(A.charAt(i) == 'A')
            {
                aCount++;
            }
            if(A.charAt(i) == 'G')
            {
                agCount+=aCount;
            }
        }

        return agCount;
    }

    public int findAthFibonacci(int A) {
        if(A == 0 || A== 1)
        {
            return A;
        }
        return findAthFibonacci(A - 1) + findAthFibonacci(A - 2);
    }

    public int Factorial(int A) {
        if(A == 1) return A;

        return A * Factorial(A -1);
    }

    public void PrintA(int A) {
        System.out.println(PrintAHelper(A)+" ");
    }

    private String PrintAHelper(int A)
    {
        if(A == 1) return "1";
        return PrintAHelper(A - 1) +" "+ A;
    }

    public ArrayList<Integer> primeNos(int A) {
        boolean[] isPrimeNos = new boolean[A + 1];
        Arrays.fill(isPrimeNos, true);
        for (int i =2; i * i <= A; i++)
        {
            if(isPrimeNos[i])
            {
                for(int j = i * i; j <= A; j+=i)
                {
                    isPrimeNos[j] = false;
                }
            }
        }
        ArrayList<Integer> primeNos = new ArrayList<>();
        for(int i = 2; i <= A; i++)
        {
            if(isPrimeNos[i])
            {
                primeNos.add(i);
            }
        }

        return primeNos;
    }

    public ArrayList<Integer> primesum(int A) {
        boolean[] isPrime = new boolean[A +1];
        Arrays.fill(isPrime, true);
        for(int i = 2; i * i <= A; i++)
        {
            if(isPrime[i])
            {
                for(int j = i * i; j <= A; j+=i)
                {
                    isPrime[j] = false;
                }
            }
        }
        ArrayList<Integer> primeSumNos = new ArrayList<>();
        for(int i =2; i <= A; i++)
        {
            if(isPrime[i] && isPrime[A - i])
            {
                primeSumNos.add(i);
                primeSumNos.add(A - i);
                break;
            }
        }

        return primeSumNos;
    }

    public int ShaggyDistances(ArrayList<Integer> A) {
        int n = A.size(), minPairDistance = Integer.MAX_VALUE;
        Map<Integer, Integer> digits = new HashMap<>();
        for(int i =0; i < n;i++)
        {
            int currentElement = A.get(i);
            if(digits.containsKey(currentElement) && i - digits.get(currentElement) < minPairDistance)
            {
                minPairDistance = i - digits.get(currentElement);
            }
            else
            {
                digits.put(currentElement, i);
            }
        }

        return minPairDistance == Integer.MAX_VALUE ? -1 : minPairDistance;
    }

    public int subArrayWithZeroSum(ArrayList<Integer> A) {
        Set<Long> sums = new HashSet<>();
        Long sum = 0L;
        for (Integer i : A)
        {
            sum += i;
            if(sum == 0 || sums.contains(sum))
            {
                return 1;
            }

            sums.add(sum);
        }
        return 0;
    }

    public ArrayList<Integer> FrequencyInHashMap(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer, Integer> frequencyOfElements = new HashMap<>();
        ArrayList<Integer> results = new ArrayList<>();
        for(Integer intOfA : A)
        {
            if(frequencyOfElements.containsKey(intOfA))
            {
                frequencyOfElements.put(intOfA, frequencyOfElements.getOrDefault(intOfA, 0) + 1);
            }
            else
            {
                frequencyOfElements.put(intOfA, 1);
            }
        }

        for(Integer intOfB : B)
        {
            if(frequencyOfElements.containsKey(intOfB))
            {
                results.add(frequencyOfElements.getOrDefault(intOfB, 0));
            }
            else
            {
                results.add(0);
            }
        }

        return results;
    }

    public int CountDistinctElements(ArrayList<Integer> A) {
        Map<Integer, Integer> frequencyOfElements = new HashMap<>();

        for(Integer intOfA : A)
        {
            if(frequencyOfElements.containsKey(intOfA))
            {
                frequencyOfElements.put(intOfA, frequencyOfElements.getOrDefault(intOfA, 0) + 1);
            }
            else
            {
                frequencyOfElements.put(intOfA, 1);
            }
        }
        int uniqueElement = 0;
        for (var frequencyValueOfELement : frequencyOfElements.values())
        {
            if(frequencyValueOfELement == 1)
            {
                uniqueElement++;
            }
        }
        return uniqueElement;
    }

    public int FirstRepeating(ArrayList<Integer> A) {
        int firstNonRepeating = -1, minIndex = Integer.MAX_VALUE;
        Map<Integer, Integer> indexMap = new HashMap<>();

        for(int i =0; i < A.size(); i++)
        {
            int num = A.get(i);

            if(indexMap.containsKey(num))
            {
                if(indexMap.get(num) < minIndex)
                {
                    minIndex = indexMap.get(num);
                    firstNonRepeating = num;
                }
            }
            else
            {
                indexMap.put(num, i);
            }
        }
        return firstNonRepeating;
    }

    public int subArrayWithZerosum(ArrayList<Integer> A) {
       HashSet<Long> sums = new HashSet<>();
       Long sum = 0L;

       for(int i = 0; i < A.size(); i++)
       {
           sum += A.get(i);

           if(sums.contains(sum) || sum == 0)
           {
               return 1;
           }

           sums.add(sum);
       }

       return 0;
    }

    public ArrayList<Integer> CommonElements(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for(Integer ele : A)
        {
            frequency.put(ele, frequency.getOrDefault(ele,0) + 1);
        }

        for(Integer elementOfB:B)
        {
            if(frequency.containsKey(elementOfB) && frequency.get(elementOfB) > 0){
                frequency.put(elementOfB, frequency.get(elementOfB) - 1);
                result.add(elementOfB);
            }
        }
        return result;
    }

    public int CheckPairSum (int A, ArrayList<Integer> B) {
        HashSet<Integer> pairSum = new HashSet<>();
        for (Integer ele : B)
        {
            Integer diff = A - ele;
            if(pairSum.contains(diff)) {
                return 1;
            }

            pairSum.add(diff);
        }

        return 0;
    }

    public int searchInsert(ArrayList<Integer> A, int B, boolean isRightMost) {
        int n = A.size(), low = 0, high = n- 1, mid = 0;
        while (low <= high)
        {
            mid = low + (high - low)/2;

            if(A.get(mid) == B)
            {
                return mid;
            }
            else if (A.get(mid) < B)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }

        return low;
    }

    public int[] searchRange(final int[] A, int B) {
        int leftMost = findIndex(A, B, false);
        int rightMost = findIndex(A, B, true);
        return new int[]{leftMost, rightMost};
    }

    int findIndex(int[] A, int B, Boolean isRightMost)
    {
        int low = 0, high = A.length - 1, index = -1, mid;

        while(low <= high)
        {
            mid = low + (high - low) / 2;

            if(A[mid] == B)
            {
                index = mid;

                if(isRightMost)
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
            else if(B < A[mid])
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return index;
    }

    public int peakElement(ArrayList<Integer> A) {
        int n = A.size(), low = 0, high = n -1, mid = 0;

        while(low <= high)
        {
            mid = low + (high - low) / 2;
            if((mid - 1 < 0 || A.get(mid - 1) < A.get(mid)) && (mid + 1 >= n || A.get(mid + 1) < A.get(mid)))
            {
                return A.get(mid);
            }
            if(mid - 1 < 0 || A.get(mid - 1) <= A.get(mid))
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }

        return A.get(mid);
    }

    public static List<String> smallestNegativeBalance(List<List<String>> debts) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> borrowerMap = new HashMap<>();

        for(List<String> debt : debts)
        {
            String borrower = debt.get(0);
            String lender = debt.get(1);
            Integer amt = Integer.getInteger(debt.get(2));

            if(borrowerMap.containsKey(borrower))
            {
                borrowerMap.put(borrower, borrowerMap.getOrDefault(borrower, 0) - amt);
            }
            else
            {
                borrowerMap.put(borrower, -amt);
            }

            if(borrowerMap.containsKey(lender))
            {
                borrowerMap.put(lender, borrowerMap.getOrDefault(lender, 0) - amt);
            }
            else
            {
                borrowerMap.put(lender, amt);
            }

        }

        int minValue = Integer.MAX_VALUE;
        for(Integer amount : borrowerMap.values())
        {
            if(amount < minValue)
            {
                minValue = amount;
            }
        }

        TreeSet<String> orderNames = null;

        for (Map.Entry<String, Integer> entry :borrowerMap.entrySet())
        {
            if(entry.getValue() == minValue)
            {
                orderNames.add(entry.getKey());
            }
        }

        return !orderNames.isEmpty() ? new ArrayList<>(orderNames) : Collections.singletonList("Negative balance");
    }

    public Integer FindPerfectCube(Integer PerfectCube)
    {
        for(int i =1 ; i * i * i <= PerfectCube; i++)
        {
            if(i * i * i == PerfectCube)
            {
                return i;
            }
        }

        return -1;
    }

    public int[] plusOne(int[] digits) {
        List<Integer> ones = new ArrayList<>();
        int remanider = 1;
        for (int i = digits.length - 1; i >= 0; i--)
        {
            int op = remanider + digits[i];
            ones.add(op % 10);

            remanider = op / 10;
        }

        if (remanider > 0)
        {
            ones.add(remanider % 10);
            remanider/=10;
        }

        Collections.reverse(ones);
        return ones.stream().mapToInt(Integer::intValue).toArray();
    }

    public ArrayList<Integer> sorter(ArrayList<Integer> A)
    {
        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2)
                {
                    return 1;
                }
                else if(o1 > o2)
                {
                    return -1;
                }
                return 0;
            }
        });
        return A;
    }

    public int myAtoi(String s) {
        char[] chrs = s.toCharArray();
        int sign = 1;
        int result = 0;
        for(char ch : chrs)
        {
            if(ch == '-')
            {
                sign = -1;
            }
            else if(Character.isDigit(ch))
            {
               result = result * 10 + ch - '0';
            }
        }

        return sign * result;
    }

    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length, maxDiff = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                if(nums[i] > nums[i])
                {
                    if(maxDiff < nums[i] - nums[j])
                    {
                        maxDiff = nums[i] - nums[j];
                    }
                }
                else
                {
                    if(maxDiff < nums[j] - nums[i])
                    {
                        maxDiff = nums[j] - nums[i];
                    }
                }
            }
        }
        return maxDiff;
    }

    public int trap(int[] height) {
        int trapWater = 0;
        int n = height.length;
        int[] leftPrefixMax = new int[n];
        int[] rightPrefixMax = new int[n];

        leftPrefixMax[0] = height[0];
        for(int i = 1; i < n; i++)
        {
            leftPrefixMax[i] = Math.max(leftPrefixMax[i - 1],height[i]);
        }

        rightPrefixMax[n - 1] = height[n -1];
        for(int i = n - 2; i >= 0; i--)
        {
            rightPrefixMax[i] = Math.max(rightPrefixMax[i+1], height[i]);
        }

        for(int i = 0; i< n; i++)
        {
            trapWater = trapWater + (Math.min(rightPrefixMax[i], leftPrefixMax[i]) - height[i]);
        }

        return trapWater;
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int num: nums)
        {
            if(num != val)
            {
                nums[i] = num;
                i++;
            }

        }
        return i;
    }

    public int[] AsteroidCollision(int[] asteroids) {
        Stack<Integer> asteriodsStack = new Stack<Integer>();

        for(int asteriod: asteroids)
        {
            if(!asteriodsStack.isEmpty())
            {
                Integer topElement = asteriodsStack.peek();
                if (asteriod < 0 && topElement <= asteriod )
                {
                    asteriodsStack.pop();
                }
                else
                {
                    //asteriodsStack.add(asteriod);
                    continue;
                }
            }

            asteriodsStack.add(asteriod);
        }

        int[] result = new int[asteriodsStack.size()];

        for (int i =0; i < asteriodsStack.size(); i++)
        {
            result[i] = asteriodsStack.pop();
        }

        return result;
    }


    public int[] AsteroidCollision1(int[] asteroids) {
        Stack<Integer> asteroidStack = new Stack<>();
        asteroidStack.add(asteroids[0]);

        for (int i = 1; i < asteroids.length; i++)
        {
            Integer lastAsteroid = asteroidStack.peek();
            Integer currentAsteroid = asteroids[i];
            if((currentAsteroid < 0 && asteroidStack.peek() > 0) || (-currentAsteroid  == asteroidStack.peek()))
            {
                while(!asteroidStack.isEmpty() && ((currentAsteroid < 0 && asteroidStack.peek() > 0 && -currentAsteroid > asteroidStack.peek())
                || (-currentAsteroid  == asteroidStack.peek())))
                {
                    asteroidStack.pop();
                }
            }
            else
            {
                asteroidStack.add(currentAsteroid);
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        while (!asteroidStack.isEmpty()) {
            result.add(asteroidStack.pop());
        }

        return result.stream().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
    }

    public int LongestValidParentheses1(String s) {
        int n = s.length(), maxLength = 0;
        char[] chars = s.toCharArray();
        Stack<Integer> bracsStack = new Stack<Integer>();
        bracsStack.push(-1);
        for(int i = 0; i < n; i++)
        {
            char currentChar = chars[i];
            if(currentChar == '(')
            {
                bracsStack.push(i);
            }
            else if(currentChar == ')')
            {
                bracsStack.pop();
                if (bracsStack.isEmpty())
                {
                    bracsStack.push(i);
                }
                else {
                    maxLength = Math.max(maxLength, i - bracsStack.peek());
                }
            }
        }
        return maxLength;
    }

    public int majorityElement(List<Integer> A) {
        Map<Integer, Integer> haspmap = new HashMap<>();

        for (Integer num : A)
        {
            if(haspmap.containsKey(num))
            {
                haspmap.put(num , haspmap.get(num) + 1);
            }
            haspmap.put(num, 1);
        }

        List<Map.Entry<Integer, Integer>> map = new ArrayList<>(haspmap.entrySet());

        map.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        if(map.stream().findFirst().get().getValue() > Math.floor(A.size() /2 ))
        {
            return map.stream().findFirst().get().getKey();
        }

        return -1;
    }

    public int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList<>();

        int i =1;
        while (i * i <= n)
        {
            if(n % i == 0) {
                factors.add(i);
                if(n % i != i)
                {
                    factors.add(n/i);
                }
            }
            i++;
        }

        return k <= factors.size() ? factors.get(k) : -1;
    }

//    public int kthFactor(int n, int k) {
//        List<Integer> factors = new ArrayList<>();
//
//        for (int i = 1; i * i <= n; i++) {
//            if (n % i == 0) {
//                factors.add(i);
//                if (i != n / i) {
//                    factors.add(n / i);
//                }
//            }
//        }
//
//        Collections.sort(factors);  // Ensure ascending order
//
//        return (k <= factors.size()) ? factors.get(k - 1) : -1;
//    }

    public int reverse(int x) {

        int parsingValue = x;
        int parsedValue = 0;
        while (parsingValue != 0) {
            int tempVal = parsingValue % 10;
            if (parsedValue > Integer.MAX_VALUE / 10 || (parsedValue == Integer.MAX_VALUE / 10 && tempVal > 7)) {
                return 0;
            }
            if (parsedValue < Integer.MIN_VALUE / 10 || (parsedValue == Integer.MIN_VALUE / 10 && tempVal < -8)) {
                return 0;
            }
            parsedValue = (parsedValue * 10) + (tempVal);
            parsingValue = parsingValue / 10;
        }

        return parsedValue;
    }

    public String intToRoman(int num) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        return "";
    }

    public List<Integer> mapper(ArrayList<Integer> A)
    {
        var res =  A.stream().map(x ->  x *x ).collect(Collectors.toList());
        return res;
    }
}
