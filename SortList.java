public class SortList {

    class Node {
        int data;
        String name;
        Node previous;
        Node next;

        public Node(int data, String name) {
            this.data = data;
            this.name = name;
        }
    }

    // head and tail of the doubly linked list
    Node head, tail = null;

    // add a node to the list
    public void addNode(int data, String name) {
        // Create a new node
        Node newNode = new Node(data, name);

        // If list is empty
        if (head == null) {
            // Both head and tail will point to newNode
            head = tail = newNode;
            // head's previous will point to null
            head.previous = null;
            // tail's next will point to null, as it is the last node of the list
            tail.next = null;
        } else {
            // newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            // newNode's previous will point to tail
            newNode.previous = tail;
            // newNode will become new tail
            tail = newNode;
            // As it is last node, tail's next will point to null
            tail.next = null;
        }
    }

    public void sortList() {

        Node current = null, index = null;
        int temp;
        String temp_name;
        // Check whether list is empty
        if (head == null) {
            return;
        } else {
            // Current will point to head
            for (current = head; current.next != null; current = current.next) {
                // Index will point to node next to current
                for (index = current.next; index != null; index = index.next) {
                    // If current's data is greater than index's data, swap the data of current and
                    // index
                    if (current.data < index.data) {
                        temp = current.data;
                        temp_name = current.name;

                        current.data = index.data;
                        current.name = index.name;

                        index.data = temp;
                        index.name = temp_name;
                    }
                }
            }
        }
    }

    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {
            System.out.print(current.name + " " + current.data + "\n");
            current = current.next;
        }
        System.out.println();
    }

    public void newscore() {
        Node current = tail;
        System.out.println(current.name + " got new score: " + current.data);
    }

    public void remove_last_report() {
        Node current = tail;
        System.out.println(current.name + " was removed from the scoreboard.");
    }

    void deleteNode(Node del) {

        // Base case
        if (head == null || del == null) {
            return;
        }

        // If node to be deleted is head node
        else if (head == del) {
            head = del.next;
        }

        // Change next only if node to be deleted
        // is NOT the last node
        else if (del.next != null) {
            del.next.previous = del.previous;
        }

        // Change prev only if node to be deleted
        // is NOT the first node
        else // (del.previous != null)
        {
            del.previous.next = del.next;
        }

        return;
    }

    public static void main(String[] args) {

        SortList dList = new SortList();

        dList.addNode(98, "Sam");
        dList.addNode(77, "Dusk");
        dList.addNode(69, "Clev");
        dList.addNode(90, "Peter");
        dList.addNode(54, "Raph");
        dList.addNode(37, "Jean");
        dList.addNode(68, "Hanny");
        dList.addNode(50, "Toby");
        dList.addNode(47, "Rahool");
        dList.addNode(60, "Holiday");

        // Scoreboard
        System.out.println("Scoreboard: ");
        dList.sortList();
        dList.display();

        System.out.println(".......................................");
        // Update
        dList.addNode(80, "Jameski");
        dList.newscore();
        // New scoreboard
        System.out.println("\nScoreboard: ");
        dList.sortList();
        dList.deleteNode(dList.tail);
        dList.display();

        /*
         * System.out.println((dList.tail).name + " was removed from the scoreboard.");
         */

        dList.remove_last_report();
        System.out.println(".......................................");

    }
}
