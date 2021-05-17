package offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Created by XDarker
 * @Description TODO
 * @Date 2021/2/21 21:21
 */
public class JZ_003 {


    public static void main(String[] args) {

        ListNode listNode = new ListNode(67);
        listNode.next = new ListNode(0);
        listNode.next.next = new ListNode(24);
        listNode.next.next.next = new ListNode(58);

        ArrayList<Integer> list = printListFromTailToHead(listNode);
        System.out.println(list);
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode head) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        if(head == null ){
            return list;
        }
        if(head.next == null){
            list.add(head.val);
            return list;
        }


        ListNode pre = null;
        ListNode next;
        while(head != null){

            next = head.next;//记录
            head.next = pre;//调整指向
            pre = head;
            head = next;
        }

        while(pre != null){


            list.add(pre.val);
            pre = pre.next;
        }



        return list;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
