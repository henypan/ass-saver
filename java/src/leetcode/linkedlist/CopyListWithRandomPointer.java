package leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * <p>
 * A linked list is given such that each node contains an additional random pointers that could
 * point to any node in the list or null.
 * </p>
 * <p>
 * Copyright &copy 2015 Pan
 * </p>
 * 
 * @author Henry Pan
 */
public class CopyListWithRandomPointer
{
    // I'm going to use the hash map to store the connection between the random pointer of each node
    // and pointed node.
    // Below solution is from clean code:
    public RandomListNode copyRandomListNode(RandomListNode head)
    {
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode old = head;
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode copy = dummyHead;
        
        // First round, iterate though the original list node, we are mapping each nodes between
        // original list and the copied list.
        while (old!=null)
        {
            copy.next = new RandomListNode(old.data);
            map.put(old, copy.next);
            old = old.next;
            copy = copy.next;
        }
        
        // Revert back everything here.
        old = head;
        copy = dummyHead;
        
        while (old!=null)
        {
            copy.next.random = map.get(old.random);
            old = old.next;
            copy = copy.next;
        }
        return dummyHead.next;
    }
}
