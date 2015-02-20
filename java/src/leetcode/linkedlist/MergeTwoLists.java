package leetcode.linkedlist;

public class MergeTwoLists
{
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode dummyHead = new ListNode(0);
        // dummyHead acts as a reference to the original head of the p list
        ListNode p = dummyHead;
        
        while(l1 != null && l2 != null)
        {
            if (l1.data < l2.data)
            {
                p.next = l1;
                l1 = l1.next;
            }
            else 
            {
                p.next = l2;
                l2 = l2.next;
            }
            
            p = p.next;
        }
        
        if (l1 != null)
            p.next = l1;
        if (l2 != null)
            p.next = l2;
        
        return dummyHead.next;
    }
}
