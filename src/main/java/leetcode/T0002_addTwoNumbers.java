package leetcode;

/**
 * @Created by XDarker
 * @Description TODO
 * @Date 2020/5/22 19:48
 */
public class T0002_addTwoNumbers {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next= new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);

        addTwoNumbers(node1, node2);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode res1 = l1.next;
        ListNode res2 = l2.next;

        int sum = l1.val + l2.val;
        ListNode newNode = new ListNode(sum % 10);
        sum = sum / 10;
        ListNode p = newNode;
        while (res1 != null || res2 != null){
            if ( res1 != null){
                sum += res1.val;
                res1 = res1.next;
            }
            if ( res2 != null){
                sum += res2.val;
                res2 = res2.next;
            }

            p.next = new ListNode(sum % 10);
            p = p.next;
            sum = sum / 10;
        }

        if (sum == 1){
            p.next = new ListNode(1);
        }
        return newNode;

    }




    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
}
