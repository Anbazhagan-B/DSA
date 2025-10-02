package com.DsaProject.IntPack;

import com.DsaProject.IntPack.supports.Edge;
import com.DsaProject.IntPack.supports.Vertex;

import java.util.*;

public class Graph {

    public void execute()
    {
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();

        int[][] input = {
                {1,1,0,1},
                {0,0,0,1},
                {1,0,0,1},
                {0,0,1,0}
        };

        for (int i = 0; i < input.length; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < input[i].length; j++) {
                row.add(input[i][j]);
            }
            B.add(row);
        }

        System.out.println(solve(B, new ArrayList<>(List.of(1, 1)) , new ArrayList<>(List.of(2, 1))));
    }

    public int solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int n = A.size(), m = A.get(0).size();
        int[][] distance = new int[n][m];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Edge> queue = new LinkedList<>();
        queue.add(new Edge(B.get(0), B.get(1), 0));

        while (!queue.isEmpty())
        {
            Edge currentNode = queue.remove();

            for(int[] row : dirs)
            {
                int nextX = currentNode.i + row[0];
                int nextY = currentNode.j + row[1];
                if(isValid(nextX, nextY, n, m) && A.get(nextX).get(nextY) == 0)
                {
                    if(currentNode.distance + 1 < distance[nextX][nextY])
                    {
                        distance[nextX][nextY] = currentNode.distance + 1;
                        if(nextX == C.get(0) && nextY == C.get(1))
                        {
                            return distance[nextX][nextY];
                        }
                    }
                }

            }
        }

        return -1;
    }

    public int anotherBFS(int A, ArrayList<ArrayList<Integer>> B, int C, int D) {
        Map<Integer, ArrayList<Vertex>> nodes = new HashMap<>();

        for(ArrayList<Integer> row : B)
        {
            int from = row.get(0);
            int to = row.get(1);
            int weight = row.get(2);
            if(!nodes.containsKey(from))
            {
                nodes.put(from, new ArrayList<>());
            }
            if(!nodes.containsKey(to))
            {
                nodes.put(to, new ArrayList<>());
            }
            nodes.get(from).add(new Vertex(to, weight));
            nodes.get(to).add(new Vertex(from, weight));
        }

        int[] distance = new int[A];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(C);
        distance[C] = 0;
        while (!queue.isEmpty())
        {
            int currentNode = queue.remove();
            if(nodes.containsKey(currentNode))
            {
                for(Vertex vertex : nodes.get(currentNode))
                {
                    int to = vertex.v;
                    int weight = vertex.weight;

                    if(distance[to] == Integer.MAX_VALUE)
                    {
                        distance[to] = distance[currentNode] + weight;
                        queue.add(to);
                    }
                    else if(distance[currentNode] + weight < distance[to])
                    {
                        distance[to] = distance[currentNode] + weight;
                        queue.add(to);
                    }
                }
            }
        }

        return distance[D] != Integer.MAX_VALUE ? distance[D] : -1;
    }

    public int rottenOranges(ArrayList<ArrayList<Integer>> A) {
        int n = A.size(), m = A.get(0).size(), freshOranges = 0;

        Queue<Edge> queue = new LinkedList<>();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(A.get(i).get(j) == 1)
                {
                    freshOranges++;
                }
                else if(A.get(i).get(j) == 2)
                {
                    queue.add(new Edge(i, j));
                }
            }
        }
        int rottenTomatoes = 0;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            while (size > 0)
            {
                Edge currentNode = queue.remove();
                for(int[] row : dirs)
                {
                    int nextX = row[0] + currentNode.i;
                    int nextY = row[1] + currentNode.j;
                    if(isValid(nextX, nextY, n, m) && A.get(nextX).get(nextY) == 1)
                    {
                        A.get(nextX).set(nextY, 2);
                        freshOranges--;
                        queue.add(new Edge(nextX, nextY));
                    }
                }
                size--;
            }

            rottenTomatoes++;
        }
        if(freshOranges == 0)
            return rottenTomatoes - 1;
        return 0;
    }

    int[][] dirs = new int[][] {
            {1, 0},   // Down
            {-1, 0},  // Up
            {0, 1},   // Right
            {0, -1}   // Left
    };

    public int possibilityOfFinishing(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        Map<Integer, ArrayList<Integer>> nodeWithVertex = new HashMap<>();
        int[] inDegree = new int[A+1];
        for(int i = 0; i < B.size(); i++){
            int from = B.get(i);
            int to = C.get(i);
            if(!nodeWithVertex.containsKey(from))
            {
                nodeWithVertex.put(from, new ArrayList<>());
            }
            nodeWithVertex.get(from).add(to);
            inDegree[to]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < A+1; i++)
        {
            if(inDegree[i] == 0)
            {
                queue.add(i);
            }
        }

        ArrayList<Integer> nums = new ArrayList<>();
        while(!queue.isEmpty())
        {
            int currentNode = queue.remove();
            nums.add(currentNode);
            if(nodeWithVertex.containsKey(currentNode))
            {
                for (Integer num : nodeWithVertex.get(currentNode))
                {
                    inDegree[num]--;
                    if(inDegree[num] == 0)
                    {
                        queue.add(num);
                    }
                }
            }
        }

        return nums.size() == A ? 1 : 0;
    }

    int numberOfIslands(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size(), islandCount = 0;
        boolean[][] visited = new boolean[A.size()][A.get(0).size()];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(isValid(i, j, n, m) && !visited[i][j] && A.get(i).get(j) == 1)
                {
                    islandCount++;
                    DFS(A, i , j, n , m, visited);
                }
            }
        }

        return islandCount;
    }
    int[][] directions = {
            {-1, 0},  // up
            {0, -1},  // left
            {1, 0},   // down
            {0, 1},   // right
            {-1, -1}, // up-left
            {-1, 1},  // up-right
            {1, -1},  // down-left
            {1, 1}    // down-right
    };
    void DFS(ArrayList<ArrayList<Integer>> A, int i, int j, int n, int m, boolean[][] visited)
    {
        visited[i][j] = true;
        for (int[] row: directions)
        {
            int nextX = i + row[0];
            int nextY = j + row[1];
            if(isValid(nextX, nextY, n, m) && !visited[nextX][nextY] && A.get(nextX).get(nextY) == 1)
            {
                DFS(A, nextX, nextY, n ,m, visited);
            }
        }
    }

    boolean isValid(int i, int j, int n, int m)
    {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}
