import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class ListNode<T> {
    public T data;
    public ListNode next;
}

class Solution {

    /* Write Code Here */
    public ListNode<Integer> reverseBetween(ListNode<Integer> head, int left, int right) {
        int n = right - left + 1;
        ListNode<Integer> dummy = new ListNode<>();
        dummy.next = head;
        ListNode<Integer> pre = head;
        ListNode<Integer> node = null;
        left --;
        right --;

        int m = right;
        ListNode<Integer> tmp = head;
        while (m -- > 0) {
            tmp = tmp.next;
        }

        while (head != null) {
            pre = head;
            head = head.next;
            left --;
            right --;
            if (left == 0)  {
                ListNode[] list = reverse(head, n, pre);
                pre.next = list[0];
                // node = list[1];

            }
            if (right == 0) {
                head.next = tmp;
                return dummy.next;
            }
        }
        System.out.println(1111);
        return dummy.next;


    }

    public ListNode<Integer>[] reverse(ListNode<Integer> node, int n, ListNode<Integer> last) {
        ListNode<Integer> pre = last;
        ListNode<Integer> cur = node;
        while (n -- > 0) {
            ListNode<Integer> tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return new ListNode[]{pre, node};
    }
}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode<Integer> res = null;

        int head_size = 0;
        head_size = in.nextInt();
        ListNode<Integer> head = null, head_curr = null;
        for(int head_i = 0; head_i < head_size; head_i++) {
            int head_item = in.nextInt();
            ListNode<Integer> head_temp = new ListNode<Integer>();
            head_temp.data = head_item;
            head_temp.next = null;

            if (head == null) {
                head = head_curr = head_temp;
            } else {
                head_curr.next = head_temp;
                head_curr = head_temp;
            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        int left;
        left = Integer.parseInt(in.nextLine().trim());

        int right;
        right = Integer.parseInt(in.nextLine().trim());

        res = new Solution().reverseBetween(head, left, right);
        while (res != null) {
            System.out.print(String.valueOf(res.data) + " ");
            res = res.next;
        }
        System.out.println();

    }
}
