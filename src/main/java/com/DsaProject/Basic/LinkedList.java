package com.DsaProject.Basic;

import com.DsaProject.DataStructureModels.ListNode;

public class LinkedList {
      // 1->2->3->4->5->null
      // null<-1<-2<-3<-4<-5
    public ListNode reverseList(ListNode A) {

        ListNode prev = null, current = A, next = A.next;
        while (current != null)
        {
            next = current.next;
            current.next = prev;
            prev =  current;
            current = next;
        }
        return prev;
    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {

        ListNode traverseNodeOfA = A, traverseNodeOfB = B, mergeList = new ListNode(-1), traverseNode = mergeList;

        while (traverseNodeOfA != null && traverseNodeOfB != null)
        {
            if(traverseNodeOfA.val < traverseNodeOfB.val)
            {
                traverseNode.next = new ListNode(traverseNodeOfA.val);
                traverseNodeOfA = traverseNodeOfA.next;
            }
            else
            {
                traverseNode.next = new ListNode(traverseNodeOfB.val);
                traverseNodeOfB = traverseNodeOfB.next;
            }
            traverseNode = traverseNode.next;
        }

        while (traverseNodeOfA != null)
        {
            traverseNode.next = new ListNode(traverseNodeOfA.val);
            traverseNode = traverseNode.next;
            traverseNodeOfA = traverseNodeOfA.next;
        }

        while (traverseNodeOfB != null)
        {
            traverseNode.next = new ListNode(traverseNodeOfB.val);
            traverseNode = traverseNode.next;
            traverseNodeOfB = traverseNodeOfB.next;
        }

        return mergeList.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0) return  null;

        ListNode templist = lists[0];

        for(int i = 1; i < lists.length; i++)
        {
            templist = mergeTwoLists1(templist, lists[i]);
        }

        return templist;
    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode(0), traverseNode = mergedList;
        while (list1 != null && list2 != null)
        {
            if(list1.val < list2.val)
            {
                traverseNode.next = list1;
                list1 = list1.next;
            }
            else
            {
                traverseNode.next = list2;
                list2 = list2.next;
            }
            traverseNode = traverseNode.next;
        }

        while (list1 != null)
        {
            traverseNode.next = list1;
            list1 = list1.next;
            traverseNode = traverseNode.next;
        }

        while (list2 != null)
        {
            traverseNode.next = list2;
            list2 = list2.next;
            traverseNode = traverseNode.next;
        }

        return mergedList.next;
    }

}
