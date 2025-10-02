package com.DsaProject.Basic;
import ch.qos.logback.core.joran.sanity.Pair;
import com.DsaProject.DataStructureModels.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class TreePrblms {
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {

        if(A.size() != B.size() || A == null || B == null)
        {
            return null;
        }

        return buildTreeHelpher(A, B, 0, A.size() -1, 0, B.size() -1);
    }

    TreeNode buildTreeHelpher(ArrayList<Integer> A, ArrayList<Integer> B, int inOrderStart, int inOrderEnd,
                              int postOrderStart, int postOrderEnd) {
        if(inOrderStart > inOrderEnd || postOrderStart > postOrderEnd)
            return null;

        Integer mid = B.get(postOrderEnd);
        int indexOfMidInOrder = A.indexOf(mid);
        int leftSubtreeCount = indexOfMidInOrder - inOrderStart;

        TreeNode rootnode = new TreeNode(mid);
        rootnode.setLeft(buildTreeHelpher(A, B, inOrderStart, indexOfMidInOrder -1, postOrderStart, postOrderStart + leftSubtreeCount - 1));
        rootnode.setRight(buildTreeHelpher(A, B, indexOfMidInOrder + 1, inOrderEnd, postOrderStart + leftSubtreeCount, postOrderEnd - 1));

        return rootnode;
    }

    public ArrayList<Integer>  RightView (TreeNode A) {
        Queue<TreeNode> queue = new ArrayDeque<>();

        ArrayList<Integer> rightViewElements = new ArrayList<>();

        queue.add(A);
        rightViewElements.add(A.val);

        while (!queue.isEmpty())
        {
            int queueCount = queue.size();
            int rightmostElement = Integer.MAX_VALUE;
            while (queueCount-- > 0)
            {
                TreeNode current = queue.remove();

                if(current.left != null)
                {
                    rightmostElement = current.left.val;
                    queue.add(current.left);
                }

                if(current.right != null)
                {
                    rightmostElement = current.right.val;
                    queue.add(current.right);
                }
            }

            if(rightmostElement != Integer.MAX_VALUE)
            {
                rightViewElements.add(rightmostElement);
            }

        }

        return rightViewElements;
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> verticalOrderTraversal = new ArrayList<ArrayList<Integer>>();
        Queue<AbstractMap.SimpleEntry<TreeNode, Integer>> queue = new ArrayDeque<>();
        Map<Integer, ArrayList<Integer>> treeNodesWithIndex = new HashMap<>();

        queue.add(new AbstractMap.SimpleEntry<>(A, 0));
        treeNodesWithIndex.put(0, new ArrayList<>(Arrays.asList(A.val)));

        while (!queue.isEmpty())
        {
            int queueNodeCount = queue.size();

            while (queueNodeCount-- > 0)
            {
                AbstractMap.SimpleEntry<TreeNode, Integer> currentRootEntry = queue.poll();
                TreeNode rootNode = currentRootEntry.getKey();
                Integer currentLvl = currentRootEntry.getValue();
                if(rootNode.left != null)
                {
                    queue.add(new AbstractMap.SimpleEntry<>(rootNode.left, currentLvl - 1));
                    if(treeNodesWithIndex.containsKey(currentLvl - 1))
                    {
                        treeNodesWithIndex.get(currentLvl - 1).add(rootNode.left.val);
                    }
                    else
                    {
                        treeNodesWithIndex.put(currentLvl - 1, new ArrayList<>(Arrays.asList(rootNode.left.val)));
                    }
                }

                if(rootNode.right != null)
                {
                    queue.add(new AbstractMap.SimpleEntry<>(rootNode.right, currentLvl + 1));
                    if(treeNodesWithIndex.containsKey(currentLvl + 1))
                    {
                        treeNodesWithIndex.get(currentLvl + 1).add(rootNode.right.val);
                    }
                    else
                    {
                        treeNodesWithIndex.put(currentLvl + 1, new ArrayList<>(Arrays.asList(rootNode.right.val)));
                    }
                }
            }
        }

        TreeMap<Integer,ArrayList<Integer>> sortedTreeNodeValues = new TreeMap<>(treeNodesWithIndex);

        for(Map.Entry<Integer,ArrayList<Integer>> entry : sortedTreeNodeValues.entrySet())
        {
            verticalOrderTraversal.add(entry.getValue());
        }
        return verticalOrderTraversal;
    }

    public ArrayList<ArrayList<Integer>> LevelOrder(TreeNode A) {
        Queue<TreeNode> treeNodesByLvl = new ArrayDeque<>();
        treeNodesByLvl.add(A);
        ArrayList<ArrayList<Integer>> levelOrderedNodes = new ArrayList<>();
        levelOrderedNodes.add(new ArrayList<>(Arrays.asList(A.val)));
        while (!treeNodesByLvl.isEmpty())
        {
            int currentNodesCount = treeNodesByLvl.size();
            ArrayList<Integer> currentLvlNodes = new ArrayList<>();
            while (currentNodesCount-- >0)
            {
                TreeNode currentLvlNode = treeNodesByLvl.poll();
                if(currentLvlNode.left != null)
                {
                    currentLvlNodes.add(currentLvlNode.left.val);
                    treeNodesByLvl.add(currentLvlNode.left);
                }

                if(currentLvlNode.right != null)
                {
                    currentLvlNodes.add(currentLvlNode.right.val);
                    treeNodesByLvl.add(currentLvlNode.right);
                }
            }
            if(!currentLvlNodes.isEmpty())
            {
                levelOrderedNodes.add(currentLvlNodes);
            }
        }

        return levelOrderedNodes;
    }

    public ArrayList<Integer> TopViewBinarytree(TreeNode A) {
        ArrayList<Integer> topViewNodes = new ArrayList<>();
        Queue<AbstractMap.SimpleEntry<TreeNode, Integer>> queue = new ArrayDeque<>();
        Map<Integer, ArrayList<Integer>> treeNodesWithIndex = new HashMap<>();

        queue.add(new AbstractMap.SimpleEntry<>(A, 0));
        treeNodesWithIndex.put(0, new ArrayList<>(Arrays.asList(A.val)));

        while (!queue.isEmpty())
        {
            int queueNodeCount = queue.size();

            while (queueNodeCount-- > 0)
            {
                AbstractMap.SimpleEntry<TreeNode, Integer> currentRootEntry = queue.poll();
                TreeNode rootNode = currentRootEntry.getKey();
                Integer currentLvl = currentRootEntry.getValue();
                if(rootNode.left != null)
                {
                    queue.add(new AbstractMap.SimpleEntry<>(rootNode.left, currentLvl - 1));
                    if(treeNodesWithIndex.containsKey(currentLvl - 1))
                    {
                        treeNodesWithIndex.get(currentLvl - 1).add(rootNode.left.val);
                    }
                    else
                    {
                        treeNodesWithIndex.put(currentLvl - 1, new ArrayList<>(Arrays.asList(rootNode.left.val)));
                    }
                }

                if(rootNode.right != null)
                {
                    queue.add(new AbstractMap.SimpleEntry<>(rootNode.right, currentLvl + 1));
                    if(treeNodesWithIndex.containsKey(currentLvl + 1))
                    {
                        treeNodesWithIndex.get(currentLvl + 1).add(rootNode.right.val);
                    }
                    else
                    {
                        treeNodesWithIndex.put(currentLvl + 1, new ArrayList<>(Arrays.asList(rootNode.right.val)));
                    }
                }
            }
        }

        TreeMap<Integer,ArrayList<Integer>> sortedTreeNodeValues = new TreeMap<>(treeNodesWithIndex);

        for(Map.Entry<Integer,ArrayList<Integer>> entry : sortedTreeNodeValues.entrySet())
        {
            topViewNodes.add(entry.getValue().stream().findFirst().get());
        }
        return topViewNodes;
    }

    public int SearchBST(TreeNode A, int B) {
        return BSTSearchHelpher(A, B) ? 1 : 0;
    }

    Boolean BSTSearchHelpher(TreeNode A, int B)
    {
        if(A == null) return false;
        if(A.val == B)
        {
            return true;
        }

        boolean foundInLeft = BSTSearchHelpher(A.left, B);
        boolean foundInRight = BSTSearchHelpher(A.right, B);

        return foundInLeft || foundInRight;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreeHelpher(p, q);
    }


    boolean isSameTreeHelpher(TreeNode p, TreeNode q) {

        if(p == null && q == null)
            return true;

        if(p == null || q == null || p.val != q.val)
            return false;
        return isSameTreeHelpher(p.left, q.left) && isSameTreeHelpher(p.right, q.right);
    }
    public TreeNode invertTree(TreeNode A) {
        if(A == null)
            return null;
        TreeNode root = new TreeNode(A.val);
        root.left = invertTree(A.right);
        root.right = invertTree(A.left);

        return root;
    }

}
