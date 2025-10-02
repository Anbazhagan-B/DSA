package com.DsaProject.GeeksForGeeks.Tree;

import com.DsaProject.LLD.ConcertBookingLLD.Seat;

import java.util.*;

public class Executor {

    public void execute()
    {

        System.out.println(longestKSubstring("aabacbebebe", 3));
    }

    public int longestKSubstring(String s, int k) {
       char[] chars = s.toCharArray();
       int n = s.length(), maxLength = Integer.MAX_VALUE;
       ArrayList<Character> charQueue = new ArrayList<>();
       int left = 0;
       for(int right = 0; right < n; right++)
       {
           if(!charQueue.contains(chars[right]))
           {
               charQueue.add(chars[right]);
           }

           while (charQueue.size() > k)
           {
               charQueue.remove(left);
               left++;
           }

           maxLength = Math.min(maxLength, right - left + 1);
       }

       return maxLength;
    }

//    public int minTime(Node root, int target) {
//        Map<Node, Node> mapWithVertex = new HashMap<>();
//        loadIntoMap(root, mapWithVertex);
//        List<Node> targetNode = mapWithVertex.get(target);
//        Queue<List<Node>> queueNodes = new ArrayDeque<>();
//        queueNodes.add(targetNode);
//
//        int speardCount = 0;
//        while (!queueNodes.isEmpty())
//        {
//            List<Node> currentNode = queueNodes.remove();
//            int queueCount = queueNodes.size();
//            while (queueCount-- > 0)
//            {
//                List<Node> nextSetOfNodes = new ArrayList<>();
//                for(Node currentNodeData : currentNode)
//                {
//                    if(mapWithVertex.containsKey(currentNodeData.data))
//                    {
//                        nextSetOfNodes.add(currentNodeData);
//                    }
//                }
//                queueNodes.add(nextSetOfNodes);
//            }
//            speardCount++;
//        }
//
//        return speardCount;
//    }

//    void loadIntoMap(Node root, Map<Integer, List<Node>> mapWithVertex)
//    {
//        if(root != null)
//        {
//
//            if(root.left != null)
//            {
//                mapWithVertex.put(root.left.data, mapWithVertex.getOrDefault(root.left.data, new ArrayList<>()).add(root));
//                mapWithVertex.getOrDefault(root.data, new ArrayList<>()).add(root.left);
//            }
//
//            if(root.right != null)
//            {
//                mapWithVertex.getOrDefault(root.right.data, new ArrayList<>()).add(root);
//                mapWithVertex.getOrDefault(root.data, new ArrayList<>()).add(root.right);
//            }
//        }
//    }
}
