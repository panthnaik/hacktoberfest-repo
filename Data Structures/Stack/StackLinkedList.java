public class StackLinkedList<T> {
    Node head;

    int top;
    int length;

    class Node {
        T data;
        Node next;

        Node() {
            this.data = null;
            this.next = null;
        }

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    StackLinkedList() {
        head = new Node();
        length = 0;
        top = -1;
    }

    public void push(T data) {
        Node newNode = new Node(data);
        newNode.next = this.head.next;
        this.head.next = newNode;
        top++;
        length++;
    }

    public T pop() {
        if (top != -1) {
            T x = this.head.next.data;
            this.head.next = this.head.next.next;
            top--;
            length--;
            return x;
        } else {
            System.out.println("Stack Underflow");
            return null;
        }
    }

    public T peek() {
        if(top==-1){
            System.out.println("Stack is empty, nothing to peek");
            return null;
        }
        return this.head.next.data;
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    public void printStack() {
        Node temp = this.head.next;
        if (top != -1) {
            for (int i = 0; i <= top; i++) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        } else {
            System.out.println("Empty Stack");
        }
    }

    public static void main(String[] args) {
        StackLinkedList<Integer> s = new StackLinkedList<>();
        System.out.println("Stack Created!");
        System.out.println("Operations on empty Stack: ");
        System.out.print("Print stack: ");
        s.printStack();
        System.out.println("Is empty? : "+s.isEmpty());
        System.out.println("top:" + s.peek());
        System.out.println("top index:" + s.top);
        System.out.println("length of stack: " + s.length);
        System.out.println("pop: "+s.pop());

        System.out.println("Adding elements in stack");
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);

        System.out.print("Stack: ");
        s.printStack();
        System.out.println("Is empty? : "+s.isEmpty());
        System.out.println("top:" + s.peek());
        System.out.println("top index:" + s.top);
        System.out.println("length of stack: " + s.length);
        System.out.println("popped element: "+s.pop());
        System.out.print("New Stack after pop operation: ");
        s.printStack();
        System.out.println("top:" + s.peek());
        System.out.println("top index:" + s.top);
        System.out.println("length of stack: " + s.length);
    }
}