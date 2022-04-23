package task1.task12.stlinkedlist;

public class StackUsingLinkedList {
    public Node head;
    public Node top;

    public StackUsingLinkedList() {
        head = null;
        top = null;
    }

    public void traversal() {
        Node temp = this.head; //temporary pointer to point to head

        while(temp != null) { //iterating over stack
            System.out.print(temp.data+"\t");
            temp = temp.next;
        }

        System.out.println("");
    }

    public boolean isEmpty() {
        if(this.top == null)
            return true;
        return false;
    }

    public void push(Node n) {
        if(this.isEmpty()) {
            this.head = n;
            this.top = n;
        }
        else {
            this.top.next = n;
            this.top = n;
        }
    }

    public int pop() {
        if(this.isEmpty()) {
            System.out.println("Stack Underflow\n");
            return -1000;
        }
        else {
            int x = this.top.data;
            if(this.head == this.top) {// only one node
                this.top = null;
                this.head = null;
            }
            else {
                Node temp = this.head;
                while(temp.next != this.top) // iterating to the last element
                    temp = temp.next;
                temp.next = null;
                this.top = temp;
            }
            return x;
        }
    }

}
