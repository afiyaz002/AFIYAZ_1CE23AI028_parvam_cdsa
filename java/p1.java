// Node class to represent each element in the doubly linked list
class Node {
    int data;
    Node next;
    Node prev;

    // Constructor to create a new node
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

// DoublyLinkedList class
class DoublyLinkedList {
    Node head; // head of the list

    // Constructor to create an empty list
    DoublyLinkedList() {
        head = null;
    }

    // Add a new node at the end of the doubly linked list
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    // Add a new node at the beginning of the doubly linked list
    public void prepend(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Delete the first node from the list
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Delete the last node from the list
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.prev.next = null;
        }
    }

    // Traverse and print the list from head to tail
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Traverse and print the list from tail to head
    public void printReverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        // Go to the last node
        while (temp.next != null) {
            temp = temp.next;
        }
        // Traverse backwards
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }
}

// Main class to test the doubly linked list operations
public class DoublyLinkedListExample {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Append some nodes
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);

        // Prepend a node
        list.prepend(5);

        // Print the list from head to tail
        System.out.println("List (Forward):");
        list.printList();

        // Print the list from tail to head
        System.out.println("List (Reverse):");
        list.printReverse();

        // Delete the first node
        list.deleteFirst();
        System.out.println("After deleting the first node (Forward):");
        list.printList();

        // Delete the last node
        list.deleteLast();
        System.out.println("After deleting the last node (Forward):");
        list.printList();
    }
}