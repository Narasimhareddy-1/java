// Node class to represent each element in the list
class Node {
    int data;       // stores the data
    Node next;      // pointer to the next node

    // Constructor to create a new node
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class to represent the linked list
class LinkedList {
    Node head;  // head of the list

    // Constructor to initialize the linked list
    LinkedList() {
        this.head = null;
    }

    // Function to add a node at the beginning of the list
    void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;  // new node's next points to the current head
        head = newNode;       // head points to the new node
    }

    // Function to add a node at the end of the list
    void addLast(int data) {
        Node newNode = new Node(data);

        // If the list is empty, make the new node the head
        if (head == null) {
            head = newNode;
            return;
        }

        // Otherwise, traverse to the last node
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;  // Append the new node at the end
    }

    // Function to delete a node by value
    void delete(int value) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        // If the node to be deleted is the head
        if (head.data == value) {
            head = head.next;  // Move the head to the next node
            return;
        }

        // Find the node to delete
        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        // If the value is not found
        if (current.next == null) {
            System.out.println("Value " + value + " not found in the list.");
            return;
        }

        // Delete the node
        current.next = current.next.next;
    }

    // Function to print the linked list
    void printList() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.println(current.data );
            current = current.next;
        }
        System.out.println("null");  // Indicate the end of the list
    }
}

// Main class to test the linked list
public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        // Add elements at the beginning and end
        linkedList.addFirst(10);  // List: 10
        linkedList.addFirst(20);  // List: 20 -> 10
        linkedList.addLast(30);   // List: 20 -> 10 -> 30
        linkedList.addLast(40);   // List: 20 -> 10 -> 30 -> 40

        // Print the list after adding nodes
        System.out.println("Linked List after adding nodes:");
        linkedList.printList();

        // Delete a node (e.g., value 10)
        linkedList.delete(10);  // List: 20 -> 30 -> 40

        // Print the list after deletion
        System.out.println("Linked List after deleting 10:");
        linkedList.printList();

        // Try to delete a node that doesn't exist (e.g., value 100)
        linkedList.delete(100);  // List remains unchanged: 20 -> 30 -> 40
    }
}

