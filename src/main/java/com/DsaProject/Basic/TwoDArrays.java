package com.DsaProject.Basic;

import java.util.*;

public class TwoDArrays {
    public ArrayList<Integer> ColumnSum(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        ArrayList<Integer> columnSums = new ArrayList<>();
        int m = A.get(0).size();

        for (int i = 0; i < m; i++)
        {
            int columnSum = 0;
            for(int j = 0; j < n; j++)
            {
                columnSum += A.get(j).get(i);
            }
            columnSums.add(columnSum);
        }

        return columnSums;
    }

    public int digonalSum(final List<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int diagonalSum = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(i == j)
                {
                    diagonalSum+= A.get(i).get(j);
                }
            }
        }
        return diagonalSum;
    }

    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        int i = 0, j =0, n = A.size(), m = A.get(0).size();
        ArrayList<ArrayList<Integer>> diagonals = new ArrayList<>();
        for(j = 0; j < n; j++)
        {
            diagonals.add(printDiagonal(A, i, j, n, m));
        }

        j = m -1;

        for(i = 1; i < n; i++)
        {
            diagonals.add(printDiagonal(A, i, j, n, m));
        }

        return diagonals;
    }

    public ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        ArrayList<ArrayList<Integer>> transposeMatrix = new ArrayList<>();
        for(int j = 0; j < m; j++)
        {
            transposeMatrix.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++)
        {
            for(int j= 0 ; j < m; j++)
            {
                transposeMatrix.get(j).add(A.get(i).get(j));
            }
        }

        return transposeMatrix;
    }
    public int RowWithMaxOnes(ArrayList<ArrayList<Integer>> A) {
        int n = A.size(), m = A.get(0).size(), maxOneCount = 0, maxOneRow = 0;

        for(int i = 0; i < n; i++)
        {
            int rowCount = 0;
            for(int j = 0; j < m;j++)
            {
                if(A.get(i).get(j) == 1)
                {
                    rowCount++;
                }
            }

            if(rowCount > maxOneCount)
            {
                maxOneCount = rowCount;
                maxOneRow = i;
            }
        }

        return maxOneRow;
    }

    public int SumAllSubMatrices(ArrayList<ArrayList<Integer>> A) {
        int n = A.size(), m = A.get(0).size();
        int sumOfMatrix = 0;
        for(int i = 0 ; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                int rowSum = (i + 1) * (n - i);
                int colSum = (j + 1) * (m - j);
                int currentSum = rowSum * colSum * A.get(i).get(j);
                sumOfMatrix = (sumOfMatrix + currentSum)  % 1000000009;
            }
        }

        return sumOfMatrix;
    }

    public int searchInRowColumn(ArrayList<ArrayList<Integer>> A, int B) {
        int n = A.size(), m = A.get(0).size(), result = Integer.MAX_VALUE;

        int i = 0, j = m - 1;
        while(i < n && i >= 0 && j < m && j >= 0)
        {
            int currentElement = A.get(i).get(j);
            if(currentElement == B)
            {
                if((i + 1) * 1009 + (j + 1) < result)
                {
                    result = (i + 1) * 1009 + (j + 1);
                }
                j--;
            }
            else if(currentElement <= B)
            {
                i++;
            }
            else
            {
                j--;
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    ArrayList<Integer> printDiagonal(ArrayList<ArrayList<Integer>> A, int i, int j, int n, int m)
    {
        ArrayList<Integer> result = new ArrayList<>();
        int row = i, col = j;
        while(row < n && col >= 0)
        {
            result.add(A.get(row).get(col));
            row++;
            col--;
        }

        while (result.size() < n)
        {
            result.add(0);
        }
        return result;
    }

    public ArrayList<Integer> rowSum(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        ArrayList<Integer> rowSums = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            int rowSum = 0;
            for(int j = 0; j < m; j++)
            {
                rowSum += A.get(i).get(j);
            }
            rowSums.add(rowSum);
        }

        return rowSums;
    }

    public int firstMissingPositive(ArrayList<Integer> A) {
        int missingNo = 1, n = A.size();
        A.sort((a, b) -> a.compareTo(b));
        for(int i =0; i< n;i++)
        {
            if (missingNo == A.get(i))
            {
                missingNo++;
            }
        }

        return missingNo;
    }

//    public ArrayList<ArrayList<Integer>> insert(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B) {
//    }
}
