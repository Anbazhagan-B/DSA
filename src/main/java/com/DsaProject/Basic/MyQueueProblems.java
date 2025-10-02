package com.DsaProject.Basic;

import java.util.*;

public class MyQueueProblems {
    public String perfectNos(int A) {
        Queue<String> perfectNumbers = new ArrayDeque<>();
        perfectNumbers.add("");
        int i = 0;
        while (i <= A)
        {
            String currentNo = perfectNumbers.poll();
            if(currentNo != "null")
            {
                String next1 = currentNo + "1" + reverseString(currentNo + "1");
                i++;
                if(i == A)
                {
                    return next1;
                }

                String next2 = currentNo + "2" + reverseString(currentNo + "2");
                i++;
                if(i == A)
                {
                    return next2;
                }
                perfectNumbers.add(currentNo + "1");
                perfectNumbers.add(currentNo + "2");

            }
        }

        return "";
    }

    String reverseString(String A)
    {
        char[] inputChar = A.toCharArray();
        int low = 0, high = inputChar.length - 1;

        while (low <= high)
        {
            char tempChar = inputChar[low];
            inputChar[low] = inputChar[high];
            inputChar[high] = tempChar;
            low++;
            high--;
        }

        return new String(inputChar);
    }

    public int CpuJobs(ArrayList<Integer> A, ArrayList<Integer> B) {
        Queue<Integer> taskQueue = new ArrayDeque<>(A);
        int clockCycleCount = 0;
        for(Integer task : B)
        {
            while(!Objects.equals(task, taskQueue.peek()))
            {
                Integer removedElement = taskQueue.poll();
                clockCycleCount++;
                taskQueue.add(removedElement);
            }

            taskQueue.poll();
            clockCycleCount++;
        }

        return clockCycleCount;
    }

    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Integer maxInCurrentWindow = Integer.MIN_VALUE;
        for(int i = 0; i < B; i++)
        {
            if(maxInCurrentWindow < A.get(i))
            {
                maxInCurrentWindow = A.get(i);
            }
        }

        Queue<Integer> maxElements = new ArrayDeque<>();
        maxElements.add(maxInCurrentWindow);
        result.add(maxInCurrentWindow);

        int low = 1;


        for(low = B; low <= A.size() - 1; low++)
        {
            if(!maxElements.isEmpty() && maxElements.peek() < A.get(low))
            {
                maxInCurrentWindow = A.get(low);
                maxElements.add(maxInCurrentWindow);
                result.add(maxInCurrentWindow);
            }
            else
            {
                result.add(maxInCurrentWindow);
            }
        }
        return result;
    }
}
