/*
  递归模拟出栈
*/

public class Solution {
    private ListNode left;

    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;

        left = head;
        return judge(head);
    }

    public boolean judge(ListNode right){
        if(right.next == null){
            if(left.val == right.val){
                left = left.next;
                return true;
            }
            else
                return false;
        }
        else {
            if(judge(right.next))
                if(left.val == right.val) {
                    left = left.next;
                    return true;
                }
            return false;
        }
    }
}



/*
  List分成两部分，后半部分先reverse，再作比较。
*/

public class Solution {  
    public boolean isPalindrome(ListNode head) {  
        //input check  abcba abccba  
        if(head==null || head.next==null) return true;  
          
        ListNode middle = partition(head);  
        middle = reverse(middle);  
          
        while(head!=null && middle!=null) {  
            if(head.val != middle.val) return false;  
            head = head.next;  
            middle = middle.next;  
        }  
        return true;  
    }  
    private ListNode partition(ListNode head) {  
        ListNode p = head;  
        while(p.next!=null && p.next.next!=null) {  
            p = p.next.next;  
            head = head.next;  
        }  
          
        p = head.next;  
        head.next = null;  
        return p;  
    }  
    private ListNode reverse(ListNode head) {  
        if(head==null || head.next==null) return head;  
        ListNode pre = head;  
        ListNode cur = head.next;  
        pre.next = null;  
        ListNode nxt = null;  
          
        while(cur!=null) {  
            nxt = cur.next;  
            cur.next = pre;  
            pre = cur;  
            cur = nxt;  
        }  
        return pre;  
    }  
}  
