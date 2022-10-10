
public class JLinkedList<T> {

    Node head;// head of linked list

    class Node {
        T data;
        Node next;

        Node() {
            data = null;
            next = null;
        }

        Node(T d) {
            this.data = d;
            this.next = null;
        }
    }

    JLinkedList() { // constructor to create head node when linkedlist is initialized
        head = new Node();// empty head node
    }

    // -------calculate length------
    public int length() {
        int length = 0;
        Node temp = this.head.next;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }

    // --------Print LinkedList---------
    public void printList() {
        Node currNode = this.head.next;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    // --------Insert Operations--------

    public void insertFront(T data) { // insert at front
        Node newNode = new Node(data);
        newNode.next = this.head.next;
        this.head.next = newNode;
    }

    public void insertEnd(T data) { // insert at end
        Node newNode = new Node(data);
        newNode.next = null;
        Node temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;

    }

    public void insertKey(T key, T data) { // insert after node having given data
        Node newNode = new Node(data);
        newNode.next = null;
        Node temp = this.head;
        while (temp.next != null) {
            if (temp.data == key) {
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            } else {
                temp = temp.next;
            }
        }

    }

    public void insertAt(int index, T data) { // insert At perticular Index
        Node newNode = new Node(data);
        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // ---------Reverse List-------
    public void reverse() {
        // using iteration
        // for (int i = 0; i < this.length(); i++) {
        //     this.insertAt(i, this.deleteEnd());
        // }
        //using head node
        Node curr = this.head.next;
        Node prev=null,nextNode=null;
        while(curr!=null){
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        this.head.next = prev;
    }

    // --------merge another List-------
    public void merge(JLinkedList<T> list) {
        Node temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = list.head.next;
    }

    // ----------Deletion Operations---------

    public T deleteFront() {// delete from front
        if (this.head.next == null) { // check for empty list
            return null;
        }
        Node temp = this.head.next;// save to return deleted node
        this.head.next = temp.next;
        System.out.print("Element Deleted ");
        return temp.data;
    }

    public T deleteEnd() {
        T x = null;
        Node temp = this.head.next, prev = this.head;
        if (temp != null) {
            while (temp.next != null) {
                prev = temp;
                temp = temp.next;
            }
            x = temp.data;
            prev.next = null;
            System.out.print("Element Deleted ");
            return x;
        }
        System.out.print("Empty list ");
        return x;
    }

    public void deleteKey(T key) {
        Node temp = this.head.next, prev = this.head;
        if (temp != null) {
            while (temp != null) {
                if (temp.data == key) {
                    System.out.println("Element deleted: " + key);
                    prev.next = temp.next;
                    return;
                }
                prev = temp;
                temp = temp.next;
            }
            System.out.println("Key not found");
            return;
        }
        System.out.println("List is empty");
    }

    public T deleteAt(int index) {
        T x = null;
        Node temp = this.head.next, prev = this.head;
        if (temp != null) {
            for (int i = 0; i < index; i++) {
                if (temp.next == null) {
                    System.out.println("Index out of bound");
                    return null;
                }
                prev = temp;
                temp = temp.next;
            }
            x = temp.data;
            prev.next = temp.next;
            System.out.print("Element deleted ");
            return x;
        }
        System.out.println("List is empty");
        return x;
    }

    public static void main(String[] args) {
        JLinkedList<Integer> LinkList = new JLinkedList<>();
        JLinkedList<Integer> LinkList2 = new JLinkedList<>();
        JLinkedList<Integer> LinkList3 = new JLinkedList<>();
        JLinkedList<Integer> LinkList4 = new JLinkedList<>();
        JLinkedList<Integer> LinkList5 = new JLinkedList<>();
        // insert end
        LinkList.insertEnd(1);
        LinkList.insertEnd(2);
        LinkList.insertEnd(3);
        LinkList.insertEnd(4);
        LinkList.insertEnd(5);
        LinkList.insertEnd(6);
        // printlist
        LinkList.printList();
        System.out.println("Length of list: " + LinkList.length());

        // insert front
        LinkList.insertFront(-1);
        LinkList.printList();

        // insert after given key
        LinkList.insertKey(4, 5);
        LinkList.printList();

        // insert at given index
        LinkList.insertAt(3, 5);
        LinkList.printList();
        LinkList2.insertEnd(1);
        LinkList2.insertEnd(2);
        LinkList2.insertEnd(3);
        LinkList2.insertEnd(4);

        // merge two list
        LinkList.merge(LinkList2);
        LinkList.printList();

        // delete front
        LinkList2.printList();
        System.out.println(LinkList2.deleteFront());
        LinkList2.printList();

        // delete front from empty list
        LinkList3.printList();
        System.out.println("deleting front from empty list: " + LinkList3.deleteFront());

        // delete front from list containing only one element
        LinkList4.insertEnd(1);
        LinkList4.printList();
        System.out.println(LinkList4.deleteFront());
        LinkList4.printList();

        // delete end
        LinkList2.printList();
        System.out.println(LinkList2.deleteEnd());
        LinkList2.printList();

        // delete end from empty list
        System.out.println("deleting end from empty list: " + LinkList3.deleteEnd());

        // delete front from list containing only one element
        LinkList4.insertEnd(1);
        LinkList4.printList();
        System.out.println(LinkList4.deleteEnd());
        LinkList4.printList();

        // deleting key
        LinkList.printList();
        LinkList.deleteKey(6);
        LinkList.printList();

        // deleting from empty list
        System.out.print("deleting from empty list: ");
        LinkList3.deleteKey(6);

        // deleting invalid key
        System.out.print("deleting invalid key: ");
        LinkList2.deleteKey(4);

        // deleting key from only one element
        LinkList4.insertEnd(1);
        LinkList4.printList();
        LinkList4.deleteKey(1);
        LinkList4.printList();

        // delete last key
        LinkList4.insertAt(0, 1);
        LinkList4.insertAt(0, 2);
        LinkList4.insertAt(0, 3);
        LinkList4.insertAt(0, 4);
        LinkList4.printList();
        LinkList4.deleteKey(1);
        LinkList4.printList();

        // deleting at index
        System.out.println(LinkList4.deleteAt(2));
        LinkList4.printList();
        System.out.println(LinkList4.deleteAt(0));// first index
        LinkList4.printList();

        // reverse list
        LinkList5.insertEnd(1);
        LinkList5.insertEnd(2);
        LinkList5.insertEnd(3);
        LinkList5.insertEnd(4);
        LinkList5.insertEnd(5);
        LinkList5.printList();
        LinkList5.reverse();
        LinkList5.printList();
    }
}
