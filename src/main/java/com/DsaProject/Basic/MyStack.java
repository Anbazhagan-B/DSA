package com.DsaProject.Basic;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyStack {

    public int countStudents(int[] students, int[] sandwiches) {

//        Queue<Integer> queue = IntStream.of(students).boxed().collect(Collectors.toCollection(ArrayDeque::new));
//        Queue<Integer> sandwichesSatck = IntStream.of(sandwiches).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        Queue<Integer> studentsQueue = new ArrayDeque<>();
        Queue<Integer> sandwichesSatck = new ArrayDeque<>();
        int zeroCountInStudent = 0, oneCountInStudent= 0, n= students.length;
        for (int i = 0; i< n; i++)
        {
            if(students[i] == 0)
                zeroCountInStudent++;
            else
                oneCountInStudent++;

            studentsQueue.offer(students[i]);
            sandwichesSatck.offer(sandwiches[i]);
        }

        for(Integer sandwich : sandwiches)
        {
            if(sandwich == 0 && zeroCountInStudent > 0)
                zeroCountInStudent--;
            else if(sandwich == 1 && oneCountInStudent > 0)
                oneCountInStudent--;
            else
                break;
        }

        if(oneCountInStudent + zeroCountInStudent > 0)
            return  oneCountInStudent + zeroCountInStudent;


        while (!sandwichesSatck.isEmpty())
        {
            Integer topElement = studentsQueue.poll();

            if(topElement.equals(sandwichesSatck.peek()))
            {

                sandwichesSatck.poll();
            }
            else
            {
                studentsQueue.add(topElement);
            }
        }

        return studentsQueue.size();
    }

    public int reverse(int x) {
        StringBuilder sb = new StringBuilder(x);
        String reversedString = sb.reverse().toString();
        return -Integer.getInteger(reversedString);
    }

    public int BalancedParanthesis(String A) {
        java.util.Stack<Character> paranthesisStack = new java.util.Stack<>();

        for (Character ch : A.toCharArray())
        {
            if (!paranthesisStack.isEmpty() && ((ch.equals('}') && paranthesisStack.peek() == '{')
                    || (ch.equals(')') && paranthesisStack.peek() == '(')
                    || (ch.equals(']') && paranthesisStack.peek() == '[')))
            {
                paranthesisStack.pop();
            }
            else
                paranthesisStack.push(ch);
        }

        return paranthesisStack.size() == 0 ? 1 : 0;
    }

    public String doubleCharacterTrouble(String A) {
        Stack<Character> characterStack = new Stack<>();
        for(Character ch : A.toCharArray())
        {
            if(!characterStack.isEmpty() && characterStack.peek() == ch)
            {
                characterStack.pop();
            }
            else
            {
                characterStack.push(ch);
            }
        }
        StringBuilder response = new StringBuilder();
        while (!characterStack.isEmpty())
        {
            response.append(characterStack.pop());
        }
        return response.reverse().toString();
    }

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> intElements = new Stack<>();
        ArrayList<Integer> results = new ArrayList<>();
        for(Integer ele : A)
        {
            while(!intElements.isEmpty() && intElements.peek() >= ele)
            {
                intElements.pop();
            }

            if(intElements.isEmpty())
            {
                results.add(-1);
            }
            else
            {
                results.add(intElements.peek());
            }

            intElements.push(ele);
        }

        return results;
    }

    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        Stack<Integer> rightGreaterElements = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = A.size() - 1; i >= 0; i--)
        {
            while (!rightGreaterElements.isEmpty() && rightGreaterElements.peek() <= A.get(i))
            {
                rightGreaterElements.pop();
            }

            if(rightGreaterElements.isEmpty())
            {
                result.add(-1);
            }
            else
            {
                result.add(rightGreaterElements.peek());
            }

            rightGreaterElements.push(A.get(i));
        }
        Collections.reverse(result);
        return result;
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> asteroidStack = new Stack<>();

        for (int asteriod : asteroids)
        {
            if(asteriod > 0)
            {
                asteroidStack.add(asteriod);
            }
            else
            {

                while (!asteroidStack.isEmpty() && asteroidStack.peek() < 0 && asteroidStack.peek() > -asteriod)
                {
                    asteroidStack.pop();
                }

                if(!asteroidStack.isEmpty() && asteroidStack.peek() > 0 && asteroidStack.peek() == -asteriod)
                {
                    asteroidStack.pop();
                }
                else
                {
                    asteroidStack.add(asteriod);
                }
            }

        }

        return null;
    }

    public ArrayList<Integer> sorter(ArrayList<Integer> A)
    {
        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2)
                {
                    return -1;
                }
                else if(o1 > o2)
                {
                    return 1;
                }
                return 0;
            }
        });

        return A;
    }
}

