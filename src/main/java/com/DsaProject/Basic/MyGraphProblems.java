package com.DsaProject.Basic;


import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class MyGraphProblems {
    public int PathDirectedGraph(int A, ArrayList<ArrayList<Integer>> B) {
        Map<Integer, ArrayList<Integer>> nodesWithVertex = new HashMap<>();
        for(ArrayList<Integer> row: B)
        {
            Integer from = row.get(0);
            Integer to = row.get(1);

            if(!nodesWithVertex.containsKey(from))
            {
                nodesWithVertex.put(from, new ArrayList<>());
            }

            nodesWithVertex.get(from).add(to);
        }

        boolean[] visited = new boolean[A + 1];
        for(Map.Entry<Integer, ArrayList<Integer>> vertex : nodesWithVertex.entrySet())
        {
            DFS(vertex.getKey(), nodesWithVertex, visited);
        }

        return visited[A] ? 1 : 0;
    }

    void DFS(int vertexId, Map<Integer, ArrayList<Integer>> nodesWithVertex , boolean[] visited)
    {
        if(nodesWithVertex.containsKey(vertexId))
        {
            for (Integer neighbor : nodesWithVertex.get(vertexId))
            {
                if(!visited[neighbor])
                {
                    visited[neighbor] = true;
                    DFS(neighbor, nodesWithVertex, visited);
                }
            }
        }
    }

    public int HasCycle(int A, ArrayList<ArrayList<Integer>> B) {
        Map<Integer, ArrayList<Integer>> nodesWithVertex = new HashMap<>();
        for(ArrayList<Integer> row: B)
        {
            Integer from = row.get(0);
            Integer to = row.get(1);

            if(!nodesWithVertex.containsKey(from))
            {
                nodesWithVertex.put(from, new ArrayList<>());
            }

            nodesWithVertex.get(from).add(to);
        }

        int[] visited = new int[A + 1];
        Arrays.fill(visited, 0);

        for(Map.Entry<Integer, ArrayList<Integer>> vertex : nodesWithVertex.entrySet())
        {
            if(visited[vertex.getKey()] != 2 && DFSHasCycle(vertex.getKey(), nodesWithVertex, visited)){
               return 1;
            }
        }

        return 0;
    }

    boolean DFSHasCycle(int vertexId, Map<Integer, ArrayList<Integer>> nodesWithVertex , int[] visited)
    {
        if(visited[vertexId] == 1)
        {
            return true;
        }
        visited[vertexId] = 1;
        if(nodesWithVertex.containsKey(vertexId))
        {
            for (Integer neighbor : nodesWithVertex.get(vertexId))
            {
                if(visited[neighbor] != 2 && DFSHasCycle(neighbor, nodesWithVertex, visited))
                {
                    return true;
                }
            }
        }

        visited[vertexId] = 2;
        return false;
    }

    public int PossibilityOfFinishing (int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int[] indegre = new int[A+1];
        Map<Integer, ArrayList<Integer>> nodeWithVertex = new HashMap<>();

        Arrays.fill(indegre, 0);
        for (int i = 0; i < A; i++)
        {
            int from = B.get(i);
            int to = C.get(i);

            indegre[to]++;

            if(!nodeWithVertex.containsKey(from))
            {
                nodeWithVertex.put(from, new ArrayList<>());
            }

            nodeWithVertex.get(from).add(to);
        }

        Queue<Integer> traverseNodes = new ArrayDeque<>();

        for (int i = 1; i < A+ 1; i++)
        {
            if(indegre[i] == 0)
            {
                traverseNodes.add(i);
            }
        }

        boolean[] visited = new boolean[A + 1];
        while(!traverseNodes.isEmpty())
        {
            int currentNode = traverseNodes.poll();
            if(nodeWithVertex.containsKey(currentNode))
            {
                for(var vertex : nodeWithVertex.get(currentNode))
                {
                    indegre[vertex]--;
                    DFS(vertex, nodeWithVertex, visited);
                }
            }
        }

        return visited[A] ? 1 : 0;
    }
}
