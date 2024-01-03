// Task 1: Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
// DEFINITIONCircuIar linked list: A (corrupt) linked list in which a node’s next pointer points to an earlier node, so as
// to make a loop in the linked list.
// EXAMPLE
// input: A -> B -> C -> D -> E -> C [the same C as earlier]
// output: C

package com.java_cross_platform.additional4;

public class CircularLinkedList {

    // Solution - Floyd’s fast and slow pointer algorithms

    public static ListNode detectLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Detect if there's a loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break; // Collision point found
            }
        }

        // Check if there is no loop
        if (fast == null || fast.next == null) {
            return null;
        }

        // Move one pointer to the head, keep the other at the collision point
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Return the node where the loop starts
        return slow;
    }

    public static void main(String[] args) {

        // // Example # 1
        // ListNode a = new ListNode(1);
        // ListNode b = new ListNode(2);
        // ListNode c = new ListNode(3);
        // ListNode d = new ListNode(4);
        // ListNode e = new ListNode(5);
        // a.next = b;
        // b.next = c;
        // c.next = d;
        // d.next = e;
        // e.next = c; // Creating a loop

        // // Example # 2
        // ListNode a = new ListNode(1);
        // ListNode b = new ListNode(2);
        // ListNode c = new ListNode(3);
        // a.next = b;
        // b.next = c;
        // c.next = null; // No loop

        // Example # 3
        // ListNode a = new ListNode(1);
        // a.next = a; // Self-loop

        // Example # 4
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = b; // Loop

        ListNode loopStartNode = detectLoop(a);

        if (loopStartNode != null) {
            System.out.println("Loop starts at node with value: " + loopStartNode.val);
        } else {
            System.out.println("No loop found in the linked list.");
        }
    }
}