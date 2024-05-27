package SingleyLinkedList;

import Shared.Node;

import java.util.Stack;

public class PlaindromeLinkedList {


    boolean isPlaindromeLinkedListMethod2(Node head) {

        if (head == null) {
            return true;

        }
        if (head.next == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        for (Node curr = head; curr != null; curr = curr.next) {
            stack.push(curr.data);
        }
        Node curr = head;

        while (!stack.isEmpty() && curr != null) {

            int poped = stack.pop();
            if (poped != curr.data) {
                return false;
            }
            curr = curr.next;
        }

        return true;
    }

    boolean isPalindromeLinkedList(Node head) {
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }


        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node curr = head;
        Node rev = reverse(slow);
        while (rev != null) {
            if (curr.data != rev.data) {
                return false;
            }
            curr = curr.next;
            rev = rev.next;
        }


        return true;
    }


    Node reverse(Node head) {
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
